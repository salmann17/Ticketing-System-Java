/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.server;

import Model.Acara;
import Model.Parkir;
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

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getUserById")
    public User getUserById(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        User u = User.findById(id);
        return u;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAcara")
    public Acara[] getAcara() {
        //TODO write your implementation code here:
        ArrayList<Acara> listAcara = Acara.viewListData();
        
        
        Acara[] arrAcara = new Acara[listAcara.size()];
        
        listAcara.toArray(arrAcara);        
        
        return arrAcara;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAcaraByNama")
    public Acara getAcaraByNama(@WebParam(name = "nama") String nama) {
        //TODO write your implementation code here:
        Acara a= Acara.findByName(nama);
        return a;
    @WebMethod(operationName = "getParkir")
    public Parkir[] getParkir() {
        //TODO write your implementation code here:
        return null;
    }
    
    
    
    


}
