function  onSelectPayeeSubmit(action) {
		var action1="addPayeeAction";
		var action2="makePaymentAction";
		alert("action wwwwwwname= "+ action);
		if(action==action1)
		{
				//document.forms[0].action="http://localhost:8080/synergy-bank/bank/addPayee"
			    alert("____(#_#+_#++___");
				$("#customerTransactionCommand").attr("action","http://localhost:8080/synergy-bank/bank/addPayee");
		}
		
		alert("Document wis going to be submitted");
		$("#customerTransactionCommand").submit();
		//document.forms[0].submit();	
	}