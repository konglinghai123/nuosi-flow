package com.nuosi.flow.logic.util;

import java.lang.reflect.Field;

/**
 * @author nuosi fsofs@163.com
 * @version 0.1.0
 * @name DtoUtil
 * @desc TODO
 * @date 2021/3/6 17:19
 */
public class DtoUtil {

    public static String toString(Object obj){
        if(obj!=null) {
            StringBuilder buff = new StringBuilder("[");
            Class cls = obj.getClass();
            try {
                Field[] fields = cls.getDeclaredFields(); //反射获取该对象里面的所有变量
                for (Field field : fields) {
                    field.setAccessible(true); //强制允许访问私有变量
                    Object value = null;
                    value = field.get(obj);
                    value = value == null ? "null" : value;
                    buff.append(field.getName() + "=\"" + value.toString() + "\","); //变量值装String
                }
                _toString(obj, cls.getSuperclass(), buff); // 递归
                buff.setLength(buff.length()-1);
            } catch (IllegalAccessException e) {
                //抛出异常和编码
            }

            buff.append("]");
            return buff.toString();
        }else{
            return "null";
        }
    }

    private static void _toString(Object obj, Class cls, StringBuilder buff) throws IllegalAccessException {
        Field[] fields = cls.getDeclaredFields(); //反射获取该对象里面的所有变量
        for (Field field : fields) {
            field.setAccessible(true); //强制允许访问私有变量
            Object value = null;
            value = field.get(obj);
            value = value == null ? "null" : value;
            buff.append(field.getName() + "=\"" + value.toString() + "\","); //变量值装String
        }

        if(cls.getSuperclass()!=null){
            _toString(obj, cls.getSuperclass(), buff);
            return;
        }
    }
}
