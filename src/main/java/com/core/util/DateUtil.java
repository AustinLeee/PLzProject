package com.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.core.exception.Code3gException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

public final class DateUtil {
    /**
     * pattern MM/dd/yy
     */
    public static String pattern1 = "MM/dd/yy";
    /**
     * pattern MMddyy
     */
    public static String pattern2 = "MMddyy";
    /**
     * pattern yyyy-MM-dd   HH:mm:ss.0<br>
     * java.sql.Date的格式
     */
    public static String pattern3 = "yyyy-MM-dd HH:mm:ss.0";
    /**
     * pattern yyyy-MM-dd<br>
     * java.sql.Date的格式
     */
    public static String pattern4 = "yyyy-MM-dd";

    /**
     * pattern yyyy/MM/dd <br>
     * java.sql.Date的格式
     */
    public static String pattern5 = "yyyy/MM/dd";
    
    /**
     * pattern MM/dd/yy HH:mm:ss<br>
     * java.sql.Date的格式
     */
    public static String pattern7 = "MM/dd/yy HH:mm:ss";

    /**
     * pattern HH:mm:ss<br>
     * java.sql.Date的格式
     */
    public static String pattern8 = "HH:mm:ss";

    /**
     * pattern yyyyMMdd<br>
     * java.sql.Date的格式
     */
    public static String pattern9 = "yyyyMMdd";

    /**
     * pattern yyyy/MM<br>
     * java.sql.Date的格式
     */
    public static String pattern10 = "yyyy/MM";
    
    /**
     * pattern yyyy-MM-dd HH:mm:ss<br>
     * java.sql.Date的格式
     */
    public static String pattern11 = "yyyy-MM-dd HH:mm:ss";
    
    /**
     * pattern yyyy/MM/dd HH:mm:ss<br>
     */
    public static String pattern12 = "yyyy/MM/dd HH:mm:ss";

    /**
     * pattern yyyy/MM/dd HH:mm<br>
     */
    public static String pattern13 = "yyyy/MM/dd HH:mm";

    /**
     * pattern yyyyMMddHHmmss<br>
     */
    public static String pattern14 = "yyyyMMddHHmmss";
    
    /**
     * pattern M/d(EE)<br>
     */
    public static String pattern15 = "M/d(E)";

    /**
     * pattern HHmm<br>
     */
    public static String pattern16 = "HHmm";
    
    /**
     * pattern HH:mm<br>
     */
    public static String pattern17 = "HH:mm";
    
    /**
     * pattern E (星期幾)<br>
     */
    public static String pattern18 = "E";
    
    /**
     * pattern yyyyMM<br>
     */
    public static String pattern19 = "yyyyMM";
    
    /**
     * pattern MM/dd<br>
     */
    public static String pattern20 = "MM/dd";
    
    /**
     * pattern yyyy/MM/dd(E) HH:mm<br>
     */
    public static String pattern21 = "yyyy/MM/dd(E) HH:mm";

    /**
     * pattern yyyy/MM/dd(E)
     */
    public static String pattern22 = "yyyy/MM/dd(E)";
    /**
     * pattern yy/MM
     */
    public static String pattern23 = "yy/MM";
    /**
     * pattern HHmmss
     */
    public static String pattern24 = "HHmmss";
    /**
     * pattern yyMM
     */
    public static String pattern25 = "yyMM";
    
    /**
     * pattern MMdd
     */
    public static String pattern26 = "MMdd";
    

    /**
	 * 取得當天日期(去掉時間)
	 * @return
	 */
	public final static Date getToday() {
		return DateUtils.truncate(Calendar.getInstance().getTime(), Calendar.DAY_OF_MONTH);
	}

