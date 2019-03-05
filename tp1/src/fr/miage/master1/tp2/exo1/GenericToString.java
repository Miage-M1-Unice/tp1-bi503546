package fr.miage.master1.tp2.exo1;

import java.awt.*;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;

public class GenericToString {
    public String toString(Object obj) throws IllegalAccessException, IllegalArgumentException, NoSuchFieldException {
        return  this.toString(obj, 1);
    }

    public String toString(Object obj, int profondeur) throws IllegalAccessException, IllegalArgumentException, NoSuchFieldException {
        String res = "";
        Class cl = obj.getClass();
        res += cl.getName() + "[";
        Field f[] = cl.getDeclaredFields();
        for (Field field : f) {
            Field fild = cl.getDeclaredField(field.getName());
            fild.setAccessible(true);

            //System.out.println(field.getName() + " " + fild.getType().isPrimitive());
            if (fild.getType().isPrimitive()) {
                res += fild.getName() + " = " + fild.get(obj) ;
            }
            else if (fild.get(obj).getClass().isArray()) {
                int size = Array.getLength(fild.get(obj));
                res+= fild.getName() + " = " + "{ ";
                //System.out.println(field.get(obj).getClass().getComponentType());
                for (int i = 0; i < size; i++) {
                    if (fild.get(obj).getClass().getComponentType().isPrimitive()) {
                        res+= Array.get(fild.get(obj), i);
                    } else {
                        if(profondeur > 1)
                            res += fild.getName() + " = " + toString(Array.get(fild.get(obj), i), (profondeur - 1));
                    }
                    res+=", ";
                }
                res+="}";
            }
            else if(profondeur > 1) {
                    res+=toString(fild.get(obj), (profondeur - 1));
                }
            else {
                    res+= fild.get(obj).getClass().getName();
                }
                res+="; ";

        }
        res += "]";
        return res;
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {

        System.out.println(new GenericToString().toString(new Point(12,24)));

        Polygon pol = new Polygon(new int[]{10, 20, 30}, new int[]{20, 30, 40}, 3);
        pol.getBounds();
        System.out.println(new GenericToString().toString(pol, 2));
    }
}
