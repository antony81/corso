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

import java.time.LocalDate;

/**
 *
 * @author Antonio
 */
public class Autore extends Persona {
    
    private String materia;

    public Autore(String codiceFiscale, String nome, String cognome, LocalDate dataNascita, String luogoNascita, String provinciaNascita, char sesso, String materia) {
        super(codiceFiscale, nome, cognome, dataNascita, luogoNascita, provinciaNascita, sesso);
        
        this.materia = materia;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(", materia: ").append(materia);
        
        return builder.toString();
    }
    
}
