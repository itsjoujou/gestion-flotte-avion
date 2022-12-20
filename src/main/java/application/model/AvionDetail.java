package application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "v_avion_detail")
public class AvionDetail extends Avion {
    @Column(name = "kilometrage")
    private int kilometrage;

    @Column(name = "debut_assurance")
    private Date debutAssurance;

    @Column(name = "fin_assurance")
    private Date finAssurance;

    public int getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }

    public Date getDebutAssurance() {
        return debutAssurance;
    }

    public void setDebutAssurance(Date debutAssurance) {
        this.debutAssurance = debutAssurance;
    }

    public Date getFinAssurance() {
        return finAssurance;
    }

    public void setFinAssurance(Date finAssurance) {
        this.finAssurance = finAssurance;
    }
}
