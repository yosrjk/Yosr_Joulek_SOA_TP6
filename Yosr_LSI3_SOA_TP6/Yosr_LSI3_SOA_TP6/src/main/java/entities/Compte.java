package entities;

import lombok.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

// Lombok annotations to automatically generate getters, setters, toString, and constructors
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@ToString
public class Compte {

    // Generated ID using the strategy of IDENTITY
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    // Account balance
    double solde;

    // Date of creation for the account
    Date dateCreation;

    // Enumeration representing the state of the account (assuming etatCompte is an enum)
    etatCompte etat;

    // Enumeration representing the type of account (assuming typeCompte is an enum)
    typeCompte compte;

    // Getter method for the 'id' field
    public long getId() {
        return id;
    }

    // Setter method for the 'id' field
    public void setId(long id) {
        this.id = id;
    }

    // Getter method for the 'solde' field
    public double getSolde() {
        return solde;
    }

    // Setter method for the 'solde' field
    public void setSolde(double solde) {
        this.solde = solde;
    }

    // Getter method for the 'dateCreation' field
    public Date getDateCreation() {
        return dateCreation;
    }

    // Setter method for the 'dateCreation' field
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    // Getter method for the 'etat' field
    public etatCompte getEtat() {
        return etat;
    }

    // Setter method for the 'etat' field
    public void setEtat(etatCompte etat) {
        this.etat = etat;
    }

    // Getter method for the 'compte' field
    public typeCompte getCompte() {
        return compte;
    }

    // Setter method for the 'compte' field
    public void setCompte(typeCompte compte) {
        this.compte = compte;
    }


}
