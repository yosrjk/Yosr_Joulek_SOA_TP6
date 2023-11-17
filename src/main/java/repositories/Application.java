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

@SpringBootApplication
@EntityScan(basePackages = "entities")
public class Application {
    public static void main(String []args){
        SpringApplication.run(Application.class,args);

    }
    @Bean
    public CommandLineRunner demo(CompteRepository compteRepository){
        return (args)->{
            Compte compte1=new Compte(0,2500.0,new Date(), etatCompte.courant, typeCompte.ACTIVE);
            Compte compte2=new Compte(1,2700.0,new Date(), etatCompte.epargne, typeCompte.ACTIVE);
            Compte compte3=new Compte(2,1500.25,new Date(), etatCompte.courant, typeCompte.ACTIVE);
            Compte compte4=new Compte(3,3500.0,new Date(), etatCompte.courant, typeCompte.ACTIVE);
            compteRepository.saveAll(Arrays.asList(compte1,compte2,compte3,compte4));
            List<Compte> comptes=compteRepository.findAll();
            for (Compte compte : comptes) {
                System.out.println("Solde du compte #" + compte.getId() + ": " + compte.getSolde());
            }

        };
    }
}
