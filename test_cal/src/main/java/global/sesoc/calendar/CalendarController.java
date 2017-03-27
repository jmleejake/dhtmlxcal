package global.sesoc.calendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

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
	@RequestMapping(value="save", method=RequestMethod.POST)
	public String saveSchedule(Calendar cal) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		cal.setStart_date(sdf.format(new Date(cal.getStart_date())));
		cal.setEnd_date(sdf.format(new Date(cal.getEnd_date())));
		logger.debug("showSchedule : \n{}", cal);
		dao.saveCal(cal);
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
