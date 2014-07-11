function validateregdform() {
	var userid = document.customerRegistration.userId;
	var password = document.customerRegistration.password;
	var contact = document.customerRegistration.mobile;
	var mailid = document.customerRegistration.email;
alert(userid);
alert(password);
	if (validate_userId(userid, 4, 10)) {
		if (validate_password(password, 6, 12)) {
			if (validate_phone(contact)) {
				if (ValidateEmail(mailid)) {
						return true;
						}
					}
				}
			}
	
	return false;
}

/*function validate_userId(userid, min, max) {
	
	  var x = userid.value;
	    if (x == null || x == "" ||  x > max) {
	        alert("First name must be filled out");
	        document.loginform.userid.focus();
	        return false;
	    }
	}
}*/

function validate_userId(userid) {
	var letters = /^[A-Za-z]+$/;
	if (userid.value.match(letters)) {
		document.getElementById("iderror").innerHTML = "";
		return true;
	} else {
		document.getElementById("iderror").innerHTML = "only aplhabets are allowed";
		userid.focus();
		return false;
	}

}

function validate_password(password, min, max) {
	var len = password.value.length;
	if (len == 0 || len < min || len > max) {
		document.getElementById("passerror").innerHTML = "should not be empty Or between "
				+ min + " and " + max + "";
		password.focus();
		return false;
	} else {
		document.getElementById("passerror").innerHTML = "";
		return true;
	}
}


function validate_phone(contact) {
	var onlydigit = /^\d{10}$/;
	if (contact.value.match(onlydigit)) {
		document.getElementById("phoneerror").innerHTML = "";
		return true;
	} else {
		document.getElementById("phoneerror").innerHTML = "only accept digits";
		contact.focus();
		return false;
	}
}

function ValidateEmail(mailid) {
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if (mailid.value.match(mailformat)) {
		return true;
	} else {
		document.getElementById("emailerror").innerHTML = "You have entered an invalid email address!";
		mailid.focus();
		return false;
	}
}