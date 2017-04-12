package global.sesoc.calendar.vo;

public class Calendar {
	
	private String id;
	private String start_date;
	private String end_date;
	private String text;
	private String content;
	private String repeat_type;
	private String repeat_end_date;
	
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
	public String getRepeat_type() {
		return repeat_type;
	}
	public void setRepeat_type(String repeat_type) {
		this.repeat_type = repeat_type;
	}
	public String getRepeat_end_date() {
		return repeat_end_date;
	}
	public void setRepeat_end_date(String repeat_end_date) {
		this.repeat_end_date = repeat_end_date;
	}
	
	@Override
	public String toString() {
		return "Calendar [id=" + id + ", start_date=" + start_date + ", end_date=" + end_date + ", text=" + text
				+ ", content=" + content + ", repeat_type=" + repeat_type
				+ ", repeat_end_date=" + repeat_end_date + "]";
	}
	
}
