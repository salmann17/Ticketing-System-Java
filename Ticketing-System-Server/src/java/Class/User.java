/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import authentication.MyModel;
import java.sql.PreparedStatement;
import java.sql.Statement;
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
            this.statement = (Statement) MyModel.conn.createStatement();
            PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement("select * from users where username =? and password = md5(?)");
            sql.setString(1, this.username);
            sql.setString(2, this.password);
            this.result = sql.executeQuery();
            if(result.next()){
                this.id = result.getInt("id");
                this.saldo = result.getDouble("saldo");
                this.noTelp = result.getString("no_telp");
                this.email = result.getString("email");
                return true;
            }
            
            
            
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }    
        return false;
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
        try{
            if (!MyModel.conn.isClosed()){
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                "UPDATE `users` SET `username` = '?', `password` = 'md5(?)', `no_telp` = '?', `email` = '?' WHERE (`id` = '?');");
                sql.setString(1, getUsername());
                sql.setString(2, getPassword());
                sql.setString(3, getNoTelp());
                sql.setString(4, getEmail());
                sql.setInt(5, getId());
                sql.executeUpdate();
                sql.close();
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void deleteData() {
        try{
            if (!MyModel.conn.isClosed()){
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                "DELETE FROM `ticketing_system_java`.`users` WHERE (`id` = '?');");
                sql.setInt(1, getId());
                sql.executeUpdate();
                sql.close();
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public ArrayList<Object> viewListData() {
        ArrayList<Object> collections = new ArrayList<Object>();
        try
        {
            this.statement = (Statement) MyModel.conn.createStatement();
            this.result = this.statement.executeQuery("select * from account");
            while (this.result.next())
            {
                User tampung = new User(this.result.getInt("id"), 
                        this.result.getString("username"), 
                        this.result.getString("password"), 
                        this.result.getDouble("saldo"), 
                        this.result.getString("no_telp"),
                        this.result.getString("email"));
                collections.add(tampung);
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return collections;
    }
}
