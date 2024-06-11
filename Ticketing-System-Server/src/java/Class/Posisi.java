/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import authentication.MyModel;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author natha
 */
public class Posisi extends MyModel{

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
    
    public void insertData() {
        try{
            if (!MyModel.conn.isClosed()){
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                "Insert into users(nomor, harga, parkir_id) values (?,?,?)");
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
    
    public ArrayList<Object> viewListData() {
        ArrayList<Object> collections = new ArrayList<Object>();
        try
        {
            this.statement = (Statement) MyModel.conn.createStatement();
            this.result = this.statement.executeQuery("select * from posisi");
            while (this.result.next())
            {
                Posisi tampung = new Posisi(this.result.getInt("id"), 
                        this.result.getString("nomor"), 
                        this.result.getDouble("harga"));
                tampung.parkir.setId(this.result.getInt("parkir_id"));
                collections.add(tampung);
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return collections;
    }
    
}
