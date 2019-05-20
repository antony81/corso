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

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe che stampa le caratteristiche di un'altra classe tramite il
 * meccanismo della reflection.
 *
 * @author Antonio
 */
public class DescribeClass {
    
    private static final Logger LOGGER = Logger.getLogger(DescribeClass.class.getName());
    
    private DescribeClass() {
    }
    
    public static void print(String className) {
        StringBuilder builder = new StringBuilder();
        try {
            // get the class
            Class<?> cl = Class.forName(className);
            String modifiers = Modifier.toString(cl.getModifiers()); // il metodo getModifiers() torna un intero che identifica i modificatori di cl, in questo caso
            if(modifiers.length() > 0)
                builder.append(modifiers).append(" ");
            builder.append("class ").append(className);
            
            // get the super class
            Class<?> supercl = cl.getSuperclass();
            if(supercl != null && supercl != Object.class)
                builder.append(" extends ").append(supercl.getName());
            
            // get the iterfaces if exist
            Class<?>[] interfaces = cl.getInterfaces();
            int n = interfaces.length;
            if(n > 0) {
                builder.append(" implements ");
                for(int i = 0; i < n; i++) {
                    if(i > 0)
                        builder.append(", ");
                    builder.append(interfaces[i].getName());
                }
            }
            builder.append(" {\n");
            appendFields(cl, builder);
            builder.append("\n");
            appendConstructors(cl, builder);
            builder.append("\n");
            appendMethods(cl, builder);
            builder.append("}");
        } catch (ClassNotFoundException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
            LOGGER.log(Level.SEVERE, "The Class {0} does not exist", className);
        }
        
        System.out.println(builder);
    }

    private static void appendFields(Class cl, StringBuilder builder) {
        Field[] fields = cl.getDeclaredFields();
        for(Field f : fields) {
            Class<?> type = f.getType();
            String name = f.getName();
            builder.append("  ");
            String modifiers = Modifier.toString(f.getModifiers());
            if(modifiers.length() > 0)
                builder.append(modifiers).append(" ");
            builder.append(type.getName()).append(" ").append(name).append(";\n");
        }
    }

    private static void appendConstructors(Class cl, StringBuilder builder) {
        Constructor<?>[] constructors = cl.getDeclaredConstructors();
        for(Constructor<?> c : constructors) {
            String name = c.getName();
            builder.append("  ");
            String modifiers = Modifier.toString(c.getModifiers());
            if(modifiers.length() > 0)
                builder.append(modifiers).append(" ");
            builder.append(name).append("(");
            
            // print parameter types
            Class<?>[] paramTypes = c.getParameterTypes();
            int n = paramTypes.length;
            for(int i = 0; i < n; i++) {
                if(i > 0)
                    builder.append(", ");
                builder.append(paramTypes[i].getName());
            }
            builder.append(")");
            
            // print exception types
            Class<?>[] exceptions = c.getExceptionTypes();
            n = exceptions.length;
            if(n > 0)
                builder.append(" throws ");
            for(int i = 0; i < n; i++) {
                if(i > 0)
                    builder.append(", ");
                builder.append(exceptions[i].getName());
            }
            builder.append(";\n");
        }
    }

    private static void appendMethods(Class cl, StringBuilder builder) {
        Method[] methods = cl.getDeclaredMethods();
        for(Method m : methods) {
            Class<?> returnType = m.getReturnType();
            String name = m.getName();
            builder.append("  ");
            String modifiers = Modifier.toString(m.getModifiers());
            if(modifiers.length() > 0)
                builder.append(modifiers).append(" ");
            builder.append(returnType.getName()).append(" ").append(name).append("(");
            
            // print parameter types
            Class[] paramTypes = m.getParameterTypes();
            int n = paramTypes.length;
            for(int i = 0; i < n; i++) {
                if(i > 0)
                    builder.append(", ");
                builder.append(paramTypes[i].getName());
            }
            builder.append(")");
            
            // print exception types
            Class<?>[] exceptions = m.getExceptionTypes();
            n = exceptions.length;
            if(n > 0)
                builder.append(" throws ");
            for(int i = 0; i < n; i++) {
                if(i > 0)
                    builder.append(", ");
                builder.append(exceptions[i].getName());
            }
            builder.append(";\n");
        }
    }
    
}
