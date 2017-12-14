/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.net.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author ggrr1
 */



public class MultiClient {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("TestDrive");
 
        Socket CS = null;
        try {
            CS = new Socket();
 
            System.out.print("Login? (enter num): ");
            int temp = input.nextInt();
 
            CS.connect(new InetSocketAddress(InetAddress.getLocalHost(), 4040));
            System.out.println("SUCCESS");
 
            while (true) {
                System.out.print("> ");
                String message = input.nextLine();
                if(message.equals("quit")) {
                    break;
                }
                byte[] as = message.getBytes("UTF-8");
                OutputStream OS = CS.getOutputStream();
                OS.write(as);
            }
 
        } catch (Exception e) {
            System.out.println(e);
        }
 
        try {
            CS.close();
        } catch (Exception e) {
            System.out.println(e);
        }
 
    }// MAIN
}
