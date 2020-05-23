/**
 * CommFuncts
 * 
 * Communication Functions
 * 
 * Alfredo Barrios
 */
var _Communication = {
	GetRemoteDataPost: function (ActionUrl, Arguments) {
	        return _Communication.GetRemoteData(ActionUrl, Arguments, "POST");
    },
    GetRemoteDataGet: function (ActionUrl, Arguments) {
        return _Communication.GetRemoteData(ActionUrl, Arguments, "GET");
    },
    GetRemoteData: function (ActionUrl, Arguments, PostGet) {
        var result;
        try {
        	$.ajax({ 
        		type:PostGet, 
        		url: ActionUrl, 
        		async: false, 
                dataType: 'json', 
                contentType: 'application/json; charset=utf-8',
                mimeType: 'application/json',
                headers: authenticationToken,
        		data: JSON.stringify(Arguments), 
        		xhrFields: { withCredentials: true }, 
        		crossDomain: true, 
        		success: function (data) { 
                    if (data != "") {
                        result = data;
                    }
    			}, 
                error: function (xhr, ajaxOptions, thrownError) {
                    _CommonFunctions.MessageBox("Error on Remote call " + ActionUrl + " : " + xhr.status + " - " + thrownError);
    				} 
    			});        	        
        } catch (e) {
            _CommonFunctions.MessageBox("Error on GetRemoteData: " + e.message);
        }
        return result;
    },
    GetRemoteDataPostAsync: function (ActionUrl, Arguments) {
        return _Communication.GetRemoteData(ActionUrl, Arguments, "POST");
    },
    GetRemoteDataGetAsync: function (ActionUrl, Arguments) {
        return _Communication.GetRemoteData(ActionUrl, Arguments, "GET");
    },
    GetRemoteDataAsync: function (ActionUrl, Arguments, PostGet) {
        var result;
        try {
            $.ajax({
                type: PostGet,
                url: ActionUrl,
                data: Arguments,
                dataType: "json",
                async: true,
                cache: false,
                success: function (data) {
                    if (data != "") {
                        result = data;
                    }
                },
                error: function (xhr, ajaxOptions, thrownError) {
                    _CommonFunctions.MessageBox("Error on Remote call " + ActionUrl + " : " + xhr.status + " - " + thrownError);
                }
            });
        } catch (e) {
            _CommonFunctions.MessageBox("Error on GetRemoteData: " + e.message);
        }
        return result;
    }

};