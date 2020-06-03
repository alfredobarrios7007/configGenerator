/**
 * @author Alfredo Barrios
 * 
 * April 29, 2020
 * 
*/

var authenticationToken = {"authentication":"wDo3rXrE/"};
var ulrLoginValidation = "http://localhost:8080/security/login";
var ulrRecoveryPassword = "http://localhost:8080/security/recoveryPassword";
var ulrSetPassword = "http://localhost:8080/security/setPassword";
var urlVerifyChangePasswordCode ="http://localhost:8080/security/VerifyChangePasswordCode";
var urlSetNewPassword ="http://localhost:8080/security/SetNewPassword";
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
	,"htmlTitle":"Log in - Alfredo \"Köatchy\" Barrios"
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
	,"htmlTitle":"Log in - Alfredo \"Köatchy\" Barrios"
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
	,"htmlTitle":"Recuperar contraseña - Alfredo \"Köatchy\" Barrios"
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
	,"htmlTitle":"Recover your password - Alfredo \"Köatchy\" Barrios"
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
	"htmlTitle":"Establece tu nueva contraseña - Alfredo \"Köatchy\" Barrios"
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
	"htmlTitle":"Set Your New Password - Alfredo \"Köatchy\" Barrios"
	,"lblFormTitle":"Set Your New Password"
	,"lblEnterPassword":"Type and confirm your new password"
	,"lblinputPassword":"New Password"
	,"lblinputConfirmPassword":"Confirm your New Password"
	,"btnSubmit":"Reset Password"
	,"codeDoesNotExistMsg":"The code does not exist."
	,"fiilPasswordAndConfirmMsg":"Please set the field New Password and Confirm New Password."
	,"confirmDoesNotMatchMsg":"The password and the confirmation do not match."
	,"unexpectedErrorMsg":"Ups! we are very sorry, an unexpected error happens, please, try again later."
	,"lengthWronghMsg":"The password must to have 7 characters at least."
	,"successMsg":"The password was settled successfuly, please, <a href='login.html'>set your credentials</a>."
};
