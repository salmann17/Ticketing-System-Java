/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import authentication.MyModel;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author natha
 */
public class User extends MyModel{

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
    

    @Override
    public void insertData() {
        try{
            if (!MyModel.conn.isClosed()){
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                "Insert into users(username, password, saldo, no telp, email) values (?,md5(?),?,?, ?)");
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

    @Override
    public void updateData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Object> viewListData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
