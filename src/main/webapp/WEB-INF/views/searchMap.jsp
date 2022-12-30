<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색페이지 지도</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=12231aee9abe11c18052c9da5753ed7e&libraries=services"></script>
</head>
<body>
	<input type="text" name="search" id="search" />
	<input type="button" id="btn" value="검색" />
	<div id="map" style="width: 100%; height: 350px;"></div>
	<script src="map/searchPageMap.js"></script>
</body>
</html>