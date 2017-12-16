/*
* Copyright (C) 2017 Antonio
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package oop.main;

import static java.lang.System.out;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 *
 * @author Antonio
 */
public class TestDateJ8 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        out.println("start main");
        out.println("--------------------------------------------------");
        
        localDateTime();
        out.println("--------------------------------------------------");
        
        zonedDateTime();
        out.println("--------------------------------------------------");
        
        chronoUnitsEnum();
        out.println("--------------------------------------------------");
        
        periodDuration();
        out.println("--------------------------------------------------");
        
        temporalAdjusters();
        out.println("--------------------------------------------------");
        
        compatibility();
        out.println("--------------------------------------------------");
        
        formatDate();
        out.println("--------------------------------------------------");
        
        out.println("end main");
        /*LocalDateTime ldt = LocalDateTime.of(1988, 11, 24, 10, 36, 56);
        Instant i = ldt.toInstant(ZoneOffset.UTC);
        System.out.println(Date.from(i));*/
        LocalDateTime ldt = LocalDateTime.of(1988, 5, 12, 13, 30);
        ZonedDateTime zdt = ldt.atZone(ZoneId.systemDefault());
        Instant i = zdt.toInstant();
        System.out.println(zdt);
        System.out.println(i);
        System.out.println(Date.from(i));
    }
    
    private static void localDateTime() {
        // Get the current date and time
        LocalDateTime currentTime = LocalDateTime.now();
        out.println("Current DateTime: " + currentTime);
        
        LocalDate date1 = currentTime.toLocalDate();
        out.println("date1: " + date1);
        
        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();
        out.println("month: " + month + ", day: " + day + ", seconds: " + seconds);
        
        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        out.println("date2: " + date2);
        
        //12 december 2014
        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
        out.println("date3: " + date3);
        
        //22 hour 15 minutes
        LocalTime date4 = LocalTime.of(22, 15);
        out.println("date4: " + date4);
        
        //parse a string
        LocalTime date5 = LocalTime.parse("20:15:30");
        out.println("date5: " + date5);
    }
    
    private static void zonedDateTime() {
        // Get the current date and time
        ZonedDateTime date6 = ZonedDateTime.parse("2007-12-03T10:15:30+05:30[Asia/Karachi]");
        out.println("date6: " + date6);
        
        ZoneId id = ZoneId.of("Europe/Paris");
        out.println("ZoneId: " + id);
        
        ZoneId currentZone = ZoneId.systemDefault();
        out.println("CurrentZone: " + currentZone);
    }
    
    private static void chronoUnitsEnum() {
        //Get the current date
        LocalDate today = LocalDate.now();
        out.println("Current date: " + today);
        
        //add 1 week to the current date
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        out.println("Next week: " + nextWeek);
        
        //add 1 month to the current date
        LocalDate nextMonth = today.plus(1, ChronoUnit.MONTHS);
        out.println("Next month: " + nextMonth);
        
        //add 1 year to the current date
        LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
        out.println("Next year: " + nextYear);
        
        //add 10 years to the current date
        LocalDate nextDecade = today.plus(1, ChronoUnit.DECADES);
        out.println("Date after ten year: " + nextDecade);
    }
    
    private static void periodDuration() {
        out.println("test period:");
        // Get the current date
        LocalDate date7 = LocalDate.now();
        out.println("Current date: " + date7);
        
        //add 1 month to the current date
        LocalDate date8 = date7.plus(1, ChronoUnit.MONTHS);
        out.println("Next month: " + date8);
        
        Period period = Period.between(date8, date7);
        out.println("Period: " + period);
        
        out.println("test duration:");
        LocalTime time1 = LocalTime.now();
        Duration twoHours = Duration.ofHours(3);
        
        LocalTime time2 = time1.plus(twoHours);
        out.println("time2: " + time2);
        
        Duration duration = Duration.between(time1, time2);
        out.println("Duration: " + duration);
    }
    
    private static void temporalAdjusters() {
        // Get the current date
        LocalDate date9 = LocalDate.now();
        out.println("Current date: " + date9);
        
        //get the next tuesday
        LocalDate nextTuesday = date9.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
        out.println("Next Tuesday on : " + nextTuesday);
        
        //get the second saturday of next month
        LocalDate firstInYear = LocalDate.of(date9.getYear(), date9.getMonth(), 1);
        LocalDate secondSaturday = firstInYear.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY))
                .with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        out.println("Second Saturday on : " + secondSaturday);
    }
    
    private static void compatibility() {
        //Get the current date
        Date currentDate = new Date();
        out.println("Current date: " + currentDate);
        
        //Get the instant of current date in terms of milliseconds
        Instant now = currentDate.toInstant();
        ZoneId currentZone = ZoneId.systemDefault();
        
        LocalDateTime localDateTime = LocalDateTime.ofInstant(now, currentZone);
        out.println("Local date: " + localDateTime);
        
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, currentZone);
        out.println("Zoned date: " + zonedDateTime);
    }
    
    private static void formatDate() {
        LocalDate date = LocalDate.now();
        out.printf("date: %s%n", date);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("LL d yyyy");
        String text = date.format(fmt);
        out.printf("text: %s%n", text);
        LocalDate parsedDate = LocalDate.parse(text, fmt);
        out.printf("parsedDate: %s%n", parsedDate);
    }
    
}
