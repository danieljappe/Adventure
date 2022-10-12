public class SolidObject extends Door {

    private String description;
    private String opening;
    private Item hiddenItem;

    public SolidObject(String name,boolean isOpen,String closedDescription,String opening,KeyType rightKey,Item hiddenItem){
        super(name,isOpen,closedDescription,opening,rightKey);
        this.hiddenItem = hiddenItem;
    }

    public Item getHiddenItem() {
        return hiddenItem;
    }
}
