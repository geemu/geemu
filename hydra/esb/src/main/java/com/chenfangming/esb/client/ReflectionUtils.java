package com.chenfangming.esb.client;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 反射工具类
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-10-21 21:26
 */
@Slf4j
public class ReflectionUtils {

    /**
     * 获取字段值
     * @param obj 对象
     * @param fieldName 字段名
     * @return 字段值
     * @throws IllegalAccessException 异常
     */
    public static Object getFieldValue(Object obj, String fieldName) throws IllegalAccessException {
        return getFieldValue(obj, getField(obj.getClass(), fieldName));
    }

    /**
     * 获取字段值
     * @param obj 对象
     * @param field 字段
     * @return 字段值
     * @throws IllegalAccessException 异常
     */
    public static Object getFieldValue(Object obj, Field field) throws IllegalAccessException {
        setAccessible(field);
        return field.get(obj);
    }

    /**
     * 查找指定类中的所有字段（包括非public字段），也包括父类和Object类的字段， 字段不存在则返回<code>null</code>
     * @param beanClass 被查找字段的类,不能为null
     * @param name 字段名
     * @return 字段
     */
    public static Field getField(Class<?> beanClass, String name) {
        final List<Field> fields = getField(beanClass, Boolean.TRUE);
        for (Field field : fields) {
            if (name.equals(field.getName())) {
                return field;
            }
        }
        return null;
    }

    /**
     * 设置方法为可访问（私有方法可以被外部调用）
     * @param <T> AccessibleObject的子类，比如Class、Method、Field等
     * @param accessibleObject 可设置访问权限的对象，比如Class、Method、Field等
     * @return 被设置可访问的对象
     */
    public static <T extends AccessibleObject> T setAccessible(T accessibleObject) {
        if (null != accessibleObject && !accessibleObject.isAccessible()) {
            accessibleObject.setAccessible(Boolean.TRUE);
        }
        return accessibleObject;
    }

    /**
     * 获取所有字段
     * @param clazz 类型
     * @param withSuperClassFields 是否包含父类 true:包含、false:不包含
     * @return 所有字段
     */
    public static List<Field> getField(Class<?> clazz, boolean withSuperClassFields) {
        List<Field> allFields = new ArrayList<>(10);
        while (null != clazz) {
            Field[] declaredFields = clazz.getDeclaredFields();
            allFields.addAll(Arrays.asList(declaredFields));
            clazz = withSuperClassFields ? clazz.getSuperclass() : null;
        }
        return allFields;
    }

    /**
     * 设置字段值
     * @param obj 对象
     * @param fieldName 字段名
     * @param value 值，值类型必须与字段类型匹配，不会自动转换对象类型
     * @throws IllegalAccessException 异常
     */
    public static void setFieldValue(Object obj, String fieldName, Object value) throws IllegalAccessException {
        final Field field = getField(obj.getClass(), fieldName);
        setFieldValue(obj, field, value);
    }

    /**
     * 设置字段值
     * @param obj 对象
     * @param field 字段
     * @param value 值，值类型必须与字段类型匹配，不会自动转换对象类型
     * @throws IllegalAccessException 异常
     */
    public static void setFieldValue(Object obj, Field field, Object value) throws IllegalAccessException {
        setAccessible(field);
        field.set(obj, value);
    }

}
