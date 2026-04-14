package exercice4;

public class Complexe {
    private double reel;
    private double imaginaire;

    public Complexe(double reel, double imaginaire) {
        this.reel = reel;
        this.imaginaire = imaginaire;
    }


    public Complexe addition(Complexe autre) {
        return new Complexe(
                this.reel + autre.reel,
                this.imaginaire + autre.imaginaire
        );
    }


    public Complexe multiplication(Complexe autre) {
        double r = this.reel * autre.reel - this.imaginaire * autre.imaginaire;
        double i = this.reel * autre.imaginaire + this.imaginaire * autre.reel;
        return new Complexe(r, i);
    }

    public void afficher() {
        if (this.imaginaire >= 0) {
            System.out.println(this.reel + " + " + this.imaginaire + "i");
        } else {
            System.out.println(this.reel + " - " + Math.abs(this.imaginaire) + "i");
        }
    }


    public static void main(String[] args) {
        Complexe a = new Complexe(2, 3);
        Complexe b = new Complexe(1, 4);

        System.out.print("a = "); a.afficher();
        System.out.print("b = "); b.afficher();

        System.out.print("la somme "); a.addition(b).afficher();
        System.out.print("le produit "); a.multiplication(b).afficher();
    }
}