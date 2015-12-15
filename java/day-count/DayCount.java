import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Ruunable;


public class DayCount implements Runnable {
	private static final List<String> daysOfWeek = new ArrayList<String>(Arrays.asList("monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"));
	private static final int [] monthLengths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
	public static void main(String[] args) {
		int referenceYear = Integer.parseInt(args[0]),
			referenceMonth = Integer.parseInt(args[1]),
			referenceDay = Integer.parseInt(args[2]);
		String referenceDayOfWeek = args[3];
		int targetYear = Integer.parseInt(args[4]),
			targetMonth = Integer.parseInt(args[5]),
			targetDay = Integer.parseInt(args[6]);

		int count = DayCount.countDays(referenceYear, referenceMonth, referenceDay,
											  targetYear, targetMonth, targetDay);

		System.out.println("Days between dates: " + count);
		System.out.println("MOD: " + (count % 7));
		// System.out.println("That day was a " + daysOfWeek.get(7 + daysOfWeek.indexOf(referenceDayOfWeek.toLowerCase()) - (count % 7)));
	}

	private static int countDays(int referenceYear, int referenceMonth, int referenceDay,
								 int targetYear, int targetMonth, int targetDay) {
		int referenceDays = daysInDate(referenceYear, referenceMonth, referenceDay),
			targetDays = daysInDate(targetYear, targetMonth, targetDay);


		return (referenceDays + daysInYears(referenceYear, targetYear)) - targetDays;
	}

	private static int daysInDate (int year, int month, int day) {
		int total = day;

		if (month > 1) {
			total += daysInFullMonthsOfDate(year, month);
		}

		return total;
	}

	private static int daysInFullMonthsOfDate(int year, int month) {
		int total = 0;

		// the month must be adjusted 1 for correcting the array indice
		for (int i = 0; i < (month - 1); i++) {
			total += monthLengths[i];
		}

		if (month > 2 && isLeapYear(year)) {
			total++;
		}

		return total;
	}

	private static int daysInYears(int referenceYear, int targetYear) {
		int total = 0;

		for (int startYear = targetYear; startYear < referenceYear; startYear++) {
			total += ((isLeapYear(startYear)) ? 366 : 365);
		}

		return total;
	}

	private static boolean isLeapYear(int year) {
		return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
	}
}




	
