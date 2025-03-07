import java.util.Scanner;
import utils.*;

public class Verwaltung {
    private Scanner scanner;
    private Queue<Kunde> warteschlange;
    private List<Getraenk> getraenkeListe;
    private Stack<Rechnung> rechnungsStack;

    public static void main(String[] args) {
        new Verwaltung();
    }

    public Verwaltung() {
        scanner = new Scanner(System.in);
        warteschlange = new Queue<>();
        getraenkeListe = new List<>();
        rechnungsStack = new Stack<>();
        fuelleKaffeeListeAuf();

        while (true) {
            System.out.println("==The Belaouns==");
            System.out.println("[1] Kunde hinzufügen"); //warteschlange
            System.out.println("[2] Getränk hinzufügen"); //list
            System.out.println("[3] Warteschlange anzeigen");// zwei Warteschlange verwenden um auszugeben
            System.out.println("[4] Rechnung erhalten");//stack
            System.out.println("[5] Beenden");
            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                kundeHinzufuegen();
            } else if (option == 2) {
                getraenkHinzufuegen();
            } else if (option == 3) {
                zeigeWarteschlange();
            } else if (option == 4) {
                getrechnung();
            } else if (option == 5) {
                System.out.println("Programm wird beendet. Auf Wiedersehen!");
                break;
            } else {
                System.out.println("Ungültige Option. Bitte erneut versuchen.");
            }
        }
        scanner.close();
    }


    private void kundeHinzufuegen() {
        System.out.print("Name des Kunden: ");
        String name = scanner.nextLine();
        System.out.print("Gewünschtes Getränk (Cappuccino, Kaffee, FlatWhite, ColdBrew): ");
        String wunschGetraenk = scanner.nextLine();
        Kunde neuerKunde = new Kunde(name, wunschGetraenk);
        warteschlange.enqueue(neuerKunde);

        System.out.println("Kunde " + name + " wurde zur Warteschlange hinzugefügt.");
    }

    private void getraenkHinzufuegen() {
        System.out.print("Name des Getränks: ");
        String getraenkName = scanner.nextLine();
        System.out.print("Preis des Getränks: ");
        double preis = scanner.nextDouble();
        scanner.nextLine();

        getraenkeListe.append(new Getraenk(getraenkName, preis));
        System.out.println("Getränk " + getraenkName + " wurde der Getränkeliste hinzugefügt.");
    }

    private void getrechnung() {
        if (warteschlange.isEmpty()) {
            System.out.println("Warteschlange ist leer.");
            return;
        }


        kunde = warteschlange.dequeue();
        Rechnung rechnung = new Rechnung("20.02.2025", rechnungsStack.isEmpty() ? 1 : rechnungsStack.peek().getRechnungsnr() + 1, kunde.gesamtbetrag());
        rechnungsStack.push(rechnung);
        System.out.println("Rechnung für " + kunde.getName() + " wurde erstellt und abgelegt.");
    }


    private void zeigeWarteschlange() {

        // Gesamte Warteschlange anzeigen
        if (warteschlange.isEmpty()) {
            System.out.println("Warteschlange ist leer.");
        } else {
            System.out.println("Aktuelle Warteschlange:");
            for (Kunde kunde : warteschlange) {
                System.out.println("- " + kunde.getName());
            }
        }

    }

    private void fuelleKaffeeListeAuf() {
        getraenkeListe.append(new Getraenk("Cappuccino",3));
        getraenkeListe.append(new Getraenk("Kaffee",2));
        getraenkeListe.append(new Getraenk("FlatWhite",4));
        getraenkeListe.append(new Getraenk("ColdBrew",2));
    }
}





