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

import oop.matematica.geometria.Cubo;
import oop.matematica.geometria.Figura2D;
import oop.matematica.geometria.Figura3D;
import oop.matematica.geometria.Sfera;

/**
 * Classe che implementa l'interfaccia FiguraAbstractFactory per creare
 * una tipologia specifica di oggetti appartenenti al supertipo Figura3D.
 *
 * @author Antonio
 */
public class Figura3DFactory implements FiguraAbstractFactory {

    /**
     * Override del metodo <code>getFigura2D</code> che ritorna null.
     * L'implementazione di questo metodo non esiste perché non serve per
     * questa classe.
     * 
     * @param figura - il valore dell'enum Figure per creare una figura
     * @param args - i possibili dati di una figura
     * @return null
     */
    @Override
    public Figura2D getFigura2D(Figure figura, double... args) {
        return null;
    }
    
    /**
     * Override del metodo <code>getFigura3D</code> che ritorna un oggetto di
     * tipo Figura3D dati in input le specifiche per la creazione di esse.
     * 
     * @param figura - il valore dell'enum Figure per creare una figura
     * @param args - i possibili dati di una figura
     * @return un oggetto di tipo Figura3D
     */
    @Override
    public Figura3D getFigura3D(Figure figura, double... args) {
        Figura3D returnValue = null;
        switch(figura) {
            case SFERA:
                returnValue = new Sfera(args[0]);
                break;
            case CUBO:
                returnValue = new Cubo(args[0]);
        }
        
        return returnValue;
    }
    
}
