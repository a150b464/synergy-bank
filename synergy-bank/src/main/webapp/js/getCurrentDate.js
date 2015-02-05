$(function() {
	var dtToday = new Date();

	var month = dtToday.getMonth() + 1;
	var day = dtToday.getDate();
	var year = dtToday.getFullYear();
	var yesterday = dtToday.getDate() - 1;
	if (month < 10)
		month = '0' + month.toString();
	if (day < 10)
		day = '0' + day.toString();
	if (yesterday < 10) {
		yesterday = '0' + yesterday.toString();
	}

	var maxDate = year + '-' + month + '-' + day;
	var yestMaxDate = year + '-' + month + '-' + yesterday;
	$('#enddate').attr('max', maxDate);
	$('#startdate').attr('max', yestMaxDate);

	
});