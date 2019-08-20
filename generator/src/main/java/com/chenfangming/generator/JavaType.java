package com.chenfangming.generator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * com.chenfangming.generator
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-08-20 21:17
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public enum JavaType {

    // 基本类型
    BASE_BYTE("byte", null),
    BASE_SHORT("short", null),
    BASE_CHAR("char", null),
    BASE_INT("int", null),
    BASE_LONG("long", null),
    BASE_FLOAT("float", null),
    BASE_DOUBLE("double", null),
    BASE_BOOLEAN("boolean", null),

    // 包装类型
    BYTE("Byte", null),
    SHORT("Short", null),
    CHARACTER("Character", null),
    INTEGER("Integer", null),
    LONG("Long", null),
    FLOAT("Float", null),
    DOUBLE("Double", null),
    BOOLEAN("Boolean", null),
    STRING("String", null),

    // sql 包下数据类型
    DATE_SQL("Date", "java.sql.Date"),
    TIME("Time", "java.sql.Time"),
    TIMESTAMP("Timestamp", "java.sql.Timestamp"),
    BLOB("Blob", "java.sql.Blob"),
    CLOB("Clob", "java.sql.Clob"),

    // java8 新时间类型
    LOCAL_DATE("LocalDate", "java.time.LocalDate"),
    LOCAL_TIME("LocalTime", "java.time.LocalTime"),
    YEAR("Year", "java.time.Year"),
    YEAR_MONTH("YearMonth", "java.time.YearMonth"),
    LOCAL_DATE_TIME("LocalDateTime", "java.time.LocalDateTime"),
    INSTANT("Instant", "java.time.Instant"),

    // 其他杂类
    BYTE_ARRAY("byte[]", null),
    OBJECT("Object", null),
    DATE("Date", "java.util.Date"),
    BIG_INTEGER("BigInteger", "java.math.BigInteger"),
    BIG_DECIMAL("BigDecimal", "java.math.BigDecimal");

    /** 类型 **/
    private String type;
    /** 包路径 **/
    private String pkg;

}
