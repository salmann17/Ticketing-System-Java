/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import authentication.MyModel;
import java.util.ArrayList;

/**
 *
 * @author natha
 */
public class Saldo extends MyModel{

    private int id;
    private double jumlah;
    private User user;
    private String keterangan;
    private NotaAcara notaAcara;
    private NotaParkir notaParkir;
    
    public Saldo(int id, double jumlah, User user, String keterangan, NotaAcara notaAcara, NotaParkir notaParkir) {
        this.id = id;
        this.jumlah = jumlah;
        this.user = user;
        this.keterangan = keterangan;
        this.notaAcara = notaAcara;
        this.notaParkir = notaParkir;
    }
    
     public Saldo() {
        this.id = 0;
        this.jumlah = 0.0;
        this.user = new User();
        this.keterangan = "";
        this.notaAcara = new NotaAcara();
        this.notaParkir = new NotaParkir(); 
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the jumlah
     */
    public double getJumlah() {
        return jumlah;
    }

    /**
     * @param jumlah the jumlah to set
     */
    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the keterangan
     */
    public String getKeterangan() {
        return keterangan;
    }

    /**
     * @param keterangan the keterangan to set
     */
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    /**
     * @return the notaAcara
     */
    public NotaAcara getNotaAcara() {
        return notaAcara;
    }

    /**
     * @param notaAcara the notaAcara to set
     */
    public void setNotaAcara(NotaAcara notaAcara) {
        this.notaAcara = notaAcara;
    }

    /**
     * @return the notaParkir
     */
    public NotaParkir getNotaParkir() {
        return notaParkir;
    }

    /**
     * @param notaParkir the notaParkir to set
     */
    public void setNotaParkir(NotaParkir notaParkir) {
        this.notaParkir = notaParkir;
    }

    
    
    
    @Override
    public void insertData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Object> viewListData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
