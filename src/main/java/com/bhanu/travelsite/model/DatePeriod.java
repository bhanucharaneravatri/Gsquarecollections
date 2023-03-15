/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bhanu.travelsite.model;
        import java.time.LocalDate;

/**
 *
 * @author charanbhanu4
 */
public class DatePeriod {
        private LocalDate start;
    private LocalDate end;

    @Override
    public String toString() {
        return "DatePeriod{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    public DatePeriod(LocalDate start, LocalDate end) {
        assert start.isBefore(end) || start.isEqual(end);
        this.start = start;
        this.end = end;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }
    
}
