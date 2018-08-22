<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="./resources/scheduler-5.0/codebase/dhtmlxscheduler.js" type="text/javascript" charset="utf-8"></script>
<script src="./resources/scheduler-5.0/codebase/locale/locale_jp.js" type="text/javascript" charset="utf-8"></script>
<script src="./resources/schedulerTest.js" type="text/javascript" charset="utf-8"></script>

<link rel="stylesheet" href="./resources/scheduler-5.0/codebase/dhtmlxscheduler_terrace.css" type="text/css">
<style type="text/css" >
html, body{
	height:100%;
}	
</style>

<script>
$(document).ready(function(){
	$("#sche").addClass("active");
});	
</script>
</head>

<body onload="init();">
<jsp:include page="../top.jsp"></jsp:include>
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