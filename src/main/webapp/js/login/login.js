/**
 * CommFuncts
 * 
 * Communication Functions
 * 
 * Alfredo Barrios
 */
var _Login = {
	ShowForm:function(){
		try {
			var lang = _CommonFunctions.SetCookie("language");
			var lg_global = null;
			var lg_login = null;
			if(lang===undefined) lang="sp";
			if(lang=="sp"){
				lg_global = splg_global;
				lg_form = splg_login;
			}else{
				lg_global = enlg_global;
				lg_form = enlg_login;
			}
			document.title = lg_form.htmlTitle;
			$("#lblTitle").html(lg_global.lblTitle);
			$("#lblGotoPrivacyPol").html(lg_global.lblGotoPrivacyPol);
			$("#lblCopyright").html(lg_global.lblCopyright);
			$("#lblGotoTermsCondit").html(lg_global.lblGotoTermsCondit);
			$("#lblFormTitle").html(lg_form.lblFormTitle);
			$("#lblinputEmailAddress").html(lg_form.lblinputEmailAddress);
			$("#lblinputPassword").html(lg_form.lblinputPassword);
			$("#lblrememberPasswordCheck").html(lg_form.lblrememberPasswordCheck);
			$("#lnkGoRecoveryPassword").html(lg_form.lnkGoRecoveryPassword);
			$("#lblGotoRegister").html(lg_form.lblGotoRegister);
			$("#worngCredentialsMsg").html(lg_form.worngCredentialsMsg);
			$("#unExpectedErrorMsg").html(lg_form.unExpectedErrorMsg);
			$("#emailEmptyMsg").html(lg_form.emailEmptyMsg);
			$("#passwordEmptyMsg").html(lg_form.passwordEmptyMsg);
			$("#btnSubmit").val(lg_form.btnSubmit);
			$("#btnSubmit").click(function(){ 
				_Login.CleanMsg();
				return _Login.SubmitForm();
			});
			$("#inputEmailAddress").focusin(function() {
				_Login.CleanMsg();
			});
			$("#inputPassword").focusin(function() {
				_Login.CleanMsg();
			});
			} catch (error) {
			alert(error);
		}
	},
	CleanMsg:function(){
		$("#worngCredentialsMsg").hide();
		$("#unExpectedErrorMsg").hide();
		$("#emailEmptyMsg").hide();
		$("#passwordEmptyMsg").hide();
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
				if(data.message=="WRONG_CREDENTIALS"){
					$("#worngCredentialsMsg").show();
				}
				else{
					$("#unExpectedErrorMsg").show();
				}
				return false;
			}
			$("#successMsg").show();
			if($("#rememberPasswordCheck").prop("checked")==true){
				_CommonFunctions.SetCookie("token", data.data.value);
			}
		} catch (error) {
			$("#unExpectedErrorMsg").show();
		}
		return false;
	},
	ResetForm:function(){
		//TO DO
		alert('ResetForm');
	},
	Validation: function(){
		if($("#inputEmailAddress").val().trim()==""){
			$("#emailEmptyMsg").show();
			return false;
		}
		if($("#inputPassword").val().trim()==""){
			$("#passwordEmptyMsg").show();
			return false;
		}
		return true;
	},
	Mock:function(){
		alert('_Login Mock');
	}
}


 _Login.ShowForm();
