package mobile.forkit.forkit_client.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by horimori on 6/25/17.
 */

public class StringJoiner {
    String delim, prefix, suffix;
    List<String> parts;
    public StringJoiner(String delim, String prefix, String suffix) {
        this.delim = delim;
        this.prefix = prefix;
        this.suffix = suffix;
        this.parts = new ArrayList<>();
    }

    public StringJoiner add(String s) {
        parts.add(s); return this;
    }

    public StringJoiner add(int s) {
        parts.add(Integer.toString(s));
        return this;
    }

    public StringJoiner add(double s) {
        parts.add(Double.toString(s));
        return this;
    }

    public StringJoiner add(boolean s) {
        parts.add(Boolean.toString(s));
        return this;
    }

    public StringJoiner addAll(List<String> s) {
        parts.addAll(s);
        return this;
    }

    public String toString() {
        String s = prefix;
        for (int i = 0; i < parts.size(); i++) {
            s += parts.get(i);
            if (i < parts.size() - 1) {
                s += delim;
            }
        }
        s += suffix;
        return s;
    }

    public String collect(StringJoiner... joiners) {
        for (StringJoiner s : joiners) {
            this.add(s.toString());
        }
        return this.toString();
    }

    public void clear() {
        parts.clear();
    }
}
