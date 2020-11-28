const lang_es = {
	"servicesLnk":"Servicios",
	"portfolioLnk":"Portafolio",
	"aboutLnk":"Acerca de...",
	"teamLnk":"Equipo",
	"contactLnk":"Contacto",
	"welcomeMessage1":"Bienvenido a mi estudio",
	"welcomeMessage2":"Me da gusto conocerte",
	"tellMeMore":"Cuéntame más",
	"servicesSectionTitle":"Servicios",
	"servicesSectionSubtitle":"Conoce m&aacute;s acerca de nuestros servicios.",
	"servicesSectionConfGen":"Config Generator",
	"servicesSectionResponsiveDesign":"Diseño y desarrollo de Aplicaciones Web y M&oacute;viles.",
	"servicesSectionWebSecurity":"Seguridad Single Sign On",
	"servicesSectionConfGenText":"Genera la configuraci&oacute;n de tus aplicaciones web &oacute; m&oacute;viles.",
	"servicesSectionResponsiveDesignText":"Diseño y desarrollamos tu aplicación web &oacute; m&oacute;vil desde cero hasta publicarla.",
	"servicesSectionWebSecurityText":"Registra usuarios, confirmaci&oacute;n de registro, recuperaci&oacute;n de contrasea&ntilde;a, estable el avatar del usuario, administra usarios y ve el reporte de actividad del usuario.",
	"portfolioSectionTitle":"Portafolio",
	"portfolioSectionSubtitle":"",
	"aboutSectionTitle":"Acerca de...",
	"aboutSectionSubtitle":"",
	"teamSectionTitle":"Nuestro equipo",
	"teamSectionSubtitle":"",
	"contactSectionTitle":"Cont&aacute;ctanos",
	"contactSectionSubtitle":"",
	"contactSectionNameInput":"Tu nombre *",
	"contactSectionEmailInput":"Tu e-mail *",
	"contactSectionPhoneInput":"Tu tel&eacute;fono",
	"contactSectionMessageInput":"Tu mensaje *",
	"contactSectionSendButton":"Enviar",
	"copyright":"Derechos Reservados para © K&ouml;atchy 2020",
	"void":""
};
const lang_en = {
	"servicesLnk":"Services",
	"portfolioLnk":"Portfolio",
	"aboutLnk":"About of ...",
	"teamLnk":"Team",
	"contactLnk":"Contact",
	"welcomeMessage1":"Welcome To Our Studio!",
	"welcomeMessage2":"IT'S NICE TO MEET YOU",
	"tellMeMore":"tell me more",
	"servicesSectionTitle":"Services",
	"servicesSectionSubtitle":"Lear more about of our services.",
	"servicesSectionConfGen":"Config Generator",
	"servicesSectionResponsiveDesign":"Web and Mobile Design and Development.",
	"servicesSectionWebSecurity":"Web Security",
	"servicesSectionConfGenText":"Generate the configuration files in JSON format of your web apps or mobile apps.",
	"servicesSectionResponsiveDesignText":"We make your Web or Mobile application from scrach till bring you published.",
	"servicesSectionWebSecurityText":"Register, confirm register, edit profile, recovery password, set avatar, manage user and activy report.",
	"portfolioSectionTitle":"Portfolio",
	"portfolioSectionSubtitle":"",
	"aboutSectionTitle":"About of...",
	"aboutSectionSubtitle":"",
	"teamSectionTitle":"OUR AMAZING TEAM",
	"teamSectionSubtitle":"",
	"contactSectionTitle":"Contact Us",
	"contactSectionSubtitle":"",
	"contactSectionNameInput":"Your name *",
	"contactSectionEmailInput":"Your E-mail",
	"contactSectionPhoneInput":"Your phone",
	"contactSectionMessageInput":"Your Message",
	"contactSectionSendButton":"Send Message",
	"copyright":"Copyright © K&ouml;atchy 2020",
	"void":""
};
const lang_fr = {
	"servicesLnk":"Servicios",
	"portfolioLnk":"Servicios",
	"aboutLnk":"Acerca de...",
	"teamLnk":"Equipo",
	"contactLnk":"Contacto",
	"welcomeMessage1":"Bienvenido a mi estudio",
	"welcomeMessage2":"Me da gusto conocerte",
	"tellMeMore":"Cu&eacuote;ntame m&aacute;s",
	"servicesSectionTitle":"Servicios",
	"servicesSectionSubtitle":"",
	"servicesSectionConfGen":"E-Commerce",
	"servicesSectionResponsiveDesign":"Diseño de Aplicaciones Responsivo",
	"servicesSectionWebSecurity":"Seguridad Single Sign On",
	"servicesSectionConfGenText":"",
	"servicesSectionResponsiveDesignText":"",
	"servicesSectionWebSecurityText":"",
	"portfolioSectionTitle":"Portafolio",
	"portfolioSectionSubtitle":"",
	"aboutSectionTitle":"Acerca de...",
	"aboutSectionSubtitle":"",
	"teamSectionTitle":"Nuestro equipo",
	"teamSectionSubtitle":"",
	"contactSectionTitle":"Cont&aacute;ctanos",
	"contactSectionSubtitle":"",
	"contactSectionNameInput":"",
	"contactSectionEmailInput":"",
	"contactSectionPhoneInput":"",
	"contactSectionMessageInput":"",
	"contactSectionSendButton":"",
	"copyright":"Derechos Reservados para © K&ouml;atchy 2020",
	"void":""
};
const HomeKoatchy = {
	changeLanguage:function(lg){
		var setLanguage = (lg==='es'?lang_es:(lg==='en'?lang_en:lang_fr)); 
		$("#servicesLnk").html(setLanguage.servicesLnk);
		$("#portfolioLnk").html(setLanguage.portfolioLnk);
		$("#aboutLnk").html(setLanguage.aboutLnk);
		$("#teamLnk").html(setLanguage.teamLnk);
		$("#contactLnk").html(setLanguage.contactLnk);
		$("#welcomeMessage1").html(setLanguage.welcomeMessage1);
		$("#welcomeMessage2").html(setLanguage.welcomeMessage2);
		$("#tellMeMore").text(setLanguage.tellMeMore);
		$("#servicesSectionTitle").html(setLanguage.servicesSectionTitle);
		$("#servicesSectionSubtitle").html(setLanguage.servicesSectionSubtitle);
		$("#servicesSectionConfGen").html(setLanguage.servicesSectionConfGen);
		$("#servicesSectionResponsiveDesign").html(setLanguage.servicesSectionResponsiveDesign);
		$("#servicesSectionWebSecurity").html(setLanguage.servicesSectionWebSecurity);
		$("#servicesSectionConfGenText").html(setLanguage.servicesSectionConfGenText);
		$("#servicesSectionResponsiveDesignText").html(setLanguage.servicesSectionResponsiveDesignText);
		$("#servicesSectionWebSecurityText").html(setLanguage.servicesSectionWebSecurityText);
		$("#portfolioSectionTitle").html(setLanguage.portfolioSectionTitle);
		$("#portfolioSectionSubtitle").html(setLanguage.portfolioSectionSubtitle);
		$("#aboutSectionTitle").html(setLanguage.aboutSectionTitle);
		$("#aboutSectionSubtitle").html(setLanguage.aboutSectionSubtitle);
		$("#teamSectionTitle").html(setLanguage.teamSectionTitle);
		$("#teamSectionSubtitle").html(setLanguage.teamSectionSubtitle);
		$("#contactSectionTitle").html(setLanguage.contactSectionTitle);
		$("#contactSectionSubtitle").html(setLanguage.contactSectionSubtitle);
		$("#contactSectionNameInput").attr("placeholder", setLanguage.contactSectionNameInput);
		$("#contactSectionEmailInput").attr("placeholder", setLanguage.contactSectionEmailInput);
		$("#contactSectionPhoneInput").attr("placeholder", setLanguage.contactSectionPhoneInput);
		$("#contactSectionMessageInput").attr("placeholder", setLanguage.contactSectionMessageInput);
		$("#contactSectionSendButton").text(setLanguage.contactSectionSendButton);
		$("#copyright").html(setLanguage.copyright);
	},
}
$(document).ready(function(){
	HomeKoatchy.changeLanguage("es");
	$("#langEs").click(()=>{
		HomeKoatchy.changeLanguage("es");
	});
	$("#langEn").click(()=>{
		HomeKoatchy.changeLanguage("en");
	});
	$("#langFr").click(()=>{
		HomeKoatchy.changeLanguage("fr");
	});
});
