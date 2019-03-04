package fr.miage.master1.tp2.exo1;

import java.awt.*;
import java.lang.reflect.Field;
import java.util.Arrays;

public class GenericToString {
    public String toString(Object obj, int profondeur) throws IllegalAccessException,IllegalArgumentException, NoSuchFieldException {
        String res = "";
        Class cl = obj.getClass();
        res += cl +"[";
        Field f[] = cl.getDeclaredFields();
        for (Field field : f) {
            Field fild = cl.getDeclaredField(field.getName());
            fild.setAccessible(true);
            //System.out.println(field.getName() + " " + fild.get(obj).getClass().isPrimitive());
            if (fild.get(obj).getClass().isPrimitive() && profondeur == 1) {
                res += fild.getName() + " = " + fild.get(obj) + ";";
            } else if (fild.get(obj).getClass().isArray()) {
                toString(fild.get(obj), profondeur - 1);
            } else {

                Object items[] = (Object[]) fild.get(obj);
                //System.out.println("*****" + items.toString());
                res += field.getName() + " = " + Arrays.toString(items) + "; ";
            }
        }
        res += "]";
        return res;
    }

    public static void main (String[] args) throws NoSuchFieldException,IllegalArgumentException, IllegalAccessException {

        //System.out.println(new GenericToString().toString(new Point(12,24)));

        Polygon pol = new Polygon(new int[]{10, 20, 30}, new int[]{20,30, 40}, 3);
        pol.getBounds();
        System.out.println(new GenericToString().toString(pol, 2));
    }
}
