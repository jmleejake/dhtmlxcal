/**
 * 
 */

function getDate(range) {
	var d = new Date();
	var month = ''+(d.getMonth() + 1);
    var day = ''+(d.getDate()+range);
    var year = d.getFullYear();

	if (month.length < 2) month = '0' + month;
	if (day.length < 2) day = '0' + day;
	
	var date = year +'/'+ month + '/' + day;
	return date;
}

function getFormatDate(date) {
	var d = new Date(date);
	var month = ''+(d.getMonth() + 1);
    var day = ''+(d.getDate());
    var year = d.getFullYear();
    var hour = ''+d.getHours();
    var minute = ''+d.getMinutes();
    var second = ''+d.getSeconds();
    
    if (month.length < 2) month = '0' + month;
	if (day.length < 2) day = '0' + day;
	
	if (hour.length < 2) hour = '0' + hour;
	if (minute.length < 2) minute = '0' + minute;
	if (second.length < 2) second = '0' + second;
	
	var format = year+'-'+month+'-'+day+' '+hour+':'+minute+':'+second;
	
	return format;
}