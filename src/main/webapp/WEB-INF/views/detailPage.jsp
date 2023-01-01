<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세페이지전 리스트페이지</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=85e3a2b784700813659ca3ae8da46d29"></script>
</head>
<body>
<input type="button" onclick="button1_click();" value="버튼1" />
<!-- 이미지 지도를 표시할 div 입니다 -->
<div id="staticMap" style="width:600px;height:350px;"></div>    
<script>

function button1_click(){	
//	window.location.href = "http://localhost:8090/myapp/detailPageMap.do";
	coordinate("37.6106947", "126.9160994");
}


function coordinate(lat, lng){
	$.ajax({

		type : 'POST',
		dataType : 'json',
		data : {
			'lat' : lat,
			'lng' : lng
		},
		url : 'detailPageMap.do',
		success : function(result) {
			var lat = result.lat;
			var lng = result.lng;
			console.log("lat: "+ lat + "lng: " + lng);
			marker(lat,lng);
		},
		error : function(error) {
			alert(error);
		}
	});
}

function marker(lat, lng){
	// 이미지 지도에서 마커가 표시될 위치입니다 
	var markerPosition  = new kakao.maps.LatLng(lat, lng); 

	// 이미지 지도에 표시할 마커입니다
	// 이미지 지도에 표시할 마커는 Object 형태입니다
	var marker = {
	    position: markerPosition
	};

	var staticMapContainer  = document.getElementById('staticMap'), // 이미지 지도를 표시할 div  
	    staticMapOption = { 
	        center: new kakao.maps.LatLng(lat, lng), // 이미지 지도의 중심좌표
	        level: 3, // 이미지 지도의 확대 레벨
	        marker: marker // 이미지 지도에 표시할 마커 
	    };    

	// 이미지 지도를 생성합니다
	var staticMap = new kakao.maps.StaticMap(staticMapContainer, staticMapOption);
	}
</script>
</body>
</html>