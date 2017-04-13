<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>cal_test</title>
<script src="resources/jquery-3.1.1.min.js"></script>
<script src="resources/jquery-ui.js"></script>
<script src="scheduler/dhtmlxscheduler.js" type="text/javascript"></script>
<script src='scheduler/ext/dhtmlxscheduler_minical.js' type="text/javascript"></script>
<script src="scheduler/ext/dhtmlxscheduler_recurring.js"
	type="text/javascript"></script>
<script src="scheduler/locale/locale_ko.js" charset="utf-8"></script> 
<script type="text/javascript">
$( function() {
    $( "#my_form" ).draggable();
} );
//현재 연월 값!
var todayDate = new Date();
var todayDate2 = new Date();
var nowHr = todayDate2.getHours();
var nowMin = todayDate2.getMinutes();
//이벤트창 현재시간으로 설정 
function selectTime(){
	if(nowHr<12){
	$("#Sam")[0].selected=true;
	$("#Eam")[0].selected=true;
	$("#SHour_"+nowHr)[0].selected=true;
	$("#EHour_"+nowHr)[0].selected=true;
	}else{
	$("#Spm")[0].selected=true;
	$("#Epm")[0].selected=true;
	$("#SHour_"+(nowHr-12))[0].selected=true;
	$("#EHour_"+(nowHr-12))[0].selected=true;
	}
	$("#SMin_"+nowMin)[0].selected=true;
	$("#EMin_"+nowMin)[0].selected=true;
}

function selectTimeFromDB(sH, sM, eH, eM){
	if(sH<12){
	$("#Sam")[0].selected=true;
	$("#SHour_"+sH)[0].selected=true;
	}else{
	$("#Spm")[0].selected=true;
	$("#SHour_"+(sH-12))[0].selected=true;
	}
	
	
	if(eH<12){
	$("#Eam")[0].selected=true;
	$("#EHour_"+eH)[0].selected=true;
	}else{
	$("#Epm")[0].selected=true;
	$("#EHour_"+(eH-12))[0].selected=true;
	}
	$("#SMin_"+sM)[0].selected=true;
	$("#EMin_"+eM)[0].selected=true;
}

// 초기화
function init() {
	scheduler.config.xml_date = "%Y-%m-%d %H:%i";
	scheduler.config.details_on_dblclick = true;
	scheduler.config.details_on_create = true;

	scheduler.init('scheduler_here', new Date(), "month");
	
	getCalData(todayDate.getFullYear(), todayDate.getMonth() + 1);

	 // 월 변경
    $('.dhx_cal_prev_button').on('click', function(){
   	 todayDate.setMonth(todayDate.getMonth() - 1);
   	 getCalData(todayDate.getFullYear(), todayDate.getMonth() + 1);
   	 });
    $('.dhx_cal_next_button').on('click', function(){
   	 todayDate.setMonth(todayDate.getMonth() + 1);
   	 getCalData(todayDate.getFullYear(), todayDate.getMonth() + 1);
   	 });
	//날짜 얻어오기
//     console.log("start");
    var tGdayYear = new Date().getFullYear();
    var tGdayMonth = new Date().getMonth();
    var tGdayDay = new Date().getDate();
    
    //시작날짜를 Date로 !
    var tSday = "2017-04-11 00:01";
    var tSdatyYear=tSday.substring(0,4);
    var tSdatyMonth=tSday.substring(5,7);
    var tSdatyDay=tSday.substring(8,10);
    var tStart = new Date(tSdatyYear,tSdatyMonth-1,tSdatyDay,00,01,0);
//     console.log("시작날짜 : "+tStart);
    //종료날짜를 Date로!
    var tEday = "2017-10-20 00:05";
    var tEdatyYear=tEday.substring(0,4);
    var tEdatyMonth=tEday.substring(5,7);
    var tEdatyDay=tEday.substring(8,10);
    var tEnd = new Date(tEdatyYear,tEdatyMonth-1,tEdatyDay,00,01,0);
//     console.log("종료날짜 : "+tEnd);

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
    	    var test=tStart.setDate(tStart.getDate()+1);
    	    var test2=tStart.setMinutes(tStart.getMinutes()+5);
    	    
//     		console.log(i+"번째 : "+tStart);

    	    /*
    	    scheduler.addEvent({
 		       id:repeat+"_"+i+"_"+1234
 		       , start_date: new Date(test)
 		       , end_date: new Date(test2)
 		       , text: "니홍고 3차 역량 -0- -0- -0- -0- -0- -0- -0-"
 		       ,repeat_type : "daily"
 		       ,repeat_end_date : new Date(tEnd)
 		    });
    	    */
    	}
    	
    	break;
    case "monthly":
    	var monthDiff = parseInt(diff/currMonth);
    	for(var i=0;i<monthDiff;i++){
    	    tStart.setMonth(tStart.getMonth()+1);
//     		console.log(i+"번째 : "+tStart);
    	}
    	break;
    case "yearly":
    	var yearlyDiff = parseInt(diff/currYear);
    	for(var i=0;i<yearlyDiff;i++){
    	    tStart.setFullYear(tStart.getFullYear()+1);
//     		console.log(i+"번째 : "+tStart);
    	}
    	break;

    default:
    	break;
    }

