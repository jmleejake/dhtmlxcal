<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="./resources/scheduler-5.0/codebase/dhtmlxscheduler.js" type="text/javascript"></script>
<script src="./resources/scheduler-5.0/codebase/locale/locale_jp.js" type="text/javascript" charset="utf-8"></script>

<link rel="stylesheet" href="./resources/scheduler-5.0/codebase/dhtmlxscheduler_terrace.css" type="text/css">
<link rel="stylesheet" href="./resources/schedulerTest.css" type="text/css">

<script src="./resources/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
<script src="./resources/bootstrap-datetimepicker/bootstrap-datetimepicker.ja.js" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" href="./resources/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css" type="text/css">

<script src="./resources/schedulerTest.js" type="text/javascript" charset="utf-8"></script>

<script>
$(document).ready(function(){
	$("#sche").addClass("active");
	
	/*
	https://stackoverflow.com/questions/44171706/how-change-the-bootstrap-datepicker-start-time-every-time-every-time-i-change-th
	여깄는거 적용하면 아마 스타트타임 누를때 엔드타임에 스타트타임옵션 적용하는게 가능할지도...
	*/
	$("#start_date").datetimepicker({
		format: 'yyyy-mm-dd hh:ii'
		, autoclose: true
		, minuteStep: 10
	});

	$("#end_date").datetimepicker({
		format: 'yyyy-mm-dd hh:ii'
		, autoclose: true
		, minuteStep: 10
	});
});	
</script>
</head>

<body onload="init();">
<jsp:include page="../top.jsp"></jsp:include>

<div id="my_form">
	<table class="table">
	<tbody>
	<tr>
	<th>デスクリプション</th>
	<td>
	<input type="text" class="form-control input-sm" id="description" value="insert description">
	</td>
	</tr>
	<tr>
	<th>期間</th>
	<td>
	<input type="text" class="form-control" id="custom1">
	</td>
	</tr>
	<tr>
	<th>テスト項目一番</th>
	<td>
	<input type="text" class="form-control" id="custom2">
	</td>
	</tr>
	<!-- https://www.malot.fr/bootstrap-datetimepicker/ -->
	<tr>
	<th>時間</th>
	<td>
	<div>
	<input type="text" class="form-control" id="start_date" style="width: 150px; display: inline-block;">
	<label style="width: 10px; display: inline-block;">~</label>
	<input type="text" class="form-control" id="end_date" style="width: 150px; display: inline-block;">
	</div>
	</td>
	</tr>
	</tbody>
	</table>
	<input type="button" class="btn btn-sm btn-info" name="save" value="Save" id="save" onclick="save_form()">
	<input type="button" class="btn btn-sm btn-info" name="close" value="Close" id="close" onclick="close_form()">
	<input type="button" class="btn btn-sm btn-danger" name="delete" value="Delete" id="delete" onclick="delete_event()">
</div>

<div id="scheduler_here" class="dhx_cal_container" style='width:100%; height:100%;'>
	<div class="dhx_cal_navline">
		<div class="dhx_cal_prev_button">&nbsp;</div>
		<div class="dhx_cal_next_button">&nbsp;</div>
		<div class="dhx_cal_today_button"></div>
		<div class="dhx_cal_date"></div>
<!-- 		<div class="dhx_cal_tab" name="day_tab" style="right:204px;"></div> -->
<!-- 		<div class="dhx_cal_tab" name="week_tab" style="right:140px;"></div> -->
<!-- 		<div class="dhx_cal_tab" name="month_tab" style="right:76px;"></div> -->
	</div>
	<div class="dhx_cal_header">
	</div>
	<div class="dhx_cal_data">
	</div>
</div>
</body>