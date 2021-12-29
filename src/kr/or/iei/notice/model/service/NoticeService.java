package kr.or.iei.notice.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.or.iei.notice.model.vo.Notice;
import kr.or.iei.notice.model.vo.NoticeCampaign;

public interface NoticeService {

	 /**남진구
	 * @param currentPage 
	 * @return void
	 * 2021.12.27
	 * Description: 요청한 페이지(currentPage)에 대한 목록을 리턴해주는 메소드
	 */
	HashMap <String,Object> selectAllPostList(int currentPage);
	
	     /**남진구
		 * @param 
		 * @return 
		 * 2021.12.28
		 * Description: 
		 */
	Notice selectOnePost(int noticeNo);
	
	

	/**남진구
	 * @param currentPage
	 * @return
	 */
	HashMap<String, Object> selectAllCampaignPostList(int currentPage);
	
	

	NoticeCampaign selectOneCampaignPost(int campaignNo);

	ArrayList<Notice> showNotice();

}
