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
		logger.debug("Welcome gridHome! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home2";
	}
	
	@RequestMapping(value="/testPage")
	public String testPage() {
		logger.debug("testPage called!");
		return "test/test";
	}
	
	@ResponseBody
	@RequestMapping(value="/ajaxTest")
	public String ajaxTest(@RequestParam(value="intVal") int val) {
		logger.debug("ajaxTest in {}", val);
		int result = 4 + val;
		
		return result+"";
	}
	
	@RequestMapping(value="/getInfo")
	public void getDetail(String id) {
		logger.debug("getDetail : {}", id);
	}
	
	@RequestMapping(value="/fileTest", method=RequestMethod.POST)
	public String fileTest(String testValue) {
		logger.debug("fileTest :: {}", testValue);
		return "redirect:testPage";
	}
	
	@ResponseBody
	@RequestMapping(value="/update")
	public ArrayList<Car> updateGridTest(@RequestBody ArrayList<Car> text) {
		logger.debug("updateTest :: {}", text);
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
		logger.debug("deleteGridTest :: {}", del_seq_id);
		
		ArrayList<Car> list = new ArrayList<Car>();
		list.add(new Car("111", "maker", "model name", "how much", "2018/08/11", "2018/08/13"));
		list.add(new Car("222", "maker2", "model name2", "how much2", "2018/08/14", "2018/08/14"));
		list.add(new Car("333", "maker3", "model name3", "how much3", "2018/08/14", ""));
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="/returnArrayTest", method=RequestMethod.POST)
	public ArrayList<String> returnArrayTest(@RequestBody ArrayList<Car> text) {
		logger.debug("returnArrayTest :: {}", text);
		
		/**
		 * [치환완료 화면전환시 seq_id리스트 처리하기]
		 * 1. 치환이 끝나고 새롭게 발급된 seq_id를 리스트형태로 ajax반환한다
		 * 2. 반환된 리스트는 hidden 객체에 담아 해당시점에 화면이동을 위해 submit한다
		 * 3. submit된 리스트는 model객체에 담아 해당 화면에서 사용 할 수 있게 처리한다.
		 * 4. ajax로 grid rowData를 요청하는 시점에 model로 넘겨준 seq_id리스트를 함께 data로 넘겨 쿼리를 진행한다.
		 * */
		ArrayList<String> ret = new ArrayList<>();
		for (Car car : text) {
			ret.add(car.getModel());
		}
		return ret;
	}
	
	@RequestMapping(value="/showResultPage", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public String goResultPageWithJSON(String[] text, Model model) {
		logger.debug("goResultPageWithJSON");
		ArrayList<String> list = new ArrayList<>();
		for (String str : text) {
			logger.debug("str : {}", str);
			list.add(str);
		}
		
		model.addAttribute("idList", list);
		return "test/result";
	}
	
	@ResponseBody
	@RequestMapping(value="/transResult")
	public ArrayList<Car> transResult3(@RequestParam(value="id_lst") String val) {
		logger.debug("transResult3");
		val = val.replace("[", "");
		val = val.replace("]", "");
		String[] strArr = val.split(",");
		
		ArrayList<Car> list = new ArrayList<Car>();
		for (int i=0; i<strArr.length; i++) {
			logger.debug("str : {}", strArr[i]);
			list.add(new Car(i+""+i, strArr[i], "model name", "how much", "2018/08/16", ""));
		}
		
		return list;
	}
	
}
