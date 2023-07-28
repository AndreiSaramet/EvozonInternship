package people;

import java.util.List;

public class Nurse extends MedicalStaff {
    private KindLevel kindLevel;

    public Nurse(String name) {
        super(name);
    }

    public KindLevel getKindLevel() {
        return kindLevel;
    }

    public void setKindLevel(KindLevel kindLevel) {
        this.kindLevel = kindLevel;
    }

    public List<String> nurseDog() {
        return List.of("pet", "pamper");
    }
}
