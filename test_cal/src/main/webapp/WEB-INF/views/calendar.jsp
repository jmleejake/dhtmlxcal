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
$(function() {

		/* 
		 초기 세팅!!!
		 scheduler.config.xml_date="%Y-%m-%d %H:%i";  //데이터 폼
		 scheduler.config.first_hour = 8; //시작시간
		 scheduler.config.last_hour = 17; //종료시간
		 scheduler.init('scheduler_here',null,"week");
		 scheduler.config.start_on_monday = true; //월요일 시작
		 scheduler.config.repeat_date = "%m/%d/%Y";
		 scheduler.config.include_end_by = true;
		 */
		 //scheduler.config.wide_form = true;
		//반복설정
		 scheduler.config.lightbox.sections = [ {
			name : "description",
			height : 130,
			map_to : "text",
			type : "textarea",
			focus : true
		}, {
			name : "recurring",
			type : "recurring",
			map_to : "rec_type",
			button : "recurring",
			form : "my_recurring_form"
		}, {
			name : "time",
			height : 72,
			type : "time", //time or calendar_time
			map_to : "auto"
		} ];  

		//시간 입력설정 셋팅하는 곳
		//default lightbox definition
		/* scheduler.config.lightbox.sections=[
		  {name:"description", height:200, map_to:"text", type:"textarea", focus:true},
		  {name:"time", height:72, type:"time", map_to:"auto"}
		]; */
		//change type:"time" -> type:"calendar_time"
		/* scheduler.config.lightbox.sections = [
		  {name:"description", height:200, map_to:"text", type:"textarea", focus:true},
		  {name:"time", height:72, type:"calendar_time", map_to:"auto" }
		];
		 */
		
		//설정
		scheduler.config.wide_form = false;
		scheduler.config.repeat_date = "%m/%d/%Y";
		scheduler.config.include_end_by = true;
		scheduler.config.start_on_monday = false;
		scheduler.config.fix_tab_position = true; //스킨입히면 true	
		
		scheduler.templates.event_text = function(start, end, ev) {
			return '카테고리: ' + ev.text + '';
		};//일정 카테고리별 나누기 	

		scheduler.skin = "flat";

		scheduler.init('scheduler_here', new Date(), "month");
		
		
		/* scheduler.attachEvent("onCellClick", function (x_ind, y_ind, x_val, y_val, e){
		    //any custom logic here
		    alert('clicked');
		}); */
		
		//달력 이벤트 클릭
		/* scheduler.attachEvent("onClick", function (id, e){
		       alert('id값 : '+id);
		       return true;
		  }); */
		//이벤트 예시
		var events = [
			{id:1, text:"모임",   start_date:"03/11/2017 14:00",end_date:"03/11/2017 17:00"},
			{id:2, text:"대청소기간",start_date:"03/15/2017 12:00",end_date:"03/18/2017 19:00"},
			{id:3, text:"면접", start_date:"03/24/2017 09:00",end_date:"03/24/2017 10:00"}
			];
		//이벤트 넣기
		scheduler.parse(events, "json");
		
		//이벤트 기간으로 읽기 
		/* var evs = scheduler.getEvents(new Date(2017,1,3),new Date(2017,30,3)); 
		console.log(evs);
		console.log(scheduler.getEvent(1));
		for (var i=0; i<evs.length; i++){
		       alert(evs[i].text);
		} */  
		
		//이벤트 전제 가져오기 (현재 사용안됨)
	/* 	var evs = scheduler.getEvents();
		alert(evs); 
		console.log(evs);
		 for (var i=0; i<evs.length; i++){
		       alert(evs[i].text);
		} 
		  */
		
		scheduler.templates.event_text = function(start,end,ev){
			   return 'Subject: ' + ev.text + ''+ev.id;
			};
	/* 
		var eventObj = scheduler.getEvent(1);
		alert(JSON.stringify(eventObj));
 */

 //미니캘린더 (스케줄러(주))
			var calendar = scheduler.renderCalendar({
			    container:"cal_here", 
			    navigation:true,
			    handler:function(date){
			        scheduler.setCurrentView(date, scheduler._mode);
			    }
			});
 
 
});//main


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