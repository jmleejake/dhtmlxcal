<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="./resources/fileTest.js"></script>

<script>
$(document).ready(function(){
	$("#home").addClass("active");
	
	$('#js-selectFile').on('click', 'button', function () {
	    $('#js-upload').click();
	    return false;
	});

	$('#js-upload').on('change', function() {
	    //選択したファイル情報を取得し変数に格納
	    var file = $(this).prop('files')[0];
	    //アイコンを選択中に変更
	    $('#js-selectFile').find('.icon').addClass('select').html('選択中');
	    //未選択→選択の場合（.filenameが存在しない場合）はファイル名表示用の<div>タグを追加
	    if(!($('.filename').length)){
	        $('#js-selectFile').append('<div class="filename"></div>');
	    };
	    //ファイル名を表示
	    $('.filename').html('ファイル名：' + file.name);
	});
});
</script>

<style>
/* オリジナルボタン */
.original_btn {
    border: 1px solid #ddd;
    padding: 10px;
    cursor: pointer;
    border-radius: 5px;
    color: #666;
    background: linear-gradient(to bottom,#fff 0,#f4f4f4 100%);
    box-shadow: inset 0px -1px 0px 0px rgba(0, 0, 0, 0.09);
}
/* 未選択時のアイコン */
.icon {
    font-size: 12px;
    margin: 0 10px 0 15px;
    padding: 3px 30px;
    border-radius: 15px;
    background: #666;
    color: #fff;
    display: inline-block;
}
/* 選択時のアイコン */
.icon.select {
    background: #ff5050;
    color: #fff;
}
/* ファイル名 */
.filename {
    display: inline-block;
    font-size: 12px;
}
</style>
</head>
<body>
<jsp:include page="top.jsp"></jsp:include>
<div class="container-fluid">
<h3>Home2</h3>
<span id="retSpan"></span>
<!-- onsubmit 걸리는거 확인완료 -->
<form action="/test" method="post" enctype="application/multipart-file" onsubmit="return test();">
<div id="js-selectFile col-md-8">
<input id="js-upload" type="file" name="upload" style="display:none">
<button class="original_btn">ファイルを選択</button>
<span class="icon">未選択</span>
</div>
<div class="col-md-4">
<input type="submit" class="original_btn">
</div>
</form>
</div>
</body>
</html>
