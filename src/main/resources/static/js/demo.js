function search() {
	var userId = document.getElementById("userId").value;
//	window.location.href = link;
//	var oAjax = new XMLHttpRequest();
//	oAjax.open("POST","check?name="+userId,true);
//	oAjax.send();
	window.location.href ="check?name="+userId;
}

