package nl.dvberkel.demo.xml;

import java.util.Collections;
import java.util.List;

public class CannedResponseFortuneTeller implements FortuneTeller {
    private final List<String> fortunes;

    public CannedResponseFortuneTeller(List<String> fortunes) {
        this.fortunes = fortunes;
    }

    @Override
    public String fortune() {
        Collections.shuffle(fortunes);
        return fortunes.get(0);
    }
}
