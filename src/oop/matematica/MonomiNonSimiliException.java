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
package oop.matematica;

/**
 * Classe che estende 'RuntimeException' per rappresentare una eccezione
 * personalizzata (una 'Unchecked Exception'), la quale indica che un monomio
 * non può essere sommato algebricamente ad un altro se gli esponenti
 * non sono uguali.
 *
 * @author Antonio
 * @see RuntimeException
 */
public class MonomiNonSimiliException extends RuntimeException {

    private static final long serialVersionUID = 2L;

    /**
     * Metodo costruttore di default
     */
    public MonomiNonSimiliException() {
    }
    
}
