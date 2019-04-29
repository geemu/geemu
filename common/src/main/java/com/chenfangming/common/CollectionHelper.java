package com.chenfangming.common;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

/**
 * 集合工具类
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-04-29 22:21
 */
public final class CollectionHelper {

    // ------------------------------------ isEmpty start ------------------------------------ //

    /**
     * 集合collection是否为空
     * @param collection 集合
     * @return {@code true} 如果集合collection为空或{@code null}
     */
    public static boolean isEmpty(Collection<?> collection) {
        return null == collection || collection.isEmpty();
    }

    /**
     * Map是否为空
     * @param map 集合
     * @return {@code true} 如果map为空或{@code null}
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return null == map || map.isEmpty();
    }

    /**
     * Iterable是否为空
     * @param iterable Iterable对象
     * @return {@code true} 如果iterable为{@code null}或不存在元素
     */
    public static boolean isEmpty(Iterable<?> iterable) {
        return null == iterable || isEmpty(iterable.iterator());
    }

    /**
     * Iterator是否为空
     * @param iterator Iterator对象
     * @return {@code true} 如果iterator为{@code null}或不存在元素
     */
    public static boolean isEmpty(Iterator<?> iterator) {
        return null == iterator || !iterator.hasNext();
    }

    /**
     * Enumeration是否为空
     * @param enumeration Enumeration
     * @return {@code true} 如果enumeration为{@code null}或没有元素
     */
    public static boolean isEmpty(Enumeration<?> enumeration) {
        return null == enumeration || !enumeration.hasMoreElements();
    }
    // ------------------------------------ isEmpty end ------------------------------------ //

}
