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
package oop.matematica.geometria;

import java.util.Objects;

/**
 *
 * @author Antonio
 */
public class Punto2D {
    
    private double x;
    private double y;

    public Punto2D() {
        x = 1;
        y = 1;
    }

    public Punto2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    public double distanza(Punto2D p) {
        double deltaX = Math.pow(p.x - x, 2);
        double deltay = Math.pow(p.y - y, 2);
        
        return Math.sqrt(deltaX + deltay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Punto2D p = (Punto2D) obj;
        
        return this.x == p.x && this.y == p.y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    
}
