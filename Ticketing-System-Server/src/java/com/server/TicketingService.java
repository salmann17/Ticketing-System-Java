/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.server;

import Model.Acara;
import Model.History_Transaksi;
import Model.Jam_Parkir;
import Model.Parkir;
import Model.Slot_Parkir;
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
    @WebMethod(operationName = "getHistoryTransaksi")
    public History_Transaksi[] getHistoryTransaksi() {
        //TODO write your implementation code here:
        ArrayList<History_Transaksi> listHistory = User.DataHistoryTransaksi();
        
        History_Transaksi[] arrTransaksi = new History_Transaksi[listHistory.size()];
        
        listHistory.toArray(arrTransaksi);
        
        return arrTransaksi;
    }
    
    @WebMethod(operationName = "getAcaraByNama")
    public Acara getAcaraByNama(@WebParam(name = "nama") String nama) {
        //TODO write your implementation code here:
        Acara a= Acara.findByName(nama);
        return a;
    }
    @WebMethod(operationName = "getParkir")
    public Parkir[] getParkir() {
        ArrayList<Parkir> listParkir = Parkir.viewListData();
        
        return (Parkir[])(listParkir.toArray());
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getSlotParkir")
    public Slot_Parkir[] getSlotParkir(@WebParam(name = "idParkir") int idParkir) {
        Parkir parkir = new Parkir();
        parkir.setId(idParkir);
        parkir.getDataSlotParkir();
        return (Slot_Parkir[])(parkir.getSlot_parkir().toArray());
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getJam_Parkir")
    public Jam_Parkir[] getJam_Parkir() {
        //TODO write your implementation code here:
        return (Jam_Parkir[])(Jam_Parkir.viewListData().toArray());
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "TambahNotaParkir")
    public boolean TambahNotaParkir(@WebParam(name = "idUser") int idUser, @WebParam(name = "tanggal_booking") String tanggal_booking, @WebParam(name = "parkir_id") int parkir_id, @WebParam(name = "slot_parkir_kode") String slot_parkir_kode, @WebParam(name = "jam_parkir_id") int jam_parkir_id) {
        //TODO write your implementation code here:
        return false;
    }
    
    
}
