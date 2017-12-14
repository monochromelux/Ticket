/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Ticket.InfoParsing;
import Ticket.ListParsing;
import java.net.*;
import java.io.*;
import java.util.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 *
 * @author ggrr1
 */

class userThread extends Thread {
    Socket SS;
    String ID;
 
    userThread(Socket SS, String ID) {
        this.SS = SS;
        this.ID = ID;
    }
 
    @Override
    public void run() {
        try {
            while (true) {
                InputStream IS = SS.getInputStream();
                OutputStream out = SS.getOutputStream();
                byte[] bt = new byte[256];
                int size = IS.read(bt);
 
                String output = new String(bt, 0, size, "UTF-8");
                System.out.println(ID + "> " + output);
                
                ListParsing pasList = new ListParsing();
                InfoParsing pasInfo = new InfoParsing();
                
                //pasList.run(output);
                pasInfo.run("1", output); //162570
            }
        } catch (IOException e) {
            System.out.println("--" + ID + " user OUT");
        }
    }
 
}//

class connectThread extends Thread {
 
    ServerSocket MSS;
    int Count = 1;
 
    connectThread(ServerSocket MSS) {
        this.MSS = MSS;
    }
 
    @Override
    public void run() {
        try {
            while (true) {
                Socket SS = MSS.accept();
                System.out.println("--" + Count + " user login");
                InetAddress inetaddr = SS.getInetAddress();
                System.out.println(inetaddr.getHostAddress()+ " 로부터 접속했습니다.");
                String ID = inetaddr.getHostAddress();
 
                userThread ust = new userThread(SS, ID);
                ust.start();
                Count++;
            }
 
        } catch (IOException e) {
            System.out.println("--SERVER CLOSE");
        }
    }
}//

public class MultiServer {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ServerSocket MSS = null;
 
        try {
            MSS = new ServerSocket();
            MSS.bind(new InetSocketAddress(InetAddress.getLocalHost(), 4040));
 
            System.out.println("--SERVER Close : input num");
            System.out.println("--SERVER Waiting...");
            connectThread cnt = new connectThread(MSS);
            cnt.start();
 
            int temp = input.nextInt();
 
        } catch (Exception e) {
            System.out.println(e);
        }
 
        try {
            MSS.close();
        } catch (Exception e) {
            System.out.println(e);
        }
 
    }// MAIN

}
