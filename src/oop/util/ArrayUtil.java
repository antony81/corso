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
package oop.util;

/**
 *
 * @author Antonio
 * 
 * Classe che contiene dei metodi con algoritmi di ordinamento degli
 * array.
 */
public final class ArrayUtil {
    
    private ArrayUtil() {
    }
    
    /**
     * Metodo che sfrutta l'algoritmo del selection sort per ordinare gli
     * elementi presenti nell'array
     *
     * @param <T> - il tipo di dati per cui si vuole parametrizzare
     * @param arr - l'array (o un numero di elementi essendo un varargs) da ordinare
     */
    public static <T extends Comparable<? super T>> void selectionSort(T... arr) {
        int length = arr.length;
        for(int i = 0; i < (length-1); i++) {
            int posMin = i; // indice della posizionne del minimo valore
            for(int j = i; j < length; j++) {
                if(arr[j].compareTo(arr[posMin]) < 0)
                    posMin = j;
            }
            T tmp = arr[i];
            arr[i] = arr[posMin];
            arr[posMin] = tmp;
        }
    }
    
    /**
     * Metodo che sfrutta l'algoritmo del bubble sort per ordinare gli
     * elementi presenti nell'array
     *
     * @param <T> - il tipo di dati per cui si vuole parametrizzare
     * @param arr - l'array (o un numero di elementi essendo un varargs) da ordinare
     */
    public static <T extends Comparable<? super T>> void bubbleSort(T... arr) {
        int length = arr.length;
        for(int i = 0; i < length; i++) {
            for(int j = 1; j < (length-i); j++) {
                if(arr[j-1].compareTo(arr[j]) > 0) {
                    T tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
    
    /**
     * Metodo che sfrutta l'algoritmo del bubble sort per ordinare gli
     * elementi presenti nell'array
     *
     * @param <T> - il tipo di dati per cui si vuole parametrizzare
     * @param key - l'elemento da cercare nell'array
     * @param arr - l'array (o un numero di elementi essendo un varargs) su cui cercare
     * @return l'indice in cui è presente l'elemento che si sta cercando
     */
    public static <T extends Comparable<? super T>> int binarySearch(T key, T... arr) {
        int index = -1;
        int first = 0;
        int last = arr.length;
        int mid = last/2;
        while(index == -1 && first <= last) {
            if(key.compareTo(arr[mid]) > 0)
                first = mid+1;
            else if(key.compareTo(arr[mid]) < 0)
                last = mid-1;
            else
                index = mid;
            mid = (first+last)/2;
        }
        
        return index;
    }
    
}
