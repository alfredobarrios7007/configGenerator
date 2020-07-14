/*
* Functions for workspace.html
* 
* Alfredo Barrios
*/
var workspace = {
	ShowForm:function(){
		var lg_global = null;
		var lg_form = null;
		if(lang=="es"){
			lg_global = splg_global;
			lg_form = splg_ws1;
		}else{
			lg_global = enlg_global;
			lg_form = enlg_ws1;
		}
        if(workspace.SessionValidation()==false){
			alert(lg_form.noValidSessionMsg);
			window.location.href = "login.html";
		}

		document.title = lg_form.htmlTitle;

		$("#lblTitle").html(lg_global.lblTitle);
		/*
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
			workspace.CleanMsg();
			return workspace.SubmitForm();
		 });
		$("#inputEmailAddress").focusin(function() {
			workspace.CleanMsg();
		});
		*/
	},
	SessionValidation:function(){
		var token = _CommonFunctions.GetCookie("token");
		//alert(token==undefined||""==$.trim(token)?"Sin login: " + token:"Con login: " + token);
		if(token==undefined||""==$.trim(token)) return false;
		$("#searcher").val(token);
		var params = {"platform":"web","caller": _CommonFunctions.GetCaller(),"token": $.trim(token) };
		var data = _Communication.GetRemoteDataPost(urlCheckSessionToken, params);
		if(data.code!=200){
			return false;
		}
		return true;
	},
	CleanMsg:function(){
		$("#fillTheEmailMsg").hide();
		$("#unexpectedErrorMsg").hide();
		$("#emailDoesNotExistMsg").hide();
	},
	SubmitForm:function(){
		try {
			if(!workspace.Validation())
			{
				return false;
			}

			var params = {"platform":"web","caller": _CommonFunctions.GetCaller(),"username": $("#inputEmailAddress").val().trim() };
			var data = _Communication.GetRemoteDataPost(ulrmain, params);
	
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
		alert('main Mock');
	}

}
workspace.ShowForm();
