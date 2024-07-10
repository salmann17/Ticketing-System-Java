/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author natha
 */
public class NotaAcara{
    private int id;
    private User user;
    private Acara acara;
    private int jumlah;
    private double harga;    
    private String tanggal_Transaksi;
    
    public NotaAcara(int id, User user, Acara acara, int jumlah, double harga, Timestamp tanggal_transaksi) {
        this.id = id;
        this.user = user;
        this.acara = acara;
        this.jumlah = jumlah;
        this.harga = harga;    
        setTanggal_Transaksi(tanggal_transaksi.toString());
    }
    
    public NotaAcara() {
        this.id = 0;
        this.user = new User();
        this.acara = new Acara();
        this.jumlah = 0;
        this.harga = 0.0;     
        this.tanggal_Transaksi = "";
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Acara getAcara() {
        return acara;
    }

    public void setAcara(Acara acara) {
        this.acara = acara;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
    
    public String getTanggal_Transaksi(){
        return tanggal_Transaksi;
    }
    
    public void setTanggal_Transaksi(String tanggal_Transaksi){
        this.tanggal_Transaksi = tanggal_Transaksi;
    }
        
    
    public boolean insertData() {
        try {
            Koneksi a = new Koneksi();
            if (!Koneksi.getConn().isClosed()) {
                User u = User.findById(user.getId());
                if(u.getSaldo()>=harga)
                {
                    a.setStatement(Koneksi.getConn().prepareStatement("UPDATE users SET saldo = saldo - ? WHERE id = ?"));
                    PreparedStatement sqlUpdateSaldo = (PreparedStatement)a.getStatement();
                    sqlUpdateSaldo.setDouble(1, harga);
                    sqlUpdateSaldo.setInt(2, user.getId());
                    int rowAffected = sqlUpdateSaldo.executeUpdate();
                    sqlUpdateSaldo.close();

                    a.setStatement(Koneksi.getConn().prepareStatement("INSERT INTO nota_acara(users_id, Acara_id, jumlah, harga,tanggal_transaksi) VALUES (?, ?, ?, ?,now())"));
                    PreparedStatement sql = (PreparedStatement)a.getStatement();
                    sql.setInt(1, user.getId());
                    sql.setInt(2, acara.getId());
                    sql.setInt(3, jumlah);
                    sql.setDouble(4, harga);
                    sql.executeUpdate();
                    sql.close();

                    return rowAffected != 0;
                }
                return false;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public static NotaAcara findById(int id) {
        Koneksi a = new Koneksi();
        try {
            String query = "SELECT nota_acara.id, nota_acara.jumlah, nota_acara.harga, users.id AS userId, users.username, users.password, users.saldo, users.no_telp, users.email, " +
                           "acara.id AS acaraId, acara.nama, acara.kuota, acara.lokasi, acara.tanggal_acara, acara.deskripsi, acara.harga AS acaraHarga " +
                           "FROM nota_acara " +
                           "INNER JOIN users ON nota_acara.users_id = users.id " +
                           "INNER JOIN acara ON nota_acara.Acara_id = acara.id " +
                           "WHERE nota_acara.id = ?";
            a.setStatement(Koneksi.getConn().prepareStatement(query));
            PreparedStatement sql = (PreparedStatement)a.getStatement();
            sql.setInt(1, id);
            a.setResult(sql.executeQuery());
            if (a.getResult().next()) {
                User user = new User(a.getResult().getInt("userId"), a.getResult().getString("username"), a.getResult().getString("password"), a.getResult().getDouble("saldo"), a.getResult().getString("no_telp"), a.getResult().getString("email"));
                Acara acara = new Acara(a.getResult().getInt("acaraId"), a.getResult().getString("nama"), a.getResult().getString("lokasi"), a.getResult().getTimestamp("tanggal_acara"), a.getResult().getString("deskripsi"), a.getResult().getDouble("acaraHarga"));
                NotaAcara notaAcara = new NotaAcara(a.getResult().getInt("id"), user, acara, a.getResult().getInt("jumlah"), a.getResult().getDouble("harga"),a.getResult().getTimestamp("tanggal_transaksi"));
                return notaAcara;
            }
        } catch (SQLException ex) {
            System.out.println("Failed because : " + ex.getMessage());
        }
        return null;
    }           
}
