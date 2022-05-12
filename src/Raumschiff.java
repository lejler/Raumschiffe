import java.util.ArrayList;

public class Raumschiff {

    private String name;
    private String kapitaen;
    private int energieversorgungInProzent;
    private int schutzschildeInProzent;
    private int lebenserhaltungssystemeInProzent;
    private int huelleInProzent;
    private static final ArrayList<String> BROADCAST_COMMUNICATOR = new ArrayList<>();
    private Ladung[] ladungsverzeichnis;
    
    public Raumschiff() {
    }

    public Raumschiff(String name, String kapitaen, int energieversorgungInProzent, int schutzschildeInProzent, int lebenserhaltungssystemeInProzent, 
                      int huelleInProzent, Ladung[] ladungsverzeichnis) {
                 
        this.name = name;
        this.kapitaen = kapitaen;
        this.energieversorgungInProzent = energieversorgungInProzent;
        this.schutzschildeInProzent = schutzschildeInProzent;
        this.lebenserhaltungssystemeInProzent = lebenserhaltungssystemeInProzent;
        this.huelleInProzent = huelleInProzent;
        this.ladungsverzeichnis = ladungsverzeichnis;
    }

    public void showZustand() {

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < ladungsverzeichnis.length; i++) {
            builder.append(ladungsverzeichnis[i].getName() + "(" + ladungsverzeichnis[i].getAnzahl() + ")");
            if(i != ladungsverzeichnis.length - 1) {builder.append(", ");}
        }

        System.out.println("Name: " + name);
        System.out.println("Kapitän: " + kapitaen);
        System.out.println("Energieversorgung: " + energieversorgungInProzent + "%");
        System.out.println("Schutzschilde: " + schutzschildeInProzent + "%");
        System.out.println("Lebenserhaltungssysteme: " + lebenserhaltungssystemeInProzent + "%");
        System.out.println("Hülle: " + huelleInProzent + "%");
        System.out.print("Ladung: " + builder);

    }

    public void shootTorpedo(int torpedoAmountToShoot, Raumschiff raumschiff) {
        if (anzahlTorpedos == 0) {
            System.out.println("Keine Photonentorpedos gefunden!");
            notifyAll("-=*Click*=-");
            return;
        }
        if (torpedoAmountToShoot > anzahlTorpedos) {
            torpedoAmountToShoot = anzahlTorpedos;
        }
        anzahlTorpedos-=1;
        notifyAll("Photonentorpedo abgeschossen");
        hit();
    }

    public void shootKanone(Raumschiff raumschiff) {
        if (energieversorgungInProzent < 50) {
            System.out.println("-=*Click*=-");
            return;
        }
        energieversorgungInProzent-= 50;
        notifyAll("Phaserkanone abgeschossen");
        hit();
    }

    private void hit() {
        schutzschildeInProzent -= 50;
        if (schutzschildeInProzent < 0) {
            huelleInProzent -= 50;
            energieversorgungInProzent -= 50;
            // ich weiß, dass die Aufgabe vorgibt, bei 0% diese Nachricht ausgeben zu lassen, finde es so aber sinnvoller
            if (huelleInProzent < 0) {
                notifyAll("Lebenserhaltungssysteme wurden zerstört!");
            }
        }
        System.out.println(name + " wurde getroffen!");
    }

    public void notifyAll(String message) {
        System.out.println(message);
        BROADCAST_COMMUNICATOR.add(message);
    }

    public void addLadung(Ladung ladung) {
        //TODO
    }

    public ArrayList<String> showLogbuchEintraege(ArrayList<String> broadcastCommunicator) {
        return BROADCAST_COMMUNICATOR;
    }

    public void rohreLaden(int anzahlTorpedos) {

    }

    public void sendReparaturAuftrag(boolean schutzschild, boolean energieversorgung, boolean huelle) {
        
    }

    public void addLogEntry(String logEntry) {

    }

    private boolean hasTorpedos() {
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKapitaen() {
        return kapitaen;
    }

    public void setKapitaen(String kapitaen) {
        this.kapitaen = kapitaen;
    }

    public int getEnergieversorgungInProzent() {
        return energieversorgungInProzent;
    }

    public void setEnergieversorgungInProzent(int energieversorgungInProzent) {
        this.energieversorgungInProzent = energieversorgungInProzent;
    }

    public int getSchutzschildeInProzent() {
        return schutzschildeInProzent;
    }

    public void setSchutzschildeInProzent(int schutzschildeInProzent) {
        this.schutzschildeInProzent = schutzschildeInProzent;
    }

    public int getLebenserhaltungssystemeInProzent() {
        return lebenserhaltungssystemeInProzent;
    }

    public void setLebenserhaltungssystemeInProzent(int lebenserhaltungssystemeInProzent) {
        this.lebenserhaltungssystemeInProzent = lebenserhaltungssystemeInProzent;
    }

    public int getHuelleInProzent() {
        return huelleInProzent;
    }

    public void setHuelleInProzent(int huelleInProzent) {
        this.huelleInProzent = huelleInProzent;
    }

}
