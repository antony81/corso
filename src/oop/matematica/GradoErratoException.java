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
package oop.matematica;

/**
 * Classe che estende 'RuntimeException' per rappresentare una eccezione
 * personalizzata (una 'Unchecked Exception'), la quale indica che un monomio
 * non può essere addizionato al polinomio se esso supera il grado scelto
 * in fase di creazione.
 * Ad esempio un polinomio di secondo grado non può accettare monomi di grado
 * superiore.
 *
 * @author Antonio
 * @see RuntimeException
 */
public class GradoErratoException extends RuntimeException {

    private static final long serialVersionUID = 3L;

    /**
     * Metodo costruttore di default
     */
    public GradoErratoException() {
    }
    
}
