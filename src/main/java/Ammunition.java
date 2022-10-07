public class Ammunition extends Item{
    private AmmunitionType ammunitionType;
    private int amount;

    public Ammunition(String name,int amount,AmmunitionType ammunitionType){
        super(name);
        this.amount = amount;
        this.ammunitionType = ammunitionType;
    }
}
