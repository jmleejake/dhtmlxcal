<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://unpkg.com/ag-grid/dist/ag-grid.min.noStyle.js"></script>
<link rel="stylesheet" href="https://unpkg.com/ag-grid/dist/styles/ag-grid.css">
<link rel="stylesheet" href="https://unpkg.com/ag-grid/dist/styles/ag-theme-balham.css">

<script>
$(document).ready(function(){
	$("#file").addClass("active");
	console.log("result page");
	
	getData();
});

</script>
</head>
<body>
<jsp:include page="../top.jsp"></jsp:include>
<div class="container-fluid">
<h3>Test2 - result page</h3>

<button type="button" class="btn btn-primary" id="btn_down">ダウンロード</button>
<div id="myGrid" style="height: 300px;width:500px;" class="ag-theme-balham"></div>

<script src="./resources/resultPage.js"></script>

</div>
<input type="hidden" id="seq_id_list" value="${idList }">
</body>
</html>