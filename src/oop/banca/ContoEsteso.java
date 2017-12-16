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
package oop.banca;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 *
 * @author Antonio
 */
public class ContoEsteso extends ContoBancario {
    
    private static final long serialVersionUID = 9171240682087241598L;
    
    private double fido;
    
    public ContoEsteso(String numeroConto) {
        this(numeroConto, 0.0d);
    }
    
    public ContoEsteso(String numeroConto, double saldo) {
        this(numeroConto, saldo, 1000d);
    }
    
    public ContoEsteso(String numeroConto, double saldo, double fido) {
        super(numeroConto, saldo);
        
        this.fido = fido;
    }
    
    public double getFido() {
        return fido;
    }
    
    public void setFido(double fido) {
        this.fido = fido;
    }
    
    @Override
    public boolean preleva(double ammontare) {
        if(ammontare > (saldo+fido))
            return false;
        
        saldo -= ammontare;
        
        return true;
    }
    
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        ContoEsteso ce = (ContoEsteso) obj;
        if (Double.doubleToLongBits(saldo) != Double.doubleToLongBits(ce.saldo))
            return false;
        
        return Double.doubleToLongBits(fido) == Double.doubleToLongBits(ce.fido);
    }
    
    @Override
    public String toString() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        DecimalFormat format = new DecimalFormat("0.00", symbols);
        
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(", fido: ");
        builder.append(format.format(fido));
        
        return builder.toString();
    }
}
