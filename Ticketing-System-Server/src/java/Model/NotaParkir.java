/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;
import java.sql.Timestamp;


/**
 *
 * @author natha
 */
public class NotaParkir{
    private int id;
    private Timestamp tanggal_transaksi;
    private User user;
    private Date tanggal_booking;
    private Slot_Parkir slot_parkir;
    private Jam_Parkir jam_parkir;

    public NotaParkir() {
        this.id = 0;
        this.tanggal_transaksi = new Timestamp(new java.util.Date().getTime());
        this.user = new User();
        this.tanggal_booking = new Date(new java.util.Date().getTime());
        this.slot_parkir = new Slot_Parkir();
        this.jam_parkir = new Jam_Parkir();
    } 
     
    public NotaParkir(int id, Timestamp tanggal_transaksi, User user, Date tanggal_booking, Slot_Parkir slot_parkir, Jam_Parkir jam_parkir) {
        this.id = id;
        this.tanggal_transaksi = tanggal_transaksi;
        this.user = user;
        this.tanggal_booking = tanggal_booking;
        this.slot_parkir = slot_parkir;
        this.jam_parkir = jam_parkir;
    }
     
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getTanggal_transaksi() {
        return tanggal_transaksi;
    }

    public void setTanggal_transaksi(Timestamp tanggal_transaksi) {
        this.tanggal_transaksi = tanggal_transaksi;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getTanggal_booking() {
        return tanggal_booking;
    }

    public void setTanggal_booking(Date tanggal_booking) {
        this.tanggal_booking = tanggal_booking;
    }

    public Slot_Parkir getSlot_parkir() {
        return slot_parkir;
    }

    public void setSlot_parkir(Slot_Parkir slot_parkir) {
        this.slot_parkir = slot_parkir;
    }

    public Jam_Parkir getJam_parkir() {
        return jam_parkir;
    }

    public void setJam_parkir(Jam_Parkir jam_parkir) {
        this.jam_parkir = jam_parkir;
    }
     
    
//    
//    public void insertData() {
//        try{
//            if (!Koneksi.getConn().isClosed()){
//                Koneksi a = new Koneksi();
//                a.setStatement(Koneksi.getConn().prepareStatement(
//                "Insert into parkirs(posisi_id, users_id, tgl_reservasi, tgl_finish, harga) values (?,?,?,?,?)"));
//                PreparedStatement sql = (PreparedStatement)a.getStatement() ;
//                sql.setInt(1, getPosisi().getId());
//                sql.setInt(2, getUser().getId());
//                sql.setTimestamp(3, getTglReservasi());
//                sql.setTimestamp(4, getTglFinish());
//                sql.setDouble(5, getHarga());
//                sql.executeUpdate();
//                sql.close();
//            }
//        }
//        catch (Exception ex){
//            System.out.println(ex.getMessage());
//        }
//    }
//    public static NotaParkir findById(int id) {
//        Koneksi a = new Koneksi();
//        try {
//            String query = "SELECT nota_parkir.id, nota_parkir.tgl_reservasi, nota_parkir.tgl_finish, nota_parkir.harga, " +
//                           "posisi.id AS posisiId, posisi.nomor, posisi.harga AS posisiHarga, " +
//                           "users.id AS userId, users.username, users.password, users.saldo, users.no_telp, users.email " +
//                           "FROM nota_parkir " +
//                           "INNER JOIN posisi ON nota_parkir.posisi_id = posisi.id " +
//                           "INNER JOIN users ON nota_parkir.users_id = users.id " +
//                           "WHERE nota_parkir.id = ?";
//            a.setStatement(Koneksi.getConn().prepareStatement(query));
//            PreparedStatement sql = (PreparedStatement)a.getStatement();
//            sql.setInt(1, id);
//            a.setResult(sql.executeQuery());
//            if (a.getResult().next()) {
//                Slot_Parkir posisi = new Slot_Parkir(a.getResult().getInt("posisiId"), a.getResult().getString("nomor"), a.getResult().getDouble("posisiHarga"));
//                User user = new User(a.getResult().getInt("userId"), a.getResult().getString("username"), a.getResult().getString("password"), a.getResult().getDouble("saldo"), a.getResult().getString("no_telp"), a.getResult().getString("email"));
//                NotaParkir notaParkir = new NotaParkir(a.getResult().getInt("id"), posisi, user, a.getResult().getTimestamp("tgl_reservasi"), a.getResult().getTimestamp("tgl_finish"), a.getResult().getDouble("harga"));
//                return notaParkir;
//            }
//        } catch (Exception ex) {
//            System.out.println("failed because : " + ex.getMessage());
//        }
//        return null;
//    }
        
}
