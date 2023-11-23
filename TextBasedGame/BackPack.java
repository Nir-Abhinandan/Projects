
import java.util.*;
public class BackPack extends ItemList {
    //attributes
    private int maxItems;

    //sets max items in your backpack to 5
    public BackPack(){
        this.maxItems = 5;
    }

    public BackPack(int maxItems){
        this.maxItems = maxItems;
    }
    
    //add an item to the backpack
    public boolean addItem(Item item){
        if (this.size() >= maxItems){
            return false;
        }
        else{
            this.add(item);
            return true;
        }
    }

    //function to remove all items in your backpack
    public void removeAllItems(){
        for (int i=this.size()-1;i>=0;i--){
            this.remove(i);
        }
    }

    //function to display the player's inventory
    public void checkInventory() {
        //System.out.println(this.toString());
        Collections.sort(this);
        System.out.println("Items in backpack: ");
        for (int i = 0; i < this.size(); i++){
            System.out.println((i+1) + ". " + this.get(i).getName());
        }
    }

}
