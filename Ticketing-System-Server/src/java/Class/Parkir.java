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
public class Parkir extends MyModel{

    private int id;
    private String lokasi;
    private int kuota;
    
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

    @Override
    public void insertData() {
        try{
            if (!MyModel.conn.isClosed()){
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
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

    @Override
    public void updateData() {
        try{
            if (!MyModel.conn.isClosed()){
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
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

    @Override
    public void deleteData() {
        try{
            if (!MyModel.conn.isClosed()){
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
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

    @Override
    public ArrayList<Object> viewListData() {
        ArrayList<Object> collections = new ArrayList<Object>();
        try
        {
            this.statement = (Statement) MyModel.conn.createStatement();
            this.result = this.statement.executeQuery("select * from parkir");
            while (this.result.next())
            {
                Parkir tampung = new Parkir(this.result.getInt("id"), 
                        this.result.getString("lokasi"), 
                        this.result.getInt("kuota"));
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
