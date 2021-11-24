/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vigenere;

/**
 *
 * @author Long
 */
public class func {
    public static String encode(String raw,String key){//mã hóa raw ,trả về raw đã được mã hóa
        return raw+"-encode-"+key;
    }
    public static String decode(String code,String key){//giải mã code ,trả về code đã được giải mã
        return code+"-decode-"+key;
    }
    public static CQ findMostChar(String raw){// trả về kí tự xuất hiện nhiều nhất và số lần
        
        CQ cq=new CQ("X",3);
        return cq;
    }
}

