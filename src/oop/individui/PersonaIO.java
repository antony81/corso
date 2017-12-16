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
package oop.individui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oop.util.LoggerFactory;

/**
 *
 * @author Antonio
 */
public class PersonaIO {
    
    private final static Logger LOGGER = LoggerFactory.getLogger(Persona.class);

    private PersonaIO() {
    }
    
    public static boolean save(Persona p) {
        boolean res = true;
        
        File file = new File("./src/oop/saves/individui/persona.txt");
        try ( FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw); ) {
            bw.append(p.getNome()).append(", ").append(p.getCognome());
            bw.newLine();
            LOGGER.log(Level.INFO, "Persona salvata");
        } catch (FileNotFoundException ex) {
            res = false;
            LOGGER.log(Level.SEVERE, "errore!", ex);
        } catch (IOException ex) {
            res = false;
            LOGGER.log(Level.SEVERE, "errore!", ex);
        }
        
        return res;
    }
    
    public static String load() {
        StringBuilder builder = new StringBuilder();
        
        File file = new File("./src/oop/saves/individui/persona.txt");
        try ( FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr); ) {
            String s;
            while((s = br.readLine()) != null)
                builder.append(s).append("\n");
            LOGGER.log(Level.INFO, "Persona caricata");
        } catch (FileNotFoundException ex) {
            LOGGER.log(Level.SEVERE, "errore!", ex);
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "errore!", ex);
        }
        
        return builder.toString();
    }
    
}
