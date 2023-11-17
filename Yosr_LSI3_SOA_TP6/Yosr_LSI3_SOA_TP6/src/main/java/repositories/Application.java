package repositories;

import entities.Compte;
import entities.etatCompte;
import entities.typeCompte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Application {
    @Autowired
    private CompteRepository compteRepository;

    // Méthode principale pour démarrer l'application Spring Boot
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // Utilisation de l'annotation @Bean pour définir un CommandLineRunner
    @Bean
    public CommandLineRunner demo(CompteRepository compteRepository) {
        return (args) -> {
            // Ajout de comptes initiaux

            Compte compte1 = new Compte(0, 2500.0, new Date(), etatCompte.ACTIVE, typeCompte.EPARGNE);
            Compte compte2 = new Compte(1, 500.0, new Date(), etatCompte.ACTIVE, typeCompte.EPARGNE);
            Compte compte3 = new Compte(2, 1500.0, new Date(), etatCompte.ACTIVE, typeCompte.EPARGNE);

            // Enregistrement des comptes dans la base de données en utilisant le CompteRepository
            compteRepository.saveAll(Arrays.asList(compte1, compte2, compte3));

            // Affichage des soldes des comptes récupérés de la base de données
            List<Compte> comptes = compteRepository.findAll();
            for (Compte compte : comptes) {
                System.out.println("Solde du compte #" + compte.getId() + ": " + compte.getSolde());
            }
        };
    }
}
