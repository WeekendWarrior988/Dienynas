package lt.bta.java2.entities;

import javax.persistence.*;
import java.util.List;

@Entity(name = "studentai")
public class Studentas implements Comparable<Studentas> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String vardas;

    private String pavarde;

    @Column(name = "el_paštas")
    private String pastas;


    @OneToMany(mappedBy = "studentas", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pazymys> pazymiai;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public String getPastas() {
        return pastas;
    }

    public void setPastas(String pastas) {
        this.pastas = pastas;
    }

    public List<Pazymys> getPazymiai() {
        return pazymiai;
    }

    public void setPazymiai(List<Pazymys> pazymiai) {
        this.pazymiai = pazymiai;
    }

    @Override
    public int compareTo(Studentas o) {
        int compare = this.getPavarde().compareTo(o.getPavarde());
        if (compare <= 0) return compare;

        return this.getVardas().compareTo(o.getVardas());
    }

    @Override
    public String toString() {
        return "Studentas{" +
                "id=" + id +
                ", vardas='" + vardas + '\'' +
                ", pavarde='" + pavarde + '\'' +
                ", pastas='" + pastas + '\'' +
                ", pazymiai=" + pazymiai +
                '}';
    }
}
