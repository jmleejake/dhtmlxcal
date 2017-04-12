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
//현재 연월 값!
var m_oMonth = new Date();
m_oMonth.setDate(1);

function init() {

	scheduler.config.xml_date = "%Y-%m-%d %H:%i";
	scheduler.config.details_on_dblclick = true;
	scheduler.config.details_on_create = true;

	scheduler.init('scheduler_here', new Date(), "month");
	
	getCalData(m_oMonth.getFullYear(), m_oMonth.getMonth() + 1);
}

var html = function(id) { return document.getElementById(id); }; //just a helper

scheduler.showLightbox = function(id) {
	var ev = scheduler.getEvent(id);
	scheduler.startLightbox(id, html("my_form"));

	html("description").focus();
	html("description").value = ev.text;
	html("custom1").value = ev.custom1 || "";
	html("content").value = ev.content || "";
	html("category").value = ev.category || "";
	html("alarm").value = ev.alarm || "none";
	html("repeat").value = ev.repeat_type || "none";
	html("check_end_date").checked = ev.check_end_date;
	html("end_date").value = ev.repeat_end_date || "";
// 	html("timeSetting").value = ev.timeSetting || "";
	switch(ev.repeat_type) {
	case "monthly": // 매월
		$("#mon_day").val(ev.repeat_detail);
		break;
	case "yearly": // 매년
		var sp = ev.repeat_detail.split("_");
		$("#yr_month").val(sp[0]);
		$("#yr_day").val(sp[1]);	
		break;
	}
};

function save_form() {
	var ev = scheduler.getEvent(scheduler.getState().lightbox_id);
	ev.text = html("description").value;
	ev.custom1 = html("custom1").value;
	ev.content = $("#content")[0].value;
	ev.alarm = $("#alarm").val();
	ev.check_end_date = $("#check_end_date")[0].checked;
	ev.repeat_type = $("#repeat").val()
	ev.repeat_end_date = $("#end_date").val();
	
	switch($("#repeat").val()) {
	case "monthly": // 매월
		 ev.repeat_detail = $("#mon_day").val();
		break;
	case "yearly": // 매년
		ev.repeat_detail = $("#yr_month").val() + "_" + $("#yr_day").val();	
		break;
	}
	
	console.log(ev);
	
	$.ajax({
		url:"save"
		, type:"post"
		, data:ev
		,success:function() {
			
		}
		, error:function() {
			
		}
	});

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
	case "monthly": // 매월
		r_day += "<input style='width:30px;' type='text' id='mon_day' >일";
		$("#div_repeat_day").html(r_day);
		break;
	case "yearly": // 매년
		r_month += "<select id='yr_month' onchange='rep_mon_changed();'>";
		for(var i=1; i<13; i++) {
			r_month += "<option>" + i + "</option>"
		}
		r_month += "</select>월";
		
		$("#div_repeat_month").html(r_month);
		
		r_day += "<select id='yr_day'>"
		for(var j=1; j<daysInMonth(1, new Date().getFullYear())+1; j++) {
			r_day += "<option>" + j + "</option>"
		}
		r_day += "</select>일"
		
		$("#div_repeat_day").html(r_day);
		break;
	}
}

// 반복일정 매년 선택시 해당 월의 일수를 얻어 셀렉트박스 갱신
function rep_mon_changed() {
	var r_day = "";
	$("#div_repeat_day").html(r_day);
	
	r_day += "<select id='yr_day'>"
	for(var j=1; j<daysInMonth($("#yr_month").val(), new Date().getFullYear())+1; j++) {
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

//반복일정 체크박스 클릭시
function fnc_end_date() {
	if($("#check_end_date")[0].checked) {
		$("#end_date")[0].disabled = false;
	} else {
		$("#end_date").val("");
		$("#end_date")[0].disabled = true;
	}
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

function getCalData(thisYear, thisMonth) {
	$.ajax({
		url:"show"
			, type:"post"
			, data : {"thisYear":thisYear,"thisMonth" : thisMonth}
			, dataType : "json"
			, success:showEvents
			, error:function(e) {
				alert(JSON.stringify(e));
			} 
	});
}
function showEvents(ret) {
	var calArray = new Array();
	$.each(ret, function(i, event) {
		var calObj = {
				id:event.id
				, text:event.text
				, start_date:event.start_date
				, end_date:event.end_date
				, content:event.content
				, repeat_type:event.repeat_type
				, repeat_end_date:event.repeat_end_date
// 				, rec_type:event.rec_type
// 				, event_pid:event.event_pid
		}
		calArray.push(calObj);
	});
	scheduler.parse(calArray, "json");
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
	width: 65px;
	height: 20px;
	display: inline-block;
}

.sel {
	width: 80px;
	height: 20px;
}
</style>
</head>
<body onload="init();">

<div id="my_form">
	<table>
		<tr>
			<th>제목</th>
			<td><input type="text" id="description"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" id="custom1"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea id="content" rows="5" cols="50"></textarea></td>
		</tr>
		<tr>
			<th>카테고리</th>
			<td><input type="text" name="category" value="" id="category"></td>
		</tr>
		<tr>
			<th>알람</th>
			<td>
			<select class="sel" id="alarm" onchange="alarmChanged();">
				<option value="none">알람없음</option>
				<option value="0">시작시간</option>
				<option value="5">5분전</option>
				<option value="10">10분전</option>
				<option value="60">1시간전</option>
				<option value="180">3시간전</option>
			</select>
			</td>
		</tr>
		<tr>
			<th>반복일정</th>
			<td>
			※체크박스를 누르고 종료기한을 설정하지 않을시 3개월간 반복합니다.<br>
			<select class="sel" id="repeat" onchange="repeatChanged();">
				<option value="none">반복안함</option>
				<option value="daily">매일</option>
				<option value="monthly">매월</option>
				<option value="yearly">매년</option>
			</select>
			<label>
			    <input type="checkbox" id="check_end_date" value="date_of_end" onclick="fnc_end_date();" />
			    <input class="dhx_repeat_date" type="text" id="end_date" disabled="disabled" readonly="readonly" onclick="input_minical('end_date')" />까지
		    </label><br>
			<div class="detail_sel" id="div_repeat_month"></div>
			<div class="detail_sel" id="div_repeat_day"></div>
			</td>
		</tr>
		<tr>
			<th>시간설정</th>
			<td></td>
		</tr>
	</table>
	<!-- 
	<label for="description">제목</label><input type="text" name="description" value="" id="description"><br>
	<label for="custom1">작성자</label><input type="text" name="custom1" value="" id="custom1"><br>
	<label for="custom2"></label>내용<textarea rows="5" cols="50"></textarea><br>
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
	<label for="repeat">반복 일정 ※체크박스를 누르고 종료기한을 설정하지 않을시 3개월간 반복합니다.</label>
	<br>
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
	<div class="detail_sel" id="div_repeat_day"></div><br>
	<label for="timeSetting">시간설정</label><input type="text" name="timeSetting" value="" id="timeSetting"><br>
	 -->
	<div style="text-align: center;">
	<input type="button" name="save" value="Save" id="save" style='width:100px;' onclick="save_form()">
	<input type="button" name="close" value="Close" id="close" style='width:100px;' onclick="close_form()">
	<input type="button" name="delete" value="Delete" id="delete" style='width:100px;' onclick="delete_event()">
	</div>
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