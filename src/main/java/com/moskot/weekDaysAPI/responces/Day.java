package com.moskot.weekDaysAPI.responces;

import lombok.Getter;

@Getter
public class Day implements ResponseTemplate {
    private final String date;
    private final String dayOfWeek;
    private final String dateType;
    private final String textForClient;


    public Day(String date, String dayOfWeek, String dateType, String textForClient) {
        this.date = date;
        this.dayOfWeek = dayOfWeek;
        this.dateType = dateType;
        this.textForClient = textForClient;
    }
}
