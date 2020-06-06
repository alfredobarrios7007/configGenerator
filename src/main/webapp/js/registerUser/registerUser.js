/**
 * @author Alfredo Barrios
 * 
 * June 4, 2020
 * 
*/
var registerUser = {
	ShowForm:function(){
		try {
			var lang = _CommonFunctions.SetCookie("language");
			var lg_global = null;
			var lg_login = null;
			if(lang===undefined) lang="sp";
			if(lang=="sp"){
				lg_global = splg_global;
				lg_form = splg_RegUser;
			}else{
				lg_global = enlg_global;
				lg_form = enlg_RegUser;
			}
			document.title = lg_form.htmlTitle;
			$("#lblTitle").html(lg_global.lblTitle);
			$("#lblGotoPrivacyPol").html(lg_global.lblGotoPrivacyPol);
			$("#lblCopyright").html(lg_global.lblCopyright);
			$("#lblGotoTermsCondit").html(lg_global.lblGotoTermsCondit);		
			$("#lblFormTitle").html(lg_form.lblFormTitle);
			$("#lblinputFirstName").html(lg_form.lblinputFirstName);
			$("#lblinputLastName").html(lg_form.lblinputLastName);
			$("#lblinputEmailAddress").html(lg_form.lblinputEmailAddress);
			$("#lblinputOrganization").html(lg_form.lblinputOrganization);
			$("#lblinputArea").html(lg_form.lblinputArea);
			$("#lblinputPassword").html(lg_form.lblinputPassword);
			$("#lblinputConfirmPassword").html(lg_form.lblinputConfirmPassword);
			$("#lnkGotoLogin").html(lg_form.lnkGotoLogin);
			$("#codeDoesNotExistMsg").html(lg_form.codeDoesNotExistMsg);
			$("#fiilPasswordAndConfirmMsg").html(lg_form.fiilPasswordAndConfirmMsg);
			$("#confirmDoesNotMatchMsg").html(lg_form.confirmDoesNotMatchMsg);
			$("#lengthWronghMsg").html(lg_form.lengthWronghMsg);		
			$("#unexpectedErrorMsg").html(lg_form.unexpectedErrorMsg);
			$("#successMsg").html(lg_form.successMsg);
			$("#btnSubmit").val(lg_form.btnSubmit);
			$("#inputFirstName").attr("placeholder", lg_form.phinputFirstName);
			$("#inputLastName").attr("placeholder", lg_form.phinputLastName);
			$("#inputEmailAddress").attr("placeholder", lg_form.phinputEmailAddress);
			$("#inputOrganization").attr("placeholder", lg_form.phinputOrganization);
			$("#inputArea").attr("placeholder", lg_form.phinputArea);
			$("#inputPassword").attr("placeholder", lg_form.phinputPassword);
			$("#inputConfirmPassword").attr("placeholder", lg_form.phinputConfirmPassword);
			$("#btnSubmit").click(function(){ 
				 registerUser.CleanMsg();
				return  registerUser.SubmitForm();
			});
			$("#inputCompany").focusin(function() {

			});
			$("#inputArea").focusin(function() {

			});
			 registerUser.CheckCode();
		} catch (error) {
			alert(error);			
		}
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
		var params = {"code": code};
		var data = _Communication.GetRemoteDataPost(urlVerifyChangePasswordCode, params);

		if(data.code!=200){
			$("#formSetPassword").hide();
			$("#codeDoesNotExistMsg").show();
			return false;
		}
	},
	SubmitForm:function(){
		try {
			if(! registerUser.Validation())
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
		if($("#inputFirstName").val().trim()==""||$("#inputCompany").val().trim()==""||$("#inputArea").val().trim()==""||$("#inputEmailAddress").val().trim()==""){
			$("#needAllTheFieldmMsg").show();
			return false;
		}
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
		alert('registerUser Mock');
	}
}


registerUser.ShowForm();
