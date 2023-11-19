package entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import java.util.Date;
//Lombok's annotations to automatically generate getters,setters,toString,and constructors
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Compte {
    //generated ID using the startegy of identity
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    // account balance
    private double solde ;
    //date of creation for the account
    private Date dateCreation;
    // enumeration representing the state of the account
    private etatCompte etat ;
    // enumeration representing the type of the account
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
       //getter methode for the id field
    public long getId() {
        return id;
    }
    //setter methode for the id field

    public void setId(long id) {
        this.id = id;
    }

    //getter methode for the solde  field
    public double getSolde() {
        return solde;
    }

    //setter methode for the solde  field
    public void setSolde(double solde) {
        this.solde = solde;
    }

    //getter methode for the dateCreation field
    public Date getDateCreation() {
        return dateCreation;
    }

    //setter methode for the dateCreation field
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    //getter methode for the etat field
    public etatCompte getEtat() {
        return etat;
    }

    //setter methode for the etat field
    public void setEtat(etatCompte etat) {
        this.etat = etat;
    }

    //getter methode for the type field
    public typeCompte getType() {
        return type;
    }

    //setter methode for the type field
    public void setType(typeCompte type) {
        this.type = type;
    }



}
