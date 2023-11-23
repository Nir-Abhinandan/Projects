
import java.util.ArrayList;
import java.util.*;
import java.io.*;
public class Item implements Comparable<Item>{
    private String name;
    private String id;
    private ArrayList<Action> actions;
    

    public Item(String s, ArrayList<Action> a){
        actions=a;
        name = s;
    }
    public Item(String s, String id){
        actions = new ArrayList<Action>();
        name=s;
        this.id=id;
    }
    public Item(String s, String id, ArrayList<Action> a){
        name=s;
        this.id=id;
        this.actions=a;
    }
    public Item(String s){
        actions=new ArrayList<Action>();
        name=s;
    }
    

    public Item(String [] arr){
        name = arr[(int)Math.random()*arr.length-1];
        
    }

    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }
    public ArrayList<Action> getActions(){
        return actions;
    }

     public int compareTo(Item i) {
        return this.name.compareTo(i.getName());
    }
    
}
