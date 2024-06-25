/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class Jam_Parkir {
    private int id;
    private Time jam_mulai;
    private Time jam_selesai;

    public Jam_Parkir() {
        this.id = 0;
        this.jam_mulai = new Time(new Date().getTime());
        this.jam_selesai = new Time(new Date().getTime());       
    }

    public Jam_Parkir(int id, Time jam_mulai, Time jam_selesai) {
        this.id = id;
        this.jam_mulai = jam_mulai;
        this.jam_selesai = jam_selesai;
    }

    public Time getJam_selesai() {
        return jam_selesai;
    }

    public void setJam_selesai(Time jam_selesai) {
        this.jam_selesai = jam_selesai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getJam_mulai() {
        return jam_mulai;
    }

    public void setJam_mulai(Time jam_mulai) {
        this.jam_mulai = jam_mulai;
    }
    
    public static ArrayList<Jam_Parkir> viewListData() {
        ArrayList<Jam_Parkir> collections = new ArrayList<>();
        Koneksi k = new Koneksi();
        try
        {
            k.setStatement((Statement)Koneksi.getConn().createStatement());
            k.setResult(k.getStatement().executeQuery("SELECT * FROM jam+parkir"));
            while (k.getResult().next())
            {
                Jam_Parkir temp = new Jam_Parkir(k.getResult().getInt("id"), 
                        k.getResult().getTime("jam_mulai"), 
                        k.getResult().getTime("jam_selesai"));
                collections.add(temp);
            }
            return collections;          
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
