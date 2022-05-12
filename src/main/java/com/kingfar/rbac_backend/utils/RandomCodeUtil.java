package com.kingfar.rbac_backend.utils;

import java.util.Random;

/**
 * @author ZKH
 */
public class RandomCodeUtil {

    public static String generateRandomUID(int length) {
        String str = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<length; i++){
            int number = random.nextInt(10);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

}
