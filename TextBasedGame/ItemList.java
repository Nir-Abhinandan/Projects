
import java.util.ArrayList;
import java.util.*;
import java.io.*;
public class ItemList extends ArrayList<Item>{
    public ItemList(){
        super();
    }
    public boolean add(Item s){
        return super.add(s);
        
    }
    public boolean remove(Item s){
        return super.remove(s);
        
    }
    //Helper method used by World.java
    public boolean hasItem(String itemName){
        for (Item i : this){
            if(i.getName().equals(itemName)){
                return true;
            }
        }
        return false;
    }
    public void display() {
        for(int i=0; i<this.size(); i++){
            System.out.println(super.get(i));
        }
    }
}
