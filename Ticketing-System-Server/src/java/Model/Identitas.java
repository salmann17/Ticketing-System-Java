/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.User;
import Model.Koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author natha
 */
public class Identitas extends Koneksi{

    private int id;
    private String nama;
    private String alamat;
    private String noKTP;
    private User user;
    
    public Identitas(int id, String nama, String alamat, String noKTP, User user) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.noKTP = noKTP;
        this.user = user;
    }
    
    public Identitas() {
        this.id = 0;
        this.nama = "";
        this.alamat = "";
        this.noKTP = "";
        this.user = new User();
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
     * @return the alamat
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     * @param alamat the alamat to set
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    /**
     * @return the noKTP
     */
    public String getNoKTP() {
        return noKTP;
    }

    /**
     * @param noKTP the noKTP to set
     */
    public void setNoKTP(String noKTP) {
        this.noKTP = noKTP;
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
    public static Identitas findById(int id) {
        Koneksi a = new Koneksi();
        try {
            PreparedStatement sql = Koneksi.getConn().prepareStatement("SELECT * FROM identitas WHERE id = ?");
            sql.setInt(1, id);
            ResultSet rs = sql.executeQuery();
            if (rs.next()) {
                User user = User.findById(rs.getInt("users_id"));
                Identitas identitas = new Identitas(rs.getInt("id"), rs.getString("nama"), rs.getString("alamat"), rs.getString("no_ktp"), user);
                rs.close();
                sql.close();
                return identitas;
            }
            rs.close();
            sql.close();
        } catch (Exception ex) {
            System.out.println("Failed because : " + ex.getMessage());
        }
        return null;
    }
   
}
