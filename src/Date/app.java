package Date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class app {

    public static void main(String[] args) {

        Date date = new Date();

        System.out.println(date);

        LocalDate localDate = LocalDate.now();
        LocalDate.of(2015,02,20);
        LocalDate.parse("2015-02-20");

        System.out.println(localDate);

        LocalTime localTime = LocalTime.now();

        System.out.println(localTime);

        LocalDateTime dateTime = LocalDateTime.now();
        LocalDateTime localDateTime = localDate.atTime(localTime);

        System.out.println(dateTime);
        System.out.println(localDateTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        System.out.println(localDateTime.format(formatter));

        LocalDate before = localDate.minus(1, ChronoUnit.MONTHS);
        localDate.minus(Period.ofMonths(1));

        System.out.println(before);

        System.out.println(before.isBefore(localDateTime.toLocalDate()));

        System.out.println(ChronoUnit.DAYS.between(before, localDate));

        System.out.println(Period.between(before, localDate).getDays());

        System.out.println(Duration.between(localTime.minus(Duration.ofHours(2)), localTime).getSeconds());

        System.out.println(LocalDateTime.ofInstant(date.toInstant(), ZoneId.of("Europe/Paris")));

        ZonedDateTime zdt1 = ZonedDateTime.of(2015, 1, 1, 15, 0, 0, 0, ZoneId.of("Israel"));
        ZonedDateTime zdt2 = ZonedDateTime.of(2015, 1, 1, 14, 0, 0, 0, ZoneId.of("Europe/London"));

        System.out.println(zdt1);
        System.out.println(zdt2);
        System.out.println(zdt1.compareTo(zdt2));

        LocalDateTime ldt1 = zdt1.toLocalDateTime();
        LocalDateTime ldt2 = zdt2.toLocalDateTime();

        System.out.println(ldt1);
        System.out.println(ldt2);

        System.out.println(ldt1.compareTo(ldt2));
    }
}
