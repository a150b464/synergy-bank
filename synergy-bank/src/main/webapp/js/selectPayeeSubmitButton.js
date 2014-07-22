function  onSelectPayeeSubmit(action) {
<<<<<<< .mine
	
	var action1="addPayeeAction";
	var action2="makePaymentAction";
	
	//document.write("action name= "+ action);
	
	if(action==action1)
=======
		var action1="addPayeeAction";
		var action2="makePaymentAction";
		alert("action wwwwwwname= "+ action);
		if(action==action1)
>>>>>>> .r144
		{
<<<<<<< .mine
			document.forms[0].action="http://localhost:8080/synergy-bank/bank/addpayee.do"
=======
				//document.forms[0].action="http://localhost:8080/synergy-bank/bank/addPayee"
			    alert("____(#_#+_#++___");
				$("#customerTransactionCommand").attr("action","http://localhost:8080/synergy-bank/bank/addPayee");
>>>>>>> .r144
		}
		
		alert("Document wis going to be submitted");
		$("#customerTransactionCommand").submit();
		//document.forms[0].submit();	
	}