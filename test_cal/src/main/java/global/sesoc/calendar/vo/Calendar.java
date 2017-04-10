package global.sesoc.calendar.vo;

public class Calendar {
	
	private String id;
	private String start_date;
	private String end_date;
	private String text;
	private String content;
	private String rec_type;
	private String event_pid;
	private long event_length;
	private String _end_date; // 반복설정시 종료일자
	private String _start_date; // 매월반복 설정시 시작일자
	
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
	public String get_end_date() {
		return _end_date;
	}
	public void set_end_date(String _end_date) {
		this._end_date = _end_date;
	}
	public String get_start_date() {
		return _start_date;
	}
	public void set_start_date(String _start_date) {
		this._start_date = _start_date;
	}
	
	@Override
	public String toString() {
		return "Calendar [id=" + id + ", start_date=" + start_date + ", end_date=" + end_date + ", text=" + text
				+ ", content=" + content + ", rec_type=" + rec_type + ", event_pid=" + event_pid + ", event_length="
				+ event_length + ", _end_date=" + _end_date + ", _start_date=" + _start_date + "]";
	}
	
}
