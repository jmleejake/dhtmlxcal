<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>cal_test</title>
<script src="resources/jquery-3.1.1.min.js"></script>
<script src="scheduler/dhtmlxscheduler.js" type="text/javascript"></script>
<script src='scheduler/ext/dhtmlxscheduler_minical.js' type="text/javascript"></script>
<script src="scheduler/ext/dhtmlxscheduler_recurring.js"
	type="text/javascript"></script>
<script src="scheduler/locale/locale_ko.js" charset="utf-8"></script> 
<script type="text/javascript">
function init() {

	scheduler.config.xml_date = "%Y-%m-%d %H:%i";
	scheduler.config.details_on_dblclick = true;
	scheduler.config.details_on_create = true;

	scheduler.init('scheduler_here', new Date(), "month");
	

}

var html = function(id) { return document.getElementById(id); }; //just a helper

scheduler.showLightbox = function(id) {
	var ev = scheduler.getEvent(id);
	scheduler.startLightbox(id, html("my_form"));

	html("description").focus();
	html("description").value = ev.text;
	html("custom1").value = ev.custom1 || "";
	html("custom2").value = ev.custom2 || "";
	html("category").value = ev.category || "";
	html("alarm").value = ev.alarm || "";
	html("repeat").value = ev.repeat || "";
	html("timeSetting").value = ev.timeSetting || "";
};

function save_form() {
	var ev = scheduler.getEvent(scheduler.getState().lightbox_id);
	ev.text = html("description").value;
	ev.custom1 = html("custom1").value;
	ev.custom2 = html("custom2").value;

	scheduler.endLightbox(true, html("my_form"));
}
function close_form() {
	scheduler.endLightbox(false, html("my_form"));
}

function delete_event() {
	var event_id = scheduler.getState().lightbox_id;
	scheduler.endLightbox(false, html("my_form"));
	scheduler.deleteEvent(event_id);
}

</script>
<link rel="stylesheet" href="scheduler/dhtmlxscheduler_flat.css"
	type="text/css">
<style type="text/css" media="screen">
html, body {
			margin: 0px;
			padding: 0px;
			height: 100%;
			overflow: hidden;
		}

		#my_form {
			position: absolute;
			top: 100px;
			left: 200px;
			z-index: 10001;
			display: none;
			background-color: white;
			border: 2px outset gray;
			padding: 20px;
			font-family: Tahoma;
			font-size: 10pt;
		}

		#my_form label {
			width: 200px;
		}
.mainwrapp {
	width: 900px; 
	height : 500px;
	margin:0 auto;
	/* left: 50%; */
	text-align:center;
}
</style>
</head>
<body onload="init();">

<div id="my_form">
	<label for="description">제목</label><input type="text" name="description" value="" id="description"><br>
	<label for="custom1">작성자</label><input type="text" name="custom1" value="" id="custom1"><br>
	<label for="custom2">내용</label><input type="text" name="custom2" value="" id="custom2"><br>
	<label for="category">카테고리</label><input type="text" name="category" value="" id="category"><br>
	<label for="alarm">알람</label><input type="text" name="alarm" value="" id="alarm"><br>
	<label for="repeat">일정 반복</label><input type="text" name="repeat" value="" id="repeat"><br>
	<label for="timeSetting">시간설정</label><input type="text" name="timeSetting" value="" id="timeSetting"><br>
	<input type="button" name="save" value="Save" id="save" style='width:100px;' onclick="save_form()">
	<input type="button" name="close" value="Close" id="close" style='width:100px;' onclick="close_form()">
	<input type="button" name="delete" value="Delete" id="delete" style='width:100px;' onclick="delete_event()">
</div>

<div id="scheduler_here" class="dhx_cal_container" style='width:100%; height:100%;'>
	<div class="dhx_cal_navline">
		<div class="dhx_cal_prev_button">&nbsp;</div>
		<div class="dhx_cal_next_button">&nbsp;</div>
		<div class="dhx_cal_today_button"></div>
		<div class="dhx_cal_date"></div>
		<div class="dhx_cal_tab" name="day_tab" style="right:204px;"></div>
		<div class="dhx_cal_tab" name="week_tab" style="right:140px;"></div>
		<div class="dhx_cal_tab" name="month_tab" style="right:76px;"></div>
	</div>
	<div class="dhx_cal_header">
	</div>
	<div class="dhx_cal_data">
	</div>
</div>
</body>
</html>