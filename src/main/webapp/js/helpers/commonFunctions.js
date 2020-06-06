/**
 * CommonFunctions
 * 
 * Alfredo Barrios
 */
var _CommonFunctions = {

	SetCookie:function(varName, value){
		$.cookie(varName, value);		
	},

	GetCookie:function(varName){
		return $.cookie(varName);		
	},

	GetLanguage:function(){
		lang = _CommonFunctions.SetCookie("language");
		if(lang===undefined) lang="es";
	},

	GetUrlParameter: function(name) {
		name = name.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
		var regex = new RegExp('[\\?&]' + name + '=([^&#]*)');
		var results = regex.exec(location.search);
		return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
	},
	
	SetDatePickerNavigationFuncsById: function (dateControlId) {
		$("#" + dateControlId).keydown(function () {
			//  LEFT: 37
			//    UP: 38
			// RIGHT: 39
			//  DOWN: 40
			//   TAB: 9

			var keyCode = event.which;
			if (keyCode != 9) // if tab was not pressed, use pressed key for calendar control
			{
				event.preventDefault();
				event.stopPropagation();

				var parts = $("#" + dateControlId).val().split("/");
				var currentDate = new Date(parts[2], parts[0] - 1, parts[1]); // months are 0-based

				switch (keyCode) {
					case 37: // LEFT, -1 day
						currentDate.setDate(currentDate.getDate() - 1);
						break;
					case 38: // UP, -1 week
						currentDate.setDate(currentDate.getDate() - 7);
						break;
					case 39: // RIGHT, +1 day
						currentDate.setDate(currentDate.getDate() + 1);
						break;
					case 40: // DOWN, +1 week
						currentDate.setDate(currentDate.getDate() + 7);
						break;
				}

				if (currentDate != null) {
					$("#" + dateControlId).datepicker("setDate", currentDate);
				}
			}

		});
		$("#" + dateControlId).datepicker("option", "showAnim", "fold");
	},

	SetDatePickerNavigationFuncsByClass: function (dateClass) {
		$("." + dateClass).keydown(function () {
			//  LEFT: 37
			//    UP: 38
			// RIGHT: 39
			//  DOWN: 40
			//   TAB: 9

			var keyCode = event.which;
			if (keyCode != 9) // if tab was not pressed, use pressed key for calendar control
			{
				event.preventDefault();
				event.stopPropagation();

				var parts = $("." + dateClass).val().split("/");
				var currentDate = new Date(parts[2], parts[0] - 1, parts[1]); // months are 0-based

				switch (keyCode) {
					case 37: // LEFT, -1 day
						currentDate.setDate(currentDate.getDate() - 1);
						break;
					case 38: // UP, -1 week
						currentDate.setDate(currentDate.getDate() - 7);
						break;
					case 39: // RIGHT, +1 day
						currentDate.setDate(currentDate.getDate() + 1);
						break;
					case 40: // DOWN, +1 week
						currentDate.setDate(currentDate.getDate() + 7);
						break;
				}

				if (currentDate != null) {
					$("." + dateClass).datepicker("setDate", currentDate);
				}
			}

		});
		$("." + dateClass).datepicker("option", "showAnim", "fold");
	},

	TruncString: function (string, length) {
		return (string.length > length ? string.substring(0, length) + "..." : string);
	},

	MessageBox: function (message) {
		alert(message);
	},

	PopulateDropDownList: function (listId, data, idColumn, textColumn, selectOption) {
		$(listId).empty();
		var _select = $('<select>');
		if (data[0].length == 0) {
			_select.append(
					$('<option></option>').val("-1").html(_GlobalModels.Labels[_GlobalModels.Values.Language].NoRowsToPopulateTheDropDownList)
				);
		} else {
			if (selectOption) {
				_select.append(
						$('<option></option>').val("-1").html(_GlobalModels.Labels[_GlobalModels.Values.Language].DropDownListSelectOne)
					);
			}

			for (var iIdx = 0; iIdx < data.length; iIdx++) {
				_select.append(
						$('<option></option>').val(data[iIdx][idColumn]).html(_CommonFunctions.TruncString(data[iIdx][textColumn], 40))
					);
			}
		}
		$(listId).append(_select.html());
	},

	PopulateDependedDropDownList: function (listId, data, idColumn, textColumn, selectorColumn, valueToCompare, selectOption) {
		var itemsAdded = 0;
		$(listId).empty();
		var _select = $('<select>');
		if (data.length == 0) {
			_select.append(
					$('<option></option>').val("-1").html(_GlobalModels.Labels[_GlobalModels.Values.Language].NoRowsToPopulateTheDropDownList)
				);
		} else {
			if (selectOption) {
				_select.append(
						$('<option></option>').val("-1").html(_GlobalModels.Labels[_GlobalModels.Values.Language].DropDownListSelectOne)
					);
			}
			for (var iIdx = 0; iIdx < data.length; iIdx++) {
				//if (iIdx == 0 || iIdx == 10 || iIdx == 250)
				if (data[iIdx][selectorColumn] == '20270')
					alert(valueToCompare + ' - ' + data[iIdx][selectorColumn]);
				if (data[iIdx][selectorColumn] == valueToCompare) {
					_select.append(
							$('<option></option>').val(data[iIdx][idColumn]).html(_CommonFunctions.TruncString(data[iIdx][textColumn], 40))
						);
					itemsAdded++;
				}
			}
		}
		$(listId).append(_select.html());
	},

	PopulateNestedDropDownList: function (listId, data, idColumn, textColumn, nullColumn, selectOption) {
		$(listId).empty();
		var selectHtml = "<select>";
		if (data[0].length == 0) {
			selectHtml += "<option value='-1'>" + _GlobalModels.Labels[_GlobalModels.Values.Language].NoRowsToPopulateTheDropDownList + "</option>";
		} else {
			if (selectOption) {
				selectHtml += "<option value='-1'>" + _GlobalModels.Labels[_GlobalModels.Values.Language].DropDownListSelectOne + "</option>";
			}
			for (var iItem = 0; iItem < data.length; iItem++) {
				if (data[iItem][nullColumn] == null) {
					if (iItem > 0) {
						selectHtml += "</optgroup>";
					}
					selectHtml += "<optgroup label='" + data[iItem][textColumn] + "'>";
				} else {
					selectHtml += "<option value='" + data[iItem][idColumn] + "'>" + data[iItem][textColumn] + "</option>";
				}
				if (iItem == (data.length - 1)) {
					selectHtml += "</optgroup>";
				}
			}
		}
		selectHtml += "</select>";
		var _select = $(selectHtml);

		$(listId).append(_select.html());
	},

	OnKeyPressDecimalPatternReq: function (event) {
		var key = window.event ? event.keyCode : event.which;
		if (event.keyCode == 8 || event.keyCode == 46 || event.keyCode == 37 || event.keyCode == 39) {
			return true;
		}
		else if (key < 48 || key > 57) {
			return false;
		}
		else
			return true;
	},

	OnKeyPressIntegerPatternReq: function (event) {
		var key = window.event ? event.keyCode : event.which;

		if (event.keyCode == 8
			|| event.keyCode == 37 || event.keyCode == 39) {
			return true;
		}
		else if (key < 48 || key > 57) {
			return false;
		}
		else
			return true;
	},

	Back: function () {
		window.history.back(0);
	},

	ShowLargeDescription: function () {
		event.preventDefault();
		x = event.x - this.offsetRight;
		y = event.y - this.offsetTop;
		// Make it hang below the cursor a bit.
		y += 20;
		style.innerHTML = '*[data-tooltip]::after { left: 20px; top: ' + y + 'px  }'
	},

	GetToday_MMddyyy: function () {
		var d = new Date();

		var month = d.getMonth() + 1;
		var day = d.getDate();

		var output = ((month < 10 ? '0' : '') + month) + '/' + ((day < 10 ? '0' : '') + day) + '/' + d.getFullYear();
		return output;
	},

	GetToday_ddMMyyy: function () {
		var d = new Date();

		var month = d.getMonth() + 1;
		var day = d.getDate();

		var output = ((day < 10 ? '0' : '') + day) + '/' + ((month < 10 ? '0' : '') + month) + '/' + d.getFullYear();
		return output;
	},

	GetToday_yyyyMMdd: function () {
		var d = new Date();

		var month = d.getMonth() + 1;
		var day = d.getDate();

		var output = d.getFullYear() + '/' + ((month < 10 ? '0' : '') + month) + '/' + ((day < 10 ? '0' : '') + day);
		return output;
	},

	ConfirmBox: function (message, caption) {
		$("#hider").show();
		$("#ConfirmBox").fadeIn();
		$("#tdTitleConfirm").html("&nbsp;&nbsp;&nbsp;" + caption + " - Logistic");
		$("#tdMessageConfirm").text(message);
		$("#btnYesDialog").focus();
	},

	ClearFormatVal: function (value) {
		for (var iIdx = 0; iIdx < 99; iIdx++)
			value = value.replace(",", "").replace("$", "").replace("'", "");
		return value;
	},

	ClearFormat: function (control) {
		for (var iIdx = 0; iIdx < 99; iIdx++)
			$(control).val($(control).val().replace(",", "").replace("$", ""));
	},

	IntegerFormatTextBox: function (control) {
		var vals = parseInt($(control).val());
		if (_CommonFunctions.valueIsNaN(vals))
			vals = 0;
		vals = vals.toFixed(1).replace(/(\d)(?=(\d{3})+\.)/g, '$1,');
		$(control).val(vals.replace(".0", ""));
	},

	DecimalFormatTextBox: function (control) {
		var vals = parseFloat($(control).val());
		if (_CommonFunctions.valueIsNaN(vals))
			vals = 0;
		vals = vals.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, '$1,');
		$(control).val(vals);
	},

	CurrencyFormatTextBoxfunction: function (control) {
		var vals = parseFloat($(control).val());
		if (_CommonFunctions.valueIsNaN(vals))
			vals = 0;
		vals = vals.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, '$1,');
		$(control).val("$" + vals);
	},

	ValueIsNaN: function (v) {
		return v !== v;
	},

	IsValidDate: function (dateString) {
		// First check for the pattern
		var date_regex = /^(0[1-9]|1[0-2])\/(0[1-9]|1\d|2\d|3[01])\/(19|20)\d{2}$/;
		if (!(date_regex.test(dateString))) {
			return false;
		}

		// Parse the date parts to integers
		dateString = dateString.replace("/", "-").replace("/", "-");
		var parts = dateString.split("-");
		var month = parseInt(parts[0], 10);
		var day = parseInt(parts[1], 10);
		var year = parseInt(parts[2], 10);

		// Check the ranges of month and year
		if (year < 1000 || year > 3000 || month == 0 || month > 12) {
			return false;
		}

		var monthLength = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];

		// Adjust for leap years
		if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) {
			monthLength[1] = 29;
		}

		// Check the range of the day
		return day > 0 && day <= monthLength[month - 1];
	},

	VerifyDate: function (control, needed) {
		if ($.trim($(control).val()) == "" && needed) {
			_MessageBox($(control).attr("data-message"), "Wrong Date");
			return false;
		}

		if ($.trim($(control).val()) != "")
			if (!isValidDate($.trim($(control).val()))) {
				_MessageBox($(control).attr("data-message"), "Wrong Date");
				return false;
			}
	},

	Pad: function (input, PadLength, PadCharacter, PadDirection) {//string/number,length=2,char=0,0/false=Left-1/true=Right
		return input = (input || PadCharacter || 0), PadCharacter = new Array(PadLength || 2).join(PadCharacter || 0), PadDirection ? (input + PadCharacter).slice(0, PadLength) : (PadCharacter + input).slice(-PadLength)
	},

	// getElementById
	$id: function (id) {
		return document.getElementById(id);
	}

};
_CommonFunctions.GetLanguage();