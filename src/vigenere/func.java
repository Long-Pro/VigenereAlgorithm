/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vigenere;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Long
 */
public class func {

    public static String encode(String raw, String key) {
        raw = raw.toUpperCase();
        key = generateKey(key, raw);
        System.out.println("key: " + key);
        String result = "";
        for (int i = 0; i < raw.length(); i++) {
            int x = (raw.charAt(i) + key.charAt(i)) % 26;

            x += 'A';

            result += (char) (x);
        }
        return result;
    }

    public static String decode(String code, String key) {
        code = code.toUpperCase();
        key = generateKey(key, code);
        String result = "";
        for (int i = 0; i < code.length(); i++) {
            int x = (code.charAt(i) - key.charAt(i) + 26) % 26;

            x += 'A';
            result += (char) (x);
        }
        return result;
    }

    public static CQ findMostChar(String raw) {
        int max = 0;
        String str = "";

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < raw.length(); i++) {
            String x = "" + (char) raw.charAt(i);
            if (map.get(x) != null) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }

            int num = map.get(x);
            if (num > max) {
                max = num;
                str = x;
            }

        }

        CQ cq = new CQ(str, max);
        return cq;
    }

    public static String generateKey(String key, String str) {
        for (int i = 0;; i++) {
            if (str.length() == i) {
                i = 0;
            }
            if (key.length() == str.length()) {
                break;
            }
            key += (key.charAt(i));
        }
        return key.toUpperCase();
    }
}
