$(document).ready(function() {
	$(".possible-breed").click(function() {
		var breedId = $(this).attr('id').split('_')[0];
		window.location = 'showBreedInfo?breedId=' + breedId + "&previousPage=showBreedsRanking";
	});
	
	$(".possible-breed").css('background-color', '#B9C7D2');
	
	$(".possible-breed").hover(function(){
		$(this).css('background-color', '#204595');
		$(this).css('color', '#ffffff');
	}, function() {
		$(this).css('background-color', '#B9C7D2');
		$(this).css('color', '#000000');
	});
});