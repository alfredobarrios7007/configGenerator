/**
 * 
 */
package com.koatchy.configGenerator.tools;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * @author alfredo.barrios
 *
 */
public class DateHelper {
	
	public Date now() {
		Date result;
		ZoneId zNewYork = ZoneId.of("America/New_York");

		Instant now = Instant.now();
		ZonedDateTime zdtNewYork = now.atZone( zNewYork );		
		result = Date.from( zdtNewYork.toInstant() );		
		return result;
	}

	public String getTodayStr() {
		String result;
        Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");  
        result = dateFormat.format(date);  
        return result;
	}	
	
	public String getNowStr() {
		String result;
        Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        result = dateFormat.format(date);  
        return result;
	}	
	
	public long friendlyTimeDiff(TypeElapsedTime typeElapsedTime, Date dateInit, Date dateFinish) {
		long timeDifference =  dateFinish.getTime() - dateInit.getTime();
		long result = 0;
/*
 * 	    long diffSeconds = timeDifference / 1000;
	    long diffMinutes = timeDifference / (60 * 1000);
	    long diffHours = timeDifference / (60 * 60 * 1000);
	    long diffDays = timeDifference / (60 * 60 * 1000 * 24);
	    long diffWeeks = timeDifference / (60 * 60 * 1000 * 24 * 7);
	    long diffMonths = (long) (timeDifference / (60 * 60 * 1000 * 24 * 30.41666666));
	    long diffYears = timeDifference / ((long)60 * 60 * 1000 * 24 * 365);

 * */
		switch(typeElapsedTime) {
		case Day:
		    result = timeDifference / (60 * 60 * 1000 * 24);
			break;
		case Hour:
		    result = timeDifference / (60 * 60 * 1000);
			break;
		case Minute:
		    result = timeDifference / (60 * 1000);
			break;
		case Second:
		    result = timeDifference / 1000;
			break;
		default:
			result = timeDifference;
			break;
			
		}		
		return result;
	}
}


