package vn.com.nct.base;

import java.text.ParseException;

public interface TimerService {
	public String getCurrentTime();
	public String getCurrentDate();
	public String getCompareDate(String date) throws ParseException ;
	public String getCompareTime(String time) throws ParseException ;
}
