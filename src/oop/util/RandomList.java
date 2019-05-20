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
package oop.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Antonio
 */
public class RandomList {
    
    private static final Random RANDOM = new Random();
    
    private RandomList() {
    }
    
    public static List<Boolean> byteList() {
        int size = RANDOM.nextInt(90)+10;
        List<Boolean> list = new ArrayList<>();
        for(int i = 0; i < size; i++)
            list.add(RANDOM.nextBoolean());
        
        return list;
    }
    
    public static List<Integer> integerList() {
        int size = RANDOM.nextInt(90)+10;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < size; i++)
            list.add(RANDOM.nextInt(100)+1);
        
        return list;
    }
    
    public static List<Long> longList() {
        int size = RANDOM.nextInt(90)+10;
        List<Long> list = new ArrayList<>();
        for(int i = 0; i < size; i++)
            list.add(RANDOM.nextLong()*100+1);
        
        return list;
    }
    
    public static List<Float> floatList() {
        int size = RANDOM.nextInt(90)+10;
        List<Float> list = new ArrayList<>();
        for(int i = 0; i < size; i++)
            list.add(RANDOM.nextFloat()*100+1);
        
        return list;
    }
    
    public static List<Double> doubleList() {
        int size = RANDOM.nextInt(90)+10;
        List<Double> list = new ArrayList<>();
        for(int i = 0; i < size; i++)
            list.add(RANDOM.nextDouble()*100+1);
        
        return list;
    }
    
}
