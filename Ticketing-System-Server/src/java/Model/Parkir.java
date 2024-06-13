/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.Koneksi;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author natha
 */
public class Parkir extends Koneksi{

    private int id;
    private String lokasi;
    private int kuota;
    private ArrayList<Posisi> listPosisi;
    
    public Parkir(int id, String lokasi, int kuota) {
        this.id = id;
        this.lokasi = lokasi;
        this.kuota = kuota;
    }
    
    public Parkir() {
        this.id = 0;
        this.lokasi = "";
        this.kuota = 0;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public int getKuota() {
        return kuota;
    }

    public void setKuota(int kuota) {
        this.kuota = kuota;
    }

    public ArrayList<Posisi> getListPosisi() {
        return listPosisi;
    }

    public void setListPosisi(ArrayList<Posisi> listPosisi) {
        this.listPosisi = listPosisi;
    }

    public void insertData() {
        try{
            if (!Koneksi.getConn().isClosed()){
                PreparedStatement sql = (PreparedStatement) Koneksi.getConn().prepareStatement(
                "Insert into parkir(lokasi, kuota) values (?,?)");
                sql.setString(1, getLokasi());
                sql.setInt(2, getKuota());
                sql.executeUpdate();
                sql.close();
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void updateData() {
        try{
            if (!Koneksi.getConn().isClosed()){
                PreparedStatement sql = (PreparedStatement) Koneksi.getConn().prepareStatement(
                "UPDATE `parkir` SET `lokasi` = '?', `kuota` = '?' WHERE (`id` = '?');");
                sql.setString(1, getLokasi());
                sql.setInt(2, getKuota());
                sql.setInt(3, getId());
                sql.executeUpdate();
                sql.close();
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void deleteData() {
        try{
            if (!Koneksi.getConn().isClosed()){
                PreparedStatement sql = (PreparedStatement) Koneksi.getConn().prepareStatement(
                "DELETE FROM `parkir` WHERE (`id` = '?');");
                sql.setInt(1, getId());
                sql.executeUpdate();
                sql.close();
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

//    public ArrayList<Parkir> viewListData() {
//        ArrayList<Parkir> collections = new ArrayList<Parkir>();
//        try
//        {
//            this.statement = (Statement) Koneksi.conn.createStatement();
//            this.result = this.statement.executeQuery("select * from parkir");
//            while (this.result.next())
//            {
//                Parkir tampung = new Parkir(this.result.getInt("id"), 
//                        this.result.getString("lokasi"), 
//                        this.result.getInt("kuota"));
//                collections.add(tampung);
//            }
//            
//            for (Parkir p : collections)
//            {
//                this.result = this.statement.executeQuery("select * from posisi where parkir_id='"+p.getId()+"';");
//                while (this.result.next())
//                    {
//                        Posisi tampung = new Posisi(this.result.getInt("id"), 
//                                    this.result.getString("nomor"), 
//                                    this.result.getDouble("harga"),
//                                    p);
//                        p.listPosisi.add(tampung);
//                    }
//            }
//        }
//        catch (Exception ex)
//        {
//            System.out.println(ex.getMessage());
//        }
//        return collections;
//    }
}
