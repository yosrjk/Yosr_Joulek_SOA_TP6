package repositories;

import entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
//interface representant un repository pour la gestion des comptes avec Spring Data JPA
//JpaRepository<Compte,Long> :interface fournie par Spring Data JPA pour la gestion entites

public interface CompteRepository extends JpaRepository<Compte,Long> {
}