//     console.log("end");
}

var html = function(id) { return document.getElementById(id); }; //just a helper

scheduler.showLightbox = function(id) {
	e_dateInit();
	var ev = scheduler.getEvent(id);
	scheduler.startLightbox(id, html("my_form"));
	
	console.log("showLightBox");
	console.log(ev);

	html("description").focus();
	html("description").value = ev.text;
	html("custom1").value = ev.custom1 || "";
	html("content").value = ev.content || "";
	html("category").value = ev.category || "";
// 	html("alarm").value = ev.alarm_val  || "none";
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
	
	$("#alarm").val(ev.alarm_val != "" ? ev.alarm_val : "none");
	
	
	/* //날짜입력창============================= */
	var sDate=ev.start_date;
	var eDate=ev.end_date;
	
	var sH=sDate.getHours();
	var sM=sDate.getMinutes();
	var eH=eDate.getHours();
	var eM=eDate.getMinutes();
	
	//db에서 가져 올때
	if(ev.is_dbdata == "T"){
		selectTimeFromDB(sH, sM, eH, eM);
	}
	//이벤트창에 날짜설정
	else{
	if(sDate.getDate() != eDate.getDate()){
	//alert("날짜 다름");
	eDate=ev.end_date.setHours(ev.end_date.getHours()-1);
	eDate=new Date(eDate);
	}		
	}
    var SYear = sDate.getFullYear();
    var SMonth = sDate.getMonth()+1;
    if(SMonth < 10) SMonth = "0" + SMonth;
    var SDay = sDate.getDate();
    if(SDay < 10) SDay = "0" + SDay;
    $("#timeSetStart").val(SYear+"-"+SMonth+"-"+SDay);
    var EYear = eDate.getFullYear();
    var EMonth = eDate.getMonth()+1;
    if(EMonth < 10) EMonth = "0" + EMonth;
    var EDay = eDate.getDate();
    if(EDay < 10) EDay = "0" + EDay;
    $("#timeSetEnd").val(EYear+"-"+EMonth+"-"+EDay);
    //새로 이벤트 입력할때 
	if(ev.is_dbdata == null)selectTime();
	
	/* //날짜입력창============================= */
};

// 저장
function save_form() {
	var ev = scheduler.getEvent(scheduler.getState().lightbox_id);
	ev.text = html("description").value;
	ev.custom1 = html("custom1").value;
	ev.content = $("#content")[0].value;
	ev.alarm_val = $("#alarm").val();
	ev.check_end_date = $("#check_end_date")[0].checked;
	ev.repeat_type = $("#repeat").val()
	ev.repeat_end_date = $("#end_date").val();
	/*
	ev.start_date = $("#timeSetStart").val() 
	+ " " + $("#Sampm").val() + " " 
	+ $("#SHour").val() + ":" + $("#SMin").val();
	ev.end_date = $("#timeSetEnd").val()
	+ " " + $("#Eampm").val() + " " 
	+ $("#EHour").val() + ":" + $("#EMin").val();
	*/
	//
	
	switch ($("#Sampm").val()) {
	case "AM":
		ev.start_date = new Date($("#timeSetStart").val() 
		+ " " + $("#SHour").val() 
		+ ":" + $("#SMin").val());
		break;
		
	case "PM":
		ev.start_date = new Date($("#timeSetStart").val() 
		+ " " + (parseInt($("#SHour").val())+12) 
		+ ":" + $("#SMin").val());
		break;
	}
	
	switch ($("#Eampm").val()) {
	case "AM":
		ev.end_date = new Date($("#timeSetEnd").val() 
		+ " " + $("#EHour").val() 
		+ ":" + $("#EMin").val());
		break;
		
	case "PM":
		ev.end_date = new Date($("#timeSetEnd").val() 
		+ " " + (parseInt($("#EHour").val())+12) 
		+ ":" + $("#EMin").val());
		break;
	}
	
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
			console.log("success");
			getCalData(todayDate.getFullYear(), todayDate.getMonth() + 1);
		}
		, error:function() {
			alert("등록실패");
			getCalData(todayDate.getFullYear(), todayDate.getMonth() + 1);
		}
	});

	scheduler.endLightbox(true, html("my_form"));
	
	if(ev.is_dbdata == null){
		scheduler.deleteEvent(ev.id);
	}
}

