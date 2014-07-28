package com.synergy.bank.util;


import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author astha
 * 
 */
public class DateUtils {
	
	 static public long dayDiff(Date d1, Date d2) {
	    final long DAY_MILLIS = 1000 * 60 * 60 * 24;
	    long day1 = d1.getTime() / DAY_MILLIS;
	    long day2 = d2.getTime() / DAY_MILLIS;
	    return (day1 - day2);
	}
	
	/**
	 *  Convert this 04/15/2014 format into 2014-04-14
	 * @param date
	 * @return
	 */
	public static String convertMMDDYYYYInToYYYYMMDD(String date) {
		String tokens[]=date.split("/");
		StringBuilder builder=new StringBuilder();
		builder.append(tokens[2]);
		builder.append("-");
		builder.append(tokens[0]);
		builder.append("-");
		builder.append(tokens[1]);
		return builder.toString();
	}
	
	static public String getJavaDateYYMMDDFormat(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String datestring = dateFormat.format(date);
		return datestring;
	}

	public static Date getCurrentJavaDate() {
		return new Date();
	}

	public static void main(String[] args) {
		String str="04/15/2014";
		String tokens[]=str.split("/");
	
	}

	/**
	 * Method which return the current date
	 * This method will take date in the format
	 * 12-May-14(dd-month-yy) and will return in the format 14-05-12(yy-mm-dd)
	 * 
	 * @return
	 */
	public static String getDateOfClass(String doclass) {
    	String tokens[]=doclass.split("-");
        String fdate=tokens[2]+"-"+getMonthIndexByName(tokens[1])+"-"+tokens[0];
        return fdate;
    }
	
	/**
	 * Method which return the current date
	 * This method will take date in the format
	 * 12-May-14(dd-month-yy) and will return in the format 14-05-12(yy-mm-dd)
	 * 
	 * @return
	 */
	public static String getSpecialDateOfClass(String doclass) {
    	String tokens[]=doclass.split("-");
        String fdate=tokens[2]+"-"+getMonthIndexByName(tokens[1].toUpperCase())+"-"+tokens[0];
        return fdate;
    }
	
	/**
	 * Method which return the current date
	 * This method will take date in the format
	 * 12/10/1984 and will return in the format 1984/10/12
	 * 
	 * @return
	 */
	public static String getChangeDOBFromExcel(String doclass) {
    	String tokens[]=doclass.split("/");
        String fdate=tokens[2]+"-"+tokens[1]+"-"+tokens[0];
        return fdate;
    }

	/**
	 * Method which return the current date
	 * 
	 * @return
	 */
	public static String getCurrentDateSQLDB() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String cdateInString = formatter.format(new Date());
		return cdateInString;
	}

	public static Time getCurrentTime() {
		// setting the values inside the queries
		Date date = new Date();
		long d = date.getTime();
		Time time = new Time(d);
		return time;
	}

	/**
	 * Method which return the current date
	 * 
	 * @return
	 */
	public static java.sql.Date getCurrentDateInSQLFormat() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String cdateInString = formatter.format(new Date());
		DateFormat dformatter = new SimpleDateFormat("yyyy-MM-dd");
		Date javaDate = null;
		try {
			javaDate = dformatter.parse(cdateInString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date cSQLDate = new java.sql.Date(javaDate.getTime());
		return cSQLDate;
	}

	public static String getMonthIndexByName(String monthName) {
		String mname = monthName.toUpperCase();
		if ("JAN".equals(mname)) {
			return "01";
		} else if ("FEB".equals(mname)) {
			return "02";
		} else if ("MAR".equals(mname)) {
			return "03";
		} else if ("APR".equals(mname)) {
			return "04";
		} else if ("MAY".equals(mname)) {
			return "05";
		} else if ("JUN".equals(mname)) {
			return "06";
		} else if ("JUL".equals(mname)) {
			return "07";
		} else if ("AUG".equals(mname)) {
			return "08";
		} else if ("SEP".equals(mname)) {
			return "09";
		} else if ("OCT".equals(mname)) {
			return "10";
		} else if ("NOV".equals(mname)) {
			return "11";
		} else if ("DEC".equals(mname)) {
			return "12";
		}
		return "01";
	}

	public static String getMonthName(int index) {
		String montharr[] = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL",
				"AUG", "SEP", "OCT", "NOV", "DEC" };
		return montharr[index];
	}

	/**
	 * get current date in dd-MMM-yyyy format 26-MAY-2013
	 * 
	 * @return
	 */
	public static String getCurrentDate() {
		// //////this is for date purpose
		String month, dd, year;
		Calendar cnd;
		String montharr[] = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL",
				"AUG", "SEP", "OCT", "NOV", "DEC" };
		String datearr[] = { "01", "02", "03", "04", "05", "06", "07", "08",
				"09", "10", "11", "12", "13", "14", "15", "16", "17", "18",
				"19", "20", "21", "22", "23", "24", "25", "26", "27", "28",
				"29", "30", "31" };
		cnd = Calendar.getInstance();
		dd = datearr[cnd.get(Calendar.DATE) - 1];
		month = montharr[cnd.get(Calendar.MONTH)];
		year = "" + cnd.get(Calendar.YEAR);
		String sysdate = "" + dd + "-" + month + "-" + year;
		
		return sysdate;
	}

	public static String convertddMMFormat(String inputString) {
		SimpleDateFormat fromUser = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat myFormat = new SimpleDateFormat("dd-MMM-yyyy");
		Date date = null;
		try {
			date = fromUser.parse(inputString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return myFormat.format(date);
	}
}
