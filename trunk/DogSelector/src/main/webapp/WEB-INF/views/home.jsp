<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>
	<head>
		<title>Eleccion del perro ideal</title>
		<script type="text/javascript" src="resources/js/jquery-1.6.1.js"></script>
		<link rel="stylesheet" type="text/css" href="resources/css/main.css">
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		
		<h3>Pregunta</h3>
		<form:form action="answer" method="POST" commandName="answer">
			<span><c:out value="${question.questionText}"/> </span>
			<form:select path="selectedOptionValue" size="1" >
				<form:options items="${question.options}" itemValue="number" itemLabel="description"/>
			</form:select>
			<br/>
			<br/>
			<input type="hidden" name="questionIndex" value="${answer.questionIndex}" />
			<input type="submit" value="Enviar" />
			
			<c:if test="${!empty answers}">
<!-- 				<input type="button" value="Volver a la pregunta anterior" onClick="javascript:window.location='deleteLastAnswer';"> -->
				<input type="button" value="Reiniciar seleccion" onClick="javascript:window.location='startOver';">
			</c:if>
		</form:form>
		
		<jsp:include page="possible-breeds.jsp"/>
	</body>
</html>
