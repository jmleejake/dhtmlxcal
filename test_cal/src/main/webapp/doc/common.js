/**
 * 
 */

function getYesterday() {
	var d = new Date();
	var yesterday = d.getFullYear() +'/'+ (d.getMonth()+1) + '/' + (d.getDate()-1);
	console.log(yesterday);
//	return yesterday;
}