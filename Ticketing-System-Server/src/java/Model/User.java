/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author natha
 */
public class User {

    /**
     * @return the id
     */
    private int id;
    private String username;
    private String password;
    private double saldo;
    private String noTelp;
    private String email;
    
    
    public User(int id, String username, String password, double saldo, String noTelp, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.saldo = saldo;
        this.noTelp = noTelp;
        this.email = email;
    }

    public User(int id, String username, String password, String noTelp, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.saldo = 0;
        this.noTelp = noTelp;
        this.email = email;
    }
    
    public User(){
        this.id = 0;
        this.username = "";
        this.password = "";
        this.saldo = 0.0;
        this.noTelp = "";
        this.email = "";
    }
    
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
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * @return the noTelp
     */
    public String getNoTelp() {
        return noTelp;
    }

    /**
     * @param noTelp the noTelp to set
     */
    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }


    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    public boolean CekLogin(){
        try{
            Koneksi a = new Koneksi();
            a.setStatement((Statement) Koneksi.getConn().createStatement());
            a.setResult(a.getStatement().executeQuery("select * from users"));
            if(a.getResult().next()){
                a.getResult().getInt("id");
                a.getResult().getDouble("saldo");
                a.getResult().getString("no_telp");
                a.getResult().getString("email");
                return true;
            }
            
            
            
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }    
        return false;
    }
    public void insertData() {
        try{
            Koneksi a = new Koneksi();
            if (!Koneksi.getConn().isClosed()){                
                PreparedStatement sql = (PreparedStatement)Koneksi.getConn().prepareStatement("Insert into users(username, password, saldo, no telp, email) values (?,md5(?),?,?, ?)");
                sql.setString(1, getUsername());
                sql.setString(2, getPassword());
                sql.setDouble(3, getSaldo());
                sql.setString(4, getNoTelp());
                sql.setString(5, getEmail());
                sql.executeUpdate();
                sql.close();
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    
    public boolean updateData() {
        try{
            Koneksi a = new Koneksi();
            if (!Koneksi.getConn().isClosed()){                
                PreparedStatement sql = (PreparedStatement) Koneksi.getConn().prepareStatement("UPDATE users SET username = ?, password = md5(?), no_telp = ?, email = ? WHERE id = ?;");
                sql.setString(1, getUsername());
                sql.setString(2, getPassword());
                sql.setString(3, getNoTelp());
                sql.setString(4, getEmail());
                sql.setInt(5, getId());
                int rowAffacted = sql.executeUpdate();
                sql.close();
                return rowAffacted == 0 ? false:true;
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }

    
    public void deleteData() {
        try{
            Koneksi a = new Koneksi();
            if (!Koneksi.getConn().isClosed()){
                 a.setStatement((PreparedStatement) Koneksi.getConn().prepareStatement("DELETE FROM `ticketing_system_java`.`users` WHERE (`id` = '?');"));
                PreparedStatement sql = (PreparedStatement)a.getStatement();
                sql.setInt(1, getId());
                sql.executeUpdate();
                sql.close();
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    
    public static ArrayList<User> viewListData() {
        ArrayList<User> collections = new ArrayList<User>();
        Koneksi a = new Koneksi();
        try {
            a.setStatement((Statement) Koneksi.getConn().createStatement());
            a.setResult(a.getStatement().executeQuery("select * from users"));
            while (a.getResult().next())
            {
                User tampung = new User(a.getResult().getInt("id"), 
                        a.getResult().getString("username"), 
                        a.getResult().getString("password"), 
                        a.getResult().getDouble("saldo"), 
                        a.getResult().getString("no_telp"),
                        a.getResult().getString("email"));
                collections.add(tampung);
            }
            return collections;            
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static User findById(int id) {
        Koneksi a = new Koneksi();
        try {
            PreparedStatement sql = Koneksi.getConn().prepareStatement("SELECT * FROM users WHERE id = ?");
            sql.setInt(1, id);
            ResultSet rs = sql.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getDouble("saldo"), rs.getString("no_telp"), rs.getString("email"));
                rs.close();
                sql.close();
                return user;
            }
            rs.close();
            sql.close();
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
