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

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Objects;

/**
 *
 * @author Antonio
 */
public class ContoBancario implements Serializable {
    
    private static final long serialVersionUID = -2886419301638293782L;
    
    protected String numeroConto;
    protected double saldo;
    
    private static int contiAttivi = 0;
    
    public ContoBancario(String numeroConto) {
        this(numeroConto, 0.0d);
    }
    
    public ContoBancario(String numeroConto, double saldo) {
        this.numeroConto = numeroConto;
        this.saldo = saldo;
        
        contiAttivi++;
    }
    
    public String getNumeroConto() {
        return numeroConto;
    }
    
    public void setNumeroConto(String numeroConto) {
        this.numeroConto = numeroConto;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public static int contiAttivi() {
        return contiAttivi;
    }
    
    public void deposita(double ammontare) {
        saldo += ammontare;
    }
    
    public boolean preleva(double ammontare) {
        if(ammontare > saldo)
            return false;
        
        saldo -= ammontare;
        
        return true;
    }
    
    @Override
    protected void finalize() throws Throwable {
        try {
            contiAttivi--;
        } finally {
            super.finalize();
        }
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(numeroConto);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ContoBancario cb = (ContoBancario) obj;
        
        return Double.doubleToLongBits(saldo) == Double.doubleToLongBits(cb.saldo);
    }
    
    @Override
    public String toString() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        DecimalFormat format = new DecimalFormat("0.00", symbols);
        
        StringBuilder builder = new StringBuilder();
        builder.append("numero conto: ");
        builder.append(numeroConto);
        builder.append(", saldo: ");
        builder.append(format.format(saldo));
        
        return builder.toString();
    }
}
