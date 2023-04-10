package org.example;

import java.util.UUID;

public class Client {
    private String nomClient;
    private Compte[] comptes = new Compte[100];
    private int nbComptes = 1;
    float soldeTotal;

    public Client(String nomClient) {
        this.nomClient = nomClient;
        this.nbComptes = 1;
    }

    public void ajouterCompte(float solde) {
        comptes[this.nbComptes - 1] = new Compte(solde);
        nbComptes++;
    }

    public String getNom() {
        return this.nomClient;
    }

    public float getSolde() {
        float soldeTotal = 0.0f;

        for (Compte compte : comptes) {
            if (compte == null) {
                break;
            }
            soldeTotal += compte.getSolde();
        }
        return soldeTotal;
    }

    public Compte[] getComptes() {
        return this.comptes;
    }

    public void renflouer() {
        if (this.getSolde() < 0) {
            for (Compte compte : comptes) {
                if (compte.getSolde() > 0) {
                    float montant = Math.min(-this.getSolde(), compte.getSolde());
                    compte.virer(montant, compte);
                    this.soldeTotal += montant;
                    System.out.println("Le compte de " + this.nomClient + " a recu " + montant + "€");
                    break;
                }
            }
        } else {
            System.out.println("Le compte de " + this.nomClient + " pas besoin de renfloument.");
        }
    }
}





