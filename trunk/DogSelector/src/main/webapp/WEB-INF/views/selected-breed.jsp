<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>
	<head>
		<title>Eleccion del perro ideal</title>
		<link rel="stylesheet" type="text/css" href="resources/css/main.css">
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		
		<jsp:include page="breed-info.jsp"/>
		
		<c:if test="${previousPage != null}">
			<input type="button" value="Volver" onClick="javascript:window.location='<c:out value="${previousPage}"/>';">
		</c:if>
		<input type="button" value="Reiniciar seleccion" onClick="javascript:window.location='startOver';">
	</body>
</html>