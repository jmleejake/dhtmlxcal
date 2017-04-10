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
var date = new Date();
var thisMonth = date.getMonth();
var thisYear = "";

// var thisMonth = new Date().getMonth()+1;
// var thisYear = new Date().getFullYear();

$(function() {	
	// DB에서 가져오기
	scheduler.config.xml_date="%Y-%m-%d %H:%i";
	getCalData(thisYear, thisMonth);
	
	
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
			var calendar = scheduler.renderCalendar({
			    container:"cal_here", 
			    navigation:true,
			    handler:function(date){
			        scheduler.setCurrentView(date, scheduler._mode);
			    }
			});
 var m_oMonth = new Date();
	m_oMonth.setDate(1);
 		
 $('#getList').on('click', function(){
	getCalData(thisYear, thisMonth);
 });
 $('.dhx_cal_prev_button').on('click', function(){
	 date.setDate(date.getMonth() - 1);
	 alert(date.getFullYear() + " / " + date.getMonth());
// 	 	thisMonth-=1;
// 	 	alert(thisMonth+"/"+thisYear);
// 		getCalData(thisYear, thisMonth);
m_oMonth.setMonth(m_oMonth.getMonth() - 1);
alert(m_oMonth);
	 });
 $('.dhx_cal_next_button').on('click', function(){
	 m_oMonth.setMonth(m_oMonth.getMonth() + 1);
alert(m_oMonth);
// 	 	thisMonth+=1;
	 	/* alert(thisMonth+"/"+thisYear);
	 	alert(thisMonth%12); */
	 	//alert(thisYear+parseInt(thisMonth/12)+"/"+thisMonth%12)
 		getCalData(thisYear, thisMonth);
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
				, rec_type:event.rec_type
				, event_pid:event.event_pid
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