	/**
	 * 取得現在時間
	 * @return
	 */
	public final static Date getNow() {
		return Calendar.getInstance().getTime();
	}
	
 
    /**
     * 將日期轉換成指定之格式
     * @param date
     * @param pattern 
     * @return 轉換後之日期格式
     * @see SimpleDateFormat
     */
    public final static String getDateString(Date date, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

    /**
     * 取得 日期  
     * 若 pattern 內含星期 擇去除 "星期" 二字
     * @param date
     * @param pattern 
     * @return 轉換後之日期格式
     * @see SimpleDateFormat
     */
    public final static String getDateStringWithDayWeek(Date date, String pattern) {
    	String date15 = getDateString(date, pattern);
    	date15 = date15.replaceAll("星期", "");
        return date15;
    }
    
   
    /**
     * 將日期轉換成指定之格式
     * @param date
     * @param pattern 
     * @param locale 欲轉換的locale
     * @return 轉換後之日期格式
     * @see SimpleDateFormat
     */
    public final static String getDateString(Date date, String pattern, Locale locale) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern, locale);
        return dateFormat.format(date);
    }

    
    /**
     * 將日期轉換成指定之格式
     * @param date
     * @param pattern 
     * @return 轉換後之日期格式
     * @throws ParseException - if the beginning of the specified string cannot be parsed.
     * @see SimpleDateFormat
     */
    public final static Date toDate(String date, String pattern) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date a = dateFormat.parse(date);
        return a;
    }
    
    /**
     * 取得目前的年度碼
     * @param today 目前的日期
     * @return		取得目前西元年未碼
     */
    public final static String getCurrentYearCode(Date today) {
        SimpleDateFormat formatter = new SimpleDateFormat ("yyyy");
        return formatter.format(today).substring(3);
    }// end of getCurrentYearCode
    
    /**
     * 取得前一年西元年之年度碼
     * @param today	目前的日期
     * @return		取得前年西元年未碼
     */
    public final static String getLastYearCode(Date today) {
        Calendar aCalendar = Calendar.getInstance();
        aCalendar.setTime(today);
        aCalendar.add(Calendar.YEAR,-1);
        SimpleDateFormat formatter = new SimpleDateFormat ("yyyy");
        return formatter.format(aCalendar.getTime()).substring(3);
    }// getLastYearCode()
    
    
 
    /**
     * 取得今天日期的前幾天,由 v_perior 決定
     * 帶入數值 無關正負皆可
     * @return Date
    */
    public static Date getTodayBefore(int v_perior) {

      Calendar date = Calendar.getInstance();
      date.getTime();
      if (v_perior < 0) {
          date.add(Calendar.DATE,v_perior);
       }
       else if (v_perior > 0) {
          date.add(Calendar.DATE,v_perior*-1);
      }
      else {
         date.add(Calendar.DATE,v_perior);
      }
      return date.getTime();
  }
    
    /**
     * 取得今天日期的前幾天或後幾天,由 v_perior 決定
     * v_perior 為正 則指 v_perior天後；反之為負 代表 v_perior天前
     * @return 傳回 Date 型別
    */
    public static Date getTodayBeforeOrAfter(int v_perior) {
      Calendar cal = Calendar.getInstance();
      cal.getTime();
      cal.add(Calendar.DATE,v_perior);
      return cal.getTime();
  }
    
    /**
     * 取得給定日期前幾天或後幾天,由 v_perior 決定
     * v_perior 為正 則指 v_perior天後；反之為負 代表 v_perior天前
     * @return 傳回 Date 型別
    */
    public static Date getGivenDateBeforeOrAfter(Date date, int v_perior) {
      Calendar cal = Calendar.getInstance();
      cal.setTime(date);
      cal.add(Calendar.DATE,v_perior);
      return cal.getTime();
    }
    
    /**
     * 取得上一個月的最後一天  pattern
     * @param inputDate
     * @return
     */
    public static String getPreMonthLastDate(Date inputDate, String pattern){
		Calendar transDate = Calendar.getInstance(); 
		transDate.setTime(inputDate); 
		transDate.set(Calendar.DATE,1);
		transDate.add(Calendar.DATE,-1);
		inputDate = transDate.getTime();
        return getDateString(inputDate, pattern);
     }
	
    /**
	 * 檢查日期格式是否正確
	 * @param date
	 * @return 格式正確：true，不正確：false
	 */
	public static boolean isDatePattern(String date, String patten, int length) {
		boolean flag = false;
		try {
			if (StringUtils.isNotBlank(date)) {
				if (date.length()==length) {
					DateUtil.toDate(date, patten);
					flag = true;
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 取得傳入日期該月最後一天 加入時分秒的格式  23:59:59
	 * @param date
	 * @return
	 */
	public static Date getLastDate(Date date) {
		Calendar transDate = Calendar.getInstance(); 
		transDate.setTime(date);
		transDate.set(Calendar.DATE,transDate.getActualMaximum(Calendar.DAY_OF_MONTH)); 
		transDate.set(Calendar.HOUR_OF_DAY,23); 
		transDate.set(Calendar.MINUTE,59); 
		transDate.set(Calendar.SECOND,59); 
		date = transDate.getTime(); 
		return date;
	}

	/**
	 * 取得傳入日期該月最後一天 加入時分秒的格式 00:00:00
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfMonth(Date date) {
		Calendar transDate = Calendar.getInstance(); 
		transDate.setTime(date);
		transDate.set(Calendar.DATE,transDate.getActualMaximum(Calendar.DAY_OF_MONTH)); 
		transDate.set(Calendar.HOUR_OF_DAY,0); 
		transDate.set(Calendar.MINUTE,0); 
		transDate.set(Calendar.SECOND,0); 
		date = transDate.getTime(); 
		return date;
	}
	
	/**
	 * 取得所給週的最後一天的 00:00:00
	 * @param belongWeek
	 * @return
	 */
	public static Date getLastDateOfWeek(Date date) {
		Calendar transDate = Calendar.getInstance(); 
		transDate.setTime(date);
		int dayOfWeek = transDate.get(Calendar.DAY_OF_WEEK); 
		transDate.add(Calendar.DATE, transDate.getActualMaximum(Calendar.DAY_OF_WEEK)-dayOfWeek);
		transDate.set(Calendar.HOUR_OF_DAY,0); 
		transDate.set(Calendar.MINUTE,0); 
		transDate.set(Calendar.SECOND,0); 
		date = transDate.getTime();  
		return date;
	}
	
	/**
	 * 取得所給週的第一天的 00:00:00
	 * @param belongWeek
	 * @return
	 */
	public static Date getFirstDateOfWeek(Date date) {
		Calendar transDate = Calendar.getInstance(); 
		transDate.setTime(date);
		int dayOfWeek = transDate.get(Calendar.DAY_OF_WEEK); 
		transDate.add(Calendar.DATE, transDate.getActualMinimum(Calendar.DAY_OF_WEEK)- dayOfWeek);
		transDate.set(Calendar.HOUR_OF_DAY,0); 
		transDate.set(Calendar.MINUTE,0); 
		transDate.set(Calendar.SECOND,0); 
		date = transDate.getTime(); 
		return date;
	}
	
	
	/**
	 * 取得傳入日期該月第一天 加入時分秒的格式 00:00:00
	 * @param date
	 * @return
	 */
	public static Date getFirstDate(Date date) {
		Calendar transDate = Calendar.getInstance(); 
		transDate.setTime(date); 
		transDate.set(Calendar.DATE,1); 
		transDate.set(Calendar.HOUR_OF_DAY,0); 
		transDate.set(Calendar.MINUTE,0); 
		transDate.set(Calendar.SECOND,0); 
		date = transDate.getTime(); 
		return date;
	}
	
	
	/**
	 * 取得傳入日期加入時分秒的格式 23:59:59
	 * @param date
	 * @return
	 */
	public static Date getEndDate(Date date) {
		Calendar transDate = Calendar.getInstance(); 
		transDate.setTime(date); 
		transDate.set(Calendar.HOUR_OF_DAY,23); 
		transDate.set(Calendar.MINUTE,59); 
		transDate.set(Calendar.SECOND,59); 
		date = transDate.getTime(); 
		return date;
	}

	/**
	 * 取得傳入日期加入時分秒的格式 00:00:00
	 * @param date
	 * @return
	 */
	public static Date getBeginDate(Date date) {
		Calendar transDate = Calendar.getInstance(); 
		transDate.setTime(date); 
		transDate.set(Calendar.HOUR_OF_DAY,0); 
		transDate.set(Calendar.MINUTE,0); 
		transDate.set(Calendar.SECOND,0); 
		date = transDate.getTime(); 
		return date;
	}
	
	/**
	 * 取得傳入日期的前一個月 01 號 00:00:00
	 * @param date
	 * @return
	 */
	public static Date getLastMonth(Date date) {
		Calendar transDate = Calendar.getInstance(); 
		transDate.setTime(date); 
		transDate.set(Calendar.SECOND,0); 
		transDate.set(Calendar.MINUTE,0); 
		transDate.set(Calendar.HOUR_OF_DAY,0); 
		transDate.set(Calendar.DAY_OF_MONTH,1); 
		transDate.set(Calendar.MONTH, transDate.get(Calendar.MONTH)-1);
		date = transDate.getTime(); 
		return date;
	}
	
	/**
	 * 取得日期時分秒之區間
	 * 範例：2008-04-10 -> 2008-04-10 00:00:00 ~ 2008-04-10 23:59:59
	 * @param date
	 * @return
	 */
	public static Date[] getDateRange(Date date){
		Date[] dateRange = new Date[2];
		dateRange[0] = getBeginDate(date);
		dateRange[1] = getEndDate(date);
		return dateRange;
	}
	
		
	/**
	 * 檢查日期是否為週末
	 * @param date
	 * @return ：為週末（六、日）：true，不為週末：false
	 */
	public static boolean isWeekend(Date date) {
		boolean flag=false;
		int dayOfWeek;
		if (date != null){
			Calendar transDate = Calendar.getInstance(); 
			transDate.setTime(date); 
			dayOfWeek = transDate.get(Calendar.DAY_OF_WEEK);
		    if((Calendar.SATURDAY == dayOfWeek) || (Calendar.SUNDAY == dayOfWeek)){
		    	flag=true;
		    }
		}
		return flag;
	}
	
	/**
	 * 取得驗收換日日期，傳入換日的時間
	 * @param hour(24小時制)
	 * @return
	 */
	public static Date getChangeDate(int hour){
		//設定D日19:00
		Calendar transDate = Calendar.getInstance(); 
		transDate.setTime(DateUtil.getToday()); 
		transDate.set(Calendar.HOUR_OF_DAY,hour); 
		//系統日期大於D日19:00則為D+1日，否則為D日
		Date date = null;
		if(getNow().after(transDate.getTime())){
			date = getTodayBeforeOrAfter(1);
		}else{
			date = DateUtil.getNow();
		}
		return date;
	}
	
	/**
	 * 取得驗收換日區間，傳入日期與換日的時間
	 * @param date
	 * @param hour
	 * @return
	 * 範例：2010-02-24 -> 2010-02-24 19:00:00 ~ 2010-02-25 18:59:59
	 */
	public static Date[] getChangeDateRange(Date date, int hour){
		Date[] dateRange = new Date[2];
		Calendar transDate = Calendar.getInstance();
		transDate.setTime(date); 
		transDate.set(Calendar.HOUR_OF_DAY,hour); 
		transDate.set(Calendar.MINUTE,0); 
		transDate.set(Calendar.SECOND,0); 
		dateRange[0] = transDate.getTime();
		long millis = transDate.getTimeInMillis() + 24 * 60 * 60 * 1000 - 1;
		transDate.setTimeInMillis(millis);
		dateRange[1] = transDate.getTime();
		return dateRange;
	}
	
	/**
	 * 取得今天是一年中的第幾天
	 * @param date
	 * @param hour
	 * @return
	 */
	public static int getDayOfYear(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_YEAR);
	}
	
	
	/**
	 * 取得傳入日期的 beforeMonth月的 01 號 00:00:00
	 * 例如 : 9月3日 進來~ 要得到 半年前的1日
	 * beforeMonth = 6,Date date = 進來的日期
	 * 會得到 Mon Mar 01 00:00:00 CST 2010   
	 * @param date
	 * @return
	 */
	public static Date getBeforeMonth(int beforeMonth,Date date) {
		Calendar transDate = Calendar.getInstance(); 
		transDate.set(Calendar.SECOND,0); 
		transDate.set(Calendar.MINUTE,0); 
		transDate.set(Calendar.HOUR_OF_DAY,0); 
		transDate.set(Calendar.DAY_OF_MONTH,1); 
		transDate.set(Calendar.MONTH, transDate.get(Calendar.MONTH)-(beforeMonth));
		date = transDate.getTime(); 
		return date;					
	}
	
	/**
	 * 取得9999/12/31的Date物件
	 * @return 9999/12/31的Date
	 */
	public static Date getDateForAll9() {
		Calendar transDate = Calendar.getInstance(); 
		transDate.set(Calendar.SECOND,0); 
		transDate.set(Calendar.MINUTE,0); 
		transDate.set(Calendar.HOUR_OF_DAY,0); 
		transDate.set(Calendar.DATE,31); 
		transDate.set(Calendar.MONTH, 11);
		transDate.set(Calendar.YEAR, 9999);
		final Date date = transDate.getTime(); 
		return date;
	}
	
	/**
	 * 將字串格式的YYYYMMDD轉換成Date物件
	 * @param dateStr 要轉換的年月日字串
	 * @param pattern 年月日的字串格式
	 * @return 指定年月日的Date
	 */
	public final static Date toDateYYYYMMDD(final String dateStr, final String pattern) {
        Date date = null;
        try {
			date = toDate(dateStr, pattern);
		} catch (ParseException e) {
			final Code3gException pos3ge = new Code3gException("B221001", e);
			throw pos3ge;
		}
        return date;
    }
	
	public static void main(String[] args) throws ParseException{
		System.out.println(getToday());
		System.out.println(getNow());
		System.out.println(getDateString(getNow(),pattern9));
		System.out.println(getDateStringWithDayWeek(getNow(), pattern9));
		System.out.println(toDate("20101231", pattern9));
		System.out.println(getCurrentYearCode(getNow()));
		System.out.println(getLastYearCode(getNow()));
		System.out.println(getTodayBefore(0));
		System.out.println(getTodayBeforeOrAfter(11));
		System.out.println(getTodayBeforeOrAfter(-11));
		System.out.println(getGivenDateBeforeOrAfter(getNow(), 11));
		System.out.println(getPreMonthLastDate(getNow(), pattern9));
		System.out.println(isDatePattern("20101231", pattern9,8));
		System.out.println(getLastDate(getNow()));
		System.out.println(getLastDayOfMonth(getNow()));
		System.out.println(getLastDateOfWeek(getNow()));
		System.out.println(getFirstDateOfWeek(getNow()));
		System.out.println("getFirstDate=" + getFirstDate(getNow()));
		System.out.println("getEndDate=" + getEndDate(getNow()));
		System.out.println("getBeginDate=" + getBeginDate(getNow()));
		System.out.println("getLastMonth=" + getLastMonth(getNow()));
		System.out.println("getDateRange=" + getDateRange(getNow())[0]);
		System.out.println("getDateRange=" + getDateRange(getNow())[1]);
		System.out.println("isWeekend=" + isWeekend(getNow()));
		System.out.println("getChangeDate=" + getChangeDate(19));
		System.out.println("getChangeDateRange=" + getChangeDateRange(getNow(), 19)[0]);
		System.out.println("getChangeDateRange=" + getChangeDateRange(getNow(), 19)[1]);
		System.out.println("getDayOfYear=" + getDayOfYear(getNow()));
		System.out.println("getBeforeMonth=" + getBeforeMonth(6,getNow()));
		
	}
	
	
}
