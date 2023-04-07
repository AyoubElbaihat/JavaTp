package org.example;

import java.util.UUID;

public class Client {
    private String nomClient;
    private Compte[] comptes = new Compte[100];
    private int nbComptes = 1;

    public Client(String nomClient) {
        this.nomClient = nomClient;
        this.nbComptes = 1;
    }

    public void ajouterCompte(float solde){
        comptes[this.nbComptes-1] = new Compte(solde);
        nbComptes++;
    }
    public String getNom(){
        return this.nomClient;
    }
    public float getSolde(){
        float soldetotal = 0.0f;

        for (Compte compte : comptes) {
            if(compte == null){
                break;
            }
            soldetotal += compte.getSolde();
        }
        return soldetotal;
    }

    public Compte[] getComptes() {
        return this.comptes;
    }


}
