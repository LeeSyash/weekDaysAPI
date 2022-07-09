package com.moskot.weekDaysAPI;

import com.moskot.weekDaysAPI.responces.Day;
import com.moskot.weekDaysAPI.responces.ResponseTemplate;
import com.moskot.weekDaysAPI.responces.WeekDay;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class DateChecker {

    public ResponseTemplate checkDate(String stringDate) {
        LocalDate date = parseLocalDate(stringDate);
        return getDayInfo(date);
    }

    public List<ResponseTemplate> checkPeriod(String dateFrom, String dateTo) {
        List<LocalDate> dates = fillPeriod(dateFrom, dateTo);
        List<ResponseTemplate> checkedDays = new ArrayList<>();
        for (LocalDate date:
             dates) {
            checkedDays.add(getDayInfo(date));
        }
        return checkedDays;
    }

    private LocalDate parseLocalDate(String stringDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(stringDate, formatter);
    }

    private List<LocalDate> fillPeriod(String dateFrom, String dateTo) {
        List<LocalDate> result = new ArrayList<>();
        LocalDate date = parseLocalDate(dateFrom);
        result.add(date);
        while (!dateTo.equals(date.toString())) {
            date = date.plusDays(1);
            result.add(date);
        }
        return result;
    }

    private Day getDayInfo(LocalDate date) {
        String dayOfWeek = date.getDayOfWeek().toString();

        String dateType = switch (date.getDayOfWeek().getValue()) {
            case 6, 7 -> "H";
            default -> "W";
        };
        return (!dateType.equals("H")) ? new WeekDay(date.toString(), dayOfWeek, dateType, "text", "1234") : new Day(date.toString(), dayOfWeek, dateType, "text");
    }
}
