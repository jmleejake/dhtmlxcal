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
		
		return "cal_test";
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
	public Calendar saveSchedule(Calendar vo) {
		Calendar ret = new Calendar();
		logger.debug("-------------------- event save process start");
		
		logger.debug("cal :: \n{}", vo);
		
		Calendar exist = dao.getEvent(vo.getId());
		logger.debug("exist: {}", exist);
		
		if(exist != null) {
			logger.debug("-------------------- event update process start1");
//			ret = dao.modifyEvent(vo);
			logger.debug("-------------------- event update process end");
		} else {
			logger.debug("-------------------- event create process start");
			ret = dao.saveCal(vo);
			logger.debug("-------------------- event create process end");
		}
		
		logger.debug("-------------------- event save process end");
		return ret;
	}
	
	@ResponseBody
	@RequestMapping(value="del", method=RequestMethod.POST)
	public String delSchedule(int id) {
		System.out.println("삭제할 게시물 :"+ id);
		dao.delCal(id);
		return "";
	}
	
	
}
