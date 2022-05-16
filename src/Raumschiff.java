import java.util.ArrayList;
import java.util.Random;

public class Raumschiff {

    private String name;
    private String kapitaen;
    private float energieversorgungInProzent;
    private float schutzschildeInProzent;
    private int anzahlTorpedos;
    private int anzahlAndroiden;
    private float lebenserhaltungssystemeInProzent;
    private float huelleInProzent;
    private static final ArrayList<String> BROADCAST_COMMUNICATOR = new ArrayList<>();
    private ArrayList<Ladung> ladungsverzeichnis = new ArrayList<>();
    
    public Raumschiff() {
    }

    public Raumschiff(String name, String kapitaen, float energieversorgungInProzent, float schutzschildeInProzent, int anzahlTorpedos, int anzahlAndroiden, float lebenserhaltungssystemeInProzent, 
                      float huelleInProzent, ArrayList<Ladung> ladungsverzeichnis) {
                 
        this.name = name;
        this.kapitaen = kapitaen;
        this.energieversorgungInProzent = energieversorgungInProzent;
        this.schutzschildeInProzent = schutzschildeInProzent;
        this.anzahlTorpedos = anzahlTorpedos;
        this.anzahlAndroiden = anzahlAndroiden;
        this.lebenserhaltungssystemeInProzent = lebenserhaltungssystemeInProzent;
        this.huelleInProzent = huelleInProzent;
        this.ladungsverzeichnis = ladungsverzeichnis;
    }

    public void showZustand() {

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < ladungsverzeichnis.size(); i++) {
            builder.append(ladungsverzeichnis.get(i).toString());
            if(i != ladungsverzeichnis.size() - 1) builder.append(", ");
        }

        System.out.println("Name: " + name);
        System.out.println("Kapitän: " + kapitaen);
        System.out.println("Energieversorgung: " + energieversorgungInProzent + "%");
        System.out.println("Schutzschilde: " + schutzschildeInProzent + "%");
        System.out.println("Lebenserhaltungssysteme: " + lebenserhaltungssystemeInProzent + "%");
        System.out.println("Hülle: " + huelleInProzent + "%");
        System.out.print("Ladung: " + builder + "\n\n");

    }

    public void shootTorpedo(Raumschiff raumschiff) {
        if (anzahlTorpedos == 0) {
            notifyAll("-=*Click*=-");
            return;
        }
        anzahlTorpedos -= 1;
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
            if (huelleInProzent <= 0) {
                notifyAll("Lebenserhaltungssysteme wurden zerstört!");
            }
        }
        System.out.println(name + " wurde getroffen!");
    }

    public void notifyAll(String message) {
        BROADCAST_COMMUNICATOR.add(message);
    }

    public void addLadung(Ladung ladung) {
        ladungsverzeichnis.add(ladung);
    }

    public static ArrayList<String> showLogbuchEintraege() {
        for (int i = 0; i < BROADCAST_COMMUNICATOR.size(); i++) {
            System.out.println(BROADCAST_COMMUNICATOR.get(i));
        }
        return BROADCAST_COMMUNICATOR;
    }

    public void sendReparaturAuftrag(boolean schutzschild, boolean energieversorgung, boolean huelle, int amountAndroidenToUse) {
        if (amountAndroidenToUse > anzahlAndroiden) amountAndroidenToUse = anzahlAndroiden;
        boolean[] schiffskomponenten = new boolean[]{schutzschild, energieversorgung, huelle};
        ArrayList<Boolean> temp = new ArrayList<>();

        for (int i = 0; i < schiffskomponenten.length; i++) {
            if (schiffskomponenten[i]) temp.add(schiffskomponenten[i]);
        }

        Random r = new Random();
        int randomInt = r.nextInt(100) + 1;
        
        float amountToRepair = randomInt * amountAndroidenToUse / temp.size();

        if (schutzschild) schutzschildeInProzent += amountToRepair;
        if (energieversorgung) energieversorgungInProzent += amountToRepair;
        if (huelle) huelleInProzent += amountToRepair;
    }

    public void addLogEntry(String logEntry) {
        BROADCAST_COMMUNICATOR.add(logEntry);
    }

    public void sweepLoadList() {
        for (int i = 0; i < ladungsverzeichnis.size(); i++) {
            if (ladungsverzeichnis.get(i).getAnzahl() == 0) ladungsverzeichnis.remove(i);
        }
    }

    public void loadTorpedos(int amountTorpedosToUse) {
        for (int i = 0; i < ladungsverzeichnis.size(); i++) {
            if (ladungsverzeichnis.get(i).equals("Photonentorpedos")) {
                if (amountTorpedosToUse > ladungsverzeichnis.get(i).getAnzahl()) {
                    amountTorpedosToUse = ladungsverzeichnis.get(i).getAnzahl();
                } else {
                    ladungsverzeichnis.get(i).setAnzahl(ladungsverzeichnis.get(i).getAnzahl() - amountTorpedosToUse);
                }
                anzahlTorpedos = amountTorpedosToUse;
                System.out.println(amountTorpedosToUse + " Photonentorpedo(s) eingesetzt");
            } else {
                System.out.println("Keine Photonentorpedos gefunden!");
                notifyAll("-=*Click*=-");
                return;
            }
        }
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

    public float getEnergieversorgungInProzent() {
        return energieversorgungInProzent;
    }

    public void setEnergieversorgungInProzent(float energieversorgungInProzent) {
        this.energieversorgungInProzent = energieversorgungInProzent;
    }

    public float getSchutzschildeInProzent() {
        return schutzschildeInProzent;
    }

    public void setSchutzschildeInProzent(float schutzschildeInProzent) {
        this.schutzschildeInProzent = schutzschildeInProzent;
    }

    public float getLebenserhaltungssystemeInProzent() {
        return lebenserhaltungssystemeInProzent;
    }

    public void setLebenserhaltungssystemeInProzent(float lebenserhaltungssystemeInProzent) {
        this.lebenserhaltungssystemeInProzent = lebenserhaltungssystemeInProzent;
    }

    public float getHuelleInProzent() {
        return huelleInProzent;
    }

    public void setHuelleInProzent(float huelleInProzent) {
        this.huelleInProzent = huelleInProzent;
    }

    public int getAnzahlTorpedos() {
        return anzahlTorpedos;
    }

    public void setAnzahlTorpedos(int anzahlTorpedos) {
        this.anzahlTorpedos = anzahlTorpedos;
    }

    public int getAnzahlAndroiden() {
        return anzahlAndroiden;
    }

    public void setAnzahlAndroiden(int anzahlAndroiden) {
        this.anzahlAndroiden = anzahlAndroiden;
    }

}
