package telran.time.tools;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;

public class DateOperation {
	public static int getAge(String birthDate) {
		LocalDate dateNow = LocalDate.now();
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate bd = null;
		try {
			bd = LocalDate.parse(birthDate, df);

		} catch (DateTimeParseException e) {
			df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			bd = LocalDate.parse(birthDate, df);
		}
		return Long.valueOf(ChronoUnit.YEARS.between(bd, dateNow)).intValue();
	}

	public static String[] sortStringDate(String[] dates) {
		DateTimeFormatter df1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter df2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String[] datesArrayCopy = Arrays.copyOf(dates, dates.length);
		
		Comparator<String> comparator;
		comparator = (d1, d2) -> {
			LocalDate dateTime1 = null;
			LocalDate dateTime2 = null;
			try {
				dateTime1 = LocalDate.parse(d1, df1);
			} catch (DateTimeParseException e) {
				dateTime1 = LocalDate.parse(d1, df2);
			}
			try {
				dateTime2 = LocalDate.parse(d2, df1);
			} catch (DateTimeParseException e) {
				dateTime2 = LocalDate.parse(d2, df2);
			}
			return dateTime1.compareTo(dateTime2);
		};

		Arrays.sort(datesArrayCopy, comparator);

		return datesArrayCopy;

	}

}
