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
package oop.main;

import java.util.Scanner;
import oop.reflection.DescribeClass;

/**
 *
 * @author Antonio
 */
public class TestDescribeClass {
    
    public static void main(String[] args) {
        String name;
        if(args.length == 1)
            name = args[0];
        else {
            System.out.println("Error! Enter Class name (e.g. java.lang.Double).");
            try (Scanner scanner = new Scanner(System.in)) {
                name = scanner.next();
            }
        }
        System.out.println();
        DescribeClass.print(name);
    }
    
}
