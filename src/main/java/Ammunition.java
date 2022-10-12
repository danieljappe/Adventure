public class Ammunition extends Item{
    private AmmunitionType ammunitionType;
    private int amount;

    public Ammunition(String name,int amount,AmmunitionType ammunitionType){
        super(name);
        this.amount = amount;
        this.ammunitionType = ammunitionType;
    }

    public AmmunitionType getAmmunitionType() {
        return ammunitionType;
    }

    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
