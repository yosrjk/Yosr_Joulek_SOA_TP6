package entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import java.util.Date;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Compte {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    private double solde ;
    private Date dateCreation;
    private etatCompte etat ;
    private typeCompte type;

    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", solde=" + solde +
                ", dateCreation=" + dateCreation +
                ", etat=" + etat +
                ", type=" + type +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public etatCompte getEtat() {
        return etat;
    }

    public void setEtat(etatCompte etat) {
        this.etat = etat;
    }

    public typeCompte getType() {
        return type;
    }

    public void setType(typeCompte type) {
        this.type = type;
    }



}
