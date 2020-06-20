/**
 * CommFuncts
 * 
 * Communication Functions
 * 
 * Alfredo Barrios
 */
var setPassword = {
	ShowForm:function(){
		var lg_global = null;
		var lg_login = null;
		if(lang=="es"){
			lg_global = splg_global;
			lg_form = splg_SetPwd;
		}else{
			lg_global = enlg_global;
			lg_form = enlg_SetPwd;
		}
		document.title = lg_form.htmlTitle;
		$("#lblTitle").html(lg_global.lblTitle);
		$("#lblGotoPrivacyPol").html(lg_global.lblGotoPrivacyPol);
		$("#lblCopyright").html(lg_global.lblCopyright);
		$("#lblGotoTermsCondit").html(lg_global.lblGotoTermsCondit);
		$("#lblFormTitle").html(lg_form.lblFormTitle);
		$("#lblEnterPassword").html(lg_form.lblEnterPassword);
		$("#lblinputPassword").html(lg_form.lblinputPassword);
		$("#lblinputConfirmPassword").html(lg_form.lblinputConfirmPassword);
		$("#codeDoesNotExistMsg").html(lg_form.codeDoesNotExistMsg);
		$("#fiilPasswordAndConfirmMsg").html(lg_form.fiilPasswordAndConfirmMsg);
		$("#confirmDoesNotMatchMsg").html(lg_form.confirmDoesNotMatchMsg);
		$("#lengthWronghMsg").html(lg_form.lengthWronghMsg);		
		$("#unexpectedErrorMsg").html(lg_form.unexpectedErrorMsg);
		$("#successMsg").html(lg_form.successMsg);
		$("#btnSubmit").val(lg_form.btnSubmit);
		$("#btnSubmit").click(function(){ 
			setPassword.CleanMsg();
			return setPassword.SubmitForm();
		});
		$("#inputPassword").focusin(function() {
			setPassword.CleanMsg();
		});
		$("#inputConfirmPassword").focusin(function() {
			setPassword.CleanMsg();
		});
		setPassword.CheckCode();
	},
	CleanMsg:function(){
		$("#codeDoesNotExistMsg").hide();
		$("#fiilPasswordAndConfirmMsg").hide();
		$("#confirmDoesNotMatchMsg").hide();
		$("#unexpectedErrorMsg").hide();
		$("#lengthWronghMsg").hide();
	},
	CheckCode:function(){
		var code = _CommonFunctions.GetUrlParameter("code");
		if($.trim(code)=="") {
			$("#formSetPassword").hide();
			$("#codeDoesNotExistMsg").show();
			return false;
		}
		var params = {"platform":"web","caller": _CommonFunctions.GetCaller(),"code": code};
		var data = _Communication.GetRemoteDataPost(urlVerifyChangePasswordCode, params);

		if(data.code!=200){
			$("#formSetPassword").hide();
			$("#codeDoesNotExistMsg").show();
			return false;
		}
	},
	SubmitForm:function(){
		try {
			if(!setPassword.Validation())
			{
				return false;
			}

			var code = _CommonFunctions.GetUrlParameter("code");
			var params = {"code": code , "newpassword": $("#inputPassword").val().trim(), "confirmpassword": $("#inputConfirmPassword").val().trim()};
			var data = _Communication.GetRemoteDataPost(urlSetNewPassword, params);
	
			if(data.code!=200){
				_MessageBox.Show("Error: " + data.code + "- " + data.message);
				return false;
			}
			if(data.data.result==true){
				$("#btnSubmit").hide();
				$("#successMsg").show();
			}else{
				$("#emailDoesNotExistMsg").show();
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
		if($("#inputPassword").val().trim()==""||$("#inputConfirmPassword").val().trim()==""){
			$("#fiilPasswordAndConfirmMsg").show();
			return false;
		}
		if($("#inputPassword").val().trim().length<7){
			$("#lengthWronghMsg").show();
			return false;
		}
		if($("#inputPassword").val().trim()!=$("#inputConfirmPassword").val().trim()){
			$("#confirmDoesNotMatchMsg").show();
			return false;
		}
		return true;
	},
	Mock:function(){
		alert('setPassword Mock');
	}
}


setPassword.ShowForm();
