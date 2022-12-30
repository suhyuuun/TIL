<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>버튼</title>
</head>
<body>
	<c:forEach items="${res_test}" var="dto">
		<p>
			<a href="detailPageMap.do?x=${dto.latitude}&y=${dto.longitude}" data-value="전환마을 부엌밥풀꽃">전환마을
				부엌밥풀꽃</a>
		</p>
		<p>
			<a href="detailPageMap.do?x=${dto.latitude}&y=${dto.longitude}" data-value="본도시락 보라매점">본도시락
				보라매점</a>
		</p>
	</c:forEach>
</body>
</html>