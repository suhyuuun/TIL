<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세페이지전 리스트페이지</title>
</head>
<body>
	<c:forEach items="${mList}" var="dto">
		<c:url var="path" value=detailPageMap.do>
			<c:param name="lat" value="${dto.latitude}" />
			<c:param name="lng" value="${dto.longitude}" />
		</c:url>
	</c:forEach>
</body>
</html>