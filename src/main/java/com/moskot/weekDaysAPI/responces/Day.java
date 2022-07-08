package com.moskot.weekDaysAPI.responces;

import lombok.Getter;

@Getter
public class Day implements ResponseTemplate {
    private String date;
    private String dayOfWeek;
    private String dateType;
    private String textForClient;


    public Day(String date, String dayOfWeek, String dateType, String textForClient) {
        this.date = date;
        this.dayOfWeek = dayOfWeek;
        this.dateType = dateType;
        this.textForClient = textForClient;
    }
}
