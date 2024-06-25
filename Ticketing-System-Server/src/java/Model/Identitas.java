/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.PreparedStatement;
/**
 *
 * @author natha
 */
public class Identitas {

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

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoKTP() {
        return noKTP;
    }

    public void setNoKTP(String noKTP) {
        this.noKTP = noKTP;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public static Identitas findById(int id) {
        Koneksi k = new Koneksi();
        try {
            k.setStatement(Koneksi.getConn().prepareStatement("SELECT * FROM identitas WHERE id = ?"));
            PreparedStatement sql = (PreparedStatement)k.getStatement();
            sql.setInt(1, id);
            k.setResult(sql.executeQuery());
            if (k.getResult().next()) {
                User user = User.findById(k.getResult().getInt("users_id"));
                Identitas identitas = new Identitas(k.getResult().getInt("id"), k.getResult().getString("nama"), k.getResult().getString("alamat"), k.getResult().getString("no_ktp"), user);
                return identitas;
            }
        } catch (Exception ex) {
            System.out.println("Failed because : " + ex.getMessage());
        }
        return null;
    }
}
