import java.time.Month;
import java.util.ArrayList;
import java.util.Objects;

public class West2FriedChickenRestaurant implements FriedChickenRestaurant {
    double balance;

    public void Sell(SetMeal setMeal) {
        if (setMeal.drink instanceof Juice) {
            SellJuice(setMeal.drink.name, setMeal.price);
        } else {
            SellBeer(setMeal.drink.name, setMeal.price);
        }
    }

    static {
        ArrayList<SetMeal> setMeals = new ArrayList<>();
        Drinks Lemonade=new Juice("Lemonade",0,0,Month.JANUARY,0);
        Drinks Budweiser=new Beer("Budweiser",0,0,0,Month.JANUARY,0);
        SetMeal setMeal1 = new SetMeal("套餐1", "部长特制炸鸡", 22, Lemonade);
        setMeals.add(setMeal1);
        SetMeal setMeal2 = new SetMeal("套餐2", "鸡米花", 22,  Budweiser);
        setMeals.add(setMeal2);
    }

    ArrayList<Beer> beers = new ArrayList<>();
    ArrayList<Juice> juices = new ArrayList<>();

    public void JuicePurchase(String juiceName, int num, double cost, int y, Month m, int d) {
        if (balance > num * cost) {
            balance -= (num * cost);
            for (int i = 0; i <= num; i++)
                juices.add(new Juice(juiceName, cost, y, m, d));
        } else
            throw new OverdraftBalanceException(num * cost - balance);
    }

    public void BeerPurchase(String beerName, int num, double cost, int y, Month m, int d, float alcohol) {
        if (balance > num * cost) {
            balance -= (num * cost);
            for (int i = 0; i <= num; i++)
                beers.add(new Beer(beerName, cost, alcohol, y, m, d));
        } else
            throw new OverdraftBalanceException(num * cost - balance);
    }

    private void SellJuice(String juiceName, double price) {
        int j = 0;
        for (Juice i : juices) {
            if (Objects.equals(i.name, juiceName)) {
                j = 1;
                juices.remove(i);
                break;
            }
        }
        if (j == 1)
            balance += price;
        else
            throw new IngredientSortOutException(juiceName);
    }

    private void SellBeer(String beerName, double price) {
        int j = 0;
        for (Beer i : beers) {
            if (Objects.equals(i.name, beerName)) {
                j = 1;
                beers.remove(i);
                break;
            }
        }
        if (j == 1)
            balance += price;
        else
            throw new IngredientSortOutException(beerName);
    }
}
