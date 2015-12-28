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
		
		<jsp:include page="breed-info.jsp"/>
		
<%-- 		<h2><c:out value="${selectedBreed.name}"/></h2> --%>
<%-- 		<form:form action="addAnswers" method="POST" commandName="answersDTO"> --%>
<!-- 			<div id="breed-container" class="clearfix"> -->
<%-- 				<img height=274 class="breed-info-img" src="resources/images/<c:out value="${selectedBreed.id}"/>.jpg"/> --%>
<!-- 				<div class="breed-info"> -->
<!-- 					<div class="breed-info-container"> -->
<!-- 						<input type="checkbox" name="dogSize" -->
<%-- 							<c:if test="${breedAnswers.dogSize != null}"> --%>
<!-- 								checked disabled  -->
<%-- 							</c:if> --%>
<!-- 						/> -->
<!-- 						<span class="breed-attribute">Tama&ntilde;o:</span> -->
<%-- 						<span class="breed-attribute-value"><c:out value="${selectedBreed.dogSize}"/></span> --%>
<!-- 					</div> -->
<!-- 					<div class="breed-info-container"> -->
<!-- 						<input type="checkbox" name="exercise" -->
<%-- 							<c:if test="${breedAnswers.exercise != null}"> --%>
<!-- 								checked disabled -->
<%-- 							</c:if> --%>
<!-- 						/> -->
<!-- 						<span class="breed-attribute">Requerimiento de ejercicio:</span> -->
<%-- 						<span class="breed-attribute-value"><c:out value="${selectedBreed.exercise}"/></span> --%>
<!-- 					</div> -->
<!-- 					<div class="breed-info-container"> -->
<!-- 						<input type="checkbox" name="bark" -->
<%-- 							<c:if test="${breedAnswers.bark != null}"> --%>
<!-- 								checked disabled -->
<%-- 							</c:if> --%>
<!-- 						/> -->
<!-- 						<span class="breed-attribute">Tendencia a ladrar:</span> -->
<%-- 						<span class="breed-attribute-value"><c:out value="${selectedBreed.bark}"/></span> --%>
<!-- 					</div> -->
<!-- 					<div class="breed-info-container"> -->
<!-- 						<input type="checkbox" name="animals" -->
<%-- 							<c:if test="${breedAnswers.animals != null}"> --%>
<!-- 								checked disabled -->
<%-- 							</c:if> --%>
<!-- 						/> -->
<!-- 						<span class="breed-attribute">Compatibilidad con otros animales:</span> -->
<%-- 						<span class="breed-attribute-value"><c:out value="${selectedBreed.animals}"/></span> --%>
<!-- 					</div> -->
<!-- 					<div class="breed-info-container"> -->
<!-- 						<input type="checkbox" name="children" -->
<%-- 							<c:if test="${breedAnswers.children != null}"> --%>
<!-- 								checked disabled -->
<%-- 							</c:if> --%>
<!-- 						/> -->
<!-- 						<span class="breed-attribute">Apropiado para ni&ntilde;os:</span> -->
<%-- 						<span class="breed-attribute-value"><c:out value="${selectedBreed.children}"/></span> --%>
<!-- 					</div> -->
<!-- 					<div class="breed-info-container"> -->
<!-- 						<input type="checkbox" name="timeAlone" -->
<%-- 							<c:if test="${breedAnswers.timeAlone != null}"> --%>
<!-- 								checked disabled -->
<%-- 							</c:if> --%>
<!-- 						/> -->
<!-- 						<span class="breed-attribute">Angustia por soledad:</span> -->
<%-- 						<span class="breed-attribute-value"><c:out value="${selectedBreed.timeAlone}"/></span> --%>
<!-- 					</div> -->
<!-- 					<div class="breed-info-container"> -->
<!-- 						<input type="checkbox" name="protection" -->
<%-- 							<c:if test="${breedAnswers.protection != null}"> --%>
<!-- 								checked disabled -->
<%-- 							</c:if> --%>
<!-- 						/> -->
<!-- 						<span class="breed-attribute">Aptitud como guardian:</span> -->
<%-- 						<span class="breed-attribute-value"><c:out value="${selectedBreed.protection}"/></span> --%>
<!-- 					</div> -->
<!-- 					<div class="breed-info-container"> -->
<!-- 						<input type="checkbox" name="garden" -->
<%-- 							<c:if test="${breedAnswers.garden != null}"> --%>
<!-- 								checked disabled -->
<%-- 							</c:if> --%>
<!-- 						/> -->
<!-- 						<span class="breed-attribute">Apropiado para el jardin:</span> -->
<%-- 						<span class="breed-attribute-value"><c:out value="${selectedBreed.garden}"/></span> --%>
<!-- 					</div> -->
<!-- 					<div class="breed-info-container"> -->
<!-- 						<input type="checkbox" name="houseSize" -->
<%-- 							<c:if test="${breedAnswers.houseSize != null}"> --%>
<!-- 								checked disabled -->
<%-- 							</c:if> --%>
<!-- 						/> -->
<!-- 						<span class="breed-attribute">Tamaño de casa requerida:</span> -->
<%-- 						<span class="breed-attribute-value"><c:out value="${selectedBreed.houseSize}"/></span> --%>
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<input type="submit" value="Enviar" /> -->		
<%-- 		</form:form> --%>
			<input type="button" value="Volver" onClick="javascript:window.location='home';">
	</body>
</html>