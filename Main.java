package Sprint_2.Inlämningsuppgift_2;

import javax.swing.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main (String[] args) {



        Method m = new Method();
        Path p = Paths.get("src/Sprint_2/Inlämningsuppgift_2/File.txt");
        List <Member> memberList = new ArrayList<>();

        memberList = m.readFile(p); // börjar med att läsa filen och skapa en lista med medlemsobjekt


        try {
            String input = JOptionPane.showInputDialog("Sök på hela namnet eller personnummer (10 siffror):");
            input = input.trim();
            int x = m.search(memberList, input); // söker om medlemmen hittas i filen
            m.printInfoAboutMember(x); // talar om ifall det är en aktiv medlem, inaktiv eller aldrig varit medlem
            System.exit(0);
        }
        catch (NullPointerException e){
            JOptionPane.showMessageDialog(null, "Du har valt att avbryta programmet");
            System.exit(0);
        }
    }
}
