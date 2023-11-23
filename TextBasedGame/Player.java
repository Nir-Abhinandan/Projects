//Ariel Berk
public class Player extends LivingBeing{
    private BackPack bp;  
    private String name;

    //constructors 
    public Player(String name){
        super(name,100,null);
        this.bp = new BackPack();
    }
    public String getName(){
        return this.name;
    }
    public boolean hasItem(Item item){

        for (int i = 0; i < this.bp.size(); i++){
            if (this.bp.get(i).getName().equals(item.getName())){
                return true;
            }
        }
        return false;
    }
    public boolean addItem(Item item){
        return this.bp.addItem(item);
    }
    public boolean removeItem(Item item){
        return this.bp.remove(item);
    }
    public void removeAllItems(){
        this.bp.removeAllItems();
    }
    public BackPack getBackPack(){
        return this.bp;
    }

     
    public String toString(){
        return getName(); 
    }
    
}