package exercice6;

import java.util.Scanner;

public class Voiture {

    private static final double VITESSE_MAX = 240;

    private String marque;
    private double vitesse;


    public Voiture(String marque, double vitesseInitiale) {
        this.marque = marque;
        this.vitesse = Math.max(0, Math.min(vitesseInitiale, VITESSE_MAX));
    }

    public void accelerer(double increment) {
        vitesse += increment;
        if (vitesse > VITESSE_MAX) {
            vitesse = VITESSE_MAX;
            System.out.println(" Vitesse maximale atteinte : " + VITESSE_MAX + " km/h");
        }
        System.out.println(marque + " : " + vitesse + " km/h");
    }

    public void freiner(double decrement) {
        vitesse -= decrement;
        if (vitesse < 0) {
            vitesse = 0;
            System.out.println("Voiture est arrêtée.");
        }
        System.out.println(marque + " : " + vitesse + " km/h");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Entrez la marque de la voiture : ");
        String marque = sc.nextLine();

        System.out.print("Entrez la vitesse initiale (km/h) : ");
        double vitesseInit = sc.nextDouble();
        sc.nextLine();

        Voiture v = new Voiture(marque, vitesseInit);

        System.out.print("\nEnter la valeur d'acceleration : ");
        double valeurAcc = sc.nextDouble();
        v.accelerer(valeurAcc);

        System.out.print("Enter la valeur de freinage : ");
        double valeurFrein = sc.nextDouble();
        v.freiner(valeurFrein);

        sc.close();
    }
}