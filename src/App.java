public class App {
    public static void main(String[] args) throws Exception {
        Ladung ladung = new Ladung(5, 6, 7, 0, 1);
        Raumschiff r = new Raumschiff("Hans", "kapitaen", 100, 100, 100, 100, 4, 5, ladung);
        r.showZustand();
    }
}
