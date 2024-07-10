/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.server;

import Model.Acara;
import Model.History_Transaksi;
import Model.Jam_Parkir;
import Model.NotaAcara;
import Model.NotaParkir;
import Model.Parkir;
import Model.Slot_Parkir;
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
    

    
    @WebMethod(operationName = "getAcaraByNama")
    public Acara getAcaraByNama(@WebParam(name = "nama") String nama) {
        //TODO write your implementation code here:
        Acara a= Acara.findByName(nama);
        return a;
    }
    @WebMethod(operationName = "getParkir")
    public Parkir[] getParkir() {
        ArrayList<Parkir> listParkir = Parkir.viewListData();
        Parkir[] arrParkir = new Parkir[listParkir.size()];
        
        listParkir.toArray(arrParkir);
        
        return arrParkir;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getSlotParkir")
    public Slot_Parkir[] getSlotParkir(@WebParam(name = "idParkir") int idParkir) {
        Parkir parkir = new Parkir();
        parkir.setId(idParkir);
        parkir.getDataSlotParkir();
        ArrayList<Slot_Parkir> listSlotParkir = parkir.getDataSlotParkir();
        
        Slot_Parkir[] arrSlotParkir = new Slot_Parkir[listSlotParkir.size()];
        listSlotParkir.toArray(arrSlotParkir);
        return arrSlotParkir;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getJam_Parkir")
    public Jam_Parkir[] getJam_Parkir() {
        //TODO write your implementation code here:
        ArrayList<Jam_Parkir> listJamParkir = Jam_Parkir.viewListData();
        Jam_Parkir[] arrJamParkir = new Jam_Parkir[listJamParkir.size()];
        
        listJamParkir.toArray(arrJamParkir);
        
        return arrJamParkir;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "TambahNotaParkir")
    public boolean TambahNotaParkir(@WebParam(name = "idUser") int idUser, @WebParam(name = "tanggal_booking") String tanggal_booking, @WebParam(name = "parkir_id") int parkir_id, @WebParam(name = "slot_parkir_kode") String slot_parkir_kode, @WebParam(name = "jam_parkir_id") int jam_parkir_id) {
        //TODO write your implementation code here:
        NotaParkir np = new NotaParkir(0, "", User.findById(idUser), tanggal_booking, Slot_Parkir.findByKodeIdParkir(parkir_id, slot_parkir_kode), Jam_Parkir.findById(jam_parkir_id),0.0);
        return np.insertData();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "dataHistoryTransaksi")
    public History_Transaksi[] dataHistoryTransaksi(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        System.out.println("Menerima permintaan untuk user ID: " + id);

        ArrayList<History_Transaksi> listTransaksi = User.DataHistoryTransaksi(id);

        if (listTransaksi == null) {
            System.out.println("Tidak ada transaksi ditemukan untuk user ID: " + id);
            return new History_Transaksi[0]; // Kembalikan array kosong jika tidak ada transaksi
        }

        System.out.println("Menemukan " + listTransaksi.size() + " transaksi untuk user ID: " + id);

        History_Transaksi[] arrTransaksi = new History_Transaksi[listTransaksi.size()];
        listTransaksi.toArray(arrTransaksi);

        return arrTransaksi;
//        ArrayList<History_Transaksi> listTransaksi = User.DataHistoryTransaksi(id);
//        History_Transaksi[] arrTransaksi = new History_Transaksi[listTransaksi.size()];
//        
//        listTransaksi.toArray(arrTransaksi);
//        
//        return arrTransaksi;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "TambahNotaAcara")
    public NotaAcara TambahNotaAcara(@WebParam(name = "idUser") int idUser, @WebParam(name = "idAcara") int idAcara, @WebParam(name = "jumlah") int jumlah) {
        //TODO write your implementation code here:
        NotaAcara na = new NotaAcara();
        na.setAcara(Acara.findById(idAcara));
        na.setUser(User.findById(idUser));
        na.setJumlah(jumlah);
        na.setHarga(jumlah*na.getAcara().getHarga());
        boolean status = na.insertData();
        if (status==true)
        {
            return na;
        }
        return new NotaAcara();
    }
    @WebMethod(operationName = "TambahTopUp")
    public Boolean TambahTopUp(@WebParam(name = "jumlah") double jumlah, @WebParam(name = "users_id") int users_id, @WebParam(name = "is_topup") boolean is_topup) {
        //TODO write your implementation code here:
        History_Transaksi ht = new History_Transaksi(jumlah,User.findById(users_id),is_topup);
        return ht.topUpSaldo();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ClaimTicket")
    public Boolean ClaimTicket(@WebParam(name = "userId") int userId) {
        //TODO write your implementation code here:
        boolean isClaim = NotaAcara.ClaimTicket(userId);
        return isClaim;
    }
    
    
}
