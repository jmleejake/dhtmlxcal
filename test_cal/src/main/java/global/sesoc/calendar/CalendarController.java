package global.sesoc.calendar;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import global.sesoc.calendar.dao.CalendarDAO;
import global.sesoc.calendar.vo.Calendar;

@Controller
public class CalendarController {
	@Autowired
	CalendarDAO dao;

	private static final Logger logger = LoggerFactory.getLogger(CalendarController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		logger.info(date.toString());
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "calendar";
	}
	@RequestMapping(value = "custom", method = RequestMethod.GET)
	public String custome() {
		return "custom_cal";
	}

	@ResponseBody
	@RequestMapping(value="showYr", method=RequestMethod.POST)
	public ArrayList<Calendar> showYr(int thisYear) {
		String date = "";
		date +=thisYear;		
		System.out.println(date+"년도");
		logger.debug("showSchedule!");
		return dao.listCalYr(date);
	}
	
	@ResponseBody
	@RequestMapping(value="show", method=RequestMethod.POST)
	public ArrayList<Calendar> showSchedule(int thisYear, int thisMonth) {
		String date = "";
		date +=thisYear+"-"+String.format("%02d", thisMonth)+"-01";
		System.out.println(date);
		logger.debug("showSchedule!");
		return dao.listCal(date);
	}
	
	@ResponseBody
	@RequestMapping(value="save", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public String saveSchedule(Calendar vo, String _end_date) {
		logger.debug("-------------------- event save process start");
		
		logger.debug("cal :: \n{}", vo);
		logger.debug("{}", _end_date);
		
		// 시작일자 종료일자의 월에 대한 세팅
		HashMap<String, Object> month_map = new HashMap<String, Object>();
		//month_short:["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"]
		month_map.put("Jan", "01");
		month_map.put("Feb", "02");
		month_map.put("Mar", "03");
		month_map.put("Apr", "04");
		month_map.put("May", "05");
		month_map.put("Jun", "06");
		month_map.put("Jul", "07");
		month_map.put("Aug", "08");
		month_map.put("Sep", "09");
		month_map.put("Oct", "10");
		month_map.put("Nov", "11");
		month_map.put("Dec", "12");
		
		StringTokenizer st_start_date = new StringTokenizer(vo.getStart_date(), " ");
		StringTokenizer st_end_date = new StringTokenizer(vo.getEnd_date(), " ");
		
		StringTokenizer st_recurring_end_date = null;
		StringTokenizer st_recurring_start_date = null;
		
		int i=0;
		logger.debug("+++++++++++++");
		// 시작일자 세팅
		String syear = "";
		String smonth = "";
		String sday = "";
		String stime = "";
		while (st_start_date.hasMoreElements()) {
			// month-short
			if(i==1) smonth = month_map.get(st_start_date.nextElement().toString()).toString();
			// day
			else if(i==2) sday = st_start_date.nextElement().toString();
			// year
			else if(i==3) syear = st_start_date.nextElement().toString();
			// time
			else if(i==4) stime = st_start_date.nextElement().toString();
			// others
			else st_start_date.nextElement();
			
			i++;
		}
		
		logger.debug("start_time: {}-{}-{} {}", syear, smonth, sday, stime);
		
		logger.debug("+++++++++++++");
		
		// 종료일자 세팅
		String eyear = "";
		String emonth = "";
		String eday = "";
		String etime = "";
		i=0;
		
		while (st_end_date.hasMoreElements()) {
			// month-short
			if(i==1) emonth = month_map.get(st_end_date.nextElement().toString()).toString();
			// day
			else if(i==2) eday = st_end_date.nextElement().toString();
			// year
			else if(i==3) eyear = st_end_date.nextElement().toString();
			// time
			else if(i==4) etime = st_end_date.nextElement().toString();
			// others
			else st_end_date.nextElement();
			
			i++;
		}
		
		logger.debug("end_time: {}-{}-{} {}", eyear, emonth, eday, etime);
		
		vo.setStart_date(syear+ "-" + smonth + "-" + sday + " " + stime);
		vo.setEnd_date(eyear+ "-" + emonth + "-" + eday + " " + etime);
		
		
		// 매월 반복 설정시 시작일자 세팅
		i=0;
		if(vo.get_start_date() != null) {
			if(!vo.get_start_date().equals("")) {
				st_recurring_start_date = new StringTokenizer(vo.get_start_date(), " ");
				
				while (st_recurring_start_date.hasMoreElements()) {
					// month-short
					if(i==1) smonth = month_map.get(st_recurring_start_date.nextElement().toString()).toString();
					// day
					else if(i==2) sday = st_recurring_start_date.nextElement().toString();
					// year
					else if(i==3) syear = st_recurring_start_date.nextElement().toString();
					// time
					else if(i==4) stime = st_recurring_start_date.nextElement().toString();
					// others
					else st_recurring_start_date.nextElement();
					
					i++;
				}
				
				logger.debug("start_time: {}-{}-{} {}", syear, smonth, sday, stime);
				vo.set_start_date(syear+ "-" + smonth + "-" + sday + " " + stime);
			}
		}
		
		// 반복설정시 종료일자 세팅
		i=0;
		if(vo.get_end_date() != null) {
			if(!vo.get_end_date().equals("")) {
				st_recurring_end_date = new StringTokenizer(vo.get_end_date(), " ");
				
				while (st_recurring_end_date.hasMoreElements()) {
					// month-short
					if(i==1) emonth = month_map.get(st_recurring_end_date.nextElement().toString()).toString();
					// day
					else if(i==2) eday = st_recurring_end_date.nextElement().toString();
					// year
					else if(i==3) eyear = st_recurring_end_date.nextElement().toString();
					// time
					else if(i==4) etime = st_recurring_end_date.nextElement().toString();
					// others
					else st_recurring_end_date.nextElement();
					
					i++;
				}
				
				if(vo.getRec_type() != null) {
					String[] arr_rec = vo.getRec_type().split("#");
					for (int j = 0; j < arr_rec.length; j++) {
						logger.debug("{} : {}", j, arr_rec[j]);
					}
					logger.debug("check rec end_date :: length={}", arr_rec.length);
					/*
					 * 반복이 no end date로 설정 되었을때는 DB insert를 고려하여
					 * 5년치에 대해서만 insert한다.
					 * */
					if(arr_rec.length > 1) {
						if("no".equals(arr_rec[1])) { 
							logger.debug("no end date!!!");
							eyear = (Integer.parseInt(syear) + 5) + "";
							emonth = smonth;
							logger.debug("{}-{}-{}", eyear, emonth, eday);
						}
					}
				}
				
				logger.debug("_end_date: {}-{}-{} {}", eyear, emonth, eday, etime);
				vo.set_end_date(eyear+ "-" + emonth + "-" + eday + " " + etime);
			}
		}
		
		Calendar exist = dao.getEvent(vo.getId());
		logger.debug("exist: {}", exist);
		
		if(exist != null) {
			logger.debug("-------------------- event update process start");
			dao.modifyEvent(vo);
			logger.debug("-------------------- event update process end");
		} else {
			logger.debug("-------------------- event create process start");
			dao.saveCal(vo);
			logger.debug("-------------------- event create process end");
		}
		
		logger.debug("-------------------- event save process end");
		return "";
	}
	
	@ResponseBody
	@RequestMapping(value="del", method=RequestMethod.POST)
	public String delSchedule(int id) {
		System.out.println("삭제할 게시물 :"+ id);
		dao.delCal(id);
		return "";
	}
	
	
}
