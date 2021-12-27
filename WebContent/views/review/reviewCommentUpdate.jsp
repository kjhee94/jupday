<%@page import="kr.or.iei.review.model.vo.ReviewComment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%-- 댓글 수정 로직 --%>
	
	<% 
		request.setCharacterEncoding("UTF-8");
		String comment = request.getParameter("comment"); //댓글 내용
		int postNum = Integer.parseInt(request.getParameter("postNum")); //게시글 번호
		int commentNo = Integer.parseInt(request.getParameter("commentNo")); //댓글 번호
		int currentPage = Integer.parseInt(request.getParameter("currentPage")); //현재 페이지
	%>	
	<p>수정할 댓글 내용을 입력하세요</p>
	<form action="/review/reviewCommentUpdate.do" method="post" display="none">	
		<input type="hidden" name="commentNo" value="<%=commentNo %>"/>
		<input type="hidden" name="postNum" value="<%=postNum%>"/>
		<input type="hidden" name="currentPage" value="<%=currentPage%>"/>		
		<textarea name="comment"><%=comment%></textarea>
		<button>수정</button>
	</form>
	
	<%--다 하고나면 창을 닫는 코드가 필요한데, 어떤게 있으려나.. --%>
	
</body>
</html>