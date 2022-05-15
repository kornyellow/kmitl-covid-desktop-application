package kmitl.covid.lib.korn.kornutil;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class KornDateTime {
	public KornDateTime() {
		this.calendar = Calendar.getInstance();
	}
	public KornDateTime(Calendar calendar) {
		this.calendar = calendar;
	}

	public LocalDate getLocalDate() {
		return LocalDate.ofInstant(this.calendar.toInstant(), this.calendar.getTimeZone().toZoneId());
	}
	public LocalDateTime getLocalDateTime() {
		return LocalDateTime.ofInstant(this.calendar.toInstant(), this.calendar.getTimeZone().toZoneId());
	}

	public String toFullDate() {
		return this.getDate() + " " +
			this.getMonthString() + " " +
			this.getYear();
	}
	public String toFullThaiDate() {
		return this.getDate() + " " +
			this.getMonthStringThai() + " พ.ศ." +
			this.getYearThai();
	}

	public static KornDateTime createFromDate(int date, int month, int year) {
		KornDateTime toReturn = new KornDateTime();
		toReturn.getCalendar().set(Calendar.YEAR, year);
		toReturn.getCalendar().set(Calendar.MONTH, month - 1);
		toReturn.getCalendar().set(Calendar.DATE, date);
		return toReturn;
	}
	public static KornDateTime createFromDateTime(int date, int month, int year, int hour, int minute, int second) {
		KornDateTime toReturn = new KornDateTime();
		toReturn.getCalendar().set(Calendar.YEAR, year);
		toReturn.getCalendar().set(Calendar.MONTH, month - 1);
		toReturn.getCalendar().set(Calendar.DATE, date);
		toReturn.getCalendar().set(Calendar.HOUR, hour);
		toReturn.getCalendar().set(Calendar.MINUTE, minute);
		toReturn.getCalendar().set(Calendar.SECOND, second);
		return toReturn;
	}
	public static KornDateTime createFromThaiDate(int date, int month, int year) {
		KornDateTime toReturn = new KornDateTime();
		toReturn.getCalendar().set(Calendar.YEAR, year - 543);
		toReturn.getCalendar().set(Calendar.MONTH, month - 1);
		toReturn.getCalendar().set(Calendar.DATE, date);
		return toReturn;
	}
	public static KornDateTime createFromThaiDateTime(int date, int month, int year, int hour, int minute, int second) {
		KornDateTime toReturn = new KornDateTime();
		toReturn.getCalendar().set(Calendar.YEAR, year - 543);
		toReturn.getCalendar().set(Calendar.MONTH, month - 1);
		toReturn.getCalendar().set(Calendar.DATE, date);
		toReturn.getCalendar().set(Calendar.HOUR, hour);
		toReturn.getCalendar().set(Calendar.MINUTE, minute);
		toReturn.getCalendar().set(Calendar.SECOND, second);
		return toReturn;
	}
	public static KornDateTime createFromMySQLDate(String dateString) {
		String[] dates = dateString.split("-");
		return KornDateTime.createFromDate(
			Integer.parseInt(dates[2]),
			Integer.parseInt(dates[1]),
			Integer.parseInt(dates[0])
		);
	}
	public static KornDateTime createFromMySQLDateTime(String dateTimeString) {
		String[] dateTimes = dateTimeString.split(" ");
		String[] dates = dateTimes[0].split("-");
		String[] times = dateTimes[1].split(":");
		return KornDateTime.createFromDateTime(
			Integer.parseInt(dates[2]),
			Integer.parseInt(dates[1]),
			Integer.parseInt(dates[0]),
			Integer.parseInt(times[0]),
			Integer.parseInt(times[1]),
			Integer.parseInt(times[2])
		);
	}

	public static Map<Integer, String> getMonths() {
		Map<Integer, String> months = new HashMap<>();
		months.put(1, "January");
		months.put(2, "February");
		months.put(3, "March");
		months.put(4, "April");
		months.put(5, "May");
		months.put(6, "June");
		months.put(7, "July");
		months.put(8, "August");
		months.put(9, "September");
		months.put(10, "October");
		months.put(11, "November");
		months.put(12, "December");
		return months;
	}
	public static Map<Integer, String> getMonthsThai() {
		Map<Integer, String> months = new HashMap<>();
		months.put(1, "มกราคม");
		months.put(2, "กุมภาพันธ์");
		months.put(3, "มีนาคม");
		months.put(4, "เมษายน");
		months.put(5, "พฤษภาคม");
		months.put(6, "มิถุนายน");
		months.put(7, "กรกฎาคม");
		months.put(8, "สิงหาคม");
		months.put(9, "กันยายน");
		months.put(10, "ตุลาคม");
		months.put(11, "พฤษจิกายน");
		months.put(12, "ธันวาคม");
		return months;
	}

	public String getSecond() {
		return new SimpleDateFormat("s").format(this.calendar.getTime());
	}
	public String getMinute() {
		return new SimpleDateFormat("m").format(this.calendar.getTime());
	}
	public String getHour() {
		return new SimpleDateFormat("h").format(this.calendar.getTime());
	}
	public String getTime12FormatWithLeadingZero() {
		return new SimpleDateFormat("KK:mm").format(this.calendar.getTime());
	}
	public String getTime12Format() {
		return new SimpleDateFormat("K:m").format(this.calendar.getTime());
	}
	public String getFullTime12FormatWithLeadingZero() {
		return new SimpleDateFormat("hh:mm:ss").format(this.calendar.getTime());
	}
	public String getFullTime12Format() {
		return new SimpleDateFormat("h:m:s").format(this.calendar.getTime());
	}
	public String getTime24FormatWithLeadingZero() {
		return new SimpleDateFormat("HH:mm").format(this.calendar.getTime());
	}
	public String getTime24Format() {
		return new SimpleDateFormat("H:m").format(this.calendar.getTime());
	}
	public String getFullTime24FormatWithLeadingZero() {
		return new SimpleDateFormat("HH:mm:ss").format(this.calendar.getTime());
	}
	public String getFullTime24Format() {
		return new SimpleDateFormat("H:m:s").format(this.calendar.getTime());
	}
	public String getAMPMMarker() {
		return new SimpleDateFormat("a").format(this.calendar.getTime());
	}

	public String getDateWithLeadingZero() {
		return new SimpleDateFormat("dd").format(this.calendar.getTime());
	}
	public String getDate() {
		return new SimpleDateFormat("d").format(this.calendar.getTime());
	}
	public String getDateString() {
		return new SimpleDateFormat("EEEE").format(this.calendar.getTime());
	}
	public String getDateStringShort() {
		return new SimpleDateFormat("EE").format(this.calendar.getTime());
	}
	public String getDateStringThai() {
		String day = this.getDateStringShort();
		if (day.equals("Mon")) return "จันทร์";
		if (day.equals("Tue")) return "อังคาร";
		if (day.equals("Wed")) return "พุธ";
		if (day.equals("Thu")) return "พฤหัสบดี";
		if (day.equals("Fri")) return "ศุกร์";
		if (day.equals("Sat")) return "เสาร์";
		if (day.equals("Sun")) return "อาทิตย์";
		return "";
	}

	public String getMonthWithLeadingZero() {
		return new SimpleDateFormat("MM").format(this.calendar.getTime());
	}
	public String getMonth() {
		return new SimpleDateFormat("M").format(this.calendar.getTime());
	}
	public String getMonthString() {
		return new SimpleDateFormat("MMMM").format(this.calendar.getTime());
	}
	public String getMonthStringShort() {
		return new SimpleDateFormat("MMM").format(this.calendar.getTime());
	}
	public String getMonthStringThai() {
		String month = this.getMonth();
		if (month.equals("1")) return "มกราคม";
		if (month.equals("2")) return "กุมภาพันธ์";
		if (month.equals("3")) return "มีนาคม";
		if (month.equals("4")) return "เมษายน";
		if (month.equals("5")) return "พฤษภาคม";
		if (month.equals("6")) return "มิถุนายน";
		if (month.equals("7")) return "กรกฎาคม";
		if (month.equals("8")) return "สิงหาคม";
		if (month.equals("9")) return "กันยายน";
		if (month.equals("10")) return "ตุลาคม";
		if (month.equals("11")) return "พฤษจิกายน";
		if (month.equals("12")) return "ธันวาคม";
		return "";
	}
	public String getMonthStringThaiShort() {
		String month = this.getMonth();
		if (month.equals("1")) return "ม.ค.";
		if (month.equals("2")) return "ก.พ.";
		if (month.equals("3")) return "มี.ค.";
		if (month.equals("4")) return "เม.ย.";
		if (month.equals("5")) return "พ.ค.";
		if (month.equals("6")) return "มิ.ย.";
		if (month.equals("7")) return "ก.ค.";
		if (month.equals("8")) return "ส.ค.";
		if (month.equals("9")) return "ก.ย.";
		if (month.equals("10")) return "ต.ค.";
		if (month.equals("11")) return "พ.ย.";
		if (month.equals("12")) return "ธ.ค.";
		return "";
	}

	public String getYear() {
		return new SimpleDateFormat("yyyy").format(this.getCalendar().getTime());
	}
	public String getYearTwoDigit() {
		return new SimpleDateFormat("yy").format(this.getCalendar().getTime());
	}
	public String getYearThai() {
		KornDateTime thaiYear = new KornDateTime(this.calendar);
		thaiYear.getCalendar().add(Calendar.YEAR, 543);
		return new SimpleDateFormat("yyyy").format(thaiYear.getCalendar().getTime());
	}
	public String getYearThaiTwoDigit() {
		KornDateTime thaiYear = new KornDateTime(this.calendar);
		thaiYear.getCalendar().add(Calendar.YEAR, 543);
		return new SimpleDateFormat("yy").format(thaiYear.getCalendar().getTime());
	}

	public String getMySQLDateFormat() {
		return new SimpleDateFormat("yyyy-MM-dd").format(this.getCalendar().getTime());
	}
	public String getMySQLDateTimeFormat() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.getCalendar().getTime());
	}

	private final Calendar calendar;

	public Calendar getCalendar() {
		return calendar;
	}
}
