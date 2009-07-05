package complexescomparing;

import java.util.Collection;
import java.util.TreeSet;

/**
 *
 * @author misiek (mw219725@gmail.com)
 */
public class Complex implements Comparable<Complex> {

    private String name;
    private Collection<String> proteins = new TreeSet<String>();

    public Complex(String name) {
        this.name = name;
    }

    public Collection<String> getProteins() {
        return proteins;
    }

    public void setProteins(Collection<String> proteins) {
        this.proteins = proteins;
    }

    public void addProtein(String protein) {
        this.proteins.add(protein);
    }

    public String getName() {
        return name;
    }

    public int compareTo(Complex c) {
        return this.getName().compareTo(c.getName());
    }

    public int size() {
        return proteins.size();
    }
}
