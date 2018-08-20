<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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

$(function() {	
	// DB에서 가져오기
	scheduler.config.xml_date="%Y-%m-%d %H:%i";
	getCalData(m_oMonth.getFullYear(), m_oMonth.getMonth() + 1);
	
	
		//시간 입력설정 셋팅하는 곳
		//change type:"time" -> type:"calendar_time"
		/*  scheduler.config.lightbox.sections = [
		  {name:"description", height:200, map_to:"text", type:"textarea", focus:true},
		  {name:"time", height:72, type:"calendar_time", map_to:"auto" }
		]; */
		//설정
		scheduler.config.wide_form = false;
		scheduler.config.repeat_date = "%m/%d/%Y";
		scheduler.config.include_end_by = true;
		scheduler.config.start_on_monday = false;
		scheduler.config.fix_tab_position = true; //스킨입히면 true	
		scheduler.templates.event_text = function(start, end, ev) {
			return '카테고리: ' + ev.text + '';
		};//일정 카테고리별 나누기 	
		//스킨
		scheduler.skin = "flat";
		//시작화면 설정
		scheduler.init('scheduler_here', new Date(), "month");		
		scheduler.templates.event_text = function(start,end,ev){
			   return 'Subject: ' + ev.text + ''+ev.id;
			};

		//반복설정
		 scheduler.locale.labels.section_title = "타이토루";
		 scheduler.locale.labels.section_alarm = "알람설정";
		
 		var alarm_opts = [
 			{key:"none", label:"없는거다요"}
 			, {key:"5", label:"고분마에"}
 			, {key:"10", label:"쥬뿐마에"}
 		];
			 scheduler.config.lightbox.sections = [{
				name:"title", 
				height:80, 
				map_to:"text", 
				type:"textarea",
				focus : true
			 },{
				name : "description",
				height : 130,
				map_to : "content",
				type : "textarea"
			}, {
				name:"alarm",
				height:25,
				type:"select",
				options:alarm_opts,
				map_to:"alarm_val"
			}, {
				name : "time",
				height : 72,
				type : "time", //time or calendar_time
				map_to : "auto"
			}, {
				name : "recurring",
				type : "recurring",
				map_to : "rec_type",
				button : "recurring",
				form : "my_recurring_form"
			}];  
			 
			
 		//미니캘린더 (스케줄러(주))
			/* var calendar = scheduler.renderCalendar({
			    container:"cal_here", 
			    navigation:true,
			    handler:function(date){
			        scheduler.setCurrentView(date, scheduler._mode);
			    }
			}); */

 		
 $('#getList').on('click', function(){
	 getCalData(m_oMonth.getFullYear(), m_oMonth.getMonth() + 1);
 });
 
 // 월 변경
 $('.dhx_cal_prev_button').on('click', function(){
	 m_oMonth.setMonth(m_oMonth.getMonth() - 1);
	 getCalData(m_oMonth.getFullYear(), m_oMonth.getMonth() + 1);
	 });
 $('.dhx_cal_next_button').on('click', function(){
	 m_oMonth.setMonth(m_oMonth.getMonth() + 1);
	 getCalData(m_oMonth.getFullYear(), m_oMonth.getMonth() + 1);
	 });
 
 
 
 
console.log("start");
var tGdayYear = new Date().getFullYear();
var tGdayMonth = new Date().getMonth();
var tGdayDay = new Date().getDate();

//시작날짜를 Date로 !
var tSday = "2017-04-11 00:01";
var tSdatyYear=tSday.substring(0,4);
var tSdatyMonth=tSday.substring(5,7);
var tSdatyDay=tSday.substring(8,10);
var tStart = new Date(tSdatyYear,tSdatyMonth-1,tSdatyDay,00,01,0);
console.log("시작날짜 : "+tStart);
//종료날짜를 Date로!
var tEday = "2017-04-20 00:05";
var tEdatyYear=tEday.substring(0,4);
var tEdatyMonth=tEday.substring(5,7);
var tEdatyDay=tEday.substring(8,10);
var tEnd = new Date(tEdatyYear,tEdatyMonth-1,tEdatyDay,00,01,0);
console.log("종료날짜 : "+tEnd);

//시작날짜와 종료날짜의 시간텀!
var diff = tEnd - tStart;
var currDay = 24*60*60*1000;//시*분*초*밀리세컨
var currMonth = currDay*30;//월만듬
var currYear=currMonth*12;//년 만듬
/*
alert("diff : "+diff);
alert("일수차이 = "+parseInt(diff/currDay)+"일");
alert("월수차이 = "+parseInt(diff/currMonth)+"월");
alert("년수차이 = "+parseInt(diff/currYear)+"년");
*/




//반복일정 만들기 view 딴에 뿌려주기 !!!! 
var Repeat = "daily";
switch (Repeat) {
case "daily":
	var dayDiff = parseInt(diff/currDay);
	for(var i=0;i<dayDiff;i++){
	    tStart.setDate(tStart.getDate()+1);
		console.log(i+"번째 : "+tStart);
	}
	
	break;
case "monthly":
	var monthDiff = parseInt(diff/currMonth);
	for(var i=0;i<monthDiff;i++){
	    tStart.setMonth(tStart.getMonth()+1);
		console.log(i+"번째 : "+tStart);
	}
	break;
case "yearly":
	var yearlyDiff = parseInt(diff/currYear);
	for(var i=0;i<yearlyDiff;i++){
	    tStart.setFullYear(tStart.getFullYear()+1);
		console.log(i+"번째 : "+tStart);
	}
	break;

default:
	break;
}

console.log("end");


//달력 설정하는 textbox클릭시 미니캘린더 팝업
scheduler.attachEvent("onLightbox", function(){
	var lightbox_form = scheduler.getLightbox(); // this will generate lightbox form
	var inputs = lightbox_form.getElementsByTagName('input');
	var date_of_end = null;
	for (var i=0; i<inputs.length; i++) {
		if (inputs[i].name == "date_of_end") {
			date_of_end = inputs[i];
			break;
		}
	}

	var repeat_end_date_format = scheduler.date.date_to_str(scheduler.config.repeat_date);
	var show_minical = function(){
		if (scheduler.isCalendarVisible())
			scheduler.destroyCalendar();
		else {
			scheduler.renderCalendar({
				position:date_of_end,
				date: scheduler.getState().date,
				navigation:true,
				handler:function(date,calendar) {
					date_of_end.value = repeat_end_date_format(date);
					scheduler.destroyCalendar()
				}
			});
		}
	};
	date_of_end.onclick = show_minical;
});

 
  
});//main Function

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
// 				, rec_type:event.rec_type
// 				, event_pid:event.event_pid
		}
		calArray.push(calObj);
	});
	scheduler.parse(calArray, "json");
}
//미니캘린더
function show_minical(){
    if (scheduler.isCalendarVisible()){
        scheduler.destroyCalendar();
    } else {
        scheduler.renderCalendar({
            position:"dhx_minical_icon",
            date:scheduler._date,
            navigation:true,
            handler:function(date,calendar){
                scheduler.setCurrentView(date);
                scheduler.destroyCalendar()
            }
        });
    }
}

