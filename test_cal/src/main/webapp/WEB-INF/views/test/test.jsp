<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://unpkg.com/ag-grid/dist/ag-grid.min.noStyle.js"></script>
<link rel="stylesheet" href="https://unpkg.com/ag-grid/dist/styles/ag-grid.css">
<link rel="stylesheet" href="https://unpkg.com/ag-grid/dist/styles/ag-theme-balham.css">

<link rel="stylesheet" href="./resources/bootstrap-datepicker/bootstrap-datepicker.min.css">
<script src="./resources/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>

<script>
$(document).ready(function(){
	$("#file").addClass("active");
	
	gridPageInit();
	
	$("#txt_order").datepicker(); // datepicker : bootstrap 4.1.3 및 ag-grid와 css충돌문제없음
	
	$.ajax({
		url: "ajaxTest"
		, data:{intVal:3}
		, success: function(result){
        	$("#retSpan").html(result);
    	}
	});
});

</script>
</head>
<body>
<jsp:include page="../top.jsp"></jsp:include>
<div class="container-fluid">
<h3>Test</h3>
<span id="retSpan"></span>

<button type="button" class="btn btn-primary" id="btn_sel">選択結果</button>
<button type="button" class="btn btn-primary" id="btn_mod">更新</button>
<button type="button" class="btn btn-primary" id="btn_create">登録</button>
<button type="button" class="btn btn-primary" id="btn_del">削除</button>
<input type="text" id="txt_order" class="form-control" style="width: 150px;" placeholder="日付選択">
<input type="text" id="txt_keyword" placeholder="press any... and press enter" style="width: 200px;">
<button type="button" class="btn btn-primary" id="btn_srch">検索</button>
<div id="myGrid" style="height: 300px;width:500px;" class="ag-theme-balham"></div>

<script src="./resources/gridTest.js"></script>

<form>
	<input type="hidden" name="id" id="car_id">
</form>
</div>
</body>
</html>