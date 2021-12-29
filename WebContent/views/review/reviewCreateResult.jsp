<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%boolean result = (boolean)request.getAttribute("result"); 
		int postNum = (int)request.getAttribute("postNum");
		int currentPage = (int)request.getAttribute("currentPage");
	%>
	
	<script>
		<%if(result) {%>
	
			alert("리뷰 작성 완료")
			location.replace("/review/reviewSelectContent.do?postNum=<%=postNum%>&currentPage=<%=currentPage%>");
	
		<%}else { %>
		
			alert("리뷰 작성에 실패했습니다, 지속적인 문제 발생시 관리자에게 문의해주세요 ")
			location.replace("/views/review/reviewWriteForm.jsp");
		
		<%} %>
	</script>

</body>
</html>