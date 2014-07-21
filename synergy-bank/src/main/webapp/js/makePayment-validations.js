
/**
 * 
 */
function validateMakePaymentForm() {
	
	var flag=true;
	var transactionAmount = document.makePayments.transactionAmount.value;
	//document.write('TRANSACTION AMOUNT is:' + transactionAmount);

	if(transactionAmount.length==0) {
		flag=false;
		alert("Transaction Amount cannot be blank.");
		return flag;
		
	}
	else
	{
		alert("The transactions details has been emailed to your given email address! Thank You for banking with us!!! "+transactionAmount);
		document.makePayments.submit();		
	}
}