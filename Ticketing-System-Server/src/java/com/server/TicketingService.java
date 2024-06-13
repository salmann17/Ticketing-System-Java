/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.server;

import Model.MyModel;
import Model.User;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Salman Alfarizi
 */
@WebService(serviceName = "TicketingService")
public class TicketingService extends MyModel{

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
    @WebMethod(operationName = "userLogin")
    public ArrayList userLogin() {
        try {
            //TODO write your implementation code here:
            ArrayList<Object> userData = new ArrayList<Object>();
            this.statement = (Statement) MyModel.conn.createStatement();
            this.result = this.statement.executeQuery("select * from users");
            while (this.result.next())
            {
                User tampung = new User(this.result.getInt("id"),
                        this.result.getString("username"),
                        this.result.getString("password"),
                        this.result.getDouble("saldo"), 
                        this.result.getString("no_telp"),
                        this.result.getString("email"));
                userData.add(tampung);
            }
            return userData;
        } catch (SQLException ex) {
            Logger.getLogger(TicketingService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
