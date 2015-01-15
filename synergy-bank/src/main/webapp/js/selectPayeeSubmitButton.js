/**
 * 
 * * @author Swapnil
 */


function  onSelectPayeeSubmit(action) {
	
	var action1="addPayeeAction";
	var action2="makePaymentAction";
	
	
		if(action==action1)

		{
			document.forms[0].action="http://localhost:8889/synergy-bank/bank/addpayee.do"
				
			//$("#customerTransactionCommand").attr("action","http://localhost:8080/synergy-bank/bank/addPayee");
		}
		
		
		document.forms[0].submit();
		//$("#customerTransactionCommand").submit();
		return;	
	}