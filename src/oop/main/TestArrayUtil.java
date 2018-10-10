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

import java.util.Arrays;
import oop.util.ArrayUtil;

/**
 *
 * @author Antonio
 */
public class TestArrayUtil {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer[] arr = {7, 6, 12, 667, 33, 10, 13, 34, 4, 100};
        // ArrayUtil.selectionSort(arr);
        ArrayUtil.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("*******************************************************");
        int index = ArrayUtil.binarySearch(100, arr);
        System.out.println(index != -1 ? "element found at index " + index : "element not found");
    }
    
}
