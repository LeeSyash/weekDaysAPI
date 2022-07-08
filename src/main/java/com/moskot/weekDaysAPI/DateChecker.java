package com.moskot.weekDaysAPI;

import com.moskot.weekDaysAPI.responces.Day;
import com.moskot.weekDaysAPI.responces.WeekDay;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class DateChecker {

    public Day checkDate(String stringDate) {
        String dateType;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(stringDate, formatter);
        String dayOfWeek = date.getDayOfWeek().toString();

        switch (date.getDayOfWeek().getValue()) {
            case 6:
            case 7:
                dateType = "H";
                break;
            default:
                dateType = "W";
                break;
        }
        return (!dateType.equals("H")) ? new WeekDay(stringDate, dayOfWeek, dateType, "text", "1234") : new Day(stringDate, dayOfWeek, dateType, "text");
    }

    public List<Day> checkDates(String dateTo, String dateFrom) {

    }
}
