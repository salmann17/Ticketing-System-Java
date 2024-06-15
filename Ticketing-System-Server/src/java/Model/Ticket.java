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
public class Ticket {

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
            String query = "SELECT ticket.id, users.id AS userId, users.username, users.password, users.saldo, users.no_telp, users.email, " +
                           "acara.id AS acaraId, acara.nama, acara.kuota, acara.lokasi, acara.tanggal_acara, acara.deskripsi, acara.harga AS acaraHarga, " +
                           "identitas.id AS identitasId, identitas.nama, identitas.alamat, identitas.no_ktp, identitas.users_id " +
                           "FROM ticket " +
                           "INNER JOIN users ON ticket.nota_acara_users_id = users.id " +
                           "INNER JOIN acara ON ticket.nota_acara_Acara_id = acara.id " +
                           "INNER JOIN identitas ON ticket.identitas_id = identitas.id " +
                           "WHERE ticket.id = ?";
            PreparedStatement sql = Koneksi.getConn().prepareStatement(query);
            sql.setInt(1, id);
            ResultSet rs = sql.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getInt("userId"), rs.getString("username"), rs.getString("password"), rs.getDouble("saldo"), rs.getString("no_telp"), rs.getString("email"));
                Acara acara = new Acara(rs.getInt("acaraId"), rs.getString("nama"), rs.getInt("kuota"), rs.getString("lokasi"), rs.getTimestamp("tanggal_acara"), rs.getString("deskripsi"), rs.getDouble("acaraHarga"));
                Identitas identitas = new Identitas(rs.getInt("identitasId"), rs.getString("nama"), rs.getString("alamat"), rs.getString("no_ktp"), user);
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
            String query = "SELECT ticket.id, users.id AS userId, users.username, users.password, users.saldo, users.no_telp, users.email, " +
                           "acara.id AS acaraId, acara.nama, acara.kuota, acara.lokasi, acara.tanggal_acara, acara.deskripsi, acara.harga AS acaraHarga, " +
                           "identitas.id AS identitasId, identitas.nama, identitas.alamat, identitas.no_ktp, identitas.users_id " +
                           "FROM ticket " +
                           "INNER JOIN users ON ticket.nota_acara_users_id = users.id " +
                           "INNER JOIN acara ON ticket.nota_acara_Acara_id = acara.id " +
                           "INNER JOIN identitas ON ticket.identitas_id = identitas.id";
            PreparedStatement sql = Koneksi.getConn().prepareStatement(query);
            ResultSet rs = sql.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt("userId"), rs.getString("username"), rs.getString("password"), rs.getDouble("saldo"), rs.getString("no_telp"), rs.getString("email"));
                Acara acara = new Acara(rs.getInt("acaraId"), rs.getString("nama"), rs.getInt("kuota"), rs.getString("lokasi"), rs.getTimestamp("tanggal_acara"), rs.getString("deskripsi"), rs.getDouble("acaraHarga"));
                Identitas identitas = new Identitas(rs.getInt("identitasId"), rs.getString("nama"), rs.getString("alamat"), rs.getString("no_ktp"), user);
                Ticket ticket = new Ticket(rs.getInt("id"), user, acara, identitas);
                collections.add(ticket);
            }
            rs.close();
            sql.close();
            return collections;
        } catch (Exception ex) {
            System.out.println("Failed because : " + ex.getMessage());
        }
        return null;
    }

    
    
}
