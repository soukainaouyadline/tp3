package exercice5;

import java.util.Scanner;

public class CompteBancaire {

    private String numero;
    private double solde;

    public CompteBancaire(String numero, double soldeInitial) {
        this.numero = numero;
        this.solde = soldeInitial >= 0 ? soldeInitial : 0;
    }

    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            System.out.println(" Dépôt  effectué.");
        } else {
            System.out.println("Montant invalide.");
        }
    }

    public boolean retirer(double montant) {
        if (montant > 0 && montant <= solde) {
            solde -= montant;
            System.out.println("Retrait effectué.");
            return true;
        } else {
            System.out.println(" Solde insuffisant ");
            return false;
        }
    }

    public void transferer(CompteBancaire destination, double montant) {
        if (this.retirer(montant)) {
            destination.deposer(montant);
            System.out.println("Transfert de " + montant + " MAD vers le compte " + destination.numero + " réussi.");
        }
    }

    public void afficherSolde() {
        System.out.println(" Compte [" + numero + "] | Solde : " + String.format("%.2f", solde) + " MAD");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Entrer le numéro du compte : ");
        String numero1 = sc.next();
        System.out.print("Entrer le solde initial : ");
        double solde1 = sc.nextDouble();
        CompteBancaire c1 = new CompteBancaire(numero1, solde1);
        c1.afficherSolde();

        System.out.print("\nEntrer la somme à déposer : ");
        double depot = sc.nextDouble();
        c1.deposer(depot);
        c1.afficherSolde();

        System.out.print("\nEntrer la somme à retirer : ");
        double retrait = sc.nextDouble();
        c1.retirer(retrait);
        c1.afficherSolde();

        System.out.print("Entrer le numéro du compte cible : ");
        String numero2 = sc.next();
        System.out.print("Entrer le solde initial du compte cible : ");
        double solde2 = sc.nextDouble();
        CompteBancaire c2 = new CompteBancaire(numero2, solde2);

        System.out.print("\nEntrer la somme à transférer du Compte 1 vers le Compte 2 : ");
        double transfert = sc.nextDouble();
        c1.transferer(c2, transfert);

        c1.afficherSolde();
        c2.afficherSolde();

        sc.close();
    }
}