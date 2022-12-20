package application.model;

import javax.persistence.*;

@Entity
@Table(name = "constructeur")
public class Constructeur {
    @Id
    @SequenceGenerator(name = "id_constructeur_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_constructeur_seq")
    @Column(name = "id_constructeur", nullable = false)
    private int idConstructeur;

    @Column(name = "nom_constructeur", nullable = false)
    private String nom;

    public int getIdConstructeur() {
        return idConstructeur;
    }

    public void setIdConstructeur(int idConstructeur) {
        this.idConstructeur = idConstructeur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
