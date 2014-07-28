
/**
 * 
 */
function validateResetPassword() {
	
	var flag=true;
	var answer = document.resetPasswordInit.answer.value;
	
	alert(answer);

	if(answer.length==0) {
		alert("Answer cannot be blank.");
		flag=false;
		return flag;
		
	}
	else
	{
		alert("secert code has been emailed to your given email address! ");
		document.makePayments.submit();		
	}
	return;
}