import java.util.ArrayList;
import java.util.List;

public class andmebaas {
    private List<isik> andmed = new ArrayList<>();

    public andmebaas() {
    }

    public List<isik> getAndmed() {
        return andmed;
    }

    public void lisaIsik(isik lisatav) {
        andmed.add(lisatav);
    }
}
