var commjs = {
	/*
	* GetRemoteData
	* It invokes a REST/SOAP service
	* 
	* Request example: '{"clientid": "' + clientid + '","selectedLine":"' + selectedLine + '"}'
	*
	* ActionUrl: URL to request 
	* Arguments: Parameters
	* PostGet: It sets the HTTP method (POST/GET/UPDATE/DELETE)
	*
	* Programer: Alfredo Barrios
	*
	*/
	GetRemoteData:function(ActionUrl, Arguments, PostGet){
		try{
			var xmlhttp = new XMLHttpRequest();
			/*xmlhttp.onreadystatechange = function(){

			};*/
			xmlhttp.open(PostGet, ActionUrl, false);
			xmlhttp.setRequestHeader("Content-Type", "application/json");
			//xmlhttp.setRequestHeader("Authorization", 'Basic noindiwid0ewi0'); 
			xmlhttp.onreadystatechange = SMCBF.CallBackGetFixedAccounts(xmlhttp);
			xmlhttp.send(Arguments);
			return xmlhttp.responseText;
		}catch(e){

		}
	}
}