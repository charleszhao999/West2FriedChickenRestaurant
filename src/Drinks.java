import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

abstract public class Drinks {
    protected String name;
    protected double cost;
    protected int shelfDate;
    protected LocalDate productionDate;

    boolean isExpired() {
        LocalDate expireDate = productionDate.plus(shelfDate, ChronoUnit.DAYS);
        return !(expireDate.isAfter(LocalDate.now()));
    }

    public abstract String toString();

}
