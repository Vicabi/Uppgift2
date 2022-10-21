package Sprint_2.Inlämningsuppgift_2;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Method {


    public List readFile(Path p) {

        List<Member> tempList = new ArrayList<>();
        String temp;

        try (BufferedReader buf = new BufferedReader(new FileReader(p.toFile()))) {
            while ((temp = buf.readLine()) != null) {
                String idNumber = temp.substring(0, 10);
                String name = temp.substring(12);
                LocalDate payDate = LocalDate.parse(buf.readLine());

                Member x = new Member(idNumber, name, payDate);
                tempList.add(x);
            }
        } catch (
                FileNotFoundException e) {
            System.out.println("Filen hittades inte");
        } catch (
                IOException e) {
            System.out.println("Något fel har inträffat");
        }
        return tempList;
    }

    public int search(List<Member> x, String y) {
        for (Member i : x)
            if (i.getIdNumber().equals(y)) {
                int j = x.indexOf(i);
                boolean b = checkPayment(j, x);
                if (b == true)
                    return 0;
                else
                    return 1;
            }
        for (Member i : x)
            if (i.getName().equals(y)) {
                int j = x.indexOf(i);
                boolean b = checkPayment(j, x);
                if (b == true)
                    return 0;
                else
                    return 1;
            }
        return 2;
    }

    public boolean checkPayment(int j, List<Member> x) {
        LocalDate l = x.get(j).getPayDate();
        LocalDate oneYearAgo = LocalDate.now().minusYears(1);
        if (l.isAfter(oneYearAgo)) {
            registerVisit(j, x);
            return true;
        } else
            return false;
    }

    public void printInfoAboutMember(int j) {
        switch (j) {
            case 0 -> JOptionPane.showMessageDialog(null, "Personen är aktiv medlem" +
                    "\nBesöket har registrerats i filen \"Visits\"");
            case 1 -> JOptionPane.showMessageDialog(null, "Personen är inaktiv medlem");
            case 2 -> JOptionPane.showMessageDialog(null, "Personen har aldrig varit medlem");
        }
    }

    public void registerVisit(int j, List<Member> x) {
        Path p = Paths.get("src/Sprint_2/Inlämningsuppgift_2/Visits.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter
                ("src/Sprint_2/Inlämningsuppgift_2/Visits.txt", true))) {
            LocalDate l = LocalDate.now();
            if (!Files.exists(p))
                Files.createFile(p);
            bw.write("Namn: " + x.get(j).getName() + " Personnummer: " + x.get(j).getIdNumber()
                    + " Senaste besök: " + l);
            bw.newLine();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

}
