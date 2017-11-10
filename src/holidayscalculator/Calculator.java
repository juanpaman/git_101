/*
 * This is the text that should be here.
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * This is something to merge.
 */
package holidayscalculator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author dmacchi
 */
public class Calculator {
    private List<Holiday> _holidays;
    
    Calculator() throws ParseException{
        _holidays = new ArrayList<Holiday>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        _holidays.add(new Holiday("Rosh Hashana", sdf.parse("2013-09-05"), sdf.parse("2013-09-06")));
        _holidays.add(new Holiday("Yom Kippur", sdf.parse("2013-09-14")));
        _holidays.add(new Holiday("Sukkot", sdf.parse("2013-09-19"), sdf.parse("2013-09-25")));
        _holidays.add(new Holiday("Shemini Atzeret", sdf.parse("2013-09-26")));
        _holidays.add(new Holiday("Simkhat Torah", sdf.parse("2013-09-27")));
        _holidays.add(new Holiday("Chanukah", sdf.parse("2013-11-28"), sdf.parse("2013-12-5")));
        
        _holidays.add(new Holiday("Año Nuevo", sdf.parse("2013-01-01")));
        _holidays.add(new Holiday("Reyes", sdf.parse("2013-01-06")));
        _holidays.add(new Holiday("Desembarco de los 33 Orientales", sdf.parse("2013-04-19")));
        _holidays.add(new Holiday("Día de los Trabajadores", sdf.parse("2013-05-01")));
        _holidays.add(new Holiday("Batalla de las Piedras", sdf.parse("2013-05-18")));
        _holidays.add(new Holiday("Natalicio de Artigas", sdf.parse("2013-06-19")));
        _holidays.add(new Holiday("Jura de la Constitución", sdf.parse("2013-07-18")));
        _holidays.add(new Holiday("Día de la Independencia", sdf.parse("2013-08-25")));
        _holidays.add(new Holiday("Día de la Raza", sdf.parse("2013-10-12")));
        _holidays.add(new Holiday("Día de los Difuntos", sdf.parse("2013-11-02")));
        _holidays.add(new Holiday("Navidad", sdf.parse("2013-12-25")));
        
        Collections.sort(_holidays, new HolidayComparator());
    }

    /**
     * @return the _holidays
     */
    public List<Holiday> getHolidays() {
        return _holidays;
    }
    
    public Holiday getNextHoliday(Date selectedDate){
        for(Holiday h: _holidays){
            if (h.getStartDate().after(selectedDate))
                return h;
        }
        
        return null;
    }
    
    public int getDaysToNextHoliday(Date selectedDate){
        Holiday nextHoliday = getNextHoliday(selectedDate);
        return daysBetween(selectedDate, nextHoliday.getStartDate());
    }
    
    private int daysBetween(Date d1, Date d2){
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60000 * 60 * 1440));
    }
    
    protected class HolidayComparator implements Comparator<Holiday> {
        @Override
        public int compare(Holiday o1, Holiday o2) {
            return o1.getStartDate().compareTo(o2.getStartDate());
        }
    }
}
