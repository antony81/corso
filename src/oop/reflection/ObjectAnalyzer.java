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
package oop.reflection;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antonio
 */
public class ObjectAnalyzer {
    
    private final List<Object> visited;

    public ObjectAnalyzer() {
        visited = new ArrayList<>();
    }
    
    public String toString(Object obj) {
        if(obj == null)
            return null;
        if(visited.contains(obj))
            return "...";
        visited.add(obj);
        Class<?> cl = obj.getClass();
        if(cl == String.class)
            return (String) obj;
        StringBuilder builder = new StringBuilder();
        if(cl.isArray()) {
            Class<?> componentType = cl.getComponentType();
            builder.append(componentType).append("[]{");
            int n = Array.getLength(obj);
            for(int i = 0; i < n; i++) {
                if(i > 0)
                    builder.append(", ");
                Object value = Array.get(obj, i);
                if(componentType.isPrimitive())
                    builder.append(value);
                else
                    builder.append(toString(value));
            }
            return builder.append("}").toString();
        }
        
        builder.append(cl.getName());
        // inspect the fields of this class and all superclasses
        do {            
            builder.append("[");
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            // get the names and values of all fields
            for(Field f : fields) {
                if(!Modifier.isStatic(f.getModifiers())) {
                    if(!builder.toString().endsWith("["))
                        builder.append(", ");
                    builder.append(f.getName()).append("=");
                    try {
                        Object value = f.get(obj);
                        Class<?> type = f.getType();
                        if(type.isPrimitive())
                            builder.append(value);
                        else
                            builder.append(toString(value));
                    } catch (IllegalArgumentException | IllegalAccessException ex) {
                        Logger.getLogger(ObjectAnalyzer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            builder.append("]");
            cl = cl.getSuperclass();
        } while (cl != null);
        
        return builder.toString();
    }
    
}
