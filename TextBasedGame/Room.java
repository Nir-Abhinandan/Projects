//Leo Shraybman
import java.util.ArrayList;
public class Room{
    //Attributes
    private String name;
    private ArrayList<RoomExit> exits;
    private ItemList items;
    private ArrayList<LivingBeing> beings;
    private String timePeriod;
    private String description;

    //Constructor
    public Room(String name,ItemList items, String timePeriod){
        this.exits=new ArrayList<RoomExit>();
        this.beings=new ArrayList<LivingBeing>();
        this.name=name;
        this.items=items;
        this.timePeriod=timePeriod;
    }
    
    //Methods
    public void setDescription(String desc){
        description=desc;
    }
    public String getDescription(){
        return this.description;
    }

    public void addLivingBeing(LivingBeing being){
        beings.add(being);
    }
    public void removeLivingBeing(LivingBeing being){
        beings.remove(being);
    }
    public void addItem(Item i){
        items.add(i);
    }
    public void removeItem(Item i){
        items.remove(i);
    }

    public void addExit(RoomExit exit){
        exits.add(exit);
    }
    public void addExits(RoomExit[] exits){
        for (RoomExit e : exits){
            this.exits.add(e);
        }
    }

    public String getName(){
        return name;
    }
    public String toString(){
        return this.getName();
    }
    
    public ItemList getItems(){
        return items;
    }
    public ArrayList<LivingBeing> getBeings(){
        return beings;
    }
    public String getTimePeriod(){
        return timePeriod;
    }
    public ArrayList<RoomExit> getExits(){
        return this.exits;
    }
    public RoomExit exitRoom(String direction){
        //Returns a roomExit that has the same direction as passed in, otherwise returns null
        for (RoomExit e : exits){
            if (e.getDirection().equals(direction)){
                return e;
            } 
        }
        return null;
        
    }
}