package sk.stuba.fei.uim.oop.spring.mvcapp.zadanie3.utilities;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Datanum {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String sDate;

    public String getsDate()
    {
        return sDate;
    }
    public LocalDate getDate() {
        return date;
    }
    @Override
    public String toString()
    {
        return this.date.toString();
    }

    public void setDate(LocalDate date) {
        this.sDate = date.toString();
        this.date = date;
    }
}
