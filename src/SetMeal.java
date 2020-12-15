public class SetMeal {
    String name, chickenName;
    Drinks drink;
    double price;
    SetMeal(String n,String cn,double p,Drinks d){
        name=n;
        price=p;
        chickenName=cn;
        drink =d;
    }
    public String toString() {
        return "套餐名:"+name+" 套餐价格:"+price+" 炸鸡"+chickenName+" 饮料:"+ drink.name;
    }
}
