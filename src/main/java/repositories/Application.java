package repositories;

import entities.Compte;
import entities.etatCompte;
import entities.typeCompte;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication // Annotation indiquant que cette classe est une application Spring Boot
@EntityScan(basePackages = "entities") // Annotation spécifiant le package où rechercher les entités JPA
public class Application {
    public static void main(String []args){
        // Méthode principale pour démarrer l'application Spring Boot
        SpringApplication.run(Application.class,args);

    }


    // Méthode annotée avec @Bean qui sera exécutée au démarrage de l'application
    @Bean
    public CommandLineRunner demo(CompteRepository compteRepository){
        return (args)->{
            // Création de quelques instances de la classe Compte pour démonstration
            Compte compte1=new Compte(0,2500.0,new Date(), etatCompte.ACTIVE, typeCompte.courant);
            Compte compte2=new Compte(1,2700.0,new Date(), etatCompte.ACTIVE, typeCompte.courant);
            Compte compte3=new Compte(2,1500.25,new Date(), etatCompte.BLOQUE, typeCompte.epargne);
            Compte compte4=new Compte(3,3500.0,new Date(), etatCompte.CREE, typeCompte.courant);
            // Enregistrement des comptes dans le référentiel (repository)
            compteRepository.saveAll(Arrays.asList(compte1,compte2,compte3,compte4));
            // Récupération de tous les comptes enregistrés
            List<Compte> comptes=compteRepository.findAll();
            // Affichage des soldes des comptes
            for (Compte compte : comptes) {
                System.out.println("Solde du compte #" + compte.getId() + ": " + compte.getSolde());
            }

        };
    }
}
