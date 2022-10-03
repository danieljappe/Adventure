public class Item {
    private String itemName;

    private Key key;
    //private Weapon weapon;
    //private Food food;


    public Item(String itemName){
        this.itemName = itemName;
    }
    public Item(String itemName, String keyWord){
        this.itemName = itemName;
        key = new Key(keyWord);
    }

    public String getItemName() {
        return itemName;
    }

    @Override
    public String toString() {
        return itemName;
    }
}
