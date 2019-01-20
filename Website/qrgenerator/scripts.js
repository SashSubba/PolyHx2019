$(document).ready(function(){

	$("#qrcode").click(function(){

		var url_getter =  $("#qrcode2").text();

		$("#qrcode2").attr("value", url_getter);

	});

});