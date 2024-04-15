package com.api.utils;

import org.springframework.stereotype.Service;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

@Service
public class Util {

    public static final String PRIVATE_KEY_PASSWORD ="d5C9A2bf";
    public static String encript(String decriptedString) {
        String decriptedStr = null;
        try {
            byte[] clave = PRIVATE_KEY_PASSWORD.getBytes();
            DESKeySpec key1 = new DESKeySpec(clave);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
            SecretKey key2 = factory.generateSecret(key1);
            Cipher ecipher = Cipher.getInstance("DES");
            ecipher.init(Cipher.ENCRYPT_MODE, key2);
            byte[] utf8 = decriptedString.getBytes(StandardCharsets.UTF_8);
            byte[] enc = ecipher.doFinal(utf8);
            decriptedStr = Base64.getEncoder().encodeToString(enc);
        } catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException
                 | NoSuchPaddingException | IllegalBlockSizeException
                 | BadPaddingException ex) {
            System.out.println(ex.getMessage());
        }
        return decriptedStr;
    }


}
