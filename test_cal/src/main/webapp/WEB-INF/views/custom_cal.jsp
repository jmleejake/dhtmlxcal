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
<script src="scheduler/ext/dhtmlxscheduler_recurring.js" type="text/javascript"></script>
<script src="scheduler/locale/locale_ko.js" charset="utf-8"></script> 
<script type="text/javascript">
//현재 연월 값!
var thisMonth = new Date().getMonth()+1;
var thisYear = new Date().getFullYear();
$(function() {	
	// DB에서 가져오기
	scheduler.config.xml_date="%Y-%m-%d %H:%i";
	getCalData(thisYear, thisMonth);
	
		//설정
		scheduler.config.wide_form = false;
		scheduler.config.repeat_date = "%m/%d/%Y";
		scheduler.config.include_end_by = true;
		scheduler.config.start_on_monday = false;
		scheduler.config.fix_tab_position = true; //스킨입히면 true		
		//스킨 ===> css에도 바꿔줘야함!!!
		scheduler.skin = "terrace";
		//시작화면 설정
		scheduler.init('scheduler_here', new Date(), "month");		
		//커스텀
		var custom_form = document.getElementById("custom_form");
		
		scheduler.showLightbox = function(id){
		    var ev = scheduler.getEvent(id);
		    scheduler.startLightbox(id, custom_form );
		   
		    //document.getElementById("some_input").value = ev.text;
		}
		//needs to be attached to the 'save' button
		function save_form() {
		    var ev = scheduler.getEvent(scheduler.getState().lightbox_id);
		    
		    //ev.text = document.getElementById("some_input").value;
		    scheduler.endLightbox(true, custom_form);
		}
		//needs to be attached to the 'cancel' button
		function close_form(argument) {
		    scheduler.endLightbox(false, custom_form);
		} 

			 
			 
			 
			 
 //미니캘린더 (스케줄러(주))
			var calendar = scheduler.renderCalendar({
			    container:"cal_here", 
			    navigation:true,
			    handler:function(date){
			        scheduler.setCurrentView(date, scheduler._mode);
			    }
			});
 $('#getList').on('click', function(){
	getCalData(thisYear, thisMonth);
 });
 $('.dhx_cal_prev_button').on('click', function(){
	 	thisMonth-=1;
		getCalData(thisYear, thisMonth);
	 });
 $('.dhx_cal_next_button').on('click', function(){	
	 	thisMonth+=1;
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
		var calObj = {id:event.id, text:event.text, start_date:event.start_date, end_date:event.end_date}
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
<link rel="stylesheet" href="scheduler/dhtmlxscheduler.css"
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

			<!--커스텀view  -->
			<div style="display: none;" id='custom_form'>
				<input type="button" value="check">
			
			</div>
			<!--커스텀view  -->
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