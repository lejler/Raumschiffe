public class Main {
    public static void main(String[] args) throws Exception {
        Ladung l = new Ladung("Torpedos", 2);
        Ladung l2 = new Ladung("Kanonen", 5);
        Ladung[] ladung = new Ladung[]{l, l2};
        Raumschiff r = new Raumschiff("Name", "kapitaen", 100, 100, 100, 100, ladung);
        r.showZustand();
    }
}
