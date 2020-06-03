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
			lg_form = splg_recovPwd;
		}else{
			lg_global = enlg_global;
			lg_form = enlg_recovPwd;
		}
		document.title = lg_form.htmlTitle;
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
		$("#emailDoesNotExistMsg").html(lg_form.emailDoesNotExistMsg);
		$("#successMsg").html(lg_form.successMsg);
		$("#fillTheEmailMsg").html(lg_form.fillTheEmailMsg);
		$("#unexpectedErrorMsg").html(lg_form.unexpectedErrorMsg);
		$("#btnSubmit").click(function(){ 
			recoveryPassword.CleanMsg();
			return recoveryPassword.SubmitForm();
		 });
		$("#inputEmailAddress").focusin(function() {
			recoveryPassword.CleanMsg();
		});
	},
	CleanMsg:function(){
		$("#fillTheEmailMsg").hide();
		$("#unexpectedErrorMsg").hide();
		$("#emailDoesNotExistMsg").hide();
	},
	SubmitForm:function(){
		try {
			if(!recoveryPassword.Validation())
			{
				return false;
			}

			var params = {"username": $("#inputEmailAddress").val().trim() };
			var data = _Communication.GetRemoteDataPost(ulrRecoveryPassword, params);
	
			if(data.code!=200){
				$("#emailDoesNotExistMsg").show();
				return false;
			}
			if(data.data==true){
				$("#btnSubmit").hide();
				$("#successMsg").show();
			}else{
				$("#emailDoesNotExistMsg").show();
			}


		} catch (error) {
			alert('SubmitForm error: ' + error);			
			$("#unexpectedErrorMsg").show();
		}
		return false;
	},
	ResetForm:function(){
		//TO DO
		alert('ResetForm');
	},
	Validation: function(){
		if($("#inputEmailAddress").val().trim()==""){
			$("#fillTheEmailMsg").show();
			return false;
		}
		return true;
	},
	Mock:function(){
		alert('recoveryPassword Mock');
	}

}

recoveryPassword.ShowForm();
