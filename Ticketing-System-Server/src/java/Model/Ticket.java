/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.User;
import Model.Koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author natha
 */
public class Ticket extends Koneksi{

    private int id;
    private User user;
    private Acara acara;
    private Identitas identitas;
    
    public Ticket(int id, User user, Acara acara, Identitas identitas) {
        this.id = id;
        this.user = user;
        this.acara = acara;
        this.identitas = identitas;
    }
    
    public Ticket() {
        this.id = 0;
        this.user = new User();
        this.acara = new Acara();
        this.identitas = new Identitas();
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
     * @return the identitas
     */
    public Identitas getIdentitas() {
        return identitas;
    }

    /**
     * @param identitas the identitas to set
     */
    public void setIdentitas(Identitas identitas) {
        this.identitas = identitas;
    }
    public void insertData() {
        try {
            Koneksi a = new Koneksi();
            if (!Koneksi.getConn().isClosed()) {
                PreparedStatement sql = Koneksi.getConn().prepareStatement("INSERT INTO ticket(nota_acara_users_id, nota_acara_Acara_id, identitas_id) VALUES (?, ?, ?)");
                sql.setInt(1, user.getId());
                sql.setInt(2, acara.getId());
                sql.setInt(3, identitas.getId());
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
                PreparedStatement sql = Koneksi.getConn().prepareStatement("UPDATE ticket SET nota_acara_users_id = ?, nota_acara_Acara_id = ?, identitas_id = ? WHERE id = ?");
                sql.setInt(1, user.getId());
                sql.setInt(2, acara.getId());
                sql.setInt(3, identitas.getId());
                sql.setInt(4, id);
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
                PreparedStatement sql = Koneksi.getConn().prepareStatement("DELETE FROM ticket WHERE id = ?");
                sql.setInt(1, id);
                sql.executeUpdate();
                sql.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static Ticket findById(int id) {
        Koneksi a = new Koneksi();
        try {
            PreparedStatement sql = Koneksi.getConn().prepareStatement("SELECT * FROM ticket WHERE id = ?");
            sql.setInt(1, id);
            ResultSet rs = sql.executeQuery();
            if (rs.next()) {
                User user = User.findById(rs.getInt("nota_acara_users_id"));
                Acara acara = Acara.findById(rs.getInt("nota_acara_Acara_id"));
                Identitas identitas = Identitas.findById(rs.getInt("identitas_id"));
                Ticket ticket = new Ticket(rs.getInt("id"), user, acara, identitas);
                rs.close();
                sql.close();
                return ticket;
            }
            rs.close();
            sql.close();
        } catch (Exception ex) {
            System.out.println("Failed because : " + ex.getMessage());
        }
        return null;
    }
    public static ArrayList<Ticket> viewListData() {
        ArrayList<Ticket> collections = new ArrayList<>();
        Koneksi a = new Koneksi();
        try {
            a.setStatement(Koneksi.getConn().createStatement());
            ResultSet rs = a.getStatement().executeQuery("SELECT * FROM ticket");
            while (rs.next()) {
                User user = User.findById(rs.getInt("nota_acara_users_id"));
                Acara acara = Acara.findById(rs.getInt("nota_acara_Acara_id"));
                Identitas identitas = Identitas.findById(rs.getInt("identitas_id"));
                Ticket tampung = new Ticket(rs.getInt("id"), user, acara, identitas);
                collections.add(tampung);
            }
            rs.close();
            return collections;
        } catch (Exception ex) {
            System.out.println("Failed because : " + ex.getMessage());
        }
        return null;
    }

    
    
}
