package com.example.springedu.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component // bean 객체로 만들겠다
public class SpringSchedulerTest {	
	/*@Scheduled(cron = "30 25 10 * * 4")// 초, 분, 시, 일, 월, 요일(0:일요일) * : 모든*/
	/*@Scheduled(fixedDelay = 5000)*/ // 5초에 한 번씩
	public void scheduleRun() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = 
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("**** 스케줄 실행 : " + 
				dateFormat.format(calendar.getTime()));
		
	}
}
