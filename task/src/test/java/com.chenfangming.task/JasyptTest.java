package com.chenfangming.task;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/**
 * 加密器
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-05-04 10:27
 */
public class JasyptTest {

    public static void main(String[] args) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("chenfangming");
        String encoded = encryptor.encrypt("root");
        System.out.println(encoded);
        String decoded = encryptor.decrypt(encoded);
        System.out.println(decoded);
    }

}
