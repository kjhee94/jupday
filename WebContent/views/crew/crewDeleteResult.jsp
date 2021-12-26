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
		boolean deleteResult = (boolean)request.getAttribute("deleteResult");
		int crewNo = (int)request.getAttribute("crewNo"); 
	%>
	
	<script>
	
		<%if(deleteResult) {%>
			alert("크루가 삭제되었습니다")
			location.replace("/crew/crewJoinList.do");
		<%}else {%>	
			alert("크루삭제에 실패했습니다 \n -지속적인 문제 발생시 관리자에게 문의해주세요")
			location.replace("/crew/crewDeleteName.do?crewNo="+<%=crewNo%>);
		<%} %>	
		
	</script>
</body>
</html>