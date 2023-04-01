import java.util.Collection;
import java.util.UUID;

class isik implements Comparable<isik> {
    private static String nimi;
    private static int vanus;
    private static String meeldibKokataJaKoristada;
    private static String muusikamaitse;
    private static String kasMüsliOnSupp;
    private static int raudVõiSulg;
    private static String meeldivadPikadJalutuskäigudRannas;
    private static String kasAnanassPitsal;
    private static String lemmiknumber; //tere

    public isik(String nimi,
                int vanus,
                String meeldibKokataJaKoristada,
                String muusikamaitse,
                String kasMüsliOnSupp,
                int raudVõiSulg,
                String meeldivadPikadJalutuskäigudRannas,
                String kasAnanassPitsal,
                String lemmiknumber) {
        this.nimi = nimi;
        this.vanus = vanus;
        this.meeldibKokataJaKoristada = meeldibKokataJaKoristada;
        this.muusikamaitse = muusikamaitse;
        this.kasMüsliOnSupp = kasMüsliOnSupp;
        this.raudVõiSulg = raudVõiSulg;
        this.meeldivadPikadJalutuskäigudRannas = meeldivadPikadJalutuskäigudRannas;
        this.kasAnanassPitsal = kasAnanassPitsal;
        this.lemmiknumber = lemmiknumber;
    }

    public static String getNimi() {
        return nimi;
    }

    public int getVanus() {
        return vanus;
    }

    public static String getMeeldibKokataJaKoristada() {
        return meeldibKokataJaKoristada;
    }

    public static String getMuusikamaitse() {
        return muusikamaitse;
    }

    public static String getKasMüsliOnSupp() {
        return kasMüsliOnSupp;
    }

    public int getRaudVõiSulg() {return raudVõiSulg;}

    public static String getMeeldivadPikadJalutuskäigudRannas() {
        return meeldivadPikadJalutuskäigudRannas;
    }

    public String getKasAnanassPitsal() {
        return kasAnanassPitsal;
    }

    public static String getLemmiknumber() {
        return lemmiknumber;
    }

    public static String toStringer() {
        return nimi+";"+vanus+";"+meeldibKokataJaKoristada + ";"+ muusikamaitse + ";" + kasMüsliOnSupp + ";" + raudVõiSulg +
                ";" + meeldivadPikadJalutuskäigudRannas +
                ";" + kasAnanassPitsal +
                ";" + lemmiknumber;
    }

    @Override
    public String toString() {
        return nimi + ", kes on " + vanus + " aastat vana";
    }

    @Override
    public int compareTo(isik o) {
        return 0;
    }
}