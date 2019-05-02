package lt.bta.java2.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "pazymiai")
public class Pazymys {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate data;

    private int pazymys;

    @ManyToOne(fetch = FetchType.LAZY)
    private Studentas studentas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getPazymys() {
        return pazymys;
    }

    public void setPazymys(int pazymys) {
        this.pazymys = pazymys;
    }

    public Studentas getStudentas() {
        return studentas;
    }

    public void setStudentas(Studentas studentas) {
        this.studentas = studentas;
    }

    @Override
    public String toString() {
        return "Pazymys{" +
                "id=" + id +
                ", data=" + data +
                ", pazymys=" + pazymys +
//                ", studentas=" + studentas +
                '}';
    }
}
