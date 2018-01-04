package vn.com.nct.base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class TimerServiceIplm implements TimerService{

	private SimpleDateFormat sdf_day  		  = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat sdf_time 		  = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private SimpleDateFormat sdf_compare_day  = new SimpleDateFormat("yyyy/MM/dd");
	private SimpleDateFormat sdf_compare_time = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	@Override
	public String getCurrentTime() {
		Date date = new Date();
		return sdf_time.format(date);
	}

	@Override
	public String getCurrentDate() {
		Date date = new Date();
		return sdf_day.format(date);
	}

	@Override
	public String getCompareDate(String date) throws ParseException {
		return sdf_compare_day.format(sdf_day.parse(date));
	}

	@Override
	public String getCompareTime(String time) throws ParseException {
		return sdf_compare_time.format(sdf_time.parse(time));
	}

	@Override
	public int countDays(String time_begin) throws ParseException {
		Date begin = sdf_time.parse(time_begin);
		Date now   = sdf_time.parse(this.getCurrentTime());
		
		return (int)( (now.getTime() - begin.getTime()) / (1000 * 60 * 60 * 24));
	}

	@Override
	public long getMiliseconds(String time) throws ParseException {
		Date date = sdf_time.parse(time);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getTimeInMillis();
	}

	
}
