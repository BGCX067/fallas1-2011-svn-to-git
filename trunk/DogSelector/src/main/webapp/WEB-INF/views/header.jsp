<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<div id="header-img">
	<div>
		<span>Eleccion del perro ideal</span>
	</div>
</div>

<c:if test="${!empty answers}">
	<h3>Respuestas</h3>
	<div id="answers-container">
		<c:forEach var="answer" items="${answers}">
			<b><c:out value="${answer.question.questionText}"/>:</b>
			<c:out value="${answer.selectedOptionDescription}"/>
			<br/>
		</c:forEach>
	</div>
</c:if>