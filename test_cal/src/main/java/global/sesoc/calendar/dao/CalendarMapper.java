package global.sesoc.calendar.dao;

import java.util.List;

import global.sesoc.calendar.vo.Calendar;

public interface CalendarMapper {

	//1)일정 읽어오기(월별) 
	public List<Calendar> listCal(int month) throws Exception;
	//2)일정 저장하기 
	public int saveCal(Calendar calendar) throws Exception;
	//3)일정 삭제하기 
	public int delCal(int calId) throws Exception;
}
