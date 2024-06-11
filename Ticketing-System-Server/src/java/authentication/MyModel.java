/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package authentication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Rome
 */
public abstract class MyModel {
    protected static Connection conn;
    protected Statement statement;
    protected ResultSet result;
    
    public MyModel(Statement statement, ResultSet result) {
        this.statement = statement;
        this.result = result;
    }
    public MyModel(){
        this.conn = this._getConnection();
        this.statement = null;
        this.result = null;
    }

    public static Connection getConn() {
        return conn;
    }

    public static void setConn(Connection conn) {
        MyModel.conn = conn;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public ResultSet getResult() {
        return result;
    }

    public void setResult(ResultSet result) {
        this.result = result;
    }
    
    private Connection _getConnection()
    {
        if (MyModel.conn == null){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                return DriverManager.getConnection("jdbc:mysql://localhost/park217", "root", "");
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        return MyModel.conn;
    }
    public abstract void insertData();
    public abstract void updateData();
    public abstract void deleteData();
    public abstract ArrayList<Object> viewListData();
}
