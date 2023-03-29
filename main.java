import java.util.ArrayList;
import java.util.List;

public class main {

    private static List<isik> inimesed = new ArrayList<>();
    public static List<isik> leiaMatchid(isik otsivIsik, int lubatudVead) {
        List<isik> matchid = new ArrayList<>();
        for (isik isik: inimesed) {
            int counter = 0;
            if (otsivIsik.isMeeldibKokataJaKoristada() != isik.isMeeldibKokataJaKoristada()) {counter ++;}
            if (otsivIsik.getMuusikamaitse() != isik.getMuusikamaitse()) {counter ++;}
            if (otsivIsik.isKasMüsliOnSupp() != isik.isKasMüsliOnSupp()) {counter ++;}
            if (otsivIsik.isMeeldivadPikadJalutuskäigudRannas() != isik.isMeeldivadPikadJalutuskäigudRannas()) {counter ++;}
            if (otsivIsik.getLemmiknumber() != isik.getLemmiknumber()) {counter ++;}
            if (counter <= lubatudVead) {
                matchid.add(isik);
            }
        }
        return matchid;
    };
    public static void main(String[] args) {
        isik Mihkel = new isik("Mihkel", 20, true, "Genialistid", true, true, true, "1");
    }
}
