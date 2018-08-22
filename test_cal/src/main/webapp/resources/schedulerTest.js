/**
 * 
 */
function init() {
	scheduler.config.multi_day = true;
	
	scheduler.config.xml_date="%Y-%m-%d %H:%i";
	scheduler.init('scheduler_here',new Date(2018,2,18),"month");
// 		scheduler.load("./resources/scheduler-5.0/events.json", "json");
	scheduler.locale.labels.section_type = "Type";
	scheduler.config.lightbox.sections = [	
		{name:"description", height:50, map_to:"text", type:"textarea" , focus:true},
		{name:"type", height:30, map_to:"type", type:"select", options:[
			{key:1, label:"Simple"},
			{key:2, label:"Complex"},
			{key:3, label:"Unknown"}
		]},
		{name:"time", height:72, type:"time", map_to:"auto"}	
	];
	scheduler.load("./resources/scheduler-5.0/types.json", "json", function(){
//		scheduler.showLightbox(2);
	});
}