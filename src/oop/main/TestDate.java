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
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antonio
 */
public class TestDate {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        out.println("start main");
        out.println("------------------------------");
        
        GregorianCalendar c = new GregorianCalendar(1981, 8, 10);
        out.println("GregorianCalendar: " + c.getTime());
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        try {
            out.println("SimpleDateFormat: " + sdf.parse("1981/09/10"));
        } catch (ParseException ex) {
            Logger.getLogger(TestDate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Date date = new Date(c.getTimeInMillis());
        out.println("Date SQL: " + date);
        
        date = Date.valueOf("1981-09-10");
        out.println("Date SQL: " + date);
        
        out.println("------------------------------");
        out.println("end main");
    }
    
}
