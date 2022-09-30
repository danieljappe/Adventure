public class Door {
    private String name;
    private boolean isOpen;
    private String closed;
    private String open;
    private Item rightKey;

    public Door(String name,boolean isOpen,String closed,String open,Item rightKey){
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

    public void openDoor(Item key){
        if(key==rightKey){
            isOpen = true;
        }
    }


}
