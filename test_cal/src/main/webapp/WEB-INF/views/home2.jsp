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
<form action="fileUpload" method="post" enctype="multipart/form-data">
	<input type="file" name="file">
	<input type="submit">
</form>
</div>
</body>
</html>
