import java.time.Month;

public interface FriedChickenRestaurant {
    void Sell(SetMeal setMeal);
    void JuicePurchase(String juiceName, int num, double cost, int y, Month m, int d);
    void BeerPurchase(String beerName, int num, double cost, int y, Month m,int d,float alcohol);
}
