package global.sesoc.calendar.vo;

import java.util.Date;

public class Calendar {
	
	private int number;
	private String start_date;
	private String end_date;
	private String text;
	
	public Calendar() {
		// TODO Auto-generated constructor stub
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
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
	@Override
	public String toString() {
		return "Calendar [number=" + number + ", start_date=" + start_date + ", end_date=" + end_date + ", text=" + text
				+ "]";
	}
	
	
}
