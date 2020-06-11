package jvm;

import java.io.FileInputStream;
import java.lang.reflect.Method;

public class TestClassLoader {


    public static void main(String[] args) throws Exception {

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> aClass = classLoader.loadClass("jvm.Base");
        Object o = aClass.newInstance();
        Method callName = aClass.getDeclaredMethod("callName", null);
        callName.invoke(o);
    }



}