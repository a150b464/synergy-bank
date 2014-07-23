
/**
 * @author Swapnil
 */
  function checkaddPayeeForm()
  {
	 
	  var accno = document.addPayee.payeeAccountNo.value;
	  var pname = document.addPayee.payeeName.value;
	 
	  /*var re = new RegExp(/[A-Za-z -']$/);
	  var re2=new RegExp(number);
	  */
	  
	  if(pname.length==0){
		  alert("Name should not be blank!");	  
		  document.getElementById('nameError').style.background ='#e35152';
		  return false;
		}
	  else{
		  document.getElementById('name').style.background ='#ccffcc';
		  document.getElementById('nameError').style.display="none";
		  return true; 
		}
  
	  	  
	  

        return false;
  }
  
  function checkPayeeNickName()
  {
	 
	  var pname = document.addPayee.payeeNickName.value;
	   
	  if(pname.length==0){
		  alert("Payee Nick Name should not be blank!");	  
		  document.getElementById('pNickNameError').style.background ='#e35152';
		  return false;
		}
	  else{
		  document.getElementById('name').style.background ='#ccffcc';
		  document.getElementById('pNickNameError').style.display="none";
		  return true; 
		}
  
	  	  
	  

        return false;
  }

