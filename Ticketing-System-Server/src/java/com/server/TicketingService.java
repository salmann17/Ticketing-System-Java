/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.server;

import Model.History_Transaksi;
import Model.User;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Salman Alfarizi
 */
@WebService(serviceName = "TicketingService")
public class TicketingService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getUser")
    public User[] getUser() {
        //TODO write your implementation code here:
        
        ArrayList<User> b = User.viewListData();
        User[] a = new User[b.size()];
        b.toArray(a);
        return a;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateUser")
    public Boolean updateUser(@WebParam(name = "id") int id, @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "noKtp") String noTelp, @WebParam(name = "email") String email) {
        //TODO write your implementation code here:
        User u =  new User(id, username, password, noTelp, email);
        return u.updateData();        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getSaldoHistory")
    public History_Transaksi[] getSaldoHistory(@WebParam(name = "idUser") int idUser) {
        //TODO write your implementation code here:
        ArrayList<History_Transaksi> s = History_Transaksi.viewListData();
        History_Transaksi[] a = new History_Transaksi[s.size()];
        s.toArray(a);
        return a;
    }

}
