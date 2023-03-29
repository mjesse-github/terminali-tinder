import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

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

    public static void failistLugemine(String failinimi) throws IOException {

        File fail = new File(failinimi);

        List<String> read = Files.readAllLines(fail.toPath(), StandardCharsets.UTF_8);

        for (String s : read) {
            boolean kokkamineKoristamine;
            int sulgVõiRaud;
            boolean müslisupp;
            boolean jalutuskäik;
            boolean ananass;
            String[] a = s.split(";");
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
            if (a[6] == "jah") {
                jalutuskäik = true;
            } else {
                jalutuskäik = false;
            }
            if (a[7] == "pitsa ananassi peal") {
                ananass = true;
            } else {
                ananass = false;
            }

            isik tegelane = new isik(a[0], parseInt(a[1]), kokkamineKoristamine, a[3], müslisupp, parseInt(a[5]), jalutuskäik, ananass, a[8]);
            inimesed.add(tegelane);

        }
    }
    public static void failiKirjutamine(String sõne, String failinimi) throws IOException {
        File file = new File(failinimi);
        FileWriter fr = new FileWriter(file,true);
        BufferedWriter br = new BufferedWriter(fr);
        br.write("\n"+sõne);
        br.close();
        fr.close();
    }

    public static void main(String[] args) throws IOException {
        failistLugemine("andmebaas.txt");
        Scanner object = new Scanner(System.in);
        System.out.println("Sisesta nimi");
        String nimi = object.nextLine();
        System.out.println("Sisesta oma vanus(numbriga)");
        int vanus = parseInt(object.nextLine());
        System.out.println("Kas sulle meeldib kokata ja koristada? (jah/ei)");
        String kokkamineKoristamine1 = object.nextLine();
        boolean kokkamineKoristamine = false;
        if (kokkamineKoristamine1 == "jah\n") {
            kokkamineKoristamine = true;
        }
        System.out.println("Mis muusikat sa kuulad?(vasta sama kirjapildiga)" + "\n" + "koit toome" + "\n" + "liis lemsalu" + "\n" + "5 miiiinust" + "\n" + "genialistid" + "\n" + "ruja");
        String muusika = object.nextLine();
        System.out.println("Kas müsli on supp? (jah/ei)");
        String müslisupp1 = object.nextLine();
        boolean müslisupp = false;
        if (müslisupp1 == "jah\n") {
            müslisupp = true;
        }
        System.out.println("Kumb on raskem, kas kilo rauda või kilo sulgi? (vastus sisesta täisarvuna vahemikus 1 kuni 4");
        int raudVõiSulg = parseInt(object.nextLine());
        System.out.println("Kas nautled pikki jalutuskäike rannas? (jah/ei)");
        String jalutuskäik1 = object.nextLine();
        boolean jalutuskäik = false;
        if (jalutuskäik1 == "jah\n") {
            jalutuskäik = true;
        }
        System.out.println("Kumb on õige? pitsa ananassi peal või ananass pitsapeal?(jälgi vastates kirjapilti)");
        String pitsa1 = object.nextLine();
        boolean pitsa = false;
        if (pitsa1 == "pitsa ananassi peal") {
            pitsa = true;
        }
        System.out.println("Sisesta oma lemmiknumber");
        String lemmiknumber = object.nextLine();
        System.out.println("mitme erinevusega lepid sõbras?(numbriga)");
        int erinevused = parseInt(object.nextLine());
        isik uuritav = new isik(nimi,vanus,kokkamineKoristamine,muusika,müslisupp,raudVõiSulg,jalutuskäik,pitsa,lemmiknumber);
        List<isik> sõbrad = leiaMatchid(uuritav, erinevused);
        if (sõbrad.size() != 0) {
            System.out.print("Meie andmebaasis sulle sarnased inimesed: ");
            for (isik sõber: sõbrad) {
                System.out.print(sõber.toString() +", ");
            }
        } else {
            System.out.println("Meie andmebaasis sulle sõpru ei leidu");
        }
        failiKirjutamine((nimi+";"+vanus+";"+kokkamineKoristamine1+";"+muusika+";"+müslisupp1+";"+raudVõiSulg+";"+jalutuskäik1+";"+pitsa1+";"+lemmiknumber), "andmebaas.txt");}
}
