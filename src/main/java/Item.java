public abstract class Item { //TODO: Lav til abstract når ny underklasse laves
    protected String itemName;


    public Item(String itemName){
        this.itemName = itemName;

    }

    /*public Item(String itemName, String keyWord){
        this.itemName = itemName;
        key = new Key(keyWord);
    }*/

    public String getItemName() {
        return itemName;
    }

    @Override
    public String toString() {
        return itemName;
    }
}
