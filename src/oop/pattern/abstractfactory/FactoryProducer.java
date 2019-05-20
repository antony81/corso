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
package oop.pattern.abstractfactory;

/**
 *
 * @author Antonio
 */
public class FactoryProducer {
    
    public static FiguraAbstractFactory getFactory(Dimensioni scelta) {
        FiguraAbstractFactory factory = null;
        switch(scelta) {
            case TWO:
                factory = new Figura2DFactory();
                break;
            case THREE:
                factory = new Figura3DFactory();
        }
        
        return factory;
    }
    
}
