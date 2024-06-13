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
public class NotaAcara extends Koneksi{

    private int id;
    private User user;
    private Acara acara;
    private int jumlah;
    private double harga;
    
    public NotaAcara(int id, User user, Acara acara, int jumlah, double harga) {
        this.id = id;
        this.user = user;
        this.acara = acara;
        this.jumlah = jumlah;
        this.harga = harga;
    }
    
    public NotaAcara() {
        this.id = 0;
        this.user = new User();
        this.acara = new Acara();
        this.jumlah = 0;
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

    /**
     * @return the acara
     */
    public Acara getAcara() {
        return acara;
    }

    /**
     * @param acara the acara to set
     */
    public void setAcara(Acara acara) {
        this.acara = acara;
    }

    /**
     * @return the jumlah
     */
    public int getJumlah() {
        return jumlah;
    }

    /**
     * @param jumlah the jumlah to set
     */
    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
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
        try {
            Koneksi a = new Koneksi();
            if (!Koneksi.getConn().isClosed()) {
                PreparedStatement sql = Koneksi.getConn().prepareStatement("INSERT INTO nota_acara(users_id, Acara_id, jumlah, harga) VALUES (?, ?, ?, ?)");
                sql.setInt(1, user.getId());
                sql.setInt(2, acara.getId());
                sql.setInt(3, jumlah);
                sql.setDouble(4, harga);
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
                PreparedStatement sql = Koneksi.getConn().prepareStatement("UPDATE nota_acara SET users_id = ?, Acara_id = ?, jumlah = ?, harga = ? WHERE id = ?");
                sql.setInt(1, user.getId());
                sql.setInt(2, acara.getId());
                sql.setInt(3, jumlah);
                sql.setDouble(4, harga);
                sql.setInt(5, id);
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
                PreparedStatement sql = Koneksi.getConn().prepareStatement("DELETE FROM nota_acara WHERE id = ?");
                sql.setInt(1, id);
                sql.executeUpdate();
                sql.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static NotaAcara findById(int id) {
        Koneksi a = new Koneksi();
        try {
            PreparedStatement sql = Koneksi.getConn().prepareStatement("SELECT * FROM nota_acara WHERE id = ?");
            sql.setInt(1, id);
            ResultSet rs = sql.executeQuery();
            if (rs.next()) {
                User user = User.findById(rs.getInt("users_id"));
                Acara acara = Acara.findById(rs.getInt("Acara_id"));
                NotaAcara notaAcara = new NotaAcara(rs.getInt("id"), user, acara, rs.getInt("jumlah"), rs.getDouble("harga"));
                rs.close();
                sql.close();
                return notaAcara;
            }
            rs.close();
            sql.close();
        } catch (SQLException ex) {
            System.out.println("Failed because : " + ex.getMessage());
        }
        return null;
    }
     public static ArrayList<NotaAcara> viewListData() {
        ArrayList<NotaAcara> collections = new ArrayList<NotaAcara>();
        Koneksi a = new Koneksi();
        try {
            a.setStatement(Koneksi.getConn().createStatement());
            ResultSet rs = a.getStatement().executeQuery("SELECT * FROM nota_acara");
            while (rs.next()) {
                User user = User.findById(rs.getInt("users_id"));
                Acara acara = Acara.findById(rs.getInt("Acara_id"));
                NotaAcara tampung = new NotaAcara(rs.getInt("id"), user, acara, rs.getInt("jumlah"), rs.getDouble("harga"));
                collections.add(tampung);
            }
            rs.close();
            return collections;            
        } catch (SQLException ex) {
            System.out.println("Failed because : " + ex.getMessage());
        }
        return null;
    }
     
   
    
    
}
