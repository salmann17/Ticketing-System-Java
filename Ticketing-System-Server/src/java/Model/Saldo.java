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
public class Saldo {
    private int id;
    private double jumlah;
    private User user;
    private String keterangan;
    private NotaAcara notaAcara;
    private NotaParkir notaParkir;
    
    public Saldo(double jumlah, User user, String keterangan) {
        this.jumlah = jumlah;
        this.user = user;
        this.keterangan = keterangan;
    }
    
    public Saldo(int id,double jumlah, User user, String keterangan, NotaAcara notaAcara, NotaParkir notaParkir) {
        this.id = id;
        this.jumlah = jumlah;
        this.user = user;
        this.keterangan = keterangan;
        this.notaAcara = notaAcara;
        this.notaParkir = notaParkir;
    }
    
     public Saldo() {
        this.id = 0;
        this.jumlah = 0.0;
        this.user = new User();
        this.keterangan = "";
        this.notaAcara = new NotaAcara();
        this.notaParkir = new NotaParkir(); 
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
     * @return the jumlah
     */
    public double getJumlah() {
        return jumlah;
    }

    /**
     * @param jumlah the jumlah to set
     */
    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
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
     * @return the keterangan
     */
    public String getKeterangan() {
        return keterangan;
    }

    /**
     * @param keterangan the keterangan to set
     */
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    /**
     * @return the notaAcara
     */
    public NotaAcara getNotaAcara() {
        return notaAcara;
    }

    /**
     * @param notaAcara the notaAcara to set
     */
    public void setNotaAcara(NotaAcara notaAcara) {
        this.notaAcara = notaAcara;
    }

    /**
     * @return the notaParkir
     */
    public NotaParkir getNotaParkir() {
        return notaParkir;
    }

    /**
     * @param notaParkir the notaParkir to set
     */
    public void setNotaParkir(NotaParkir notaParkir) {
        this.notaParkir = notaParkir;
    }
    public void insertData() {
        try {
            Koneksi a = new Koneksi();
            if (!Koneksi.getConn().isClosed()) {
                PreparedStatement sql = Koneksi.getConn().prepareStatement("INSERT INTO saldo(jumlah, users_id, keterangan, nota_acara_id, nota_parkir_id) VALUES (?, ?, ?, ?, ?)");
                sql.setDouble(1, jumlah);
                sql.setInt(2, user.getId());
                sql.setString(3, keterangan);
                sql.setInt(4, notaAcara != null ? notaAcara.getId() : null);
                sql.setInt(5, notaParkir != null ? notaParkir.getId() : null);
                sql.executeUpdate();
                sql.close();
            }
        } catch (Exception ex) {
            System.out.println("failed because : " + ex.getMessage());
        }
    }
    public static ArrayList<Saldo> viewListData() {
        ArrayList<Saldo> collections = new ArrayList<>();
        Koneksi a = new Koneksi();
        try {
            String query = "SELECT saldo.id, saldo.jumlah, saldo.keterangan, users.id AS userId, users.username, users.password, users.saldo, users.no_telp, users.email, " +
                           "nota_acara.id AS notaAcaraId, nota_acara.users_id AS notaAcaraUserId, nota_acara.Acara_id AS notaAcaraAcaraId, nota_acara.jumlah AS notaAcaraJumlah, nota_acara.harga AS notaAcaraHarga, " +
                           "nota_parkir.id AS notaParkirId, nota_parkir.posisi_id AS notaParkirPosisiId, nota_parkir.users_id AS notaParkirUserId, nota_parkir.tgl_reservasi, nota_parkir.tgl_finish, nota_parkir.harga AS notaParkirHarga " +
                           "FROM saldo " +
                           "INNER JOIN users ON saldo.users_id = users.id " +
                           "LEFT JOIN nota_acara ON saldo.nota_acara_id = nota_acara.id " +
                           "LEFT JOIN nota_parkir ON saldo.nota_parkir_id = nota_parkir.id";
            a.setStatement(Koneksi.getConn().prepareStatement(query));
            PreparedStatement sql = (PreparedStatement)a.getStatement();
            a.setResult(sql.executeQuery());
            while (a.getResult().next()) {
                User user = new User(a.getResult().getInt("userId"), a.getResult().getString("username"), a.getResult().getString("password"), a.getResult().getDouble("saldo"), a.getResult().getString("no_telp"), a.getResult().getString("email"));
                
                NotaAcara notaAcara = null;
                if (a.getResult().getInt("notaAcaraId") != 0) {
                    notaAcara = new NotaAcara(a.getResult().getInt("notaAcaraId"), User.findById(a.getResult().getInt("notaAcaraUserId")), Acara.findById(a.getResult().getInt("notaAcaraAcaraId")), a.getResult().getInt("notaAcaraJumlah"), a.getResult().getDouble("notaAcaraHarga"));
                }

                NotaParkir notaParkir = null;
                if (a.getResult().getInt("notaParkirId") != 0) {
                    notaParkir = new NotaParkir(a.getResult().getInt("notaParkirId"), Posisi.findById(a.getResult().getInt("notaParkirPosisiId")), User.findById(a.getResult().getInt("notaParkirUserId")), a.getResult().getTimestamp("tgl_reservasi"), a.getResult().getTimestamp("tgl_finish"), a.getResult().getDouble("notaParkirHarga"));
                }

                Saldo saldo = new Saldo(a.getResult().getInt("id"), a.getResult().getDouble("jumlah"), user, a.getResult().getString("keterangan"), notaAcara, notaParkir);
                collections.add(saldo);
            }
            return collections;
        } catch (Exception ex) {
            System.out.println("failed because : " + ex.getMessage());
        }
        return null;
    }
    public static boolean topUpSaldo(int userId, double topUpAmount) {
        Koneksi a = new Koneksi();
        try {
            boolean updated = User.updateSaldo(userId, topUpAmount);

            if (updated) {
                User user = User.findById(userId);
                if (user != null) {
                    Saldo newSaldo = new Saldo(topUpAmount, user, "topup");
                    newSaldo.insertData();
                    return true;
                }
            }
        } catch (Exception ex) {
            System.out.println("failed because : " + ex.getMessage());
        }
        return false;
    }
    
    
    
}
