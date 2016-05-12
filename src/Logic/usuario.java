/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.List;

/**
 *
 * @author Javier Fong
 */
public class usuario {
        String nombre;
    int numFoll;
    String id;
    String location;
    List<twitt> timeline;
    int numeroDeT;
    
    public usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumFol() {
        return numFoll;
    }

    public void setNumFol(int numFol) {
        this.numFoll = numFol;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<twitt> getTimeline() {
        return timeline;
    }

    public void setTimeline(List<twitt> timeline) {
        this.timeline = timeline;
    }

    public int getNumFoll() {
        return numFoll;
    }

    public void setNumFoll(int numFoll) {
        this.numFoll = numFoll;
    }

    public int getNumeroDeT() {
        return numeroDeT;
    }

    public void setNumeroDeT(int numeroDeT) {
        this.numeroDeT = numeroDeT;
    }
    

}
