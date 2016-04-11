package jmp.ui.form;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SearchEventForm {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date day;

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }
}
