
public class Action{
    //Attributes
    private String name;
    private String parsedAction;

    //Constructor
    public Action(String name, String parsedAction){
        this.name=name;
        this.parsedAction=parsedAction;
    }
    //Methods
    public String getName(){
        return name;
    }
    public String getParsedAction(){
        return parsedAction;
    }
}
