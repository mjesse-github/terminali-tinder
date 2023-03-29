import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    private static List<isik> inimesed = new ArrayList<>();

    public static List<isik> leiaMatchid(isik otsivIsik, int lubatudVead) {
        List<isik> matchid = new ArrayList<>();
        for (isik isik : inimesed) {
            int counter = 0;
            if (otsivIsik.isMeeldibKokataJaKoristada() != isik.isMeeldibKokataJaKoristada()) {
                counter++;
            }
            if (otsivIsik.getMuusikamaitse() != isik.getMuusikamaitse()) {
                counter++;
            }
            if (otsivIsik.isKasMüsliOnSupp() != isik.isKasMüsliOnSupp()) {
                counter++;
            }
            if (otsivIsik.isMeeldivadPikadJalutuskäigudRannas() != isik.isMeeldivadPikadJalutuskäigudRannas()) {
                counter++;
            }
            if (otsivIsik.getLemmiknumber() != isik.getLemmiknumber()) {
                counter++;
            }
            if (counter <= lubatudVead) {
                matchid.add(isik);
            }
        }
        return matchid;
    }

    public static List<isik> failistLugemine(String failinimi) throws IOException {

        File fail = new File(failinimi);

        List<isik> andmed = new ArrayList<>();
        List<String> read = Files.readAllLines(fail.toPath(), StandardCharsets.UTF_8);

        for (String s : read) {
            boolean kokkamineKoristamine;
            boolean müslisupp;
            boolean jalutuskäik;
            boolean ananass;

            String[] a = s.split("\t ");
            if (a[2] == "jah") {
                kokkamineKoristamine = true;
            } else {
                kokkamineKoristamine = false;
            }
            if (a[4] == "jah") {
                müslisupp = true;
            } else {
                müslisupp = false;
            }
            if (a[5] == "jah") {
                jalutuskäik = true;
            } else {
                jalutuskäik = false;
            }
            if (a[6] == "pitsa ananassi peal") {
                ananass = true;
            } else {
                ananass = false;
            }

            isik tegelane = new isik(a[0], Integer.parseInt(a[1]), kokkamineKoristamine, a[3], müslisupp, Integer.parseInt(a[5]), jalutuskäik, ananass, a[8]);
            andmed.add(tegelane);

        }
        return andmed;
    }
    public static void failiKirjutamine(String sõne, String failinimi) throws IOException {
        File file = new File(failinimi);
        FileWriter fr = new FileWriter(file,true);
        BufferedWriter br = new BufferedWriter(fr);
        br.write(sõne);

        br.close();
        fr.close();
    }

    public static void main(String[] args) throws IOException {
        failistLugemine("andmebaas.txt");
        Scanner object = new Scanner(System.in);
        System.out.println("Sisesta nimi");
        String nimi = object.nextLine();
        System.out.println("Sisesta oma vanus(numbriga)");
        int vanus = Integer.parseInt(object.nextLine());
        System.out.println("Kas sulle meeldib kokata ja koristada? (jah/ei)");
        String kokkamineKoristamine = object.nextLine();
        System.out.println("Mis muusikat sa kuulad?(vasta sama kirjapildiga)" + "\n" + "koit toome" + "\n" + "liis lemsalu" + "\n" + "5 miiiinust" + "\n" + "genialistid" + "\n" + "ruja");
        String muusika = object.nextLine();
        System.out.println("Kas müsli on supp? (jah/ei)");
        String müslisupp = object.nextLine();
        System.out.println("Kumb on raskem, kas kilo rauda või kilo sulgi? (vastus sisesta täisarvuna vahemikus 1 kuni 4");
        int raudVõiSulg = Integer.parseInt(object.nextLine());
        System.out.println("Kas nautled pikki jalutuskäike rannas? (jah/ei)");
        String jalutuskäik = object.nextLine();
        System.out.println("Kumb on õige? pitsa ananassi peal või ananass pitsapeal?(jälgi vastates kirjapilti)");
        String pitsa = object.nextLine();
        System.out.println("Sisesta oma lemmiknumber");
        String lemmiknumber = object.nextLine();

        
        failiKirjutamine((nimi+"\t"+vanus+"\t"+kokkamineKoristamine+"\t"+muusika+"\t"+müslisupp+"\t"+raudVõiSulg+"\t"+jalutuskäik+"\t"+pitsa+"\t"+lemmiknumber), "andmebaas.txt");

        isik Mihkel = new isik("Mihkel", 20, true, "Genialistid", true, 4, true, true, "1");
    }
}
