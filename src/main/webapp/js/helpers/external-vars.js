/**
 * @author Alfredo Barrios
 * 
 * April 29, 2020
 * 
*/
var lang = "es"; //default spanish
var authenticationToken = {"authentication":"wDo3rXrE/"};
var companyName = "Alfredo \"Köatchy\" Barrios";
var ulrDomain = "http://localhost:8080/";
var ulrLoginValidation = ulrDomain + "security/login";
var ulrRecoveryPassword = ulrDomain + "security/recoveryPassword";
var ulrSetPassword = ulrDomain + "security/setPassword";
var urlVerifyChangePasswordCode = ulrDomain + "security/VerifyChangePasswordCode";
var urlSetNewPassword = ulrDomain + "security/SetNewPassword";
var urlRegister = ulrDomain + "security/register";
var urlGetAllAreas = ulrDomain + "catlogs/getAllAreas";
var urlGetAllOrganizations = ulrDomain + "catlogs/getAllOrganizations";
var urlUploadUserPhoto = ulrDomain + "security/uploadUserPhoto";
var registerWithPhoto = ulrDomain + "security/registerWithPhoto";
// Global labels
var splg_global = {
	"lblTitle":"K&ouml;atchy"
	, "lblCopyright":"Copyright © Alfredo Barrios © K&ouml;atchy 2020"
	, "lblGotoPrivacyPol":"Pol&iacute;tica de Privacidad"
	, "lblGotoTermsCondit":"T&eacute;rmimos &amp; Condiciones"
};
var enlg_global = {
	"lblTitle":"K&ouml;atchy"
	, "lblCopyright":"Copyright © Alfredo Barrios © K&ouml;atchy 2020"
	, "lblGotoPrivacyPol":"Privacy Policy"
	, "lblGotoTermsCondit":"Terms &amp; Conditions"
};
// Login form labels
var splg_login = {
	"lblFormTitle":"Acceder"
	,"htmlTitle":"Log in - " + companyName
	,"lblinputEmailAddress":"Correo electr&oacute;nico"
	,"lblinputPassword":"Contraseña"
	,"lblrememberPasswordCheck":"Recordar tu contrase&ntilde;a"
	,"lnkGoRecoveryPassword":"Olvidaste tu contrase&ntilde;a"
	,"btnSubmit":"Enviar"
	,"lblGotoRegister":"¿Necesitas una cuenta? Reg&iacute;strate!"
	,"worngCredentialsMsg":"El usuario o la contrase&ntilde;a son incorrectos"
	,"unExpectedErrorMsg":"Hubo un error inesperado :( Por favor intente más tarde"
	,"emailEmptyMsg":"Por favor proporcione su cuenta de e-mail"
	,"passwordEmptyMsg":"Por favor proporcione su contraseña"
};
var enlg_login = {
	"lblFormTitle":"Login"
	,"htmlTitle":"Log in - " + companyName
	,"lblinputEmailAddress":"Email"
	,"lblinputPassword":"Password"
	,"lblrememberPasswordCheck":"Remember your password"
	,"lnkGoRecoveryPassword":"Forgot password?"
	,"btnSubmit":"Submit"
	,"lblGotoRegister":"Need an account? Sign up!"
	,"worngCredentialsMsg":"The credentials are wrong"
	,"unExpectedErrorMsg":"There was an un expected error :( Please try again later"
	,"emailEmptyMsg":"Please type your e-mail account"
	,"passwordEmptyMsg":"Please type your password"
};
// Recovery Password form labels
var splg_recovPwd = {
	"lblFormTitle":"Recuperar contrase&ntilde;a"
	,"htmlTitle":"Recuperar contraseña - " + companyName
	,"lblinputEmailAddress":"Correo electr&oacute;nico"
	,"lblEnterEmail":"Escribe tu correo electr&oacute;nico y te enviaremos una liga para reestablecer tu contrase&ntilde;a."
	,"btnSubmit":"Enviar"
	,"lnkGotoLogin":"Regresar a Acceder"
	,"lblGotoRegister":"¿Necesitas una cuenta? Reg&iacute;strate!"
	,"emailDoesNotExistMsg":"El correo electrónico que proporcionaste no se encuentra en nuestra base de datos."
	,"successMsg":"Te enviamos un correo electrónico para que puedas recuperar tu contraseña."
	,"fillTheEmailMsg":"Por favor escribe tu cuenta de  correo electrónico con que te registrasté."
	,"unexpectedErrorMsg":"Ocurrio un error inesperado, por favor, vuelve a intentar más tarde."
};
var enlg_recovPwd = {
	"lblFormTitle":"Rocover Password"
	,"htmlTitle":"Recover your password - " + companyName
	,"lblinputEmailAddress":"E-mail"
	,"lblEnterEmail":"Enter your email address and we will send you a link to reset your password."
	,"btnSubmit":"Send"
	,"lnkGotoLogin":"Return to login"
	,"lblGotoRegister":"Need an account? Sign up!"
	,"emailDoesNotExistMsg":"The e-mail doesn't exist in our database."
	,"successMsg":"You are going to receive an e-mail with the instructions to recover your password."
	,"fillTheEmailMsg":"Please, type the e-mail account that you used to register."
	,"unexpectedErrorMsg":"Ups! we are very sorry, an unexpected error happens, please, try again later."
};
// Set New Password form labels
var splg_SetPwd = {
	"htmlTitle":"Establece tu nueva contraseña - " + companyName
	,"lblFormTitle":"Establecer contrase&ntilde;a"
	,"lblEnterPassword":"Escribe y confirma tu nueva contrase&ntilde;a"
	,"lblinputPassword":"Nueva Contrase&ntilde;a"
	,"lblinputConfirmPassword":"Confirma tu Nueva Contrase&ntilde;a"
	,"btnSubmit":"Restablecer contraseña"
	,"codeDoesNotExistMsg":"El c&oacute;digo no existe."
	,"fiilPasswordAndConfirmMsg":"Por favor llena el campo Nueva Contrase&ntilde;a y confirma la contrase&ntilde;a."
	,"confirmDoesNotMatchMsg":"La contrase&ntilde;a y la confirmación no coinciden."
	,"unexpectedErrorMsg":"Ocurrio un error inesperado, por favor, vuelve a intentar más tarde."
	,"lengthWronghMsg":"La contraseña por lo menos debe tener al menos 7 carateres"
	,"successMsg":"La contraseña se estableci&oacute; con &eacute;xito, por favor <a href='login.html'>proporcione sus credenciales</a>."
};
var enlg_SetPwd = {
	"htmlTitle":"Set Your New Password - " + companyName
	,"lblFormTitle":"Set Your New Password"
	,"lblEnterPassword":"Type and confirm your new password"
	,"lblinputPassword":"New Password"
	,"lblinputConfirmPassword":"Confirm your New Password"
	,"btnSubmit":"Reset Password"
	,"codeDoesNotExistMsg":"The code does not exist."
	,"fiilPasswordAndConfirmMsg":"Please set the field new password and confirm new password."
	,"confirmDoesNotMatchMsg":"The password and the confirmation do not match."
	,"unexpectedErrorMsg":"Ups! we are very sorry, an unexpected error happens, please, try again later."
	,"lengthWronghMsg":"The password must to have 7 characters at least."
	,"successMsg":"The password was settled successfuly, please, <a href='login.html'>set your credentials</a>."
};
// Register New User form labels
var splg_RegUser = {
	"htmlTitle":"Crea tu cuenta - " + companyName
	,"lblFormTitle":"Crea tu cuenta "
	,"lblinputFirstName":"Nombre&nbsp;<font color='red'>*</font>"
	,"lblinputLastName":"Apellidos"
	,"lblinputEmailAddress":"Correo electr&oacute;nico&nbsp;<font color='red'><b>*</b></font>"
	,"lblinputPhoto":"Foto"
	,"lblinputOrganization":"Organizaci&oacute;n&nbsp;<font color='red'><b>*</b></font>"
	,"lblinputArea":"&Aacute;rea&nbsp;<font color='red'><b>*</b></font>"
	,"lblinputPassword":"Contrase&ntilde;a&nbsp;<font color='red'><b>*</b></font>"
	,"lblinputConfirmPassword":"Confirma tu Contrase&ntilde;a&nbsp;<font color='red'><b>*</b></font>"
	,"phinputFirstName":"Escribe tu nombre"
	,"phinputLastName":"Escribe tus apellidos"
	,"phinputEmailAddress":"Escribe tu correo electrónico"
	,"phinputPhoto":"Agrega tu foto"
	,"phinputOrganization":"Escribe el nombre de tu organización"
	,"phinputArea":"Escribe tu área "
	,"phinputPassword":"Escribe tu contraseña"
	,"phinputConfirmPassword":"Confirma tu Contraseña"
	,"btnSubmit":"Crear"
	,"lnkGotoLogin":"¿Ya tienes una cuenta? Ve a Login"
	,"fiilPasswordAndConfirmMsg":"Por favor llena el campo Contrase&ntilde;a y confirma la contrase&ntilde;a."
	,"confirmDoesNotMatchMsg":"La contrase&ntilde;a y la confirmación no coinciden."
	,"needAllTheFieldmMsg":"Por favor llene todos los campos marcados con&nbsp;<font color='red'>*</font>."
	,"unexpectedErrorMsg":"Ocurrio un error inesperado, por favor, vuelve a intentar más tarde."
	,"lengthWronghMsg":"La contraseña por lo menos debe tener al menos 7 carateres"
	,"emailAlreadyExistMsg":"La cuenta de correo electr&oacute;nico ya existe, <a href='password.html'>¿necesitas recuperar tu contrase&ntilde;a? Da clic aquí</a>"
	,"successMsg":"Tu registro se realizó con &eacute;xito, por favor <a href='login.html'>proporcione sus credenciales</a>."
};
var enlg_RegUser = {
	"htmlTitle":"Create Account - " + companyName
	,"lblFormTitle":"Create Account"
	,"lblinputFirstName":"Name&nbsp;<font color='red'><b>*</b></font>"
	,"lblinputLastName":"Last name"
	,"lblinputPhoto":"Photo"
	,"lblinputEmailAddress":"E-mail&nbsp;<font color='red'><b>*</b></font>"
	,"lblinputOrganization":"Organization&nbsp;<font color='red'><b>*</b></font>"
	,"lblinputArea":"Area&nbsp;<font color='red'><b>*</b></font>"
	,"lblinputPassword":"Password&nbsp;<font color='red'><b>*</b></font>"
	,"lblinputConfirmPassword":"Confirm your Password&nbsp;<font color='red'><b>*</b></font>"
	,"phinputFirstName":"Enter first name"
	,"phinputLastName":"Enter last name"
	,"phinputEmailAddress":"Enter e-mail address"
	,"phinputPhoto":"Add your photo"
	,"phinputOrganization":"Enter your organization"
	,"phinputArea":"Enter your area"
	,"phinputPassword":"Enter password"
	,"phinputConfirmPassword":"Confirm password"
	,"btnSubmit":"Create Account"
	,"lnkGotoLogin":"Have an account? Go to login"
	,"fiilPasswordAndConfirmMsg":"Please set the field password and confirm password."
	,"confirmDoesNotMatchMsg":"The password and the confirmation do not match."
	,"needAllTheFieldmMsg":"Please type all the fields  todos los campos signed with&nbsp;<font color='red'>*</font>."
	,"unexpectedErrorMsg":"Ups! we are very sorry, an unexpected error happens, please, try again later."
	,"lengthWronghMsg":"The password must to have 7 characters at least."
	,"emailAlreadyExistMsg":"The e-mail account already exists, <a href='password.html'>do you need to recover your password? Click here</a>"
	,"successMsg":"The registry was successfuly, please, <a href='login.html'>set your credentials</a>."
};
