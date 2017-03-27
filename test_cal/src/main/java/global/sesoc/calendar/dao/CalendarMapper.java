package global.sesoc.calendar.dao;

import java.util.ArrayList;
import java.util.List;

import global.sesoc.calendar.vo.Calendar;

public interface CalendarMapper {

	//1)일정조회(월별)
	public ArrayList<Calendar> listCal(String date) throws Exception;
	//1-2)일정조회(년)
	public ArrayList<Calendar> listCalYr(String date) throws Exception;
	//2)일정 저장 
	public int saveCal(Calendar calendar) throws Exception;
	//3)일정 삭제 
	public int delCal(int calId) throws Exception;
}
