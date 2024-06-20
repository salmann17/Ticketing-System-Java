/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author natha
 */
public class Posisi{

    private int id;
    private String nomor;
    private double harga;
    private Parkir parkir;
    
    public Posisi(int id, String nomor, double harga, Parkir parkir) {
        this.id = id;
        this.nomor = nomor;
        this.harga = harga;
        this.parkir = parkir;
    }
    
    public Posisi(int id, String nomor, double harga) {
        this.id = id;
        this.nomor = nomor;
        this.harga = harga;
        this.parkir = new Parkir();
    }
    
    public Posisi() {
        this.id = 0;
        this.nomor = "";
        this.harga = 0.0;
        this.parkir = new Parkir();
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
     * @return the nomor
     */
    public String getNomor() {
        return nomor;
    }

    /**
     * @param nomor the nomor to set
     */
    public void setNomor(String nomor) {
        this.nomor = nomor;
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

    /**
     * @return the parkir
     */
    public Parkir getParkir() {
        return parkir;
    }

    /**
     * @param parkir the parkir to set
     */
    public void setParkir(Parkir parkir) {
        this.parkir = parkir;
    }
    public static Posisi findById(int id) {
        Koneksi a = new Koneksi();
        try {
            a.setStatement( Koneksi.getConn().prepareStatement("SELECT * FROM posisi WHERE id = ?"));
            PreparedStatement sql = (PreparedStatement)a.getStatement();
            sql.setInt(1, id);
            a.setResult(sql.executeQuery());
            if (a.getResult().next()) {
                Posisi posisi = new Posisi(a.getResult().getInt("id"), a.getResult().getString("nomor"), a.getResult().getDouble("harga"));
                return posisi;
            }
        } catch (Exception ex) {
            System.out.println("failed because : " + ex.getMessage());
        }
        return null;
    }
    
    public void insertData() {
        try{
            Koneksi a = new Koneksi();
            if (!Koneksi.getConn().isClosed()){
                a.setStatement(Koneksi.getConn().prepareStatement(
                "Insert into users(nomor, harga, parkir_id) values (?,?,?)"));
                PreparedStatement sql = (PreparedStatement)a.getStatement() ;
                sql.setString(1, getNomor());
                sql.setDouble(2, getHarga());
                sql.setInt(3, parkir.getId());
                sql.executeUpdate();
                sql.close();
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
