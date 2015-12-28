<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>
	<head>
		<title>Eleccion del perro ideal</title>
		<script type="text/javascript" src="resources/js/jquery-1.6.1.js"></script>
		<script type="text/javascript" src="resources/js/breeds-ranking.js"></script>
		<link rel="stylesheet" type="text/css" href="resources/css/main.css">
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		
		<h3>No hay una raza que concuerde exactamente con sus requerimientos</h3>
		
		<div id="breeds-ranking">
			<div id="possible-breeds-list">
				<c:forEach var="breed" items="${breedsRanking}">
					<div id="<c:out value="${breed.id}"/>_select" class="possible-breed">
						<img src="resources/images/<c:out value="${breed.id}"/>.jpg" width=50 height=50 />
						<span class="breed-name"><c:out value="${breed.name}"/></span>
						<span class="breed-ranking-points">Puntaje: <c:out value="${breed.points}"/></span>
					</div>
				</c:forEach>
			</div>
		</div>
		<input type="button" value="Reiniciar seleccion" onClick="javascript:window.location='startOver';">
	</body>
</html>
