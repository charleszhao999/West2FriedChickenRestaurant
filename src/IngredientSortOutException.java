public class IngredientSortOutException extends RuntimeException {
    public IngredientSortOutException(String drinkName){
        System.out.println("购买失败，"+drinkName+"已售空");
    }

}
