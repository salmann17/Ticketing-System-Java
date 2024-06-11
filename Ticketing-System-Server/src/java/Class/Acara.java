/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import authentication.MyModel;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author natha
 */
public class Acara extends MyModel {

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

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the kuota
     */
    public int getKuota() {
        return kuota;
    }

    /**
     * @param kuota the kuota to set
     */
    public void setKuota(int kuota) {
        this.kuota = kuota;
    }

    /**
     * @return the lokasi
     */
    public String getLokasi() {
        return lokasi;
    }

    /**
     * @param lokasi the lokasi to set
     */
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

    /**
     * @return the deskripsi
     */
    public String getDeskripsi() {
        return deskripsi;
    }

    /**
     * @param deskripsi the deskripsi to set
     */
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
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
    
    public ArrayList<Object> viewListData() {
        ArrayList<Object> collections = new ArrayList<Object>();
        try
        {
            this.statement = (Statement) MyModel.conn.createStatement();
            this.result = this.statement.executeQuery("select * from acara");
            while (this.result.next())
            {
                Acara tampung = new Acara(this.result.getInt("id"), 
                        this.result.getString("nama"), 
                        this.result.getInt("kuota"), 
                        this.result.getString("lokasi"), 
                        this.result.getTimestamp("tanggal_acara"),
                        this.result.getString("deskripsi"),
                        this.result.getDouble("harga"));
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
