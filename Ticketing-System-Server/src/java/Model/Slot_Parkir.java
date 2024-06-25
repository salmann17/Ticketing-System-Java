/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author natha
 */
public class Slot_Parkir{
    private Parkir parkir;
    private String kode;
    private double harga;
    
    public Slot_Parkir() {
        this.parkir = new Parkir();
        this.kode = "";
        this.harga = 0.0;
    }

    public Slot_Parkir(Parkir parkir, String kode, double harga) {
        this.parkir = parkir;
        this.kode = kode;
        this.harga = harga;
    }
        
    public Parkir getParkir() {
        return parkir;
    }

    public void setParkir(Parkir parkir) {
        this.parkir = parkir;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }            
}
