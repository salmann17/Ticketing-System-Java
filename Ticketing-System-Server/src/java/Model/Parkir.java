/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author natha
 */
public class Parkir{

    private int id;
    private String nama;
    private String lokasi;    
    private ArrayList<Slot_Parkir> slot_parkir;
    
    public Parkir(int id, String nama, String lokasi, ArrayList<Slot_Parkir> slotParkir ) {
        this.id = id;
        this.nama = nama;
        this.lokasi = lokasi;        
        this.slot_parkir = slotParkir;
    }
    
    public Parkir() {
        this.id = 0;
        this.nama = "";
        this.lokasi = "";        
        this.slot_parkir = new ArrayList<>();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
    
    public ArrayList<Slot_Parkir> getSlot_parkir() {
        return slot_parkir;
    }

    public void setSlot_parkir(ArrayList<Slot_Parkir> slot_parkir) {
        this.slot_parkir = slot_parkir;
    }
    

    public static ArrayList<Parkir> viewListData() {
        ArrayList<Parkir> collections = new ArrayList<>();
        Koneksi k = new Koneksi();
        try
        {
            k.setStatement((Statement)Koneksi.getConn().createStatement());
            k.setResult(k.getStatement().executeQuery("SELECT * FROM Parkir"));
            while (k.getResult().next())
            {
                Parkir tampung = new Parkir(k.getResult().getInt("id"), 
                        k.getResult().getString("nama"), 
                        k.getResult().getString("lokasi"),                         
                        null);
                collections.add(tampung);
            }
            return collections;
          
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public void getSlotParkirData(){        
        Koneksi k = new Koneksi();
        try
        {                        
            k.setStatement(Koneksi.getConn().prepareStatement("SELECT kode,harga FROM slot_parkir where parkir_id = ?"));
            PreparedStatement sql = (PreparedStatement)k.getStatement() ;
            sql.setInt(1, this.id);
            k.setResult(sql.executeQuery());
            while (k.getResult().next())
            {
                Slot_Parkir temp = new Slot_Parkir(this, k.getResult().getString("kode"), k.getResult().getDouble("harga"));
                this.getSlot_parkir().add(temp);
            }                      
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }        
    }



}
