package exercice7;

import java.util.ArrayList;
import java.util.Scanner;

public class Produit {

    private int id;
    private String nom;
    private String description;
    private double prix;
    private int quantite;


    static ArrayList<Produit> listeProduits = new ArrayList<>();

    public Produit(int id, String nom, String description, double prix, int quantite) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
    }

    public static void ajouterProd(Produit p) {
        listeProduits.add(p);
    }

    public static void modifierProd(int id, String nom, double prix) {
        for (Produit p : listeProduits) {
            if (p.id == id) {
                p.nom = nom;
                p.prix = prix;
                System.out.println("Produit modifié : " + p.nom);
                return;
            }
        }
        System.out.println("Produit introuvable (id=" + id + ")");
    }

    public static void supprimerProd(int id) {
        Produit cible = getProduitByID(id);
        if (cible != null) {
            listeProduits.remove(cible);
            System.out.println("Produit supprimé : " + cible.nom);
        } else {
            System.out.println("Produit introuvable (id=" + id + ")");
        }
    }

    public static Produit getProduitByID(int id) {
        for (Produit p : listeProduits) {
            if (p.id == id) return p;
        }
        return null;
    }

    public static void getAllProduit() {
        if (listeProduits.isEmpty()) {
            System.out.println("Catalogue vide.");
            return;
        }
        System.out.println("--- Catalogue ---");
        for (Produit p : listeProduits) {
            System.out.println("[" + p.id + "] " + p.nom
                    + " | " + p.description
                    + " | " + p.prix + " MAD"
                    + " | qté: " + p.quantite);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Nom: ");
        String nom = sc.nextLine();

        System.out.print("Description: ");
        String desc = sc.nextLine();

        System.out.print("Prix: ");
        double prix = sc.nextDouble();

        System.out.print("Quantité: ");
        int qte = sc.nextInt();

        Produit p = new Produit(id, nom, desc, prix, qte);
        Produit.ajouterProd(p);

        Produit.getAllProduit();

        sc.close();
    }
}