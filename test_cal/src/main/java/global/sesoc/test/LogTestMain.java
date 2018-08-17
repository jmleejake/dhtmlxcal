package global.sesoc.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;

public class LogTestMain {
	/**
	 * 1. DailyRollingFileAppender를 사용한 appender정의
	 * 2. 해당 appender를 사용할 category정의
	 *   (*additivity false지정할 경우 중복되서 출력되지 않는다고 하는데 아마 콘솔출력을 얘기하는것 같다.
	 *   priority를 지정하여 파일에만 debug모드로 출력하게 할수도 있다.
	 *   console에 대한 apperder-ref를 지정하지 않으면 콘솔출력하지 않는다.)
	 * 3. 클래스내에서 지정해둔 category name으로 log4j Logger객체를 선언해 로그를 출력한다.
	 * */
	public static final Logger log = Logger.getLogger("global.sesoc.test");
	
	@SuppressWarnings({ "unchecked", "null" })
	public static void main(String[] args) {
		log.info("main");
		FileAppender appender = (FileAppender) log.getAppender("file_test");
		log.debug(appender.getFile());
		Enumeration<String> strEnum = log.getAllAppenders();
		while (strEnum.hasMoreElements()) {
			log.debug(strEnum.nextElement());
		}
		String str = null;
		try {
			// nullpointer exception이 당연하다만
			// exception발생시 어떻게 로그가 찍히는가 확인하니라고 설정!
			log.debug(str.split(","));
		} catch (Exception e) {
			log.error(e);
		}
		
		log.debug(getDate("YYYY-MM-dd HH:mm:ss"));

	}
	
	public static String getDate(String format) { 
		Calendar cal = Calendar.getInstance( ); 
		Date today = cal.getTime(); 
		SimpleDateFormat sdf = new SimpleDateFormat(format); 
		return sdf.format(today); 
	} 

}
