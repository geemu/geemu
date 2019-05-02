package com.chenfangming.common;

/**
 * 字符工具类
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-05-02 09:31
 */
public final class CharHelper {

    /**
     * 是否空白符
     * 空白符包括空格、制表符、全角空格和不间断空格<br>
     * @param c 字符
     * @return {@code true} 如果字符串c为空格、制表符、全角空格和不间断空格
     */
    public static boolean isBlankChar(char c) {
        return isBlankChar((int) c);
    }

    /**
     * 是否空白符
     * @param c 字符
     * @return {@code true} 如果字符串c为空格、制表符、全角空格和不间断空格
     */
    public static boolean isBlankChar(int c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c) || '\ufeff' == c || '\u202a' == c;
    }

}
