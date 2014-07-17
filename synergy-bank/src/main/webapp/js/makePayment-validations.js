
/**
 * 
 */
function  validateMakePaymentForm() {
	
	
	var transactionAmount = document.makePayments.transactionAmount.value;
	//document.write('TRANSACTION AMOUNT is:' + transactionAmount);
	if(transactionAmount.length==0) {
	 alert("Transaction Amount cannot be blank."+transactionAmount);
	 return;
	}
	

	//here we are submitting the form
	document.makePayments.submit();
	
	 

	
}