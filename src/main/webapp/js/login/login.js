/**
 * CommFuncts
 * 
 * Communication Functions
 * 
 * Alfredo Barrios
 */
var _Login = {
	ShowForm:function(){
		var lang = _CommonFunctions.SetCookie("language");
		var lg_global = null;
		var lg_login = null;
		if(lang===undefined) lang="sp";
		if(lang=="sp"){
			lg_global = splg_global;
			lg_login = splg_login;
		}else{
			lg_global = enlg_global;
			lg_login = enlg_login;
		}
		$("#lblTitle").html(lg_global.lblTitle);
		$("#lblGotoPrivacyPol").html(lg_global.lblGotoPrivacyPol);
		$("#lblCopyright").html(lg_global.lblCopyright);
		$("#lblGotoTermsCondit").html(lg_global.lblGotoTermsCondit);
		$("#lblFormTitle").html(lg_login.lblFormTitle);
		$("#lblinputEmailAddress").html(lg_login.lblinputEmailAddress);
		$("#lblinputPassword").html(lg_login.lblinputPassword);
		$("#lblrememberPasswordCheck").html(lg_login.lblrememberPasswordCheck);
		$("#lnkGoRecoveryPassword").html(lg_login.lnkGoRecoveryPassword);
		$("#lblGotoRegister").html(lg_login.lblGotoRegister);
		$("#btnSubmit").val(lg_login.btnSubmit);
		$("#btnSubmit").click(function(){ 
			return _Login.SubmitForm();
		});
	},
	SubmitForm:function(){
		try {
			if(!_Login.Validation())
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


 _Login.ShowForm();
