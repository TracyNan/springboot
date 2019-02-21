function search() {
	var userId = document.getElementById("mirrorId").value;
	var actions = document.getElementById("items");
	var index = actions.selectedIndex;
	var action = actions.options[index].value;
	ajax({
		method : 'POST',
		url : 'check',
		data : {
			'name' : userId,
			'action' : action,
		},
		success : function(response) {
			var dataJson = JSON.parse(response);
			var html = "";
			if (dataJson.Type == "info") {
				html += "<table><tr><th>LastLoginTime</th><th>Hostname</th><th>Source</th><th>SoeId</th><th>Version</th></tr><tr><td>"
						+ dataJson.lastLoginTime
						+ "</td><td>"
						+ dataJson.hostname
						+ "</td><td>"
						+ dataJson.source
						+ "</td><td>"
						+ dataJson.soeId
						+ "</td><td>"
						+ dataJson.version + "</td></tr></table>";
			} else if (dataJson.Type == "prof") {
				var baseInfo = dataJson.userBaseInfo;
				var table1 = "<table><tr><th>SoeId</th><th>Name</th><th>Email</th><th>Status</th></tr><tr><td>"
						+ baseInfo.id
						+ "</td><td>"
						+ baseInfo.Name
						+ "</td><td>"
						+ baseInfo.eMail
						+ "</td><td>"
						+ baseInfo.status + "</td></tr></table>";
				var profInfo = dataJson.userProfInfo;
				var table2 = "<table><tr><th>SoeId</th><th>type</th><th>value</th></tr><tr><td>"
						+ profInfo.id
						+ "</td><td>"
						+ profInfo.type
						+ "</td><td>" + profInfo.value + "</td></tr></table>";
				var roleInfos = dataJson.userRoleInfos;
				var table3 = "<table><tr><th>SoeId</th><th>resourceId</th><th>resourceName</th><th>roleName</th><th>env</th></tr>"
				for ( var index in roleInfos) {
					table3 += "<tr><td>" + roleInfos[index].id + "</td><td>"
							+ roleInfos[index].resourceId + "</td><td>"
							+ roleInfos[index].resourceName + "</td><td>"
							+ roleInfos[index].roleName + "</td><td>"
							+ roleInfos[index].env + "</td></tr>";
				}
				table3 += "</table>"
				html += "<p></p>" + table1 + "<p></p>" + table2 + "<p></p>"
						+ table3;
			}
			document.getElementById("Info").innerHTML = html;
		}
	});
}

function mirror() {
	var mirrorId = document.getElementById("mirrorId").value;
	var userId = document.getElementById("userId").value;
	var userName = document.getElementById("userName").value;
	var userMail = document.getElementById("userMail").value;
	if (mirrorId == "" || userId == "" || userName == "" || userMail == "") {
		alert("Please input user information");
		return false;
	}
	ajax({
		method : 'POST',
		url : 'mirror',
		data : {
			'mirrorId' : mirrorId,
			'userId' : userId,
			'userName' : userName,
			'userMail' : userMail,
		},
		success : function(response) {
			var dataJson = JSON.parse(response);
			if (dataJson.result == "success") {
				alert("success");
				document.getElementById("mirrorId").value = userId;
				document.getElementById("userId").value = "";
				document.getElementById("userName").value = "";
				document.getElementById("userMail").value = "";
				document.getElementById("items").selectedIndex=1;
				search();
			} else {
				alert("Error occure!");
			}
		}
	});
}

function next(){
	window.location.href="login";
}

function ajax(opt) {
	opt = opt || {};
	opt.method = opt.method.toUpperCase() || 'POST';
	opt.url = opt.url || '';
	opt.async = opt.async || true;
	opt.data = opt.data || null;
	opt.success = opt.success || function() {
	};
	var xmlHttp = null;
	if (XMLHttpRequest) {
		xmlHttp = new XMLHttpRequest();
	} else {
		xmlHttp = new ActiveXObject('Microsoft.XMLHTTP');
	}
	var params = [];
	for ( var key in opt.data) {
		params.push(key + '=' + opt.data[key]);
	}
	var postData = params.join('&');
	if (opt.method.toUpperCase() === 'POST') {
		xmlHttp.open(opt.method, opt.url, opt.async);
		xmlHttp.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded;charset=utf-8');
		xmlHttp.send(postData);
	} else if (opt.method.toUpperCase() === 'GET') {
		xmlHttp.open(opt.method, opt.url + '?' + postData, opt.async);
		xmlHttp.send(null);
	}
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
			opt.success(xmlHttp.responseText);
		}
	};
}
