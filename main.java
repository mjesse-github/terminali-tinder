import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import static java.lang.Integer.parseInt;

public class main {

    public static List<isik> leiaMatchid(isik otsivIsik, int lubatudVead, andmebaas andmed) throws IOException {
        List<isik> matchid = new ArrayList<>();
        for (isik isik : andmed.getAndmed()) {
            int counter = 0;

            if (!isik.getMeeldibKokataJaKoristada().contains(otsivIsik.getMeeldibKokataJaKoristada())) {
                counter+=1;
            }
            if (!isik.getMuusikamaitse().contains(otsivIsik.getMuusikamaitse())) {
                counter+=1;
            }
            if (!isik.getKasMüsliOnSupp().contains(otsivIsik.getKasMüsliOnSupp())) {
                counter+=1;
            }
            if (!isik.getMeeldivadPikadJalutuskäigudRannas().contains(otsivIsik.getMeeldivadPikadJalutuskäigudRannas())) {
                counter+=1;
            }
            if (!isik.getLemmiknumber().contains(otsivIsik.getLemmiknumber())) {
                counter+=1;
            }
            if (!isik.getKasAnanassPitsal().contains(otsivIsik.getKasAnanassPitsal())) {
                counter+=1;
            }
            if (isik.getRaudVõiSulg() != otsivIsik.getRaudVõiSulg())
            if (counter <= lubatudVead) {
                matchid.add(isik);
                }
        }
        return matchid;
    }

    public static void failistLugemine(String failinimi, andmebaas andmed) throws IOException {
        //List<isik> andmed = new ArrayList<>();
        File fail = new File(failinimi);
            try (Scanner scanner = new Scanner(fail, "UTF-8")) {
            while (scanner.hasNextLine()) {
                String rida = scanner.nextLine();
                String[] osad = rida.split(";");
                andmed.lisaIsik(new isik(osad[0], parseInt(osad[1]), osad[2], osad[3], osad[4], parseInt(osad[5]), osad[6], osad[7], osad[8]));
                //andmed.add(new isik(osad[0], parseInt(osad[1]), osad[2], osad[3], osad[4], parseInt(osad[5]), osad[6], osad[7], osad[8]));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
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
        andmebaas andmed = new andmebaas();
        failistLugemine("andmebaas.txt", andmed);

        Scanner object = new Scanner(System.in);
        System.out.println("Sisesta nimi");
        String nimi = object.nextLine();
        System.out.println("Sisesta oma vanus(numbriga)");
        int vanus = parseInt(object.nextLine());
        System.out.println("Kas sulle meeldib kokata ja koristada? (jah/ei)");
        String kokkamineKoristamine = object.nextLine();
        System.out.println("Mis muusikat sa kuulad?(vasta sama kirjapildiga)" + "\n" + "koit toome" + "\n" + "liis lemsalu" + "\n" + "5 miiiinust" + "\n" + "genialistid" + "\n" + "ruja");
        String muusika = object.nextLine();
        System.out.println("Kas müsli on supp? (jah/ei)");
        String müslisupp = object.nextLine();
        System.out.println("Kumb on raskem, kas kilo rauda või kilo sulgi? (vastus sisesta täisarvuna vahemikus 1 kuni 4");
        int raudVõiSulg = parseInt(object.nextLine());
        System.out.println("Kas nautled pikki jalutuskäike rannas? (jah/ei)");
        String jalutuskäik = object.nextLine();
        System.out.println("Kumb on õige? pitsa ananassi peal või ananass pitsapeal?(jälgi vastates kirjapilti)");
        String pitsa = object.nextLine();
        System.out.println("Sisesta oma lemmiknumber");
        String lemmiknumber = object.nextLine();
        int erinevused = 0;

        isik uuritav = new isik(nimi,vanus,kokkamineKoristamine,muusika,müslisupp,raudVõiSulg,jalutuskäik,pitsa,lemmiknumber);


        List<isik> sõbrad = new ArrayList<>();
        System.out.println(uuritav.toStringer());
        while (sõbrad.size() == 0) {
            sõbrad = leiaMatchid(uuritav, erinevused, andmed);
            if (sõbrad.size() != 0) {
                break;
            } else {
                erinevused ++;
            }
        }
        System.out.print("Meie andmebaasis sulle sarnased inimesed: ");
        for (isik sõber: sõbrad) {
            System.out.print(sõber.toString() +", ");
        }
        System.out.print("\n");
        System.out.println("Soovitame sul ruletis panustada kogu oma raha numbrile " + (int)(Math.random()*40));
        failiKirjutamine((nimi+";"+vanus+";"+kokkamineKoristamine+";"+muusika+";"+müslisupp+";"+raudVõiSulg+";"+jalutuskäik+";"+pitsa+";"+lemmiknumber), "andmebaas.txt");
    }
}

