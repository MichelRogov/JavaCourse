package Reflection;

import java.lang.reflect.Array;

public class ReflectionArray {

    public static void main(String[] args) {
        int[] intArr = new int[0];

        Class<? extends int[]> clazz = intArr.getClass();
        System.out.println("isArray: " + clazz.isArray());
        System.out.println("TypeName: " + clazz.getTypeName());

        Class<?> componentType = clazz.getComponentType();
        System.out.println("componentType: " + componentType);

        System.out.println("create Array");

        float[] flArr = (float[]) Array.newInstance(float.class, 5);
        System.out.println("flArr length: " + flArr.length);
        System.out.println("flArr type name: " + flArr.getClass().getTypeName());
    }
}
