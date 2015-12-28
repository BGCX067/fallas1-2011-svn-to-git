<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>
	<head>
		<title>Eleccion del perro ideal</title>
		<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
		<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
		<script type="text/javascript" src="resources/js/map.js"></script>
		<script type="text/javascript" src="resources/js/jquery-1.6.1.js"></script>
		<link rel="stylesheet" type="text/css" href="resources/css/main.css">
	</head>
	<body onload="initialize()">
		<jsp:include page="header.jsp"/>
		
		<h3>Pregunta</h3>
		<form:form action="mapSelection" method="POST" commandName="answer">
			<span><c:out value="${question.questionText}"/> </span>
			<br/>
			<input type="submit" value="Enviar" />
			<c:if test="${!empty answers}">
<!-- 				<input type="button" value="Volver a la pregunta anterior" onClick="javascript:window.location='deleteLastAnswer';"> -->
				<input type="button" value="Reiniciar seleccion" onClick="javascript:window.location='startOver';">
			</c:if>
			
			<div style="float: left; width: 100%;">
				<div id="map_canvas" style="width:500px; height:500px; float: left;"></div>
				<div id="selectedInfo" style="float: left; padding-left: 20px;">
					<span id="selectedStateText"></span>
				</div>
			</div>
			
			<input type="hidden" name="questionIndex" value="${answer.questionIndex}" />
			<input id="selectedState" type="hidden" name="selectedOptionValue" value="" />
		</form:form>
	</body>
</html>
