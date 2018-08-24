/**
 * 
 */
function init() {
	scheduler.config.multi_day = true;
	
	scheduler.config.xml_date="%Y-%m-%d %H:%i";
	scheduler.config.details_on_dblclick = true;
	scheduler.config.details_on_create = true;
	scheduler.init('scheduler_here',new Date(2018,2,18),"month");
//	scheduler.load("./resources/scheduler-5.0/events.json", "json");
//	scheduler.locale.labels.section_type = "Type";
	/*
	scheduler.config.lightbox.sections = [	
		{name:"description", height:50, map_to:"text", type:"textarea" , focus:true},
		{name:"location", height:70, map_to:"details", type:"textarea"},
		{name:"type", height:30, map_to:"type", type:"select", options:[
			{key:1, label:"Simple"},
			{key:2, label:"Complex"},
			{key:3, label:"Unknown"}
		]},
		{name:"test1", height:20, type:"text", map_to:"test"},
		{name:"time", height:72, type:"time", map_to:"auto"}
	];
	*/
	scheduler.load("./resources/scheduler-5.0/types.json", "json");
}

var html = function(id) { return document.getElementById(id); }; //just a helper

var s_date;

scheduler.showLightbox = function(id) {
	var ev = scheduler.getEvent(id);
	scheduler.startLightbox(id, html("my_form"));
	
	html("description").focus();
	html("description").value = ev.text;
	html("custom1").value = ev.details;
	html("custom2").value = ev.test;
	s_date = getFormatDate(ev.start_date);
	html("start_date").value = s_date;
	html("end_date").value = getFormatDate(ev.end_date);
};

function save_form() {
	var ev = scheduler.getEvent(scheduler.getState().lightbox_id);
	ev.text = html("description").value;
	ev.details = html("custom1").value;
	ev.test = html("custom2").value;

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
