/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ticket;

import java.util.*;
/**
 *
 * @author ggrr1
 */
public class ConnectPas {
    List<String> datacode = new ArrayList<>();
    List<String> contcode = new ArrayList<>();
    String content;
    
    public ConnectPas(int cp, String code, int pagecode) {
        String page = String.valueOf(pagecode);
        if(cp == 1) {
            parkListParsing paslist = new parkListParsing();
            paslist.run(code, page);

            paslist.listdata.forEach((imsi) -> {
                datacode.add(imsi);
            });

            paslist.codedata.forEach((imsi) -> {
                contcode.add(imsi);
            });
        }
        else {
            ListParsing paslist = new ListParsing();
            paslist.run(code, page);

            paslist.listdata.forEach((imsi) -> {
                datacode.add(imsi);
            });

            paslist.codedata.forEach((imsi) -> {
                contcode.add(imsi);
            });
        }
        
    }
    
    public ConnectPas(int cp, String code, String cont) {
        if(cp == 1) {
            parkInfoParsing pasinfo = new parkInfoParsing();
            pasinfo.run(code, cont);
            content = pasinfo.buf.toString();
        }
        else {
            InfoParsing pasinfo = new InfoParsing();
            pasinfo.run(code, cont);
            content = pasinfo.buf.toString();
        }
    }
}
