package entities;

// Enumération représentant l'état d'un compte
public enum etatCompte {
    // L'état du compte lorsqu'il vient d'être créé
    CREE,

    // L'état du compte lorsqu'il est actif et opérationnel
    ACTIVE,

    // L'état du compte lorsqu'il est suspendu, temporairement indisponible
    SUSPENDU,

    // L'état du compte lorsqu'il est bloqué, aucune opération n'est autorisée
    BLOQUE;
}
