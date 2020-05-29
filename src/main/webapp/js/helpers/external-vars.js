/**
 * @author Alfredo Barrios
 * 
 * April 29, 2020
 * 
 */

var ulrLoginValidation = "http://localhost:8080/security/login";
var ulrRecoveryPassword = "http://localhost:8080/security/recoveryPassword";
var authenticationToken = {"authentication":"wDo3rXrE/"};
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
	,"lblinputEmailAddress":"Correo electr&oacute;nico"
	,"lblinputPassword":"Contraseña"
	,"lblrememberPasswordCheck":"Recordar tu contrase&ntilde;a"
	,"lnkGoRecoveryPassword":"Olvidaste tu contrase&ntilde;a"
	,"btnSubmit":"Enviar"
	,"lblGotoRegister":"¿Necesitas una cuenta? Reg&iacute;strate!"
};
var enlg_login = {
	"lblFormTitle":"Login"
	,"lblinputEmailAddress":"Email"
	,"lblinputPassword":"Password"
	,"lblrememberPasswordCheck":"Remember your password"
	,"lnkGoRecoveryPassword":"Forgot password?"
	,"btnSubmit":"Submit"
	,"lblGotoRegister":"Need an account? Sign up!"
};
// Registry form labels
var splg_registry = {
	"lblFormTitle":"Recuperar contrase&ntilde;a"
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
var enlg_registry = {
	"lblFormTitle":"Password Recovery"
	,"lblinputEmailAddress":"E-mail"
	,"lblEnterEmail":"Enter your email address and we will send you a link to reset your password."
	,"btnSubmit":"Reset Password"
	,"lnkGotoLogin":"Return to login"
	,"lblGotoRegister":"Need an account? Sign up!"
	,"emailDoesNotExistMsg":"The e-mail doesn't exist in our database."
	,"successMsg":"You are going to receive an e-mail with the instructions to recover your password."
	,"fillTheEmailMsg":"Please, type the e-mail account that you used to register."
	,"unexpectedErrorMsg":"Ups! we are very sorry, an unexpected error happens, please, try again later."
};
