/**
 * CommFuncts
 * 
 * Communication Functions
 * 
 * Alfredo Barrios
 */
var _Login = {
	OnSubmit:function(){

	},
	ShowLoginForm:function(){
		alert('ShowLoginForm');
	},
	SubmitForm:function(){
		try {
			if(!_Login.Validation())
			{
				return false;
			}
			
		} catch (error) {
			alert('SubmitForm error: ' + error);
			
		}
		return false;
	},
	ResetForm:function(){
		alert('ResetForm');
	},
	Validation: function(){
		if($("#inputEmailAddress").val().trim()==""){
			_MessageBox.Show("Por favor proporcione su cuenta de e-mail");
			$("#inputEmailAddress").focus();
			return false;
		}
		if($("#inputPassword").val().trim()==""){
			_MessageBox.Show("Por favor proporcione su contraseña.");
			$("#inputPassword").focus();
			return false;
		}

		var params = {"username":$("#inputEmailAddress").val().trim(), "password":$("#inputPassword").val().trim()};

		var data = _CommFuncts.GetRemoteDataPost(ulrLoginValidation, params);

		if($("#rememberPasswordCheck").prop("checked")==true){
			//TO DO
		}
		return true;
	},
	Mock:function(){
		alert('_Login Mock');
	}
}

$("#btnSubmit").click(function(){ 
	return _Login.SubmitForm();
 });