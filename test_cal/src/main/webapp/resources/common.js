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