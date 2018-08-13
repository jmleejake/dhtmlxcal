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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import global.sesoc.calendar.dao.CalendarDAO;
import global.sesoc.calendar.vo.Calendar;
import global.sesoc.calendar.vo.Car;

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
	
	
	
	
	// , produces="application/json;charset=UTF-8"
	@ResponseBody
	@RequestMapping(value="/update", method=RequestMethod.POST, consumes="application/json;charset=UTF-8")
	public ArrayList<Car> updateTest(@RequestBody ArrayList<Car> text) {
		logger.info("updateTest :: {}", text);
		ArrayList<Car> list = new ArrayList<Car>();
		list.add(new Car("111", "maker", "model name", "how much"));
		list.add(new Car("222", "maker2", "model name2", "how much2"));
		list.add(new Car("333", "maker3", "model name3", "how much3"));
		list.add(new Car("444", "maker4", "model name4", "how much4"));
		list.add(new Car("555", "maker5", "model name5", "how much5"));
		logger.debug(list.toString());
		return list;
	}
	
}
