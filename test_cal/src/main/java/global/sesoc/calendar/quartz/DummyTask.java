/*
 *  
 *  * Revision History
 *  * Author              Date                  Description
 *  * ------------------   --------------       ------------------
 *  *  beyondj2ee          2014.01.02              
 *  
 */

package global.sesoc.calendar.quartz;

import org.apache.log4j.Logger;

public class DummyTask {
	
	public static final Logger log = Logger.getLogger("global.sesoc.test");
	private int i = 0;
	
    public void print() {
    	log.debug(i++);
    	log.debug("Spring 4.0 + Quartz 2.2 ");        
    }

}
