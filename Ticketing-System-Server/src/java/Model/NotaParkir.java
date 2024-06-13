/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.User;
import Model.MyModel;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author natha
 */
public class NotaParkir extends MyModel{

    private int id;
    private Posisi posisi;
    private User User;
    private Timestamp tglReservasi;
    private Timestamp tglFinish;
    private double harga;
    
    public NotaParkir(int id, Posisi posisi, User User, Timestamp tglReservasi, Timestamp tglFinish, double harga) {
        this.id = id;
        this.posisi = posisi;
        this.User = User;
        this.tglReservasi = tglReservasi;
        this.tglFinish = tglFinish;
        this.harga = harga;
    }

    public NotaParkir() {
        this.id = 0;
        this.posisi = new Posisi();
        this.User = new User();
        this.tglReservasi = new Timestamp(new Date().getTime());
        this.tglFinish = new Timestamp(new Date().getTime());
        this.harga = 0.0;
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
     * @return the posisi
     */
    public Posisi getPosisi() {
        return posisi;
    }

    /**
     * @param posisi the posisi to set
     */
    public void setPosisi(Posisi posisi) {
        this.posisi = posisi;
    }

    /**
     * @return the User
     */
    public User getUser() {
        return User;
    }

    /**
     * @param User the User to set
     */
    public void setUser(User User) {
        this.User = User;
    }

    /**
     * @return the tglReservasi
     */
    public Timestamp getTglReservasi() {
        return tglReservasi;
    }

    /**
     * @param tglReservasi the tglReservasi to set
     */
    public void setTglReservasi(Timestamp tglReservasi) {
        this.tglReservasi = tglReservasi;
    }

    /**
     * @return the tglFinish
     */
    public Timestamp getTglFinish() {
        return tglFinish;
    }

    /**
     * @param tglFinish the tglFinish to set
     */
    public void setTglFinish(Timestamp tglFinish) {
        this.tglFinish = tglFinish;
    }

    /**
     * @return the harga
     */
    public double getHarga() {
        return harga;
    }

    /**
     * @param harga the harga to set
     */
    public void setHarga(double harga) {
        this.harga = harga;
    }
    
    public void insertData() {
        try{
            if (!MyModel.conn.isClosed()){
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                "Insert into parkirs(posisi_id, users_id, tgl_reservasi, tgl_finish, harga) values (?,?,?,?,?)");
                sql.setInt(1, getPosisi().getId());
                sql.setInt(2, getUser().getId());
                sql.setTimestamp(3, getTglReservasi());
                sql.setTimestamp(4, getTglFinish());
                sql.setDouble(5, getHarga());
                sql.executeUpdate();
                sql.close();
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    
}
