/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vigenere;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author Long
 */
public class Server {
    public static void main(String[] args) throws SocketException, IOException{
//        gđ 1- tạo datagramsocket server
        DatagramSocket server=new DatagramSocket(8888);
        System.out.println("Server đang chạy");
        while(true){
//        gđ 3-server nhận dữ liệu
            byte keyArr[]=new byte[800000];
            byte rawArr[]=new byte[800000];
            DatagramPacket dinKey=new DatagramPacket(keyArr,keyArr.length);
            server.receive(dinKey);
            DatagramPacket dinRaw=new DatagramPacket(rawArr,rawArr.length);
            server.receive(dinRaw);
            String key=new String(dinKey.getData(),0,dinKey.getLength()).trim();
            String raw=new String(dinRaw.getData(),0,dinRaw.getLength()).trim();
            // server xử lí dữ liệu
            String result=key+"---"+raw;
            //CQ cq=func.findMostChar(raw);
            // server gửi dữ liệu vè cho client
            byte resultArr[]=new byte[800000];
            resultArr=result.getBytes();
            DatagramPacket doutResult=new DatagramPacket(resultArr,resultArr.length, dinKey.getAddress(),dinKey.getPort());
            server.send(doutResult);
               
        }
    }
    
}
