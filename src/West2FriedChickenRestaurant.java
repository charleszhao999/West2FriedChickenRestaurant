import java.time.Month;
import java.util.ArrayList;
import java.util.Objects;

public class West2FriedChickenRestaurant implements FriedChickenRestaurant {
    double balance;

    public void Sell(SetMeal setMeal) {
        if (setMeal.drink instanceof Juice) {
            Use((Juice) setMeal.drink, setMeal.price);
        } else {
            Use((Beer) setMeal.drink, setMeal.price);
        }
    }

    static {
        ArrayList<SetMeal> setMeals = new ArrayList<>();
        Drinks Lemonade = new Juice("Lemonade", 5, 0, Month.JANUARY, 0);
        Drinks Budweiser = new Beer("Budweiser", 15, 0, 0, Month.JANUARY, 0);
        SetMeal setMeal1 = new SetMeal("套餐1", "部长特制炸鸡", 22, Lemonade);
        setMeals.add(setMeal1);
        SetMeal setMeal2 = new SetMeal("套餐2", "鸡米花", 30, Budweiser);
        setMeals.add(setMeal2);
    }

    ArrayList<Beer> beers = new ArrayList<>();
    ArrayList<Juice> juices = new ArrayList<>();

    public void JuicePurchase(Juice juice, int num, int y, Month m, int d) {
        if (balance > num * juice.cost) {
            balance -= (num * juice.cost);
            for (int i = 0; i <= num; i++)
                juices.add(new Juice(juice.name, juice.cost, y, m, d));
        } else
            throw new OverdraftBalanceException(num * juice.cost - balance);
    }

    public void BeerPurchase(Beer beer, int num, int y, Month m, int d, float alcohol) {
        if (balance > num * beer.cost) {
            balance -= (num * beer.cost);
            for (int i = 0; i <= num; i++)
                beers.add(new Beer(beer.name, beer.cost, alcohol, y, m, d));
        } else
            throw new OverdraftBalanceException(num * beer.cost - balance);
    }

    private void Use(Juice juice, double price) {
        int j = 0;
        for (Juice i : juices) {
            if (Objects.equals(i.name, juice.name)) {
                j = 1;
                juices.remove(i);
                break;
            }
        }
        if (j == 1)
            balance += price;
        else
            throw new IngredientSortOutException(juice.name);
    }

    private void Use(Beer beer, double price) {
        int j = 0;
        for (Beer i : beers) {
            if (Objects.equals(i.name, beer.name)) {
                j = 1;
                beers.remove(i);
                break;
            }
        }
        if (j == 1)
            balance += price;
        else
            throw new IngredientSortOutException(beer.name);
    }
}
