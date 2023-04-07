package org.example;

import java.util.Scanner;

public class BanqueInteractive {
    Scanner scanner = new Scanner(System.in);
    Banque banque = new Banque("sbh");

    public void text() {
        System.out.println("Quelle opération voulez-vous effectuer ?");
        System.out.println("1) Ajouter un client");
        System.out.println("2) Effectuer une opération sur un client");
        System.out.println("3) Afficher un bilan général");
    }

    public void interactionAjoutClient() {
        text();
        System.out.print("-");
        int input = scanner.nextInt();
        if (input == 1) {
            System.out.println("Entrez le nom du client :");
            String nom = scanner.next();
            banque.ajouterClient(nom);
            System.out.println("Le client " + nom + " a et crée.");
        } else ;
    }

    public void interactionOperationClient() {
        text();
        System.out.print("-");
        int input = scanner.nextInt();
        if (input == 2) {
            System.out.println("Quel client ?");
            int i = 1;
            for (Client client : banque.getClients()) {
                if (client != null) {
                    System.out.println(i + ") " + client.getNom());
                    i++;
                }
            }
            int choixClient = scanner.nextInt();
            int indexClient =  choixClient - 1;
            Client client = banque.getClients()[indexClient];
            if (client != null) {
                System.out.println("Quelle opération voulez-vous effectuer sur le client " + client.getNom() + " ?");
                System.out.println("1) Afficher un bilan");
                System.out.println("2) Faire un retrait");
                System.out.println("3) Faire un dépôt");
                System.out.println("4) Faire un virement");
                System.out.println("5) cree un new compte");
                int choix = scanner.nextInt();
                if (choix == 1){
                    banque.bilanClient(client);
                }
                else if (choix == 5) {
                    System.out.println("entre le solde de new compte :");
                    client.ajouterCompte(scanner.nextFloat());
                }
                else if (choix == 2) {
                    System.out.println("Quel comptes ?");
                    int j = 1;
                    for (Compte compte : client.getComptes()) {
                        if (compte != null) {
                            System.out.println(j + ") " + compte.getNumero());
                            j++;
                        }
                        System.out.println("choisi le compte :");
                        int comptechoisi = scanner.nextInt();
                        System.out.println("entre le montant a retirer :");
                        float montantRetrait = scanner.nextFloat();
                        client.getComptes()[comptechoisi - 1].retrait(montantRetrait);
                        System.out.println("Le retrait a ete effectue ");
                    }
                }
                else if (choix == 3) {
                        System.out.println("Quel comptes ?");
                        int k = 1;
                        for (Compte compte : client.getComptes()) {
                            if (compte != null) {
                                System.out.println(k + ") " + compte.getNumero());
                                k++;
                            }
                            System.out.println("choisi le compte :");
                            int comptechoisi = scanner.nextInt();
                            System.out.println("entre le montant a deposier :");
                            float montantdepo = scanner.nextFloat();
                            client.getComptes()[comptechoisi-1].depot(montantdepo);
                            System.out.println("Le depot a ete effectue  ");
                            break;
                    }
                }
                else if (choix == 4) {
                    System.out.print("De quel montant ? : ");
                    float montantVire = scanner.nextFloat();
                    System.out.println("depuis quel comptes ?");
                    int l = 1;
                    for (Compte compte : client.getComptes()) {
                        if (compte != null) {
                            System.out.println(l + ") " + compte.getNumero());
                            l++;
                        }
                    }
                        System.out.println("choisi le compte :");
                        int comptechoisi = scanner.nextInt();
                        System.out.println("entre le compte destinataire :");
                        Compte destinataire = client.getComptes()[scanner.nextInt()-1];
                        client.getComptes()[comptechoisi-1].virer(montantVire,destinataire);
                        System.out.println("Le virment a ete effectue  ");

                    }

                }
            }
        }
    }


