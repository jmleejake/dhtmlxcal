<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
var todayDate = new Date();
var todayDate2 = new Date();
var nowHr = todayDate2.getHours();
var nowMin = todayDate2.getMinutes();
console.log(nowHr+":"+nowMin);

function selectTime(){
	if(nowHr<12){
	$("#Sam")[0].selected=true;		
	}else{
	$("#Spm")[0].selected=true;		
	}
	
	$("#SHour_"+nowHr)[0].selected=true;
	$("#EHour_"+nowHr)[0].selected=true;
	$("#SMin_"+nowMin)[0].selected=true;
	$("#EMin_"+nowMin)[0].selected=true;
	
	
}


function init() {
	getCalData(todayDate.getFullYear(), todayDate.getMonth() + 1);
	scheduler.config.xml_date = "%Y-%m-%d %H:%i";
	scheduler.config.details_on_dblclick = true;
	scheduler.config.details_on_create = true;

	scheduler.init('scheduler_here', new Date(), "month");
	
	

	// 데이터 추가
    scheduler.addEvent({
       id:1234
       , start_date: new Date(2017,3,12,14)
       , end_date: new Date(2017,3,12,18)
       , text: "니홍고 3차 역량 -0- -0- -0- -0- -0- -0- -0-"
       ,repeat_type : "daily"
       ,repeat_end_date : new Date(2017,3,15,18)
    });
	
    
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

	
	
	
}

var html = function(id) { return document.getElementById(id); }; //just a helper

scheduler.showLightbox = function(id) {
	var ev = scheduler.getEvent(id);
	scheduler.startLightbox(id, html("my_form"));

	html("description").focus();
	html("description").value = ev.text;
	html("custom1").value = ev.custom1 || "데이터가져옴";
	html("custom2").value = ev.custom2 || "";
	html("category").value = ev.category || "";
	html("alarm").value = ev.alarm || "";
	html("repeat").value = ev.repeat || "";
	//html("timeSetting").value = ev.timeSetting || "";
	
	//console.log(ev.start_date);
	//console.log(ev.end_date);
	/* //날짜입력창============================= */
	var sDate=ev.start_date;
	var eDate=ev.end_date;
	console.log(new Date(eDate));
	
	if(sDate.getDate() != eDate.getDate()){
	//alert("날짜 다름");
	eDate=ev.end_date.setHours(ev.end_date.getHours()-1);
	eDate=new Date(eDate);
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
	selectTime();
	/* //날짜입력창============================= */
};

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
//날짜 미니캘린더
function input_minical(id){
    if (scheduler.isCalendarVisible()){
        scheduler.destroyCalendar();
    } else {
        scheduler.renderCalendar({
            position: id,
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
</style>
</head>
<body onload="init();">

<div id="my_form">
	<label for="description">제목</label><input type="text" name="description" value="" id="description"> 
	<label for="custom1">작성자</label><input type="text" name="custom1" value="" id="custom1"><br>
	<label for="custom2">내용</label><input type="text" name="custom2" value="" id="custom2"><br>
	<label for="category">카테고리</label><input type="text" name="category" value="" id="category"><br>
	<label for="alarm">알람</label><input type="text" name="alarm" value="" id="alarm"><br>
	<label for="repeat">일정 반복</label><input type="text" name="repeat" value="" id="repeat"><br>
	<!-- 시간설정================================== -->
	<label for="timeSetting">시간설정</label><br>
	<input type="text" name="timeSetStart" value="" id="timeSetStart" onclick="input_minical('timeSetStart')" readonly="readonly">
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
	</select>:
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
	<input type="text" name="timeSetEnd" value="" id="timeSetEnd" onclick="input_minical('timeSetEnd')" readonly="readonly">
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
	</select>:
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
	<!-- 시간설정================================== -->
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