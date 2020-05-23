/**
 * @author Alfredo Barrios
 * 
 * April 29, 2020
 * 
 */


class LoginViewClass {	

	loginView = '';

	constructor(){
		this.loginView = '<div id="layoutAuthentication">';
		this.loginView += '    <div id="layoutAuthentication_content">';
		this.loginView += '        <main>';
		this.loginView += '            <div class="container">';
		this.loginView += '                <div class="row justify-content-center">';
		this.loginView += '                    <div class="col-lg-5">';
		this.loginView += '                        <div class="card shadow-lg border-0 rounded-lg mt-5">';
		this.loginView += '                            <div class="card-header"><h3 class="text-center font-weight-light my-4">Login Into K&ouml;atchy</h3></div>';
		this.loginView += '                            <div class="card-body">';
		this.loginView += '                                <form>';
		this.loginView += '                                    <div class="form-group"><label class="small mb-1" for="inputEmailAddress">Email</label><input class="form-control py-4" id="inputEmailAddress" type="email" placeholder="Enter email address" /></div>';
		this.loginView += '                                    <div class="form-group"><label class="small mb-1" for="inputPassword">Password</label><input class="form-control py-4" id="inputPassword" type="password" placeholder="Enter password" /></div>';
		this.loginView += '                                    <div class="form-group">';
		this.loginView += '                                        <div class="custom-control custom-checkbox"><input class="custom-control-input" id="rememberPasswordCheck" type="checkbox" /><label class="custom-control-label" for="rememberPasswordCheck">Remember password</label></div>';
		this.loginView += '                                    </div>';
		this.loginView += '                                    <div class="form-group d-flex align-items-center justify-content-between mt-4 mb-0"><a class="small" href="#"  id="lnkRecoveryPwd">Forgot Password?</a><a class="btn btn-primary" href="#" id="lnkSubmit">Login</a></div>';
		this.loginView += '                                </form>';
		this.loginView += '                            </div>';
		this.loginView += '                            <div class="card-footer text-center">';
		this.loginView += '                                <div class="small"><a href="#" id="lnkRegister">Need an account? Sign up!</a></div>';
		this.loginView += '                            </div>';
		this.loginView += '                        </div>';
		this.loginView += '                    </div>';
		this.loginView += '                </div>';
		this.loginView += '            </div>';
		this.loginView += '        </main>';
		this.loginView += '        </div>';
		this.loginView += '        <div id="layoutAuthentication_footer">';
		this.loginView += '                <footer class="py-4 bg-light mt-auto">';
		this.loginView += '                    <div class="container-fluid">';
		this.loginView += '                        <div class="d-flex align-items-center justify-content-between small">';
		this.loginView += '                            <div class="text-muted">Copyright &copy; K&ouml;atchy 2020</div>';
		this.loginView += '                            <div>';
		this.loginView += '                                <a href="#" id="lnkPrivacyPol">Privacy Policy</a>';
		this.loginView += '                                &middot;';
		this.loginView += '                                <a href="#" id="lnkTermsCond">Terms &amp; Conditions</a>';
		this.loginView += '                            </div>';
		this.loginView += '                        </div>';
		this.loginView += '                    </div>';
		this.loginView += '                </footer>';
		this.loginView += '        </div>';
		this.loginView += '</div>';
		document.body.innerHTML = this.loginView;

		document.getElementById("lnkRecoveryPwd").addEventListener( "click", this.lnkRecoveryPwdClicked );
		document.getElementById("lnkSubmit").addEventListener( "click", this.lnkSubmitClicked );
		document.getElementById("lnkRegister").addEventListener( "click", this.lnkRegisterClicked );
		document.getElementById("lnkPrivacyPol").addEventListener( "click", this.lnkPrivacyPolClicked );
		document.getElementById("lnkTermsCond").addEventListener( "click", this.lnkTermsCondClicked );
		
	}

	lnkRecoveryPwdClicked = e => {
		alert("lnkRecoveryPwdClicked");
	}	

	lnkSubmitClicked = e => {
		alert("lnkSubmitClicked");
	}	

	lnkRegisterClicked = e => {
		alert("lnkRegisterClicked");
	}	

	lnkPrivacyPolClicked = e => {
		alert("lnkPrivacyPolClicked");
	}	

	lnkTermsCondClicked = e => {
		alert("lnkTermsCondClicked");
	}	
	
}
