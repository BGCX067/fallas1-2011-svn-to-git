<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>
	<head>
		<title>Eleccion del perro ideal</title>
		<link rel="stylesheet" type="text/css" href="resources/css/main.css">
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		
		<h2>La Raza sugerida es:</h2>
		<jsp:include page="breed-info.jsp"/>
		
		<input type="button" value="Reiniciar seleccion" onClick="javascript:window.location='startOver';">
	</body>
</html>