/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.User;
import Model.MyModel;
import java.util.ArrayList;

/**
 *
 * @author natha
 */
public class Ticket extends MyModel{

    private int id;
    private User user;
    private Acara acara;
    private Identitas identitas;
    
    public Ticket(int id, User user, Acara acara, Identitas identitas) {
        this.id = id;
        this.user = user;
        this.acara = acara;
        this.identitas = identitas;
    }
    
    public Ticket() {
        this.id = 0;
        this.user = new User();
        this.acara = new Acara();
        this.identitas = new Identitas();
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
     * @return the acara
     */
    public Acara getAcara() {
        return acara;
    }

    /**
     * @param acara the acara to set
     */
    public void setAcara(Acara acara) {
        this.acara = acara;
    }

    /**
     * @return the identitas
     */
    public Identitas getIdentitas() {
        return identitas;
    }

    /**
     * @param identitas the identitas to set
     */
    public void setIdentitas(Identitas identitas) {
        this.identitas = identitas;
    }
    
    
    
}
