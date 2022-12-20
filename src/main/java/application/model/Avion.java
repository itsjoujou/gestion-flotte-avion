package application.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Avion {
    @Id
    @SequenceGenerator(name = "id_avion_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_avion_seq")
    @Column(name = "id_avion", nullable = false)
    private int idAvion;

    @NotNull
    @ManyToOne(targetEntity = Modele.class)
    @JoinColumn(name = "modele")
    private Modele modele;

    @Column(name = "annee", nullable = false)
    private int annee;

    @Column(name = "numero_plaque", nullable = false)
    private String numeroPlaque;

    @Column(name = "vitesse_max")
    private int vitesseMax;

    @Column(name = "photo")
    private String photo;

    @Column(name = "nb_sieges")
    private int sieges;

    @Column(name = "nb_reacteurs")
    private int reacteurs;

    @Column(name = "autonomie")
    private int autonomie;

    @Column(name = "envergure")
    private double envergure;

    @Column(name = "hauteur")
    private double hauteur;

    @Column(name = "longueur")
    private double longueur;

    public int getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(int idAvion) {
        this.idAvion = idAvion;
    }

    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getNumeroPlaque() {
        return numeroPlaque;
    }

    public void setNumeroPlaque(String numeroPlaque) {
        this.numeroPlaque = numeroPlaque;
    }

    public int getVitesseMax() {
        return vitesseMax;
    }

    public void setVitesseMax(int vitesseMax) {
        this.vitesseMax = vitesseMax;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getSieges() {
        return sieges;
    }

    public void setSieges(int sieges) {
        this.sieges = sieges;
    }

    public int getReacteurs() {
        return reacteurs;
    }

    public void setReacteurs(int reacteurs) {
        this.reacteurs = reacteurs;
    }

    public int getAutonomie() {
        return autonomie;
    }

    public void setAutonomie(int autonomie) {
        this.autonomie = autonomie;
    }

    public double getEnvergure() {
        return envergure;
    }

    public void setEnvergure(double envergure) {
        this.envergure = envergure;
    }

    public double getHauteur() {
        return hauteur;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    public double getLongueur() {
        return longueur;
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }
}
