package lt.bta.java2;

import lt.bta.java2.entities.Pazymys;
import lt.bta.java2.entities.Studentas;
import lt.bta.java2.helpers.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Studentas> studentai = uzkrautiDuomenis();

        for (Studentas studentas:studentai) {
            System.out.println(studentas);
            System.out.println("----------------------------");
        }

        studentai.sort(Studentas::compareTo);
        studentai.forEach(s -> {
            System.out.println(s.getId() + " " +
                    s.getPavarde() + " " +
                    s.getVardas() + " " +
                    s.getPastas());
        });

//        studentai.sort((o1, o2) -> o1.compareTo(o2));
//
//        studentai.forEach(s -> {
//            System.out.println(s.getId() + " " +
//                    s.getPavarde() + " " +
//                    s.getVardas() + " " +
//                    s.getPastas());
//        });

        System.out.println("------------------------");
        System.out.println("Studentu bendras vidurkis: " + kursoVidurkis(2018));

    }

    private static List<Studentas> uzkrautiDuomenis(){
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Studentas> studentas = em.createQuery("select a from studentai a", Studentas.class).getResultList();
        return studentas;
    }

    private static int kursoVidurkis(int metai) {
        List<Studentas> studentai = uzkrautiDuomenis();
        int countAvg = 0;
        double studentasAvg = 0;

        for (Studentas s : studentai) {

            int count = 0;
            double sum = 0;

            for (Pazymys p : s.getPazymiai()) {

                if (p.getData().getYear() == metai) {

                    sum += p.getPazymys();
                }
                count++;
            }
            studentasAvg += sum / count;
            countAvg++;
        }
        return Math.incrementExact((int) studentasAvg / countAvg);

    }

}
