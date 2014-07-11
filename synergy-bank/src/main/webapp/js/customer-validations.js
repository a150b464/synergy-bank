
/**
 * 
 */
function  validateCustomerForm() {
	var userid = document.customerRegistration.userId.value;
	if(userid.length==0) {
		alert("userid cannot be blank.");
		return;
	}
	
	
	
	//here we are submitting the form
	document.customerRegistration.submit();
	//var password = document.customerRegistration.password;
	//var contact = document.customerRegistration.mobile;
	//var mailid = document.customerRegistration.email;*/
	
}