$(document).ready(function(event) {
	$("#countryId").change(function() {
		
		$("#stateId").find('option').remove();
		$('<option>').val('').text('-Select-').appendTo("#stateId");
		
		$("#cityId").find('option').remove();
		$('<option>').val('').text('-Select-').appendTo("#cityId");
		
		var countryId = $("#countryId").val();
		$.ajax({
			type : "GET",
			url : "getstate?cid=" + countryId,
			success : function(res) {
				$.each(res, function(stateId, stateName) {
					$('<option>').val(stateId).text(stateName).appendTo("#stateId");
				});
			}
		});
	});

	$("#stateId").change(function() {
		
		$("#cityId").find('option').remove();
		$('<option>').val('').text('-Select-').appendTo("#cityId");
		
		var stateId = $("#stateId").val();
		$.ajax({
			type : "GET",
			url : "getcity?sid=" + stateId,
			success : function(data) {
				$.each(data, function(cityId, cityName) {
					$('<option>').val(cityId).text(cityName).appendTo("#cityId");
				});
			}
		});
	});

});

$(document).ready(function(e) {
	$("#email").blur(function(event) {
		$("#dupEmail").html("");
		var emailId = $("#email").val();
		$.ajax({
			url : 'validateEmail?email=' + emailId,
			success : function(abc) {
				if (abc == 'Duplicate') {
					$("#dupEmail").html("Email already registered");
					$("#email").focus();
				}
			}
		});
	});
});

function validatePwds() {
	var newPwd = $('#newPwd').val();
	var confirmPwd = $('#cnfPwd').val();
	if (newPwd != confirmPwd) {
		$('#errId').text('New Password & Confirm Password Should Be Same');
		return false;
	}
	return true;
}