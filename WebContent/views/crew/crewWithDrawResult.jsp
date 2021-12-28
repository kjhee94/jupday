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
		boolean withDrawResult = (boolean)request.getAttribute("withDrawResult");
		int crewNo = (int)request.getAttribute("crewNo");
		int currentPage = (int)request.getAttribute("currentPage");
	%>
	
	<script>
		<%if(withDrawResult) {%>
			if(prompt("정말로 크루에서 탈퇴하시겠습니까?")){
				alert("크루에서 탈퇴했습니다")
				location.replace("/crew/crewJoinList.do");
			}
		<%}else {%>	
			alert("크루탈퇴에 실패했습니다 \n -지속적인 문제 발생시 관리자에게 문의해주세요")
			location.replace("/crew/crewOnePage.do?crewNo="+<%=crewNo%>+"&currentPage="+<%=currentPage%>+"currentFeedPage=1");
		<%} %>	
		
	</script>
	
</body>
</html>