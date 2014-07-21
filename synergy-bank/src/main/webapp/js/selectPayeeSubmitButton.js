
/**
 * 
 */
function  onSelectPayeeSubmit(action) {
	
	var action1="addPayeeAction";
	var action2="makePaymentAction";
	
	document.write("action name= "+ action);
	
	if(action==action1)
		{
			document.forms[0].action="http://localhost:8080/synergy-bank/bank/addPayee"
		}
	
	alert("Document is going to be submitted");
	
	document.forms[0].submit();	
}