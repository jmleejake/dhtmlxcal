/**
 * 
 */
function test() {
	var hasFile = $("#js-upload")[0].files.length;
	console.log(hasFile);
	console.log("1111 test in");
	if (hasFile > 0) {
		// 파일이 존재할경우 서버에서 파일 처리및 디비처리후 목록화면으로 리다이렉트
		//  function return String & return "redirect:testPage"
		// 단 POST로 메소드가 되어있는 경우는 리다이렉트 처리가 안되니 페이지 이동하는 GET으로 세팅되어있는 리퀘스트매핑으로 갈것!
		console.log("has file!")
		return true;
	}
	return false;
}