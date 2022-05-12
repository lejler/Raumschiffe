public class Main {
    public static void main(String[] args) throws Exception {
        Ladung l = new Ladung("Stuff", 2);
        Ladung l2 = new Ladung("Kram", 7);
        Ladung l3 = new Ladung("Kanonen", 5);
        Ladung[] ladung = new Ladung[]{l, l2, l3};
        Raumschiff r = new Raumschiff("Name", "kapitaen", 100, 100, 2, 100, 100, ladung);
        r.showZustand();
    }
}
