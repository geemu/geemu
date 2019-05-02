package com.chenfangming.common;

/**
 * 字符串工具类
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-04-29 22:03
 */
public final class StringHelper {

    /**
     * 检查一个数组是否为空或{@code null}
     * @param text 要检查的字符串
     * @return {@code true} 如果字符串为空或{@code null}
     */
    public static boolean isEmpty(CharSequence text) {
        return null == text || 0 == text.length();
    }

    /**
     * 检查一个数组是否为为空或不为{@code null}
     * @param text 要检查的字符串
     * @return {@code true} 如果字符串不为空或不为{@code null}
     */
    public static boolean isNotEmpty(CharSequence text) {
        return !isEmpty(text);
    }

    /**
     * 字符串text是否以给定字符ch开始
     * @param text 字符串
     * @param ch 字符
     * @return {@code true} 如果字符串text以给定字符ch开始
     */
    public static boolean startWith(CharSequence text, char ch) {
        return ch == text.charAt(0);
    }

    /**
     * 字符串text是否以指定字符串prefix开头
     * @param text 字符串
     * @param prefix 开头字符串
     * @param isIgnoreCase 是否忽略大小写
     * @return {@code true} 如果字符串text以指定字符串prefix开头
     */
    public static boolean startWith(CharSequence text, CharSequence prefix, boolean isIgnoreCase) {
        if (null == text || null == prefix) {
            return null == text && null == prefix;
        }
        if (isIgnoreCase) {
            return text.toString().toLowerCase().startsWith(prefix.toString().toLowerCase());
        } else {
            return text.toString().startsWith(prefix.toString());
        }
    }

    /**
     * 字符串text是否以给定字符ch结尾
     * @param text 字符串
     * @param ch 字符
     * @return {@code true} 如果字符串text以给定字符ch结尾
     */
    public static boolean endWith(CharSequence text, char ch) {
        return ch == text.charAt(text.length() - 1);
    }

    /**
     * 字符串text是否以指定字符串suffix结尾
     * @param text 字符串
     * @param suffix 结尾字符串
     * @param isIgnoreCase 是否忽略大小写
     * @return {@code true} 如果字符串text以指定字符串suffix结尾
     */
    public static boolean endWith(CharSequence text, CharSequence suffix, boolean isIgnoreCase) {
        if (null == text || null == suffix) {
            return null == text && null == suffix;
        }
        if (isIgnoreCase) {
            return text.toString().toLowerCase().endsWith(suffix.toString().toLowerCase());
        } else {
            return text.toString().endsWith(suffix.toString());
        }
    }

    /**
     * 字符串是否为空白
     * @param text 被检测的字符串
     * @return {@code true} 如果字符串text全部为空白或为{@code null}
     */
    public static boolean isBlank(CharSequence text) {
        int length;
        if ((null == text) || (0 == (length = text.length()))) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            // 只要有一个非空字符即为非空字符串
            if (!CharHelper.isBlankChar(text.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
