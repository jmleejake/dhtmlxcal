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

// 반복 일정 셀렉트박스
function repeatChanged() {
	var r_month = "";
	var r_day = "";
	$("#div_repeat_month").html(r_month);
	$("#div_repeat_day").html(r_day);
	
	switch($("#repeat").val()) {
	case "monthly":
		
		break;
	case "yearly":
		r_month += "<select id='repeat_month' onchange='rep_mon_changed();'>";
		for(var i=1; i<13; i++) {
			r_month += "<option>" + i + "</option>"
		}
		r_month += "</select>월";
		
		$("#div_repeat_month").html(r_month);
		
		r_day += "<select>"
		for(var j=1; j<daysInMonth(1, new Date().getFullYear())+1; j++) {
			r_day += "<option>" + j + "</option>"
		}
		r_day += "</select>일"
		
		$("#div_repeat_day").html(r_day);
		break;
	}
}

function rep_mon_changed() {
	var r_day = "";
	$("#div_repeat_day").html(r_day);
	
	console.log($("#repeat_month").val());
	console.log(daysInMonth($("#repeat_month").val(), new Date().getFullYear()));
	
	r_day += "<select>"
	for(var j=1; j<daysInMonth($("#repeat_month").val(), new Date().getFullYear())+1; j++) {
		r_day += "<option>" + j + "</option>"
	}
	r_day += "</select>일"
	
	$("#div_repeat_day").html(r_day);
}

// 월에 해당하는 일수 계산하여 얻기
function daysInMonth(month,year) {
	/*
	//July
	daysInMonth(7,2009); //31
	//February
	daysInMonth(2,2009); //28
	daysInMonth(2,2008); //29
	*/
    return new Date(year, month, 0).getDate();
}



// 알람 셀렉트박스
function alarmChanged(){
	console.log($("#alarm").val());
}

function input_minical(id){
    if (scheduler.isCalendarVisible()){
        scheduler.destroyCalendar();
    } else {
        scheduler.renderCalendar({
            position:id,
            date:scheduler._date,
            navigation:true,
            handler:function(date,calendar){
                var originDate=date;
                var tYear = originDate.getFullYear();
                var tMonth = originDate.getMonth();
                if(tMonth < 10) tMonth = "0" + tMonth;
                var tDay = originDate.getDate();
                if(tDay < 10) tDay = "0" + tDay;
                $("#"+id).val(tYear+"-"+tMonth+"-"+tDay);
                scheduler.destroyCalendar()
            }
        });
    }
}

function fnc_end_date() {
	if($("#check_end_date")[0].checked) {
		$("#end_date")[0].disabled = false;
	} else {
		$("#end_date").val("");
		$("#end_date")[0].disabled = true;
	}
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
			z-index: 15;
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

.detail_sel {
	width: 70px;
	height: 15px;
	display: inline-block;
}
</style>
</head>
<body onload="init();">

<div id="my_form">
	<label for="description">제목</label><input type="text" name="description" value="" id="description"><br>
	<label for="custom1">작성자</label><input type="text" name="custom1" value="" id="custom1"><br>
	<label for="custom2">내용</label><input type="text" name="custom2" value="" id="custom2"><br>
	<label for="category">카테고리</label><input type="text" name="category" value="" id="category"><br>
	<label for="alarm">알람</label>
	<select id="alarm" onchange="alarmChanged();">
		<option value="none">알람없음</option>
		<option value="0">시작시간</option>
		<option value="5">5분전</option>
		<option value="10">10분전</option>
		<option value="60">1시간전</option>
		<option value="180">3시간전</option>
	</select><br>
<!-- 	<input type="text" name="alarm" value="" id="alarm"> -->
	<label for="repeat">반복 일정</label>
	<div>
		<select id="repeat" onchange="repeatChanged();">
			<option value="none">반복안함</option>
			<option value="daily">매일</option>
			<option value="monthly">매월</option>
			<option value="yearly">매년</option>
		</select>
		<label>
		    <input type="checkbox" id="check_end_date" value="date_of_end" onclick="fnc_end_date();" />
		    <input class="dhx_repeat_date" type="text" id="end_date" name="date_of_end" disabled="disabled" readonly="readonly" onclick="input_minical('end_date')" />까지
	    </label><br>
		<div class="detail_sel" id="div_repeat_month"></div>
		<div class="detail_sel" id="div_repeat_day"></div>
	</div>
<!-- 	<input type="text" name="repeat" value="" id="repeat"> -->
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