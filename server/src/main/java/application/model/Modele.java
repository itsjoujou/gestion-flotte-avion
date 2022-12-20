package application.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "modele")
public class Modele {
    @Id
    @SequenceGenerator(name = "id_modele_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_modele_seq")
    @Column(name = "id_modele", nullable = false)
    private int idModele;

    @Column(name = "nom_modele", nullable = false)
    private String nom;

    @NotNull
    @ManyToOne(targetEntity = Constructeur.class)
    @JoinColumn(name = "constructeur")
    private Constructeur constructeur;

    public int getIdModele() {
        return idModele;
    }

    public void setIdModele(int idModele) {
        this.idModele = idModele;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Constructeur getConstructeur() {
        return constructeur;
    }

    public void setConstructeur(Constructeur constructeur) {
        this.constructeur = constructeur;
    }
}
