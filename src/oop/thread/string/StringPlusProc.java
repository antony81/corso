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
package oop.thread.string;

/**
 *
 * @author Antonio
 */
public class StringPlusProc implements Runnable {
    
    private long time;
    private String str;

    public StringPlusProc() {
        time = 0;
        str = "";
    }

    public long getTime() {
        return time;
    }

    public String getStr() {
        return str;
    }

    @Override
    public void run() {
        System.out.println("start test for plus operator");
        long start = System.currentTimeMillis();
        
        for(int i = 0; i < 100000; i++)
            str += "*";
        
        long end = System.currentTimeMillis();
        time = end-start;
        System.out.println("end test for plus operator");
    }
    
}
