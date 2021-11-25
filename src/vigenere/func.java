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

    public static String encode(String raw, String key) {//mã hóa raw ,trả về raw đã được mã hóa
        key = generateKey(key);
        System.out.println(key);
        String result = "";
        for (int i = 0, j = 0; i < raw.length(); i++) {
            char c = raw.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c += (int) ('A' - 'a');
            } else if (c < 'A' || c > 'Z') {
                continue;
            }
            result += (char) (((int) c + (int) key.charAt(j) - 2 * (int) 'A') % 26 + (int) 'A');
            j = (j + 1) % key.length();
        }
        return result;
    }

    public static String decode(String code, String key) {//giải mã code ,trả về code đã được giải mã
        key = generateKey(key);
        String result = "";
        for (int i = 0, j = 0; i < code.length(); ++i) {
            char c = code.charAt((i));
            if (c >= 'a' && c <= 'z') {
                c += (int) ('A' - 'a');
            } else if (c < 'A' || c > 'Z') {
                continue;
            }
            result += (char) ((int) c - (int) key.charAt(j) + 26) % 26 + (int) 'A';
            j = (j + 1) % key.length();
        }
        return result;
    }

    public static CQ findMostChar(String raw) {// trả về kí tự xuất hiện nhiều nhất và số lần
        System.out.println("raw: " + raw);
        // this is test. delete this
        raw = "hieutrungnguyenhieuheiue";

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < raw.length(); i++) {
            String x = "" + (char) raw.charAt(i);
            if (map.get(x) != null) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        }

        int max = 0;
        String str = "";
        Set<String> keySet = map.keySet();
        for (String c : keySet) {
            if (map.get(c) > max) {
                max = map.get(c);
                str = c;
            }
        }

        CQ cq = new CQ(str, max);
        return cq;
    }

    public static String generateKey(String key) {
        String res = key;
        for (int i = 0; i < key.length(); i++) {
            if (key.charAt(i) >= 'A' && key.charAt(i) <= 'Z') {
                res += (char) key.charAt(i);
            } else if (key.charAt(i) >= 'a' && key.charAt(i) <= 'z') {
                res += (char) ((int) key.charAt(i) + (int) 'A' - (int) 'a');
            }
        }
        return res;
    }
}
