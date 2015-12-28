<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<h2><c:out value="${selectedBreed.name}"/></h2>
		
<div id="breed-container" class="clearfix">
	<img height=272 class="breed-info-img" src="resources/images/<c:out value="${selectedBreed.id}"/>.jpg"/>
	<div class="breed-info">
		<div class="breed-info-container"><span class="breed-attribute">Tamaño:</span><span class="breed-attribute-value"><c:out value="${selectedBreed.dogSize}"/></span></div>
		<div class="breed-info-container"><span class="breed-attribute">Requerimiento de ejercicio:</span><span class="breed-attribute-value"><c:out value="${selectedBreed.exercise}"/></span></div>
		<div class="breed-info-container"><span class="breed-attribute">Tendencia a ladrar:</span><span class="breed-attribute-value"><c:out value="${selectedBreed.bark}"/></span></div>
		<div class="breed-info-container"><span class="breed-attribute">Compatibilidad con otros animales:</span><span class="breed-attribute-value"><c:out value="${selectedBreed.animals}"/></span></div>
		<div class="breed-info-container"><span class="breed-attribute">Apropiado para niños:</span><span class="breed-attribute-value"><c:out value="${selectedBreed.children}"/></span></div>
		<div class="breed-info-container"><span class="breed-attribute">Angustia por soledad:</span><span class="breed-attribute-value"><c:out value="${selectedBreed.timeAlone}"/></span></div>
		<div class="breed-info-container"><span class="breed-attribute">Aptitud como guardian:</span><span class="breed-attribute-value"><c:out value="${selectedBreed.protection}"/></span></div>
		<div class="breed-info-container"><span class="breed-attribute">Apropiado para el jardin:</span><span class="breed-attribute-value"><c:out value="${selectedBreed.garden}"/></span></div>
		<div class="breed-info-container"><span class="breed-attribute">Tamaño de casa requerida:</span><span class="breed-attribute-value"><c:out value="${selectedBreed.houseSize}"/></span></div>
	</div>
</div>