import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {

        Random random = new Random();

        ArrayList<Ladung> ladungKlingonen = new ArrayList<>();
        ArrayList<Ladung> ladungRomulaner = new ArrayList<>();
        ArrayList<Ladung> ladungVulkanier = new ArrayList<>();

        ladungKlingonen.add(new Ladung("Ferengi Schneckensaft", 200));
        ladungKlingonen.add(new Ladung("Bat'leth Schwert", 200));
        
        ladungRomulaner.add(new Ladung("Borg-Schrott", 5));
        ladungRomulaner.add(new Ladung("Rote Materie", 2));
        ladungRomulaner.add(new Ladung("Plasma-Waffe", 50));

        ladungVulkanier.add(new Ladung("Forschungssonde", 35));

        Raumschiff klingonen = new Raumschiff("IKS Hegh'ta", "", 100, 50, 0, 2, 100, 100, ladungKlingonen);
        Raumschiff romulaner = new Raumschiff("IRW Khazara", "kapitaen", 50, 50, 2, 2, 100, 100, ladungRomulaner);
        Raumschiff vulkanier = new Raumschiff("Ni'Var", "oashjif", random.nextFloat(100) + 1, random.nextFloat(100) + 1, 3, 5, 100, random.nextFloat(100) + 1, ladungVulkanier);
    
        klingonen.shootTorpedo(romulaner);
        System.out.println();
        romulaner.shootKanone(klingonen);
        System.out.println();
        vulkanier.notifyAll("Gewalt ist nicht logisch");
        System.out.println();
        klingonen.showZustand();
        System.out.println();
        vulkanier.showZustand();
        vulkanier.sendReparaturAuftrag(true, true, true, vulkanier.getAnzahlAndroiden());
        vulkanier.loadTorpedos(vulkanier.getAnzahlTorpedos());
        vulkanier.sweepLoadList();
        klingonen.shootTorpedo(romulaner);
        klingonen.shootTorpedo(romulaner);
        vulkanier.showZustand();
        klingonen.showZustand();
        romulaner.showZustand();
        Raumschiff.showLogbuchEintraege();
    }
}
