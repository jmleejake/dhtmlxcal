package global.sesoc.calendar.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class ShowCountJob extends QuartzJobBean {
	
	private ShowCountTask showCountTask;
	
	@Override
	protected void executeInternal(JobExecutionContext context) 
			throws JobExecutionException {
		showCountTask.showCount();
	}

	/**
	 * @param showCountTask the showCountTask to set
	 */
	public void setShowCountTask(ShowCountTask showCountTask) {
		this.showCountTask = showCountTask;
	}
	
}
