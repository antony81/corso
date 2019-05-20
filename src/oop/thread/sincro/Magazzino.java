/*
 * Copyright (C) 2019 Antonio
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
package oop.thread.sincro;

/**
 *
 * @author Antonio
 * @param <E>
 */
public abstract class Magazzino<E> {
    
    static int ingressiP = 0;
    static int ingressiC = 0;
    
    public abstract void aggiungi(E element) throws InterruptedException;
    
    public abstract E preleva() throws InterruptedException;
    
}
