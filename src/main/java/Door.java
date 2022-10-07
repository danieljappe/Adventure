public class Door {
    private String name;
    private boolean isOpen;
    private String closed;
    private String open;
    private KeyType rightKey;

    public Door(String name,boolean isOpen,String closed,String open,KeyType rightKey){
        this.name = name;
        this.isOpen = isOpen;
        this.closed = closed;
        this.open = open;
        this.rightKey = rightKey;
    }

    public boolean isOpen(){
        return isOpen;
    }
    public String getOpenDescription(){
        return open;
    }
    public String getClosedDescription(){
        return closed;
    }

    public boolean openDoor(KeyType key){
        if(key==rightKey){
            isOpen = true;
            return true;
        }else {
            return false;
        }
    }
    public String getName(){
        return name;
    }


}
