package org.example;

public class Banque {
    private String nomBanque;
    private Client[] clients = new Client[1];

    public Banque(String nomBanque) {
        this.nomBanque =nomBanque;
    }


    public void ajouterClient(String nomClient){
        for (Client client:clients) {
            clients[clients.length-1] = new Client(nomClient);
            clients = java.util.Arrays.copyOf(clients,clients.length+1);
        }
    }
    public void bilanClient(Client client){
        System.out.println("le bilan de tous les comptes du "+client.getNom()+" :");
        System.out.println("solde total est : "+client.getSolde());
        for (Compte compte:client.getComptes()) {
            if (compte== null){
                break;
            }
            System.out.println("Compte "+compte.getNumero()+" :");
            System.out.println("le solde est : "+compte.getSolde());

        }
    }
    public void afficherBilan(){
        System.out.println("bilan general de la banque "+nomBanque);
        Banque banque = new Banque("sbh");
        for (Client client : banque.getClients()) {
            if (client == null) {
                break;
            }
            bilanClient(client);
        }
    }
    public void renflouer(){
        for (Client client : clients) {
            if (client == null) {
                break;
            }
            client.renflouer();
        }
    }
    public Client[] getClients() {
        return this.clients;
    }
}
