public class Bruch {
    private int zaehler;  // Zähler des Bruchs
    private int nenner;   // Nenner des Bruchs

    // Konstruktor für die Initialisierung eines Bruchs mit Zähler und Nenner
    public Bruch(int zaehler, int nenner)
    {
        if (nenner == 0)
        {
            throw new IllegalArgumentException("Nenner darf nicht 0 sein.");
        }
        int teiler = ggT(Math.abs(zaehler), Math.abs(nenner)); // Größten gemeinsamen Teiler ermitteln
        this.zaehler = zaehler / teiler; // Zähler kürzen
        this.nenner = nenner / teiler; // Nenner kürzen
    }

    // Berechnet den größten gemeinsamen Teiler (ggT) zweier Zahlen a und b
    private int ggT(int a, int b)
    {
        if (b == 0)
        {
            return a;
        }
        return ggT(b, a % b);
    }

    // Addiert den aktuellen Bruch mit einem anderen Bruch
    public Bruch add(Bruch other)
    {
        return new Bruch(this.zaehler * other.nenner + other.zaehler * this.nenner, this.nenner * other.nenner);
    }

    // Subtrahiert einen anderen Bruch vom aktuellen Bruch
    public Bruch subtract(Bruch other)
    {
        return new Bruch(this.zaehler * other.nenner - other.zaehler * this.nenner, this.nenner * other.nenner);
    }

    // Multipliziert den aktuellen Bruch mit einem anderen Bruch
    public Bruch multiply(Bruch other)
    {
        return new Bruch(this.zaehler * other.zaehler, this.nenner * other.nenner);
    }

    // Dividiert den aktuellen Bruch durch einen anderen Bruch
    public Bruch divide(Bruch other)
    {
        return new Bruch(this.zaehler * other.nenner, this.nenner * other.zaehler);
    }

    // Überladene Methoden: Operationen mit ganzen Zahlen

    public Bruch add(int zahl)
    {
        return add(new Bruch(zahl, 1));
    }

    public Bruch subtract(int zahl)
    {
        return subtract(new Bruch(zahl, 1));
    }

    public Bruch multiply(int zahl)
    {
        return multiply(new Bruch(zahl, 1));
    }

    public Bruch divide(int zahl)
    {
        return divide(new Bruch(zahl, 1));
    }

    // Gibt den Bruch in der Form "Zähler/Nenner" zurück
    @Override
    public String toString()
    {
        return zaehler + "/" + nenner;
    }

    // Hauptmethode zum Testen der Bruchklasse
    public static void main(String[] args)
    {
        Bruch bruch1 = new Bruch(3, 4);
        Bruch bruch2 = new Bruch(2, 5);

        System.out.println("Bruch 1: " + bruch1);
        System.out.println("Bruch 2: " + bruch2);

        Bruch sum = bruch1.add(bruch2);
        System.out.println("Summe: " + sum);

        Bruch difference = bruch1.subtract(bruch2);
        System.out.println("Differenz: " + difference);

        Bruch product = bruch1.multiply(bruch2);
        System.out.println("Produkt: " + product);

        Bruch quotient = bruch1.divide(bruch2);
        System.out.println("Quotient: " + quotient);

        // Testen der überladenen Methoden mit ganzen Zahlen
        Bruch sumWithInt = bruch1.add(2);
        System.out.println("Summe mit ganzer Zahl: " + sumWithInt);

        Bruch differenceWithInt = bruch2.subtract(3);
        System.out.println("Differenz mit ganzer Zahl: " + differenceWithInt);

        Bruch productWithInt = bruch2.multiply(3);
        System.out.println("Produkt mit ganzer Zahl: " + productWithInt);

        Bruch quotientWithInt = bruch1.divide(2);
        System.out.println("Quotient mit ganzer Zahl: " + quotientWithInt);
    }
}
