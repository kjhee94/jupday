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
	Object result = request.getAttribute("nickCheck");
	%>
	
	<!-- result 값이 null이거나 혹은 있거나, null이면 Servlet을 거치지 않고 바로 해당 페이지가 열렸을때 -->
	<%if(result==null){ %>
	
		<form action="/member/nickCheck.do" method="get">
			<input type="text" name="nick" placeholder="중복 확인할 닉네임을 입력하세요"/>
			<input type="submit" value="중복확인"/>
		</form>
		
	<!-- null이 아닐때 -->
	<%}else{%>
	
		<%String nick=(String)request.getAttribute("nick"); %>
		
	 	<form action="/member/nickCheck.do" method="get">
			<input type="text" id="userNick3"  name="nick" value="<%=nick%>" placeholder="중복 확인할 ID를 입력하세요"/>
			<input type="submit" value="중복확인"/>
		</form>
	
	    <!-- 중복하는 닉네임이 왔을때 -->
	    <%if((boolean)result){%>
	       <span style = "color:red;">해당 닉네임을 이미 사용 중 입니다</span>
	       
	    <!-- 중복하지 않는 닉네임일때 -->
	    <%}else{%>
		    <span style = "color:blue">해당 닉네임을 사용 가능합니다</span><br>
		    <button onclick="useNick();">사용하기</button>
	        	
		    <script>
		  	function useNick()
		  	{      		
		  		window.opener.document.getElementById('nick').value=document.getElementById("userNick3").value;
		  		window.close();
		  	}    	
		  	</script>
	  	<%} %>    
	  		
	<%} %>

</body>
</html>