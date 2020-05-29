/*
* Communication Functions
* 
* Alfredo Barrios
*/
var recoveryPassword = {
	ShowForm:function(){
		var lang = _CommonFunctions.SetCookie("language");
		var lg_global = null;
		var lg_form = null;
		if(lang===undefined) lang="sp";
		if(lang=="sp"){
			lg_global = splg_global;
			lg_form = splg_registry;
		}else{
			lg_global = enlg_global;
			lg_form = enlg_registry;
		}
		$("#lblTitle").html(lg_global.lblTitle);
		$("#lblGotoPrivacyPol").html(lg_global.lblGotoPrivacyPol);
		$("#lblCopyright").html(lg_global.lblCopyright);
		$("#lblGotoTermsCondit").html(lg_global.lblGotoTermsCondit);
		$("#lblFormTitle").html(lg_form.lblFormTitle);
		$("#lblEnterEmail").html(lg_form.lblEnterEmail);
		$("#lblinputEmailAddress").html(lg_form.lblinputEmailAddress);
		$("#lblinputPassword").html(lg_form.lblinputPassword);
		$("#lblrememberPasswordCheck").html(lg_form.lblrememberPasswordCheck);
		$("#lnkGotoLogin").html(lg_form.lnkGotoLogin);
		$("#lblGotoRegister").html(lg_form.lblGotoRegister);
		$("#btnSubmit").val(lg_form.btnSubmit);
		$("#btnSubmit").click(function(){ 
			return recoveryPassword.SubmitForm();
		 });
	},
	SubmitForm:function(){
		try {
			if(!recoveryPassword.Validation())
			{
				return false;
			}

			var params = {"username": $("#inputEmailAddress").val().trim() , "password": $("#inputPassword").val().trim()};
			var data = _Communication.GetRemoteDataPost(ulrLoginValidation, params);
	
			if(data.code!=200){
				_MessageBox.Show("Error: " + data.code + "- " + data.message);
				return false;
			}

			if($("#rememberPasswordCheck").prop("checked")==true){
				_CommonFunctions.SetCookie("token", data.data.value);
			}

		} catch (error) {
			alert('SubmitForm error: ' + error);			
		}
		return false;
	},
	ResetForm:function(){
		//TO DO
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
		return true;
	},
	Mock:function(){
		alert('_Login Mock');
	}

}

recoveryPassword.ShowForm();
