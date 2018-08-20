package global.sesoc.calendar.quartz;

import org.apache.log4j.Logger;

public class ShowCountTask {
	public static final Logger log = Logger.getLogger("global.sesoc.test");
	private int j = 0;
	
	public void showCount() {
		log.debug(j++);
	}
}
