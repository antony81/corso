/*
 * Copyright (C) 2018 Antonio
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
package oop.matematica.geometria;

/**
 * Interfaccia che rappresenta figure geometriche bidimensionali.
 *
 * @author Antonio
 */
public interface Figura2D extends Figura {
    
    /**
     * Metodo che ritorna il perimetro di una figura di due dimensioni
     * 
     * @return il perimetro della figura
     */
    double perimetro();
    
    /**
     * Metodo che ritorna l'area di una figura di due dimensioni
     * 
     * @return l'area della figura
     */
    double area();
    
}
