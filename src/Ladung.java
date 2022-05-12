public class Ladung {

    private String name;
    private int anzahl;

    public Ladung() {  
    }

    public Ladung(String name, int anzahl) {
        this.name = name;
        this.anzahl = anzahl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

}