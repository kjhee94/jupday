<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		boolean result = (boolean)request.getAttribute("deleteResult");
		int crewNo = (int)request.getAttribute("crewNo"); 
		int currentPage = (int)request.getAttribute("currentPage"); 
		int feedNo = (int)request.getAttribute("feedNo"); 
		int currentFeedPage = (int)request.getAttribute("currentFeedPage"); 
	%>
	<script>
		<%if(result) { %>
			alert("요청하신 댓글이 삭제 완료 되었습니다");
		<%}else { %>
			alert("이미 삭제되거나 잘못된 요청입니다.");
		<%} %>
		location.replace("/crew/crewOneFeed.do?crewNo="+<%=crewNo%>+"&currentPage="+<%=currentPage%>+"&feedNo="+<%=feedNo%>+"&currentFeedPage="+<%=currentFeedPage%>);
	</script>
</body>
</html>