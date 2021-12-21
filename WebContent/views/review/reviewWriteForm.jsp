<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리뷰 작성</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="/assets/commons/default.css">
<link rel="stylesheet" href="/assets/commons/header.css">
<link rel="stylesheet" href="/assets/commons/footer.css">
<link rel="stylesheet" href="/assets/commons/common.css">
<link rel="stylesheet" href="/assets/css/reviewWriteForm.css">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="/assets/js/header.js"></script>

<style>
	.dot {overflow:hidden;float:left;width:12px;height:12px;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/mini_circle.png');}    
	.dotOverlay {position:relative;bottom:10px;border-radius:6px;border: 1px solid #ccc;border-bottom:2px solid #ddd;float:left;font-size:12px;padding:5px;background:#fff;}
	.dotOverlay:nth-of-type(n) {border:0; box-shadow:0px 1px 2px #888;}    
	.number {font-weight:bold;color:#ee6152;}
	.dotOverlay:after {content:'';position:absolute;margin-left:-6px;left:50%;bottom:-8px;width:11px;height:8px;background:url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white_small.png')}
	.distanceInfo {position:relative;top:5px;left:5px;list-style:none;margin:0;}
	.distanceInfo .label {display:inline-block;width:50px;}
	.distanceInfo:after {content:none;}
</style>
</head>

<body>

	<div id="wrap">
		<!-- header -->
		<%@ include file="/views/commons/header/header.jsp"%>
			
		<div id="content">
			<div id="review_main">
				<div class="review_text">
					<p class="review_text_s">Jup:Day</p>
					<br>
					<p class="review_text_l">줍데이 리뷰 작성</p>
					<br>
				</div>
			</div>
		
			<div id="review_writing">
				
				<hr>
				<div id="writeForm">
					<form>
						<textarea rows="1" cols="85" style="resize:none; border-style:none;" placeholder="제목을 작성하세요"></textarea>
						<br>
						<textarea rows="20" cols="85" style="resize:none; border-style:none;" placeholder="내용을 작성하세요"></textarea>
						<br>
						
						<!-- 이거는 아코디언 bootstrap, 파일과 지도를 볼 수 있게 올라갔다 내려가는 구조 -->
					 	<div class="accordion accordion-flush" id="accordionFlushExample">
						  <div class="accordion-item">
						    <h2 class="accordion-header" id="flush-headingOne">
						      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
						       	 파일 추가
						      </button>
						    </h2>
						    <div id="flush-collapseOne" class="accordion-collapse collapse" aria-labelledby="flush-headingOne" data-bs-parent="#accordionFlushExample">
						      <div class="accordion-body">
						      	<!-- 여기다 파일 업로드 만들 예정 -->
						      </div>
						    </div>
						  </div>
						  <div class="accordion-item">
						    <h2 class="accordion-header" id="flush-headingTwo">
						      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo" aria-expanded="false" aria-controls="flush-collapseTwo">
						               위치 추가
						      </button>
						    </h2>
						    <div id="flush-collapseTwo" class="accordion-collapse collapse" aria-labelledby="flush-headingTwo" data-bs-parent="#accordionFlushExample">
						      <div class="accordion-body"> 
						      	<div id="map" style="width:200px;height:200px;"></div>  
						      </div>
						    </div>
						  </div>
						</div>
						<input type="submit" class="btn-submit" value="작성"/>
						<input type="reset" class="btn-rollback" value="취소"/><br>
					</form>
					
				</div>
			</div>
		</div> 
		
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=aa153422867c293a7226f0c302b5e6b3"></script>
			
			<script>
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
			    mapOption = { 
			        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			        level: 3 // 지도의 확대 레벨
			    };
			
			var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
			
			var drawingFlag = false; // 선이 그려지고 있는 상태를 가지고 있을 변수입니다
			var moveLine; // 선이 그려지고 있을때 마우스 움직임에 따라 그려질 선 객체 입니다
			var clickLine // 마우스로 클릭한 좌표로 그려질 선 객체입니다
			var distanceOverlay; // 선의 거리정보를 표시할 커스텀오버레이 입니다
			var dots = {}; // 선이 그려지고 있을때 클릭할 때마다 클릭 지점과 거리를 표시하는 커스텀 오버레이 배열입니다.
			
			// 지도에 클릭 이벤트를 등록합니다
			// 지도를 클릭하면 선 그리기가 시작됩니다 그려진 선이 있으면 지우고 다시 그립니다
			kakao.maps.event.addListener(map, 'click', function(mouseEvent) {
			
			    // 마우스로 클릭한 위치입니다 
			    var clickPosition = mouseEvent.latLng;
			
			    // 지도 클릭이벤트가 발생했는데 선을 그리고있는 상태가 아니면
			    if (!drawingFlag) {
			
			        // 상태를 true로, 선이 그리고있는 상태로 변경합니다
			        drawingFlag = true;
			        
			        // 지도 위에 선이 표시되고 있다면 지도에서 제거합니다
			        deleteClickLine();
			        
			        // 지도 위에 커스텀오버레이가 표시되고 있다면 지도에서 제거합니다
			        deleteDistnce();
			
			        // 지도 위에 선을 그리기 위해 클릭한 지점과 해당 지점의 거리정보가 표시되고 있다면 지도에서 제거합니다
			        deleteCircleDot();
			    
			        // 클릭한 위치를 기준으로 선을 생성하고 지도위에 표시합니다
			        clickLine = new kakao.maps.Polyline({
			            map: map, // 선을 표시할 지도입니다 
			            path: [clickPosition], // 선을 구성하는 좌표 배열입니다 클릭한 위치를 넣어줍니다
			            strokeWeight: 3, // 선의 두께입니다 
			            strokeColor: '#db4040', // 선의 색깔입니다
			            strokeOpacity: 1, // 선의 불투명도입니다 0에서 1 사이값이며 0에 가까울수록 투명합니다
			            strokeStyle: 'solid' // 선의 스타일입니다
			        });
			        
			        // 선이 그려지고 있을 때 마우스 움직임에 따라 선이 그려질 위치를 표시할 선을 생성합니다
			        moveLine = new kakao.maps.Polyline({
			            strokeWeight: 3, // 선의 두께입니다 
			            strokeColor: '#db4040', // 선의 색깔입니다
			            strokeOpacity: 0.5, // 선의 불투명도입니다 0에서 1 사이값이며 0에 가까울수록 투명합니다
			            strokeStyle: 'solid' // 선의 스타일입니다    
			        });
			    
			        // 클릭한 지점에 대한 정보를 지도에 표시합니다
			        displayCircleDot(clickPosition, 0);
			
			            
			    } else { // 선이 그려지고 있는 상태이면
			
			        // 그려지고 있는 선의 좌표 배열을 얻어옵니다
			        var path = clickLine.getPath();
			
			        // 좌표 배열에 클릭한 위치를 추가합니다
			        path.push(clickPosition);
			        
			        // 다시 선에 좌표 배열을 설정하여 클릭 위치까지 선을 그리도록 설정합니다
			        clickLine.setPath(path);
			
			        var distance = Math.round(clickLine.getLength());
			        displayCircleDot(clickPosition, distance);
			    }
			});
			    
			// 지도에 마우스무브 이벤트를 등록합니다
			// 선을 그리고있는 상태에서 마우스무브 이벤트가 발생하면 그려질 선의 위치를 동적으로 보여주도록 합니다
			kakao.maps.event.addListener(map, 'mousemove', function (mouseEvent) {
			
			    // 지도 마우스무브 이벤트가 발생했는데 선을 그리고있는 상태이면
			    if (drawingFlag){
			        
			        // 마우스 커서의 현재 위치를 얻어옵니다 
			        var mousePosition = mouseEvent.latLng; 
			
			        // 마우스 클릭으로 그려진 선의 좌표 배열을 얻어옵니다
			        var path = clickLine.getPath();
			        
			        // 마우스 클릭으로 그려진 마지막 좌표와 마우스 커서 위치의 좌표로 선을 표시합니다
			        var movepath = [path[path.length-1], mousePosition];
			        moveLine.setPath(movepath);    
			        moveLine.setMap(map);
			        
			        var distance = Math.round(clickLine.getLength() + moveLine.getLength()), // 선의 총 거리를 계산합니다
			            content = '<div class="dotOverlay distanceInfo">총거리 <span class="number">' + distance + '</span>m</div>'; // 커스텀오버레이에 추가될 내용입니다
			        
			        // 거리정보를 지도에 표시합니다
			        showDistance(content, mousePosition);   
			    }             
			});                 
			
			// 지도에 마우스 오른쪽 클릭 이벤트를 등록합니다
			// 선을 그리고있는 상태에서 마우스 오른쪽 클릭 이벤트가 발생하면 선 그리기를 종료합니다
			kakao.maps.event.addListener(map, 'rightclick', function (mouseEvent) {
			
			    // 지도 오른쪽 클릭 이벤트가 발생했는데 선을 그리고있는 상태이면
			    if (drawingFlag) {
			        
			        // 마우스무브로 그려진 선은 지도에서 제거합니다
			        moveLine.setMap(null);
			        moveLine = null;  
			        
			        // 마우스 클릭으로 그린 선의 좌표 배열을 얻어옵니다
			        var path = clickLine.getPath();
			    
			        // 선을 구성하는 좌표의 개수가 2개 이상이면
			        if (path.length > 1) {
			
			            // 마지막 클릭 지점에 대한 거리 정보 커스텀 오버레이를 지웁니다
			            if (dots[dots.length-1].distance) {
			                dots[dots.length-1].distance.setMap(null);
			                dots[dots.length-1].distance = null;    
			            }
			
			            var distance = Math.round(clickLine.getLength()), // 선의 총 거리를 계산합니다
			                content = getTimeHTML(distance); // 커스텀오버레이에 추가될 내용입니다
			                
			            // 그려진 선의 거리정보를 지도에 표시합니다
			            showDistance(content, path[path.length-1]);  
			             
			        } else {
			
			            // 선을 구성하는 좌표의 개수가 1개 이하이면 
			            // 지도에 표시되고 있는 선과 정보들을 지도에서 제거합니다.
			            deleteClickLine();
			            deleteCircleDot(); 
			            deleteDistnce();
			
			        }
			        
			        // 상태를 false로, 그리지 않고 있는 상태로 변경합니다
			        drawingFlag = false;          
			    }  
			});    
			
			// 클릭으로 그려진 선을 지도에서 제거하는 함수입니다
			function deleteClickLine() {
			    if (clickLine) {
			        clickLine.setMap(null);    
			        clickLine = null;        
			    }
			}
			
			// 마우스 드래그로 그려지고 있는 선의 총거리 정보를 표시하거
			// 마우스 오른쪽 클릭으로 선 그리가 종료됐을 때 선의 정보를 표시하는 커스텀 오버레이를 생성하고 지도에 표시하는 함수입니다
			function showDistance(content, position) {
			    
			    if (distanceOverlay) { // 커스텀오버레이가 생성된 상태이면
			        
			        // 커스텀 오버레이의 위치와 표시할 내용을 설정합니다
			        distanceOverlay.setPosition(position);
			        distanceOverlay.setContent(content);
			        
			    } else { // 커스텀 오버레이가 생성되지 않은 상태이면
			        
			        // 커스텀 오버레이를 생성하고 지도에 표시합니다
			        distanceOverlay = new kakao.maps.CustomOverlay({
			            map: map, // 커스텀오버레이를 표시할 지도입니다
			            content: content,  // 커스텀오버레이에 표시할 내용입니다
			            position: position, // 커스텀오버레이를 표시할 위치입니다.
			            xAnchor: 0,
			            yAnchor: 0,
			            zIndex: 3  
			        });      
			    }
			}
			
			// 그려지고 있는 선의 총거리 정보와 
			// 선 그리가 종료됐을 때 선의 정보를 표시하는 커스텀 오버레이를 삭제하는 함수입니다
			function deleteDistnce () {
			    if (distanceOverlay) {
			        distanceOverlay.setMap(null);
			        distanceOverlay = null;
			    }
			}
			
			// 선이 그려지고 있는 상태일 때 지도를 클릭하면 호출하여 
			// 클릭 지점에 대한 정보 (동그라미와 클릭 지점까지의 총거리)를 표출하는 함수입니다
			function displayCircleDot(position, distance) {
			
			    // 클릭 지점을 표시할 빨간 동그라미 커스텀오버레이를 생성합니다
			    var circleOverlay = new kakao.maps.CustomOverlay({
			        content: '<span class="dot"></span>',
			        position: position,
			        zIndex: 1
			    });
			
			    // 지도에 표시합니다
			    circleOverlay.setMap(map);
			
			    if (distance > 0) {
			        // 클릭한 지점까지의 그려진 선의 총 거리를 표시할 커스텀 오버레이를 생성합니다
			        var distanceOverlay = new kakao.maps.CustomOverlay({
			            content: '<div class="dotOverlay">거리 <span class="number">' + distance + '</span>m</div>',
			            position: position,
			            yAnchor: 1,
			            zIndex: 2
			        });
			
			        // 지도에 표시합니다
			        distanceOverlay.setMap(map);
			    }
			
			    // 배열에 추가합니다
			    dots.push({circle:circleOverlay, distance: distanceOverlay});
			}
			
			// 클릭 지점에 대한 정보 (동그라미와 클릭 지점까지의 총거리)를 지도에서 모두 제거하는 함수입니다
			function deleteCircleDot() {
			    var i;
			
			    for ( i = 0; i < dots.length; i++ ){
			        if (dots[i].circle) { 
			            dots[i].circle.setMap(null);
			        }
			
			        if (dots[i].distance) {
			            dots[i].distance.setMap(null);
			        }
			    }
			
			    dots = [];
			}
			
			// 마우스 우클릭 하여 선 그리기가 종료됐을 때 호출하여 
			// 그려진 선의 총거리 정보와 거리에 대한 도보, 자전거 시간을 계산하여
			// HTML Content를 만들어 리턴하는 함수입니다
			function getTimeHTML(distance) {
			
			    // 도보의 시속은 평균 4km/h 이고 도보의 분속은 67m/min입니다
			    var walkkTime = distance / 67 | 0;
			    var walkHour = '', walkMin = '';
			
			    // 계산한 도보 시간이 60분 보다 크면 시간으로 표시합니다
			    if (walkkTime > 60) {
			        walkHour = '<span class="number">' + Math.floor(walkkTime / 60) + '</span>시간 '
			    }
			    walkMin = '<span class="number">' + walkkTime % 60 + '</span>분'
			
			    // 자전거의 평균 시속은 16km/h 이고 이것을 기준으로 자전거의 분속은 267m/min입니다
			    var bycicleTime = distance / 227 | 0;
			    var bycicleHour = '', bycicleMin = '';
			
			    // 계산한 자전거 시간이 60분 보다 크면 시간으로 표출합니다
			    if (bycicleTime > 60) {
			        bycicleHour = '<span class="number">' + Math.floor(bycicleTime / 60) + '</span>시간 '
			    }
			    bycicleMin = '<span class="number">' + bycicleTime % 60 + '</span>분'
			
			    // 거리와 도보 시간, 자전거 시간을 가지고 HTML Content를 만들어 리턴합니다
			    var content = '<ul class="dotOverlay distanceInfo">';
			    content += '    <li>';
			    content += '        <span class="label">총거리</span><span class="number">' + distance + '</span>m';
			    content += '    </li>';
			    content += '    <li>';
			    content += '        <span class="label">도보</span>' + walkHour + walkMin;
			    content += '    </li>';
			    content += '    <li>';
			    content += '        <span class="label">자전거</span>' + bycicleHour + bycicleMin;
			    content += '    </li>';
			    content += '</ul>'
			
			    return content;
			}
			    
			</script>
		
	
		<!-- footer -->
		<%@ include file="/views/commons/footer/footer.jsp"%>	
	</div>
	
</body>
</html>