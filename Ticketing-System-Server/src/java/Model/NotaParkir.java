/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.User;
import Model.Koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author natha
 */
public class NotaParkir{

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
            if (!Koneksi.getConn().isClosed()){
                Koneksi a = new Koneksi();
                a.setStatement(Koneksi.getConn().prepareStatement(
                "Insert into parkirs(posisi_id, users_id, tgl_reservasi, tgl_finish, harga) values (?,?,?,?,?)"));
                PreparedStatement sql = (PreparedStatement)a.getStatement() ;
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
    public static NotaParkir findById(int id) {
        Koneksi a = new Koneksi();
        try {
            String query = "SELECT nota_parkir.id, nota_parkir.tgl_reservasi, nota_parkir.tgl_finish, nota_parkir.harga, " +
                           "posisi.id AS posisiId, posisi.nomor, posisi.harga AS posisiHarga, " +
                           "users.id AS userId, users.username, users.password, users.saldo, users.no_telp, users.email " +
                           "FROM nota_parkir " +
                           "INNER JOIN posisi ON nota_parkir.posisi_id = posisi.id " +
                           "INNER JOIN users ON nota_parkir.users_id = users.id " +
                           "WHERE nota_parkir.id = ?";
            a.setStatement(Koneksi.getConn().prepareStatement(query));
            PreparedStatement sql = (PreparedStatement)a.getStatement();
            sql.setInt(1, id);
            a.setResult(sql.executeQuery());
            if (a.getResult().next()) {
                Posisi posisi = new Posisi(a.getResult().getInt("posisiId"), a.getResult().getString("nomor"), a.getResult().getDouble("posisiHarga"));
                User user = new User(a.getResult().getInt("userId"), a.getResult().getString("username"), a.getResult().getString("password"), a.getResult().getDouble("saldo"), a.getResult().getString("no_telp"), a.getResult().getString("email"));
                NotaParkir notaParkir = new NotaParkir(a.getResult().getInt("id"), posisi, user, a.getResult().getTimestamp("tgl_reservasi"), a.getResult().getTimestamp("tgl_finish"), a.getResult().getDouble("harga"));
                return notaParkir;
            }
        } catch (Exception ex) {
            System.out.println("failed because : " + ex.getMessage());
        }
        return null;
    }

    
}
