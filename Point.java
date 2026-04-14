package exercice1;


import java.util.Scanner;

public class Point {
    private double x;
    private double y;


    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void afficher() {
        System.out.println("Point(" + x + ", " + y + ")");
    }

    public void deplacer(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    public double distanceOrigine() {
        return Math.sqrt(x * x + y * y);
    }

    public double distanceDeuxPoint(Point autre) {
        double dx = this.x - autre.x;
        double dy = this.y - autre.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Entrez la coordonnée x : ");
        double x1 = sc.nextDouble();
        System.out.print("Entrez la coordonnée y : ");
        double y1 = sc.nextDouble();
        Point p1 = new Point(x1, y1);


        System.out.print("Entrez la coordonnée x : ");
        double x2 = sc.nextDouble();
        System.out.print("Entrez la coordonnée y : ");
        double y2 = sc.nextDouble();
        Point p2 = new Point(x2, y2);


        p1.afficher();
        p2.afficher();

        System.out.print("\nEntrez le déplacement dx : ");
        double dx = sc.nextDouble();
        System.out.print("Entrez le déplacement dy : ");
        double dy = sc.nextDouble();
        p2.deplacer(dx, dy);

        System.out.println("\nPoint 2 après déplacement :");
        p2.afficher();

        System.out.println("Distance de P2 à l'origine : " + String.format("%.4f", p2.distanceOrigine()));
        System.out.println("Distance entre P1 et P2      : " + String.format("%.4f", p1.distanceDeuxPoint(p2)));

        sc.close();
    }
}