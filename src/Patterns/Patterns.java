package Patterns;

import java.util.HashMap;
import java.util.Map;

public class Patterns {

    public static void main(String[] args) {

       Month month = new Month();
       Week week = new Week();
       Day day = new Day();

       getCurrentDateInfo(day);

       Map<String, CalendarInf> broker = new HashMap<>();

       broker.put("day", day);
       broker.put("week", week);
       broker.put("month", month);

       String input = "week";

       getCurrentDateInfo(broker.get(input));
    }

    static void getCurrentDateInfo(CalendarInf date) {
        System.out.println(date.getTime());
        System.out.println(date.getDescription());
    }
}
