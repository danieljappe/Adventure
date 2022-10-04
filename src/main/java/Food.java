public class Food extends Item{
    private int healthValue;

    public Food(String itemName,int healthValue){
    super(itemName);
    this.healthValue = healthValue;
    }

    public int getHealthValue(){
        return healthValue;
    }
}
