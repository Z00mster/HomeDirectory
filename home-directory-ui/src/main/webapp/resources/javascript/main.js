$(document).ready(function() {
	
//    $('.folder-image').click(function(request) {
//    	console.log("asndjasndkas");
//    	$('.folder-input').submit();
//    	var pathname = $(location).attr('href');
//	    pathname = pathname + "goto";
//	    $.get(pathname, function(data, status) {
//	        alert("Data: " + data + "\nStatus: " + status);
//	    });
//    });
    
});

function submitForm(image) {
	var input = $(image).next();
	$(input).click();
}