// 창닫기
function close_form() {
	scheduler.endLightbox(false, html("my_form"));
}

// 삭제
function delete_event() {
	var event_id = scheduler.getState().lightbox_id;
	
	scheduler.endLightbox(false, html("my_form"));
	
	$.ajax({
		url : "del"
		, method : "post"
		, data : {"id" : event_id}
		, success : function(){
			alert("deleted!!!");
			getCalData(todayDate.getFullYear(), todayDate.getMonth() + 1);
		}
		,error : function(){
			alert("Not deleted!!!")
		}
	});
	
	scheduler.deleteEvent(event_id);
}

// 반복 일정 셀렉트박스
function repeatChanged() {
	e_dateInit();
	switch ($("#repeat").val()) {
		case "daily":
			$("#timeSetEnd")[0].disabled = true;
			$("#Eampm")[0].disabled = true;
			$("#EHour")[0].disabled = true;
			$("#EMin")[0].disabled = true;
			break;
	
	}
}

// 시간설정 종료일자 초기화
function e_dateInit() {
	$("#timeSetEnd")[0].disabled = false;
	$("#Eampm")[0].disabled = false;
	$("#EHour")[0].disabled = false;
	$("#EMin")[0].disabled = false;
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

// 미니캘린더 보이기
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
                getCalData(todayDate.getFullYear(), todayDate.getMonth() + 1);
            }
        });
    }
}

// 종료일자 textbox클릭시 미니캘린더 보이기
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
                var tMonth = originDate.getMonth()+1;
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
				, is_dbdata:event.is_dbdata
				, alarm_yn:event.alarm_yn
				, alram_val:event.alarm_val
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

	.detail_sel {
		width: 65px;
		height: 20px;
		display: inline-block;
	}
	
	.sel {
		width: 80px;
		height: 20px;
	}
	
	.time_section {
		width: 100px;
		height: 15px;
	}
	
	p {
		color: red;
	}
</style>
</head>
<body onload="init();">

<div id="my_form">
	<table>
		<tr>
			<th>카테고리</th>
			<td><input type="text" id="category"></td>
		</tr>
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
			<th>시간설정</th>
			<td> 
			<!-- 시간설정================================== -->
			<input class="time_section" type="text" id="timeSetStart" onclick="input_minical('timeSetStart')" readonly="readonly">
			<select id="Sampm">
				<option id="Sam">AM</option>
				<option id="Spm">PM</option>
			</select>
			<select id="SHour">
				<c:forEach var="i" begin="1" end="12" >
				<option id="SHour_${i }">
				<c:if test="${i<10 }">
				0${i }
				</c:if>
				<c:if test="${i>=10 }">
				${i }
				</c:if>
				</option>
				</c:forEach>
			</select> :
			<select id="SMin">
				<c:forEach var="i" begin="0" end="59">
				<option id="SMin_${i }">
				<c:if test="${i<10 }">
				0${i }
				</c:if>
				<c:if test="${i>=10 }">
				${i }
				</c:if>
				</option>
				</c:forEach>
			</select>
			~
			<input class="time_section" type="text" id="timeSetEnd" onclick="input_minical('timeSetEnd')" readonly="readonly">
			<select id="Eampm">
				<option id="Eam">AM</option>
				<option id="Epm">PM</option>
			</select>
			<select id="EHour">
				<c:forEach var="i" begin="1" end="12" >
				<option id="EHour_${i }">
				<c:if test="${i<10 }">
				0${i }
				</c:if>
				<c:if test="${i>=10 }">
				${i }
				</c:if>
				</option>
				</c:forEach>
			</select> :
			<select id="EMin">
				<c:forEach var="i" begin="0" end="59">
				<option id="EMin_${i }">
				<c:if test="${i<10 }">
				0${i }
				</c:if>
				<c:if test="${i>=10 }">
				${i }
				</c:if>
				</option>
				</c:forEach>
			</select>
			<br>
			<select class="sel" id="repeat" style="margin-top: 3px;" onchange="repeatChanged();">
				<option value="none">반복안함</option>
				<option value="daily">매일</option>
				<option value="monthly">매월</option>
				<option value="yearly">매년</option>
			</select>
		    <input type="checkbox" id="check_end_date" value="date_of_end" onclick="fnc_end_date();" />
		    <input class="time_section" type="text" id="end_date" disabled="disabled" readonly="readonly" onclick="input_minical('end_date')" />까지
		    <br>
			<!-- 시간설정================================== -->
			</td>
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
	</table>
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
		<!-- 미니캘린더 -->
		<div class="dhx_minical_icon" id="dhx_minical_icon" onclick="show_minical()">&nbsp;</div> 	
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