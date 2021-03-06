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
                dataType: 'json', 
                contentType: 'application/json; charset=utf-8',
                mimeType: 'application/json',
                headers: authenticationToken,
        		data: JSON.stringify(Arguments), 
        		xhrFields: { withCredentials: true }, 
        		crossDomain: true, 
        		async: false, 
                beforeSend: _CommonFunctions.ShowProgressBar(),
        		success: function (data) { 
                    if (data != "") {
                        result = data;
                    }
                    _CommonFunctions.HideProgressBar();
    			}, 
                error: function (xhr, ajaxOptions, thrownError) {
                    _CommonFunctions.HideProgressBar();
                    _CommonFunctions.MessageBox("Error on Remote call " + ActionUrl + " : " + xhr.status + " - " + thrownError);
                } 
            });        	        
        } catch (e) {
            _CommonFunctions.MessageBox("Error on GetRemoteData: " + e.message);
        }
        return result;
    },
    GetRemoteDataPostAsync: function (ActionUrl, Arguments) {
        return _Communication.GetRemoteDataAsync(ActionUrl, Arguments, "POST");
    },
    GetRemoteDataGetAsync: function (ActionUrl, Arguments) {
        return _Communication.GetRemoteDataAsync(ActionUrl, Arguments, "GET");
    },
    GetRemoteDataAsync: function (ActionUrl, Arguments, PostGet) {
        var result;
        try {
            $.ajax({
        		type:PostGet, 
        		url: ActionUrl, 
                dataType: 'json', 
                contentType: 'application/json; charset=utf-8',
                mimeType: 'application/json',
                headers: authenticationToken,
        		data: JSON.stringify(Arguments), 
        		xhrFields: { withCredentials: true }, 
        		crossDomain: true, 
        		async: true, 
                beforeSend: _CommonFunctions.ShowProgressBar(),
                success: function (data) {
                    if (data != "") {
                        result = data;
                    }
                    _CommonFunctions.HideProgressBar();
                },
                error: function (xhr, ajaxOptions, thrownError) {
                    _CommonFunctions.HideProgressBar();
                    _CommonFunctions.MessageBox("Error on Remote call " + ActionUrl + " : " + xhr.status + " - " + thrownError);
                }
            });
        } catch (e) {
            _CommonFunctions.MessageBox("Error on GetRemoteData: " + e.message);
        }
        return result;
    },

    PostMutiPartForm:function(ActionUrl, Arguments){
        var result;
        try {
            $.ajax({
                type: "POST",
                enctype: 'multipart/form-data',
                url: ActionUrl,
                data: Arguments,
                headers: authenticationToken,
                processData: false,
                contentType: false,
                cache: false,
        		async: false, 
                timeout: 600000,
                beforeSend: _CommonFunctions.ShowProgressBar(),
                success: function (data) {
                    if (data != "") {
                        result = data;
                    }
                    _CommonFunctions.HideProgressBar();
                },
                error: function (xhr, ajaxOptions, thrownError) {
                    _CommonFunctions.HideProgressBar();
                    _CommonFunctions.MessageBox("Error on Remote call " + ActionUrl + " : " + xhr.status + " - " + thrownError);
                }
            });
            return result;
        } catch (error) {
            _CommonFunctions.MessageBox("Error on PostMutiPartForm: " + error.message);
        }
    }

};