package global.sesoc.calendar.vo;

import java.sql.Timestamp;

public class Calendar {
	
	private String id;
	private String start_date;
	private String end_date;
	private String text;
	private String content;
	private String rec_type;
	private String event_pid;
	private long event_length;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRec_type() {
		return rec_type;
	}
	public void setRec_type(String rec_type) {
		this.rec_type = rec_type;
	}
	public String getEvent_pid() {
		return event_pid;
	}
	public void setEvent_pid(String event_pid) {
		this.event_pid = event_pid;
	}
	public long getEvent_length() {
		return event_length;
	}
	public void setEvent_length(long event_length) {
		this.event_length = event_length;
	}
	
	@Override
	public String toString() {
		return "Calendar [id=" + id + ", start_date=" + start_date + ", end_date=" + end_date + ", text=" + text
				+ ", content=" + content + ", rec_type=" + rec_type + ", event_pid=" + event_pid 
				+ ", event_length " + event_length + "]";
	}
	
}
