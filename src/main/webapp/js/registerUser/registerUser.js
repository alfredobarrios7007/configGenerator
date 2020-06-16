/**
 * @author Alfredo Barrios
 * 
 * June 4, 2020
 * 
*/
var thereIsUserImage = false;
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
			$("#lblinputPhoto").html(lg_form.lblinputPhoto);
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
			$("#emailAlreadyExistMsg").html(lg_form.emailAlreadyExistMsg);
			$("#successMsg").html(lg_form.successMsg);
			$("#btnSubmit").val(lg_form.btnSubmit);
			$("#inputFirstName").attr("placeholder", lg_form.phinputFirstName);
			$("#inputLastName").attr("placeholder", lg_form.phinputLastName);
			$("#inputEmailAddress").attr("placeholder", lg_form.phinputEmailAddress);
			$("#inputPhoto").attr("placeholder", lg_form.phinputPhoto);
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
			$('#inputPhoto').change( function(event) {
				var tmppath = URL.createObjectURL(event.target.files[0]);
				$("#imgPhoto").fadeIn("1000").attr('src',URL.createObjectURL(event.target.files[0]));
				thereIsUserImage=true;
			});
			$("#inputPassword").focusin(function() {
				registerUser.CleanMsg();
			});
			$("#inputConfirmPassword").focusin(function() {
				registerUser.CleanMsg();
			});
			registerUser.GetLists();
		} catch (error) {
			alert(error);			
		}
	},
	CleanMsg:function(){
		$("#emailAlreadyExistMsg").hide();
		$("#needAllTheFieldmMsg").hide();
		$("#fiilPasswordAndConfirmMsg").hide();
		$("#confirmDoesNotMatchMsg").hide();
		$("#lengthWronghMsg").hide();
		$("#unexpectedErrorMsg").hide();
		$("#successMsg").hide();
	},
	GetLists:function(){
		try {
			var params = {
			"platform": "web" 
			,"caller": "web" 
			}
			var dataAreas = _Communication.GetRemoteDataPost(urlGetAllAreas, params);
			var dataOrgs = _Communication.GetRemoteDataPost(urlGetAllOrganizations, params);
			if( dataAreas.code==200 && dataOrgs.code==200){
				var areasArray = [];
				for(var iIdx=0;iIdx<dataAreas.data.length;iIdx++){
					areasArray.push(dataAreas.data[iIdx].name);
				}
				areasArray.sort();
				var orgsArray = [];
				for(var iIdx=0;iIdx<dataOrgs.data.length;iIdx++){
					orgsArray.push(dataOrgs.data[iIdx].name);
				}
				orgsArray.sort();
				$("#inputArea").autocomplete({
					source: areasArray
				});
				$("#inputOrganization").autocomplete({
					source: orgsArray
				});
			  return false;
			}else{
				$("#unexpectedErrorMsg").show();
				$("#btnSubmit").hide();
			}
		} catch (error) {
			$("#unexpectedErrorMsg").show();
			$("#btnSubmit").hide();
		}
	},
	SubmitForm:function(){
		//stop submit the form, we will post it manually.
        event.preventDefault();
		try {
			if(! registerUser.Validation())
			{
				return false;
			}

			var userParams = {"id": 0 
			,"platform": "web" 
			,"caller": "web" 
			,"name": $("#inputFirstName").val().trim()
			,"lastname": $("#inputLastName").val().trim()
			,"organization": $("#inputOrganization").val().trim()
			,"area": $("#inputArea").val().trim()
			,"email": $("#inputEmailAddress").val().trim()
			,"password": $("#inputPassword").val().trim()
			};
			var dataRegister = _Communication.GetRemoteDataPost(urlRegister, userParams);

			if(dataRegister.code!=200){
				_MessageBox.Show("SubmitForm Error: " + dataRegister.code + "- " + dataRegister.message);
				return false;
			}

			$("#iduser").val(dataRegister.data.id);

			//if(dataRegister.data.result==true){
				if(thereIsUserImage){
					// Get form
					var form = document.getElementById('fileUploadForm');
	
					// Create an FormData object
					var paramPhoto = new FormData(form);

					var dataUpload = _Communication.PostMutiPartForm(urlUploadUserPhoto, paramPhoto);
					if(dataUpload.code!=200){
						//TO DO
						alert("UploadPhoto Error: " + dataUpload.code + "- " + dataUpload.message);
					}
					alert("UploadPhoto: " + dataUpload.code);
				}
				$("#btnSubmit").hide();
				$("#successMsg").show();
			//}else{
			//	$("#emailAlreadyExistMsg").show();
			//}
			
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
