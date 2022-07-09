package com.moskot.weekDaysAPI;

import com.moskot.weekDaysAPI.responces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public")
public class WeekDaysPublicAPIsController {
    private final DateChecker dc;

    @Autowired
    public WeekDaysPublicAPIsController(DateChecker dc) {
        this.dc = dc;
    }

    @GetMapping(value = "/getWeekDay", params = "date")
    ResponseTemplate getWeekDays(@RequestParam String date) {

        return dc.checkDate(date);
    }

    @GetMapping(value = "/getWeekDay", params = {"dateTo", "dateFrom"})
    ResponseEntity<List<ResponseTemplate>> getWeekDays(@RequestParam String dateFrom,
                                                       @RequestParam String dateTo) {
        List<ResponseTemplate> responseTemplates = dc.checkPeriod(dateFrom, dateTo);
        return new ResponseEntity<>(responseTemplates, HttpStatus.OK);
    }
}
