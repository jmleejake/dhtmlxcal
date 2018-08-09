package global.sesoc.calendar;

import java.text.DateFormat;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import global.sesoc.calendar.dao.CalendarDAO;
import global.sesoc.calendar.vo.Calendar;

@Controller
public class CalendarController {
	@Autowired
	CalendarDAO dao;

	private static final Logger logger = LoggerFactory.getLogger(CalendarController.class);
	
	@RequestMapping(value = "/calHome", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		logger.info(date.toString());
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "typeTest";
	}
	@RequestMapping(value = "custom", method = RequestMethod.GET)
	public String custome() {
		return "custom_cal";
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
	public int saveSchedule(Calendar vo) {
		int ret = 0;
		logger.debug("-------------------- event save process start");
		
		logger.debug("cal :: \n{}", vo);
		
		String email = "kdcsilk@naver.com";
		
		dao.saveScheduler(vo, email);
		
		logger.debug("-------------------- event save process end");
		return ret;
	}
	
	@ResponseBody
	@RequestMapping(value="del", method=RequestMethod.POST)
	public String delSchedule(String id) {
		System.out.println("�く��懦腹 �ｲ護亨�ｬｼ :"+ id);
		dao.delCal(id);
		return "";
	}
	
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home2(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home2";
	}
	
	@RequestMapping(value="/testPage")
	public String testPage() {
		logger.info("testPage called!");
		return "test/test";
	}
	
	@ResponseBody
	@RequestMapping(value="/ajaxTest")
	public String ajaxTest(@RequestParam(value="intVal") int val) {
		logger.info("ajaxTest in {}", val);
		int result = 4 + val;
		
		return result+"";
	}
	
}
