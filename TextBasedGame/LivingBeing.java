//Ariel Berk
public abstract class LivingBeing{
    //Attributes
    private String name; 
    private String livingBeingType; 
    private int hitPoints; 
    private Room location;  
    private boolean roamsOnOwn; 
    private int damage;
    private ItemList items;
    private Item isWeakTo; 
    

    //Constructors
    public LivingBeing(String n, String lb, int hp, Room loc, boolean roo, Item isWeakTo){
        name = n; 
        livingBeingType = lb; 
        hitPoints = hp; 
        location = loc; 
        roamsOnOwn = roo; 
        this.isWeakTo=isWeakTo;
    }
    public LivingBeing(String n, int hp, Item isWeakTo){
        name=n;
        hitPoints=hp;
        this.isWeakTo=isWeakTo;
    }

    public String getName(){
        return name;
    }

    public boolean hasItem(Item item){

        for (int i = 0; i < this.items.size(); i++){
            if (items.get(i).getName().equals(item.getName())){
                return true;
            }
        }
        return false;
    }
    //Item that kills or distracts the living being
    public boolean isWeakTo(Item item){
        if (this.isWeakTo.getName().equals(item.getName())){
            return true;
        } else {
            return false;
        }
    }
    public Item getIsWeakTo(){
        return this.isWeakTo;
    }


    public String getLivingBeingType(){
        return livingBeingType; 
    }

    public int getHitPoints(){
        return hitPoints; 
    }

    public void subtractHitPoints(int hp){
        hitPoints-=hp;
    }
    
    public void die(){
        hitPoints = 0;
    }

    
}