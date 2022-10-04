public class Food extends Item{
    public int healthValue;

    public Food(String itemName,int healthValue){
    super(itemName);
    this.healthValue = healthValue;
    }

    public int getHealthValue(){
        return healthValue;
    }
}
