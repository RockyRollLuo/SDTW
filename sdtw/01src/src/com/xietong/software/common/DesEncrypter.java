package com.xietong.software.common;

import javax.crypto.*;
import com.xietong.software.util.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DesEncrypter {
    private static Log log = LogFactory.getLog(Tool.class);
    Cipher ecipher;
    Cipher dcipher;

    public DesEncrypter(SecretKey key) {
        try {
            ecipher = Cipher.getInstance("DES");
            dcipher = Cipher.getInstance("DES");
            ecipher.init(Cipher.ENCRYPT_MODE, key);
            dcipher.init(Cipher.DECRYPT_MODE, key);

        } catch (Exception e) {
        	e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public String encrypt(String str) {
        try {
            // Encode the string into bytes using utf-8
            byte[] utf8 = str.getBytes("UTF8");

            // Encrypt
            byte[] enc = ecipher.doFinal(utf8);

            // Encode bytes to base64 to get a string
            return Base64.encodeBytes(enc, false);
        } catch (Exception e) {
            log.debug(e.getMessage());
        }
        return null;
    }

    public String decrypt(String str) {
        try {
            // Decode base64 to get bytes
            byte[] dec = Base64.decode(str);

            // Decrypt
            byte[] utf8 = dcipher.doFinal(dec);

            // Decode using utf-8
            return new String(utf8, "UTF8");
        } catch (Exception e) {
            log.debug(e.getMessage());
        }
        return null;
    }
}
