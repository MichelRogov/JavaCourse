package Multithreading.SimpleDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleDateFormatApp {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    public static void main(String[] args) {
        String date = "2018-06-22T10:00:00";

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        Runnable task = new Runnable() {
            @Override
            public void run () {
                parseDate(date);
            }
        };

        for (int i = 0; i < 100; i++) {
            executorService.submit(task);
        }

        executorService.shutdown();
    }

    private static void parseDate(String dateStr) {
        try {
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = simpleDateFormat.parse(dateStr);
            System.out.println("Successfully parsed date: " + date);
        } catch (ParseException e) {
            System.out.println("Parse error: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    private synchronized static void parseDate(String dateStr) {
//        try {
//            Date date = simpleDateFormat.parse(dateStr);
//            System.out.println("Successfully parsed date: " + date);
//        } catch (ParseException e) {
//            System.out.println("Parse error: " + e.getMessage());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
