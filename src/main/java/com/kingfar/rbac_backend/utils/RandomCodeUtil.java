package com.kingfar.rbac_backend.utils;

import java.util.Random;

/**
 * @author ZKH
 */
public class RandomCodeUtil {

    public static String generateRandomUID(int length) {
        String str = "0123456789";
        return getString(length, str);
    }

    private static String getString(int length, String str) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++){
            int idx = random.nextInt(str.length());
            builder.append(str.charAt(idx));
        }
        return builder.toString();
    }

    public static String generateRandomCode(int length) {
        String str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return getString(length, str);
    }

}
