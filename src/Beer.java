import java.time.LocalDate;
import java.time.Month;

public class Beer extends Drinks {
    float alcohol;
    int shelfDate = 30;

    Beer(String n, double c, float a, int year, Month month, int date) {
        name = n;
        cost = c;
        alcohol = a;
        productionDate = LocalDate.of(year, month, date);
    }

    public String toString() {
        return "名字" + name + "成本" + cost + "生产日期" + "保质期" + shelfDate + "酒精度数" + alcohol;
    }

}
