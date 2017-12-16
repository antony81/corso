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
package oop.elettronica;

/**
 *
 * @author Antonio
 */
public class Circuito {
    
    private Lampadina lampadina;
    private Batteria batteria;
    
    public Circuito(Lampadina lampadina, Batteria batteria) {
        this.lampadina = lampadina;
        this.batteria = batteria;
    }
    
    public boolean accendi() {
        if(lampadina.stato() == Stato.ACCESA)
            return false;
        
        lampadina.click();
        if(batteria.attiva()) {
            System.out.println("la durata della batteria è " + batteria.getCorrente());
        }
        
        return true;
    }
    
}
