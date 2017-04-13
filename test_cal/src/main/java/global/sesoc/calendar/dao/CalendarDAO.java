package global.sesoc.calendar.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.calendar.util.AlarmCronTrigger;
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
		
		public int saveScheduler(Calendar vo, String email) {
			int ret = 0;
			CalendarMapper mapper = sqlSession.getMapper(CalendarMapper.class);
			
			Calendar exist = getEvent(vo.getId());
			logger.debug("exist: {}", exist);
			logger.debug("email : {}", email);
			
			if(exist != null) {
				logger.debug("-------------------- event update process start1");
				ret = modifyEvent(vo);
				logger.debug("-------------------- event update process end");
			} else {
				logger.debug("-------------------- event create process start");
				ret = saveCal(vo);
				logger.debug("-------------------- event create process end");
			}
			
			HashMap<String, Object> param = new HashMap<>();
			// 알림세팅 
			if(ret > 0) {
				if(exist != null) {
					if("T".equals(exist.getAlarm_yn())) {
						logger.debug("-------------------- UPDATE mail sending process start");
						String alarm_time = null;
						try {
							alarm_time = mapper.selectAlarmTime(param.get("id").toString());
						} catch (Exception e) {
							e.printStackTrace();
						}
						logger.debug("alarm at {}", alarm_time);
						AlarmCronTrigger cron = new AlarmCronTrigger(alarm_time, param.get("id").toString(), 
								email, exist.getText(), exist.getContent() + " 이벤트 시작시간: " + exist.getStart_date() + " 이벤트 종료시간: " + exist.getEnd_date());
						cron.deleteJob();
						cron.createJob();
						logger.debug("-------------------- UPDATE mail sending process end");
					}
				} else {
					String latest_id = null;
					try {
						latest_id = mapper.selectLatestEventNum();
					} catch (Exception e) {
						e.printStackTrace();
					}
					Calendar latest_vo = getEvent(latest_id);
					if("T".equals(latest_vo.getAlarm_yn())) {
						logger.debug("-------------------- CREATE mail sending process start");
						String alarm_time = null;
						try {
							alarm_time = mapper.selectAlarmTime(latest_id);
						} catch (Exception e) {
							e.printStackTrace();
						}
						logger.debug("alarm at {}", alarm_time);
						AlarmCronTrigger cron = new AlarmCronTrigger(alarm_time, latest_id, 
								email, latest_vo.getText(), latest_vo.getContent() + " 이벤트 시작시간: " + latest_vo.getStart_date() + " 이벤트 종료시간: " + latest_vo.getEnd_date());
						cron.deleteJob();
						cron.createJob();
						logger.debug("-------------------- CREATE mail sending process end");
					}
				}
			}
			
			return ret;
		}
		
		//2)일정 저장
		public int saveCal(Calendar calendar){
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
			
			return result;
		}
		//3)일정 삭제
		public int delCal(String calId){
			int result = -1;
			CalendarMapper mapper = sqlSession.getMapper(CalendarMapper.class);
			int id = 0;
			try {
				id = Integer.parseInt(calId);
			} catch (NumberFormatException e) {
				String[] sp = calId.split("_");
			}
			
			try {
				mapper.delCal(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		
		// 아이디에 해당하는 내용 얻기
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
