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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;

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
		logger.info("Welcome calHome! The client locale is {}.", locale);
		
		Date date = new Date();
		logger.info(date.toString());
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "typeTest";
	}
	@RequestMapping(value = "/custom", method = RequestMethod.GET)
	public String custome() {
		return "custom_cal";
	}

	@ResponseBody
	@RequestMapping(value="/show", method=RequestMethod.POST)
	public ArrayList<Calendar> showSchedule(int thisYear, int thisMonth) {
		String date = "";
		date +=thisYear+"-"+String.format("%02d", thisMonth)+"-01";
		System.out.println(date);
		logger.debug("showSchedule!");
		return dao.listCal(date);
	}
	
	@ResponseBody
	@RequestMapping(value="/save", method=RequestMethod.POST, produces="application/json;charset=utf-8")
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
	@RequestMapping(value="/del", method=RequestMethod.POST)
	public String delSchedule(String id) {
		System.out.println("�く��懦腹 �ｲ護亨�ｬｼ :"+ id);
		dao.delCal(id);
		return "";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String gridHome(Locale locale, Model model) {
		logger.info("Welcome gridHome! The client locale is {}.", locale);
		
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
	
	@RequestMapping(value="/getInfo")
	public void getDetail(String id) {
		logger.info("getDetail : {}", id);
	}
	
	@RequestMapping(value="/fileTest", method=RequestMethod.POST)
	public String fileTest(String testValue) {
		logger.info("fileTest :: {}", testValue);
		return "redirect:testPage";
	}
	
	@ResponseBody
	@RequestMapping(value="/update")
	public ArrayList<Car> updateGridTest(@RequestBody ArrayList<Car> text) {
		logger.info("updateTest :: {}", text);
		ArrayList<Car> list = new ArrayList<Car>();
		list.add(new Car("111", "maker", "model name", "how much", "2018/08/04", "2018/08/13"));
		list.add(new Car("222", "maker2", "model name2", "how much2", "2018/08/11", "2018/08/14"));
		list.add(new Car("333", "maker3", "model name3", "how much3", "2018/08/13", "2018/08/13"));
		list.add(new Car("444", "maker4", "model name4", "how much4", "2018/08/14", "2018/08/14"));
		list.add(new Car("555", "maker5", "model name5", "how much5", "2018/08/12", "2018/08/13"));
		for (Car carObj : text) {
			list.add(carObj);
		}
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="/delete")
	public ArrayList<Car> deleteGridTest(@RequestBody ArrayList<String> del_seq_id) {
		logger.info("deleteGridTest :: {}", del_seq_id);
		
		ArrayList<Car> list = new ArrayList<Car>();
		list.add(new Car("111", "maker", "model name", "how much", "2018/08/11", "2018/08/13"));
		list.add(new Car("222", "maker2", "model name2", "how much2", "2018/08/14", "2018/08/14"));
		list.add(new Car("333", "maker3", "model name3", "how much3", "2018/08/14", ""));
		
		return list;
	}
	
	@RequestMapping(value="/goResult")
	public String goResultPage() {
		logger.info("goResultPage - get");
		return "test/result";
	}
	
	@ResponseBody
	@RequestMapping(value="/goResult", method=RequestMethod.POST)
	public String goResultPage(@RequestBody ArrayList<Car> text) {
		logger.info("goResultPage - post :: {}", text);
		JsonObject obj = new JsonObject();
		obj.addProperty("result", "FAIL");
		
		logger.info("logic execute...");
		obj.addProperty("result", "OK");
		
		return obj.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/transResult")
	public ArrayList<Car> showTransResult() {
		logger.info("showTransResult");
		ArrayList<Car> list = new ArrayList<Car>();
		list.add(new Car("111", "maker", "model name", "how much", "2018/08/04", "2018/08/13"));
		list.add(new Car("222", "maker2", "model name2", "how much2", "2018/08/11", "2018/08/14"));
		list.add(new Car("333", "maker3", "model name3", "how much3", "2018/08/13", "2018/08/13"));
		list.add(new Car("444", "maker4", "model name4", "how much4", "2018/08/14", "2018/08/14"));
		list.add(new Car("555", "maker5", "model name5", "how much5", "2018/08/12", "2018/08/13"));
		return list;
	}
	
}