function successResult(data) {
	console.log("successResult");
	console.log(JSON.stringify(data));
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
.mainwrapp {
	width: 900px; 
	height : 500px;
	margin:0 auto;
	/* left: 50%; */
	text-align:center;
}
</style>
</head>
<body>
<div class="mainwrapp">
<h1>Calendar TEST</h1>
<input type="button" id="getList" value="db값가져오기">
	<h1>
		<a href="https://docs.dhtmlx.com/scheduler/">dhtmlx API</a>
	</h1>
	<!-- 월달력view!!  -->
	<div id="scheduler_here" class="dhx_cal_container"
		style='width: 50%; height: 50%; padding: 100px;'>
		<div class="dhx_cal_navline">
			<div class="dhx_cal_prev_button">&nbsp;</div>
			<div class="dhx_cal_next_button">&nbsp;</div>
			<div class="dhx_cal_today_button"></div>
			<div class="dhx_cal_date"></div>
			<!-- 미니캘린더 추가시 -->
			<div class="dhx_minical_icon" id="dhx_minical_icon" onclick="show_minical()">&nbsp;</div> 			
			<!-- 일주월 버튼 커스텀 -->
			<div class="dhx_cal_tab" name="day_tab" style="right: 204px;"></div>
			<div class="dhx_cal_tab" name="week_tab" style="right: 140px;"></div>
			<div class="dhx_cal_tab" name="month_tab" style="right: 76px;"></div>
			<!-- <div class="dhx_cal_tab" name="day_tab" style="right: 204px;"></div>
			<div class="dhx_cal_tab" name="week_tab" style="right: 140px;"></div>
			<div class="dhx_cal_tab" name="month_tab" style="right: 76px;"></div> -->
			<!--이벤트 설정시 반복view  -->
			<div class="dhx_form_repeat" id="my_recurring_form">
				<form>
					<div>
						<select name="repeat">
							<option value="day">매일</option>
							<option value="week">매주</option>
							<option value="month">매월</option>
							<option value="year">매년</option>
						</select>
						<br />
					<label>
					    <input type="radio" name="end" value="no" checked/>No end date
					</label>
					<label>
					    <input type="radio" name="end" value="date_of_end" />
					    <input class="dhx_repeat_date" type="text" name="date_of_end" />까지
				    </label>
					</div>
					<div>
						<div style="display: none;" id="dhx_repeat_day">
							<input type="hidden" name="day_type" value="d" /> <input
								type="hidden" name="day_count" value="1" />
						</div>
						<div style="display: none;" id="dhx_repeat_week">
							원하는 요일을 선택하여 주세요!:<br /> <label><input type="checkbox"
								name="week_day" value="1" />월</label> <label><input
								type="checkbox" name="week_day" value="2" />화</label> <label><input
								type="checkbox" name="week_day" value="3" />수</label> <label><input
								type="checkbox" name="week_day" value="4" />목</label> <label><input
								type="checkbox" name="week_day" value="5" />금</label> <label><input
								type="checkbox" name="week_day" value="6" />토</label> <label><input
								type="checkbox" name="week_day" value="0" />일</label> <input
								type="hidden" name="week_count" value="1" />
						</div>
						<div style="display: none;" id="dhx_repeat_month">
							<label><input class="dhx_repeat_radio" type="hidden"
								name="month_type" value="d" /></label> <input class="dhx_repeat_text"
								type="text" name="month_day" value="1" />일<input
								class="dhx_repeat_text" type="hidden" name="month_count" value="1" /><br />
						</div>
						<div style="display: none;" id="dhx_repeat_year">
							<label><select name="year_month"><option value="0" selected >1월<option value="1">2월<option value="2">3월<option value="3">4월<option value="4">5월<option value="5">6월<option value="6">7월<option value="7">8월<option value="8">9월<option value="9">10월<option value="10">11월<option value="11">12월</select><input class="dhx_repeat_radio" type="hidden" name="year_type" value="d"/></label><input class="dhx_repeat_text" type="text" name="year_day" value="1" />일<br />
						</div>
					</div>
					<input type="hidden" value="no" name="end">
				</form>
			</div>
			<!--이벤트 설정시 반복view  -->
		</div>
		<div class="dhx_cal_header">header</div>
		<div class="dhx_cal_data">data</div>
	</div>
	
	
			<!-- 스케줄러 옆에 미니 달력! -->
			<div style='float: left; padding:10px;'>
        <div id="cal_here" style='width:250px;'></div></div>
</div><!-- mainDIV -->
	</body>
</html>