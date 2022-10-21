package Sprint_2.Inlämningsuppgift_2;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MethodTest {

    Method t = new Method();
    List <Member> testList = new ArrayList<>(); //
    Path testPath = Paths.get("Test/Sprint_2/Inlämningsuppgift_2/TestFile");

    @Test
    void readFile () {
        testList = t.readFile(testPath);
        assert (testList.size() == 4);
        assert (testList.size() != 5);
        assert (testList.get(3).getName().equals("Harald"));
        assert (!testList.get(3).getName().equals("Linda"));
        assert (!testList.get(1).getName().equals("Katarina"));
        assert (!testList.get(0).getIdNumber().equals("7612032222"));
    }

    @Test
    void search () {
        testList = t.readFile(testPath);
        String input1 = "Hannah"; // Finns på listan och metoden bör returnera nr 1, inaktiv medlem
        String input2 = "8207141232"; // Finns på listan och metoden bör returnera nr 0, aktiv medlem
        String input3 = "Jonas"; // Finns inte på listan och bör returnera nr 2, aldrig varit medlem
        assert (t.search(testList, input1) == 1);
        assert (t.search(testList, input2) == 0);
        assert (t.search(testList, input2) != 1);
        assert (t.search(testList, input3) == 2);
    }

    @Test
    void checkPayment () {
        testList = t.readFile(testPath);
        int input1 = 0;
        int input2 = 1;
        int input3 = 2;
        int input4 = 3;
        assert (t.checkPayment(input1, testList) == true);
        assert (t.checkPayment(input2, testList) == false);
        assert (!t.checkPayment(input2, testList) == true);
        assert (t.checkPayment(input3, testList) == true);
        assert (t.checkPayment(input4, testList) == false);
    }







}
