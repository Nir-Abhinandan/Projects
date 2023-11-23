//Ariel Berk
public class Creature extends LivingBeing{
    //attributes 
    private String placeInTime; 
    private String type; 
    private int lifeLeft; 
    private Item dropsOnDeath;
    private String deathMessage;
    
    

 //constructors 
    public Creature(String n, int hp, Item w, Item d){
        super(n,hp,w);
        this.dropsOnDeath=d;
    }
    public void addDeathMessage(String message){
        this.deathMessage=message;
    }
    public Item getDeathItem(){
        return this.dropsOnDeath;
    }
    
    public String getType(){
        return type; 
    }

     
    public double getLifeLeft(){
        return lifeLeft; 
    }

    public void setLifeLeft(int l){
        lifeLeft = l;
    }
    public String getDeathMessage(){
        return deathMessage;
    }
}