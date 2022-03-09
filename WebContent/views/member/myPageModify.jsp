<%@page import="kr.or.iei.file.model.vo.MemberFileData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보 수정</title>

<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap"
	rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="stylesheet" href="/assets/commons/default.css">
<link rel="stylesheet" href="/assets/commons/header.css">
<link rel="stylesheet" href="/assets/commons/footer.css">
<link rel="stylesheet" href="/assets/commons/common.css">
<link rel="stylesheet" href="/assets/css/myPageModify.css">
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="/assets/js/ui.js"></script>
</head>
<body>

	<script>
	<!--중복체크 확인 -->
		function nickCheck(){
			window.open("/views/member/nickCheck.jsp","_blank","width=800px, height=300px");
		}
		function emailCheck(){
			window.open("/views/member/emailCheck.jsp","_blank","width=800px, height=300px");
		}
		
		
   </script>
   

  <script>
	
	var imgFile = $('#file').val();
	var fileForm = /(.*?)\.(jpg|jpeg|png|gif|bmp|pdf)$/;
	var maxSize = 5 * 1024 * 1024;
	var fileSize;
	$(document).ready(function() {
		$("#profileUpload").click(function() {
			if($('#file').val() == '') {
				alert("사용하시려는 이미지를 선택하여 주세요.");
			    $("#file").focus();
			    return false;
			}
		
			if(imgFile != "" && imgFile != null) {
				fileSize = document.getElementById("file").files[0].size;
			    
			    if(!imgFile.match(fileForm)) {
			    	alert("이미지 파일만 업로드 가능합니다.");
			        return false;
			    } else if(fileSize = maxSize) {
			    	alert("프로필 사진의 크기는 5MB까지 가능합니다.");
			        return false;
			    }
			} 
		})
	})
	
	</script>
 


	<div id="wrap">
		<%@ include file="/views/commons/header/header.jsp"%>
		<% if(m!=null) {%>
		<div id="content">
			<div class="user-info">
			
				<div class=box-title>
 					<p class="tit-small">J U P : D A Y</p>
					<p class="tit-big">회원 정보 수정</p>
				</div>
				<form action="/file/profileUpdate.do" method="post" enctype="multipart/form-data">
					<table class="info">
						<tr>
							<td>사진</td>
							<td class="profile-img">
							<%
								//System.out.println(m);
								if(m.getP_Image() == null || m.getP_Image() =="") {
									//System.out.println("Null");
							%>
									<img class="profile-img2" src="/assets/images/profile.png">
							<%
								} else {
									//System.out.println("Not Null");
							%>
									<img class="profile-img2" src="/upload/<%=m.getP_Image() %>.png">
							<%
								}
							%>
							</td>
							<td>
								<p>
								회원님을 알릴 수 있는 사진을 등록해 주세요.<br>
								등록된 사진은 회원님의 게시물이나 댓글들에 사용됩니다.
								</p>
							</td>
							<td>
 								<label for="file" class="btn-s">사진등록</label>								
								<input type="file" class="btn-s" name="file" id="file" accept="image/*" style="display:none">
							</td>
						</tr>
						<tr>
							<td>아이디</td>
							<td colspan="3"> <%=m.getUserId() %></td>
						</tr>
						<tr>
							<td>닉네임</td>
								<td colspan="2"><input type="text" class="input-style" id="nick" name="nick" onclick="nickCheck();" placeholder="닉네임을 입력해주세요." value="<%=m.getNick() %>" readonly></td>
								<td><input type="button" class="btn-s" onclick="nickCheck();" value="중복확인"></td>
						</tr>
						<tr>
							<td>이메일</td>
							<td colspan="2"><input type="email" class="input-style" id="email" name="email" onclick="emailCheck();" placeholder="이메일을 입력해주세요." value="<%=m.getEmail() %>" readonly></td>
							<td><input type="button" class="btn-s" onclick="emailCheck();" value="중복확인"></td>
						</tr>
						<tr>
							<td colspan="4">
								<input type="submit" class="btn-m" value="수정하기">
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<%@ include file="/views/commons/footer/footer.jsp"%>
	</div>
		<% } else { %>
			<script>
				location.replace("/views/member/memberLogin.jsp");
			</script>
		<% }  %>


</body>
</html>