public class Item {
    private String itemName;
    /*
    private boolean isKey;
    private Key key;
    private Wepon wepon;
    private Food food;
    */

    public Item(String itemName){
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    @Override
    public String toString() {
        return itemName;
    }
}
