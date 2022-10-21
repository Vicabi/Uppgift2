package Sprint_2.Inlämningsuppgift_2;

import java.time.LocalDate;

public class Member {

    private String idNumber;
    private String name;
    private LocalDate payDate;

    public Member () {}

    public Member(String x, String y, LocalDate z) {
        idNumber = x;
        name = y;
        payDate = z;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getName() {
        return name;
    }

    public LocalDate getPayDate() {
        return payDate;
    }
}
