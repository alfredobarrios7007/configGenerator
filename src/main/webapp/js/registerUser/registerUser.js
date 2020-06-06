/**
 * @author Alfredo Barrios
 * 
 * June 4, 2020
 * 
*/
var registerUser = {
	ShowForm:function(){
		try {
			if(lang=="es"){
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
			$("#needAllTheFieldmMsg").html(lg_form.needAllTheFieldmMsg);
			$("#fiilPasswordAndConfirmMsg").html(lg_form.fiilPasswordAndConfirmMsg);
			$("#lengthWronghMsg").html(lg_form.lengthWronghMsg);		
			$("#confirmDoesNotMatchMsg").html(lg_form.confirmDoesNotMatchMsg);
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
			$("#inputFirstName").focusin(function() {
				registerUser.CleanMsg();
			});
			$("#inputLastName").focusin(function() {
				registerUser.CleanMsg();
			});
			$("#inputEmailAddress").focusin(function() {
				registerUser.CleanMsg();
			});
			$("#inputOrganization").focusin(function() {
				registerUser.CleanMsg();
			});
			$("#inputArea").focusin(function() {
				registerUser.CleanMsg();
			});
			$("#inputArea").on("keyup",function(event) {
				//console.log("asd");
				//$("#inputArea").off("keyup");
			});
			$("#inputPassword").focusin(function() {
				registerUser.CleanMsg();
			});
			$("#inputConfirmPassword").focusin(function() {
				registerUser.CleanMsg();
			});
			registerUser.GetAreaList();
		} catch (error) {
			alert(error);			
		}
	},
	CleanMsg:function(){
		$("#needAllTheFieldmMsg").hide();
		$("#fiilPasswordAndConfirmMsg").hide();
		$("#confirmDoesNotMatchMsg").hide();
		$("#lengthWronghMsg").hide();
		$("#unexpectedErrorMsg").hide();
		$("#successMsg").hide();
	},
	GetAreaList:function(){
		var params = {};
		var data = _Communication.GetRemoteDataPost(urlGetAllAreas, params);

		if(data.code=200){
			var areaList = data.data;
			var areaArray = [];
			for(var iIdx=0;iIdx<data.data.length;iIdx++){
				areaArray.push(data.data[iIdx].name);
			}
			areaArray.sort();
			$("#inputArea").select2({
				data: areaArray
			  });
		  return false;
		}else{
			$("#unexpectedErrorMsg").show();
			$("#btnSubmit").hide();
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
		if($("#inputFirstName").val().trim()==""||$("#inputOrganization").val().trim()==""||$("#inputArea").val().trim()==""||$("#inputEmailAddress").val().trim()==""){
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
