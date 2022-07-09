package com.moskot.weekDaysAPI.responces;

import lombok.Getter;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Getter
public class WeekDay extends Day {
    private final String schedule;

    public WeekDay(String date, String dayOfWeek, String dateType, String textForClient, String schedule) {
        super(date, dayOfWeek, dateType, textForClient);
        this.schedule = schedule;
    }

}
