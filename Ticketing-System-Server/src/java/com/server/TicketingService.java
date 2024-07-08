/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.server;

import Model.History_Transaksi;
import Model.User;
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
     * Web service operation
     */
    @WebMethod(operationName = "updateUser")
    public Boolean updateUser(@WebParam(name = "id") int id, @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "noKtp") String noTelp, @WebParam(name = "email") String email) {
        //TODO write your implementation code here:
        User u =  new User(id, username, password, noTelp, email);
        return u.updateData();        
    }


}
