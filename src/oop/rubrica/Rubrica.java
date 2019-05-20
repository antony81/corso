/*
 * Copyright (C) 2018 Consultant
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
package oop.rubrica;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Consultant
 */
public class Rubrica {
    
    private final Map<NumeroTelefono, Contatto> contatti;

    public Rubrica() {
        contatti = new TreeMap<>();
    }
    
    public void aggiungi(NumeroTelefono num, Contatto c) {
        contatti.put(num, c);
    }
    
    public void rimuovi(NumeroTelefono num) {
        contatti.remove(num);
    }
    
    public Contatto cercaContatto(NumeroTelefono num) {
        return contatti.get(num);
    }
    
    public NumeroTelefono cercaNumeroTelefono(String nome, String cognome) {
        NumeroTelefono trovato = null;
        Set<NumeroTelefono> set = contatti.keySet();
        for(NumeroTelefono num : set) {
            Contatto c = contatti.get(num);
            if(nome != null && cognome != null && nome.equals(c.getNome()) && cognome.equals(c.getCognome())) {
                trovato = num;
                break;
            }
        }
        
        return trovato;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Set<NumeroTelefono> set = contatti.keySet();
        set.forEach((num) -> {
            Contatto c = contatti.get(num);
            builder.append(num);
            builder.append(": ");
            builder.append(c.getNome());
            builder.append(' ');
            builder.append(c.getCognome());
            builder.append("\n");
        });
        
        return builder.toString();
    }
    
}
