
/**
 * 
 */
function  validateCustomerForm() {
	var email = document.customerRegistration.email.value;
	var mobile = document.customerRegistration.mobile.value;
	
	if(email.length==0) {
		alert("email cannot be blank.");
		if(mobile.length==0 || mobile.length!=10)
		{	
			alert("mobile number shoulb be of 10 digits only");
		}
		return;
	}
	
	

	//here we are submitting the form
	document.customerRegistration.submit();

	
}