import java.time.LocalDate;
import java.time.Month;

public class Juice extends Drinks {
    int shelfDate = 2;
    Juice(String n, double c, int year, Month month, int date) {
        name = n;
        cost = c;
        productionDate = LocalDate.of(year, month, date);
    }

    public String toString(){
        return "名字"+name+"成本"+cost+"生产日期"+"保质期"+shelfDate;
    }

}
