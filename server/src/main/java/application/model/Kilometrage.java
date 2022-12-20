package application.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "kilometrage")
public class Kilometrage {
    @Id
    @SequenceGenerator(name = "id_km_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_km_seq")
    @Column(name = "id_km", nullable = false)
    private int idKilometrage;

    @Column(name = "avion", nullable = false, updatable = false)
    private int avion;

    @Column(name = "date_km", nullable = false)
    private Date dateKM;

    @Column(name = "debut", nullable = false)
    private int debut;

    @Column(name = "fin", nullable = false)
    private int fin;

    public Kilometrage(int idKilometrage, int avion, Date dateKM, int debut, int fin) {
        this.idKilometrage = idKilometrage;
        this.avion = avion;
        this.dateKM = dateKM;
        this.debut = debut;
        this.fin = fin;
    }

    public Kilometrage() {
    }

    public int getIdKilometrage() {
        return idKilometrage;
    }

    public void setIdKilometrage(int idKilometrage) {
        this.idKilometrage = idKilometrage;
    }

    public int getVehicule() {
        return avion;
    }

    public void setVehicule(int Vehicule) {
        this.avion = Vehicule;
    }

    public java.sql.Date getDateKM() {
        return dateKM;
    }

    public void setDateKM(java.sql.Date dateKHM) {
        this.dateKM = dateKHM;
    }

    public int getDebut() {
        return debut;
    }

    public void setDebut(int debut) {
        this.debut = debut;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }
}
