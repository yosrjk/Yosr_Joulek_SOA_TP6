package repositories;

import entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

// Interface représentant un repository pour la gestion des comptes avec Spring Data JPA
// JpaRepository<Compte, Long> : Interface fournie par Spring Data JPA pour la gestion des entités
public interface CompteRepository extends JpaRepository<Compte, Long> {
}
