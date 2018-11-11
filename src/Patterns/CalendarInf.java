package Patterns;

import java.util.Date;

public interface CalendarInf {

    default Long getTime(){
        Date date = new Date();
        return date.getTime();
    };

    String getDescription();
}
