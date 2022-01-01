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

        DatagramSocket server=new DatagramSocket(8888);
        System.out.println("Server đang chạy");
        while(true){
            byte keyArr[]=new byte[800000];
            byte codeArr[]=new byte[800000];
            DatagramPacket dinCode=new DatagramPacket(codeArr,codeArr.length);
            server.receive(dinCode);
            DatagramPacket dinKey=new DatagramPacket(keyArr,keyArr.length);
            server.receive(dinKey);
            String key=new String(dinKey.getData(),0,dinKey.getLength()).trim();
            String code=new String(dinCode.getData(),0,dinCode.getLength()).trim();

            String raw=func.decode(code, key);
            CQ cq=func.findMostChar(raw);

            byte cArr[]=new byte[800000];
            byte qArr[]=new byte[800000];
            cArr=cq.getC().getBytes();
            DatagramPacket doutC=new DatagramPacket(cArr,cArr.length, dinKey.getAddress(),dinKey.getPort());
            server.send(doutC);
            qArr=String.valueOf(cq.getQ()).getBytes();
            DatagramPacket doutQ=new DatagramPacket(qArr,qArr.length, dinKey.getAddress(),dinKey.getPort());
            server.send(doutQ);
            System.out.println(code+" "+key+" "+cq.getC()+" "+cq.getQ());
               
        }
    }
    
}
