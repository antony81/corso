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
package esercitazioni.a_variabili;

/**
 *
 * @author Antonio
 */
public class InfoSistema {
    
    public static void stampaInfo() {
        System.out.println("file.separator = " + System.getProperty("file.separator") );
        System.out.println("java.class.path = " + System.getProperty("java.class.path") );
        System.out.println("java.class.version = " + System.getProperty("java.class.version") );
        System.out.println("java.home = " + System.getProperty("java.home") );
        System.out.println("java.version = " + System.getProperty("java.version") );
        System.out.println("java.vendor = " + System.getProperty("java.vendor") );
        System.out.println("java.vendor.url = " + System.getProperty("java.vendor.url") );
        System.out.println("os.name = " + System.getProperty("os.name") );
        System.out.println("os.arch = " + System.getProperty("os.arch") );
        System.out.println("os.version = " + System.getProperty("os.version") );
        System.out.println("path.separator = " + System.getProperty("path.separator") );
        System.out.println("user.dir = " + System.getProperty("user.dir") );
        System.out.println("user.home = " + System.getProperty("user.home") );
        System.out.println("user.name = " + System.getProperty("user.name") );
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        stampaInfo();
    }
    
}
