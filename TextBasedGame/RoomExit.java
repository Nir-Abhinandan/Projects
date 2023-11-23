
public class RoomExit{
    //Attributes
    private String direction;
    private Room leadsTo;
    private ItemList requiredItems;
    private boolean unlocked;

    public RoomExit(String direction, Room leadsTo, ItemList requiredItems){
        this.direction=direction;
        this.leadsTo=leadsTo;
        this.requiredItems=requiredItems;
        this.unlocked=false;
    }

    public ItemList getRequiredItems(){

        
        return this.requiredItems;
    }
    public Room getDestinationRoom(){
        return this.leadsTo;
    }
    
    public String getDirection(){
        return this.direction;
    }
    public boolean unlocked(){
        return this.unlocked;
    }
    public void unlock(){
        this.unlocked=true;
    }
}
