import java.time.Month;

public interface FriedChickenRestaurant {
    void Sell(SetMeal setMeal);
    void JuicePurchase(Juice juice, int num, int y, Month m, int d);
    void BeerPurchase(Beer beer, int num, int y, Month m,int d,float alcohol);
}
