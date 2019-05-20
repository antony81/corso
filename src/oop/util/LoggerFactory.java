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
package oop.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author Antonio
 */
public final class LoggerFactory {
    
    private LoggerFactory() {
    }
    
    public static <T> Logger getLogger(Class<T> className) {
        String name = className.getSimpleName();
        Logger logger = Logger.getLogger(name);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
        StringBuilder builder = new StringBuilder();
        builder.append("./src/oop/log/");
        builder.append(name.toLowerCase());
        builder.append('_');
        builder.append(dateFormat.format(Calendar.getInstance().getTime()));
        builder.append(".log");
        
        try {
            FileHandler fileHandler = new FileHandler(builder.toString(), true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.log(Level.INFO, "start logger");
        } catch (SecurityException | IOException ex) {
            logger.log(Level.SEVERE, "Errore accesso al disco per l'handler\n", ex);
        }   
        
        return logger;
    }
    
}
