package com.cos.raspstreaming.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
	
	public static LocalDate getStringToLocalDate(String day) {
		return LocalDate.parse(day);
	}
	
	public static String getLocalDateToString(LocalDate day) {
		return day.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
	
	public static LocalDate getPlusLocalDate(LocalDate day, long num) {
		return day.plusDays(num);
	}
	
	public static LocalDate getMinusLocalDate(LocalDate day, long num) {
		return day.minusDays(num);
	}
}
