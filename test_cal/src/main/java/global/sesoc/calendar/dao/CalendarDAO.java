package global.sesoc.calendar.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.calendar.vo.Calendar;

@Repository
public class CalendarDAO {
	@Autowired
	SqlSession sqlSession;
	
	private final String NONE = "none";
	private final String DAILY = "daily";
	private final String MONTHLY = "monthly";
	private final String YEARLY = "yearly";
	
	private static final Logger logger = LoggerFactory.getLogger(CalendarDAO.class); 
	//1)일정 조회하기(월별)
		public ArrayList<Calendar> listCal(String date){
			CalendarMapper mapper = sqlSession.getMapper(CalendarMapper.class);
			ArrayList<Calendar> result=null;
			try {
				result=mapper.listCal(date);
				System.out.println(result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
		//2)일정 저장
		public Calendar saveCal(Calendar calendar){
			/*
			 * 무제한 반복이라고 했을때 5년을 치고 컨트롤러로 넘겼을때...
			 * 
			 * .CalendarController - 0 : day
				DEBUG: global.sesoc.calendar.CalendarController - 1 : 1
				DEBUG: global.sesoc.calendar.CalendarController - 2 : 
				DEBUG: global.sesoc.calendar.CalendarController - 3 : 
				DEBUG: global.sesoc.calendar.CalendarController - 4 : #no
				
				매월 15일로 설정할 경우
				CalendarController - start_time: 2017-04-15 00:00:00
				DEBUG: global.sesoc.calendar.CalendarController - +++++++++++++
				DEBUG: global.sesoc.calendar.CalendarController - end_time: 2022-04-05 00:05:00
				DEBUG: global.sesoc.calendar.CalendarController - 0 : month
				DEBUG: global.sesoc.calendar.CalendarController - 1 : 1
				DEBUG: global.sesoc.calendar.CalendarController - 2 : 
				DEBUG: global.sesoc.calendar.CalendarController - 3 : 
				DEBUG: global.sesoc.calendar.CalendarController - 4 : #no
			 * */
			logger.debug("vo : {}", calendar);
			
			int result = -1;
			CalendarMapper mapper = sqlSession.getMapper(CalendarMapper.class);
			
			switch (calendar.getRepeat_type()) {
				case DAILY: // 매일 반복
					calendar.setRepeat_type(DAILY);
					break;
					
				case MONTHLY: // 매월 반복
					calendar.setRepeat_type(MONTHLY);
					break;
					
				case YEARLY: // 매년 반복
					calendar.setRepeat_type(YEARLY);
					break;
					
				default:
					calendar.setRepeat_type(NONE);
					break;
			}
			
			try {
				result = mapper.saveCal(calendar);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(result > 0) {
				return calendar;
			} else {
				return null;
			}
		}
		//3)일정 삭제
		public int delCal(int calId){
			int result = -1;
			CalendarMapper mapper = sqlSession.getMapper(CalendarMapper.class);
			try {
				mapper.delCal(calId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
		public ArrayList<Calendar> listCalYr(String date) {
			// TODO Auto-generated method stub
			return null;
		}
		
		public Calendar getEvent(String id) {
			Calendar ret = null;
			CalendarMapper mapper = sqlSession.getMapper(CalendarMapper.class);
			try {
				ret = mapper.selectEvent(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ret;
		}
		
		public int modifyEvent(Calendar vo) {
			int ret = 0;
			CalendarMapper mapper = sqlSession.getMapper(CalendarMapper.class);
			try {
				ret = mapper.updateEvent(vo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ret;
		}
		
		protected int dateCheck(Date a, Date b) {
			logger.debug("dateCheck :: {} - {}",a,b);
			
			int ret = 0;
			
			if(a.compareTo(b) > 0) {
				ret = -1; //a가 b보다 느린날짜일때
			} else if(a.compareTo(b) < 0) {
				ret = 1; // a가 b보다 빠른 날짜일때
			}
			
			logger.debug("dateCheck RET == {}", ret);
			
			return ret;
		}
}
