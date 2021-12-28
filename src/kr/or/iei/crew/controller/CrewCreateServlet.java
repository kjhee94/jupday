package kr.or.iei.crew.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.iei.crew.model.service.CrewService;
import kr.or.iei.crew.model.service.CrewServiceimpl;
import kr.or.iei.crew.model.vo.Crew;
import kr.or.iei.crew.model.vo.CrewFileData;
import kr.or.iei.member.model.vo.Member;

/**
 * Servlet implementation class CrewCreateServlet
 */
@WebServlet("/crew/crewCreate.do")
public class CrewCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrewCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//파일업로드 처리
		//실제 업로드되어야 하는 경로(filePath)
		String uploadFilePath = request.getServletContext().getRealPath("/upload");
		//최대 파일 사이즈 크기 설정값
		int uploadFileSizeLimit = 1024 * 1024 * 50; //50MB
		//파일이름에 대한 인코딩 처리 값
		String enType = "UTF-8";
		
		//MultipartRequest 생성
		MultipartRequest multi = new MultipartRequest(request, 
													  uploadFilePath, 
													  uploadFileSizeLimit, 
													  enType, 
													  new DefaultFileRenamePolicy());
		
		//1. 원본파일 이름 가져오기
		String originalFileName = multi.getFilesystemName("crewImg");
		
		//2. 업로드한 유저
		String fileUser = ((Member)request.getSession().getAttribute("member")).getUserId();
		
		//3. 업로드 시간(Calender Class)
		long currentTime = Calendar.getInstance().getTimeInMillis();
		//포멧을 지정하여 업로드 시간 구현하기
		SimpleDateFormat fomatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		Timestamp uploadTime = Timestamp.valueOf(fomatter.format(currentTime));
		
		//4. 파일 이름 변경 후 파일 경로 저장
		File file = new File(uploadFilePath+"\\"+originalFileName);
		file.renameTo(new File(uploadFilePath+"\\"+fileUser+"_"+currentTime+"_jupday.png"));
		//파일의 이름을 유저명_업로드시간(밀리세컨드)_kh 라는 이름으로 변경하겠다는 의미
		String changedFileName = fileUser+"_"+currentTime+"_jupday";
		
		//5. 해당 파일의 경로 저장
		String filePath = uploadFilePath+"\\"+changedFileName;
		
		//6. 파일의 사이즈
		File reFile = new File(filePath);
		long fileSize = reFile.length();
		
		
		//비즈니스로직1(정보 입력)
		//인코딩
		request.setCharacterEncoding("UTF-8");
		
		String crewName = multi.getParameter("crewName");
		String crewInfo = multi.getParameter("crewInfo");
		String crewImg = changedFileName;
		
		Crew c = new Crew(crewName, crewInfo, crewImg);
		
		String userId = ((Member)request.getSession().getAttribute("member")).getUserId();
		
		CrewService cService = new CrewServiceimpl();
		boolean createResult = cService.crewCreate(c, userId);
		
		
		
		//비즈니스로직2(파일 업로드)
		CrewFileData cfd = new CrewFileData();
		
		cfd.setCrewProfileOriginal(originalFileName);
		cfd.setCrewProfileChange(changedFileName);
		cfd.setCrewProfilePath(filePath);
		cfd.setCrewProfileSize(fileSize);
		cfd.setUserId(fileUser);
		cfd.setCrewProfileUpdateTime(uploadTime);
		
		int uplodeResult = cService.insertFileCreate(cfd);
		
		//성공실패 페이지 보내기
		RequestDispatcher view = request.getRequestDispatcher("/views/crew/crewCreateResult.jsp");
		
		if(createResult && uplodeResult>0) {
			request.setAttribute("result", true);
		}else {
			request.setAttribute("result", false);
		}
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
