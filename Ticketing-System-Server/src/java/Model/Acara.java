/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.Koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author natha
 */
public class Acara extends Koneksi {

    private int id;
    private String nama;
    private int kuota;
    private String lokasi;
    private Timestamp tanggalAcara;
    private String deskripsi;
    private double harga;
    
    public Acara(int id, String nama, int kuota, String lokasi, Timestamp tanggalAcara, String deskripsi, double harga) {
        this.id = id;
        this.nama = nama;
        this.kuota = kuota;
        this.lokasi = lokasi;
        this.tanggalAcara = tanggalAcara;
        this.deskripsi = deskripsi;
        this.harga = harga;
    }
    
    public Acara() {
        this.id = 0;
        this.nama = "";
        this.kuota = 0;
        this.lokasi = "";
        this.tanggalAcara = new Timestamp(new Date().getTime());
        this.deskripsi = "";
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

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }


    public int getKuota() {
        return kuota;
    }

    public void setKuota(int kuota) {
        this.kuota = kuota;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    /**
     * @return the tanggalAcara
     */
    public Timestamp getTanggalAcara() {
        return tanggalAcara;
    }

    /**
     * @param tanggalAcara the tanggalAcara to set
     */
    public void setTanggalAcara(Timestamp tanggalAcara) {
        this.tanggalAcara = tanggalAcara;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
    public void insertData() {
        try {
            Koneksi a = new Koneksi();
            if (!Koneksi.getConn().isClosed()) {                
                a.setStatement(Koneksi.getConn().prepareStatement("INSERT INTO Acara(nama, kuota, lokasi, tanggal_acara, deskripsi, harga) VALUES (?,?,?,?,?,?)"));
                PreparedStatement sql = (PreparedStatement)a.getStatement();
                sql.setString(1, nama);
                sql.setInt(2, kuota);
                sql.setString(3, lokasi);
                sql.setTimestamp(4, tanggalAcara);
                sql.setString(5, deskripsi);
                sql.setDouble(6, harga);
                sql.executeUpdate();
                sql.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public boolean updateData() {
        try {
            Koneksi a = new Koneksi();
            if (!Koneksi.getConn().isClosed()) {                
                a.setStatement(Koneksi.getConn().prepareStatement("UPDATE Acara SET nama = ?, kuota = ?, lokasi = ?, tanggal_acara = ?, deskripsi = ?, harga = ? WHERE id = ?")) ;
                PreparedStatement sql = (PreparedStatement)a.getStatement();
                sql.setString(1, nama);
                sql.setInt(2, kuota);
                sql.setString(3, lokasi);
                sql.setTimestamp(4, tanggalAcara);
                sql.setString(5, deskripsi);
                sql.setDouble(6, harga);
                sql.setInt(7, id);
                int rowAffected = sql.executeUpdate();
                sql.close();
                return rowAffected != 0;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
     public void deleteData() {
        try {
            Koneksi a = new Koneksi();
            if (!Koneksi.getConn().isClosed()) {
                a.setStatement(Koneksi.getConn().prepareStatement("DELETE FROM Acara WHERE id = ?"));
                PreparedStatement sql = (PreparedStatement)a.getStatement();
                sql.setInt(1, id);
                sql.executeUpdate();
                sql.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
     public static ArrayList<Acara> viewListData() {
        ArrayList<Acara> collections = new ArrayList<Acara>();
        Koneksi a = new Koneksi();
        try {
            a.setStatement(Koneksi.getConn().createStatement());
            a.setResult(a.getStatement().executeQuery("SELECT * FROM Acara"));
            while (a.getResult().next()) {
                Acara tampung = new Acara(a.getResult().getInt("id"),
                        a.getResult().getString("nama"),
                        a.getResult().getInt("kuota"),
                        a.getResult().getString("lokasi"),
                        a.getResult().getTimestamp("tanggal_acara"),
                        a.getResult().getString("deskripsi"),
                        a.getResult().getDouble("harga"));
                collections.add(tampung);
            }
            return collections;            
        } catch (SQLException ex) {
            System.out.println("Failed because : " + ex.getSQLState());
        }
        return null;
    }
     public static Acara findById(int id) {
        Koneksi a = new Koneksi();
        try {
            a.setStatement(Koneksi.getConn().prepareStatement("SELECT * FROM Acara WHERE id = ?"));
            PreparedStatement sql = (PreparedStatement)a.getStatement();
            sql.setInt(1, id);
            a.setResult(sql.executeQuery());
            if (a.getResult().next()) {
                Acara acara = new Acara(a.getResult().getInt("id"), a.getResult().getString("nama"), a.getResult().getInt("kuota"), a.getResult().getString("lokasi"), a.getResult().getTimestamp("tanggal_acara"), a.getResult().getString("deskripsi"), a.getResult().getDouble("harga"));
                return acara;
            }
        } catch (SQLException ex) {
            System.out.println("Failed because : " + ex.getMessage());
        }
        return null;
    }
}
