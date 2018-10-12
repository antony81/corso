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
 * Interfaccia che rappresenta figure geometriche tridimensionali.
 *
 * @author Antonio
 */
public interface Figura3D extends Figura {
    
    /**
     * Metodo che ritorna la superficie di una figura di tre dimensioni
     * 
     * @return la superficie della figura
     */
    double superficie();
    
    /**
     * Metodo che ritorna il volume di una figura di tre dimensioni
     * 
     * @return il volume della figura
     */
    double volume();
    
}
