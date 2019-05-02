package com.chenfangming.common;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射工具类
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-05-02 09:18
 */
@Slf4j
public final class ReflectHelper {

    /** get **/
    private static final String GET = "get";
    /** set **/
    private static final String SET = "set";


    /**
     * 获取bean中字段fieldName的值,不包括父类中的字段
     * get方法的名称即为 "get"+fieldName {@link ReflectHelper#getMethodNameGet}
     * @param bean bean
     * @param fieldName 字段名称
     * @return 值
     */
    public static Object getFieldValue(Object bean, String fieldName) {
        String methodName = GET + fieldName;
        Object value = null;
        try {
            Method method = bean.getClass().getMethod(methodName);
            value = method.invoke(bean);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            log.error("获取字段值异常:{}{}", e, "");
        }
        return value;
    }

    /**
     * 设置bean中字段fieldName的值,不包括父类中的字段
     * set方法的名称即为 "set"+fieldName {@link ReflectHelper#getMethodNameSet}
     * @param bean bean
     * @param fieldName 字段名称
     * @param value 值
     */
    public static void setFieldValue(Object bean, String fieldName, Object value) {
        String methodName = SET + fieldName;
        Class<?> parameterTypes = value.getClass();
        try {
            Method method = bean.getClass().getMethod(methodName, parameterTypes);
            method.invoke(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取字段的get方法名
     * @param fieldName 字段名称
     * @return get方法名 遵循驼峰
     */
    public static String getMethodNameGet(String fieldName) {
        return GET + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    }

    /**
     * 获取字段的set方法名
     * @param fieldName 字段名称
     * @return set方法名 遵循驼峰
     */
    public static String getMethodNameSet(String fieldName) {
        return SET + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    }

    /**
     * 获得一个类中所有字段列表,直接反射获取,无缓存
     * @param clazz 类
     * @param withSuperClassFields 是否包括父类的字段列表
     * @return 字段列表
     */
    public static Field[] getFields(Class<?> clazz, boolean withSuperClassFields) {
        Field[] fields = null;
        Field[] declaredFields;
        while (null != clazz) {
            declaredFields = clazz.getDeclaredFields();
            if (null == fields) {
                fields = declaredFields;
            } else {
                fields = ArrayHelper.append(fields, declaredFields);
            }
            clazz = withSuperClassFields ? clazz.getSuperclass() : null;
        }
        return fields;
    }


}
