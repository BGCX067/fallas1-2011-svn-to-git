<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<c:if test="${!empty possibleBreeds}">
	<script type="text/javascript" src="resources/js/possible-breeds.js"></script>
	
	<div id="possible-breeds">
		<h3>Razas posibles</h3>
		<div id="possible-breeds-list">
			<c:forEach var="breed" items="${possibleBreeds}">
				<div id="<c:out value="${breed.id}"/>_select" class="possible-breed">
					<img src="resources/images/<c:out value="${breed.id}"/>.jpg" width=50 height=50 />
					<span class="breed-name"><c:out value="${breed.name}"/></span>
				</div>
			</c:forEach>
		</div>
	</div>
</c:if>