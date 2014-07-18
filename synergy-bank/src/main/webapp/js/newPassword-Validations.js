
/**
 * 
 */
function  validateMakePaymentForm() {
	
	
	var currentPwd = document.changePassword.cPassword.value;
	var newPwd = document.changePassword.nPassword.value;
	var confirmPwd = document.changePassword.confirmPassword.value;
	
	if(currentPwd.length==0) {
	 alert("Password Amount cannot be blank!"+currentPwd);
	 return;
	}
	if(currentPwd==newPwd)
		 {
		  alert("New password cannot be same as previous password!");
		  return;
		 }
	
	if(newPwd.length==0)
		{
		 alert("Password cannot be blank!"+newPwd);
		 return;
		 }
	if(confirmedPwd.length==0) 
		{
		 alert("Password Amount cannot be blank!"+confirmedPwd);
		 return;
		 }
	if(confirmedPwd!=newPwd) 
		{
		alert("Both the paswwords must match!"+confirmedPwd);
		return;
		}
				
			
	//here we are submitting the form
	document.changePassword.submit();
}
