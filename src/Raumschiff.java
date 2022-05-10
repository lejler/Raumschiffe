import java.util.ArrayList;

public class Raumschiff {
    private int energieversorgungInProzent;
    private int schutzschildeInProzent;
    private int lebenserhaltungssystemeInProzent;
    private int huelleInProzent;
    private int anzahlTorpedos;
    private int anzahlAndroiden;
    private static final ArrayList<String> BROADCAST_COMMUNICATOR;
    private Ladung ladungsverzeichnis;
    
    public Raumschiff() {
    }

    public Raumschiff(int energieversorgungInProzent, int schutzschildeInProzent, int lebenserhaltungssystemeInProzent, 
                      int huelleInProzent, int anzahlTorpedos, int anzahlAndroiden, Ladung ladungsverzeichnis) {
                          
        this.energieversorgungInProzent = energieversorgungInProzent;
        this.schutzschildeInProzent = schutzschildeInProzent;
        this.lebenserhaltungssystemeInProzent = lebenserhaltungssystemeInProzent;
        this.huelleInProzent = huelleInProzent;
        this.anzahlTorpedos = anzahlTorpedos;
        this.anzahlAndroiden = anzahlAndroiden;
        this.ladungsverzeichnis = ladungsverzeichnis;
    }

    public void shootTorpedo(Raumschiff raumschiff) {
        //TODO
    }

    public void shootKanone(Raumschiff raumschiff) {
        //TODO
    }

    private void hit() {
        //TODO
    }

    public void notifyAll(String message) {
        System.out.println(message);
    }

    public void addLadung(Ladung ladung) {
        //TODO
    }

    public ArrayList<String> showLogbuchEintraege(ArrayList<String> broadcastCommunicator) {
        return null;
    }

    public void rohreLaden(int anzahlTorpedos) {

    }

    public void sendReparaturAuftrag(boolean schutzschild, boolean energieversorgung, boolean huelle) {
        
    }

    private boolean hasTorpedos() {
        return false;
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

    public static ArrayList<String> getBroadcastCommunicator() {
        return BROADCAST_COMMUNICATOR;
    }

    public Ladung getLadungsverzeichnis() {
        return ladungsverzeichnis;
    }

    public void setLadungsverzeichnis(Ladung ladungsverzeichnis) {
        this.ladungsverzeichnis = ladungsverzeichnis;
    }

    

}
