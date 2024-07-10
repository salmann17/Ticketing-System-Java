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
public class History_Transaksi {
    private int id;
    private double jumlah;
    private User user;
    private Boolean is_topup;
    private NotaAcara notaAcara;
    private NotaParkir notaParkir;

    public History_Transaksi(int id, double jumlah) {
        this.id = id;
        this.jumlah = jumlah;
    }
    
    public History_Transaksi(int id, double jumlah, User user, Boolean is_topup, NotaAcara notaAcara, NotaParkir notaParkir) {
        this.id = id;
        this.jumlah = jumlah;
        this.user = user;
        this.is_topup = is_topup;
        this.notaAcara = notaAcara;
        this.notaParkir = notaParkir;
    }
    
    public History_Transaksi(double jumlah, User user, Boolean is_topup) {
        this.jumlah = jumlah;
        this.user = user;        
        this.is_topup = true;
    }

    public History_Transaksi(int id,double jumlah, User user, String keterangan, NotaAcara notaAcara) {
        this.id = id;
        this.jumlah = jumlah;
        this.user = user;
        this.is_topup = false;
        this.notaAcara = notaAcara;     
        this.notaParkir = null;  
    }
    
    public History_Transaksi(int id,double jumlah, User user, String keterangan, NotaParkir notaParkir) {
        this.id = id;
        this.jumlah = jumlah;
        this.user = user;
        this.is_topup = true;
        this.notaAcara = null;   
        this.notaParkir = notaParkir;        
    }
    
     public History_Transaksi() {
        this.id = 0;
        this.jumlah = 0.0;
        this.user = new User();
        this.is_topup = false;
        this.notaAcara = new NotaAcara();
        this.notaParkir = new NotaParkir(); 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }
   
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    public Boolean Is_topup() {
        return is_topup;
    }

    public void set_topup(Boolean is_topup) {
        this.is_topup = is_topup;
    }

    public NotaAcara getNotaAcara() {
        return notaAcara;
    }

    public void setNotaAcara(NotaAcara notaAcara) {
        this.notaAcara = notaAcara;
    }

    public NotaParkir getNotaParkir() {
        return notaParkir;
    }

    public void setNotaParkir(NotaParkir notaParkir) {
        this.notaParkir = notaParkir;
    }
    public boolean topUpSaldo() {
        try {
            Koneksi a = new Koneksi();
            if (!Koneksi.getConn().isClosed()) {
                PreparedStatement sql = Koneksi.getConn().prepareStatement("INSERT INTO history_transaksi(jumlah, users_id, is_topup) VALUES (?, ?, ?)");
                sql.setDouble(1, this.jumlah);
                sql.setInt(2, this.user.getId());          
                sql.setBoolean(3, this.is_topup);
            
                int rowAffected = sql.executeUpdate();                
                sql.close();
                return rowAffected > 0;
            }
        } catch (Exception ex) {
            System.out.println("failed because : " + ex.getMessage());
        }
        return false;
    }
    
//    public static ArrayList<History_Transaksi> viewListData() {
//        ArrayList<History_Transaksi> collections = new ArrayList<>();
//        Koneksi a = new Koneksi();
//        try {
//            String query = "SELECT saldo.id, saldo.jumlah, saldo.keterangan, users.id AS userId, users.username, users.password, users.saldo, users.no_telp, users.email, " +
//                           "nota_acara.id AS notaAcaraId, nota_acara.users_id AS notaAcaraUserId, nota_acara.Acara_id AS notaAcaraAcaraId, nota_acara.jumlah AS notaAcaraJumlah, nota_acara.harga AS notaAcaraHarga, " +
//                           "nota_parkir.id AS notaParkirId, nota_parkir.posisi_id AS notaParkirPosisiId, nota_parkir.users_id AS notaParkirUserId, nota_parkir.tgl_reservasi, nota_parkir.tgl_finish, nota_parkir.harga AS notaParkirHarga " +
//                           "FROM saldo " +
//                           "INNER JOIN users ON saldo.users_id = users.id " +
//                           "LEFT JOIN nota_acara ON saldo.nota_acara_id = nota_acara.id " +
//                           "LEFT JOIN nota_parkir ON saldo.nota_parkir_id = nota_parkir.id";
//            a.setStatement(Koneksi.getConn().prepareStatement(query));
//            PreparedStatement sql = (PreparedStatement)a.getStatement();
//            a.setResult(sql.executeQuery());
//            while (a.getResult().next()) {
//                User user = new User(a.getResult().getInt("userId"), a.getResult().getString("username"), a.getResult().getString("password"), a.getResult().getDouble("saldo"), a.getResult().getString("no_telp"), a.getResult().getString("email"));
//                
//                NotaAcara notaAcara = null;
//                if (a.getResult().getInt("notaAcaraId") != 0) {
//                    notaAcara = new NotaAcara(a.getResult().getInt("notaAcaraId"), User.findById(a.getResult().getInt("notaAcaraUserId")), Acara.findById(a.getResult().getInt("notaAcaraAcaraId")), a.getResult().getInt("notaAcaraJumlah"), a.getResult().getDouble("notaAcaraHarga"));
//                }
//
//                NotaParkir notaParkir = null;
//                if (a.getResult().getInt("notaParkirId") != 0) {
//                    notaParkir = new NotaParkir(a.getResult().getInt("notaParkirId"), Slot_Parkir.findById(a.getResult().getInt("notaParkirPosisiId")), User.findById(a.getResult().getInt("notaParkirUserId")), a.getResult().getTimestamp("tgl_reservasi"), a.getResult().getTimestamp("tgl_finish"), a.getResult().getDouble("notaParkirHarga"));
//                }
//
//                History_Transaksi saldo = new History_Transaksi(a.getResult().getInt("id"), a.getResult().getDouble("jumlah"), user, a.getResult().getString("keterangan"), notaAcara, notaParkir);
//                collections.add(saldo);
//            }
//            return collections;
//        } catch (Exception ex) {
//            System.out.println("failed because : " + ex.getMessage());
//        }
//        return null;
//    }          
}
