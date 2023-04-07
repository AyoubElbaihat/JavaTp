package org.example;

import java.util.UUID;

public class Compte {
    private String numero;
    private float solde;

    public Compte(float solde) {
        this.numero = UUID.randomUUID().toString();
        this.solde = solde;
    }

    public void depot(float valeur){
        this.solde += valeur;
    }
    public void retrait(float valeur){
        this.solde -= valeur;
    }
    public float getSolde(){
        return this.solde;
    }
    public void afficherSolde(){
        System.out.println("le solde est : "+ solde);
    }
    void virer(float valeur, Compte destinataire){
        destinataire.solde += valeur;
    }
    public String getNumero(){
        return this.numero;
    }

}
