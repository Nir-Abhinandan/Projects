//Leo Shraybman
import java.util.ArrayList;
public class World{
    private ArrayList<Room> rooms;
    private Room currentRoom;
    private Player p;
    private Room startingRoom;
    private Room endingRoom;
    private String currentTime;
    private String[] randomItems = {"paper","book","ben","rock","pen","pencil"};


    public World(Player p){
        this.p=p;
        //Item definitions
        Item key = new Item("key","key");
        Item battery1 = new Item("battery","battery1");
        Item battery2 = new Item("battery","battery2");
        Item battery3 = new Item("battery","battery3");

        ArrayList<Action> a = new ArrayList<Action>();
        a.add(new Action("shoot shark","fight shark"));
        a.add(new Action("fire harpoon gun","fight shark"));
        Item harpoonGun = new Item("harpoon gun","harpoonGun",a);

        ArrayList<Action> b = new ArrayList<Action>();
        b.add(new Action("throw chicken leg","fight dinosaur"));
        b.add(new Action("distract dinosaur","fight dinosaur"));
        Item chickenLeg = new Item("chicken leg","chickenLeg",b);

        ArrayList<Action> c = new ArrayList<Action>();
        c.add(new Action("break control panel","fight robot"));
        c.add(new Action("destroy control panel","fight robot"));
        c.add(new Action("unscrew control panel","fight robot"));
        c.add(new Action("open control panel","fight robot"));

        Item wrench = new Item("wrench","wrench",c);

        //Creature definitions
        Creature dino = new Creature("dinosaur",100,chickenLeg,battery1);
        dino.addDeathMessage("The dinosaur gets distracted by the chicken leg and runs face first into the wall");
        Creature shark = new Creature("shark",100,harpoonGun,battery2);
        shark.addDeathMessage("You shoot the shark with the harpoon gun and kill it");
        Creature robot = new Creature("robot",100,wrench,battery3);
        robot.addDeathMessage("You break the control panel and the robot powers down, falling face first on the floor");
        ItemList purgatoryRoomItems = new ItemList();
        purgatoryRoomItems.add(key);
        
        ItemList dinoRoomItems = new ItemList();
        dinoRoomItems.add(chickenLeg);

        ItemList sharkRoomItems = new ItemList();
        sharkRoomItems.add(harpoonGun);

        ItemList robotRoomItems = new ItemList();
        robotRoomItems.add(wrench);

        //Room definitions

        Room purgatory = new Room("purgatory",purgatoryRoomItems,"None");
        purgatory.setDescription("You are in purgatory. There is a red door east of you, a green door west of you, and a blue door north of you. You notice a time machine with 3 battery slots in the south, and a shiny key is on the ground by your feet.");

        Room dinoRoom = new Room("dino room",dinoRoomItems,"past");
        dinoRoom.addLivingBeing(dino);
        dinoRoom.setDescription("You are in the Mesozoic Era. there are trees and plants everywhere. You see a dinosaur in the distance and a chicken leg to your right. ");

        Room sharkRoom = new Room("shark room",sharkRoomItems,"present");
        sharkRoom.addLivingBeing(shark);
        sharkRoom.setDescription("You are at the beach. You are swimming in the ocean and you see a shark in the distance. there is a harpoon gun floating to your right. ");

        Room robotRoom = new Room("robot room",robotRoomItems,"future");
        robotRoom.addLivingBeing(robot);
        robotRoom.setDescription("You are in a dystopian city. There are computers and broken down houses littering the streets. You see a robot coming towards you and a wrench by your feet. A little further away you see a square figure that looks like some type of control panel. ");

        Room home = new Room("home",null,"home");
        home.setDescription("Congratulations, you use the time machine to get home.");

        ItemList mainRoomItemReqs1 = new ItemList();
        mainRoomItemReqs1.add(key);

        ItemList mainRoomItemReqs2 = new ItemList();
        mainRoomItemReqs2.add(key);

        ItemList mainRoomItemReqs3 = new ItemList();
        mainRoomItemReqs3.add(key);
        
        ItemList emptyList = new ItemList();

        RoomExit exitToDino = new RoomExit("west",dinoRoom,mainRoomItemReqs1);
        RoomExit toPurgatory1 = new RoomExit("east",purgatory,emptyList);
        dinoRoom.addExit(toPurgatory1);

        RoomExit exitToShark = new RoomExit("north",sharkRoom,mainRoomItemReqs2);
        RoomExit toPurgatory2 = new RoomExit("south",purgatory,emptyList);
        sharkRoom.addExit(toPurgatory2);

        RoomExit exitToRobot = new RoomExit("east",robotRoom,mainRoomItemReqs3);
        RoomExit toPurgatory3 = new RoomExit("west",purgatory,emptyList);
        robotRoom.addExit(toPurgatory3);

        purgatory.addExit(exitToDino);
        purgatory.addExit(exitToShark);
        purgatory.addExit(exitToRobot);
        
        //Important attributes to know when to end the game and where to send the player once they die
        this.startingRoom=purgatory;
        this.currentRoom=purgatory;
        this.endingRoom=home;

        ItemList timeMachineRequirements = new ItemList();
        timeMachineRequirements.add(key);
        timeMachineRequirements.add(battery1);
        timeMachineRequirements.add(battery2);
        timeMachineRequirements.add(battery3);

        RoomExit finalExit = new RoomExit("south",home,timeMachineRequirements);
        purgatory.addExit(finalExit);

    }

    //Adds an item with a specific name to the players backpack, checking to see if its full
    public boolean grab(String itemName){
        ItemList currentItems = currentRoom.getItems();
        for (Item i : currentItems){
            if (i.getName().equals(itemName)){
                boolean temp = this.p.addItem(i);
                if(temp){
                    System.out.println("Successfully added " + itemName + " to your backpack");
                    currentRoom.removeItem(i);
                    return true;
                } else {
                    System.out.println("Sorry, you have too many items in your backpack");
                    return false;
                }
            }
        }
        System.out.println("Sorry, that item is not available");
        return false;
    }

    //Removes an item with a specific name from a player's backpack and adds it to the current Room
    public void drop(String itemName){
        BackPack currentBP = this.p.getBackPack();
        for (Item i : currentBP){
            if(i.getName().equals(itemName)){
                System.out.println("Dropped "+itemName+" into the "+currentRoom.getName());
                this.p.removeItem(i);
                this.currentRoom.addItem(i);
                return;
            }
        }
        System.out.println("You do not have that item");
    }

    //Prints out the description of the room
    public void look(){
        System.out.println(currentRoom.getDescription());
    }

    //Fights a living being in the room with a specific name, if it is in the room
    public void fight(String name){

        //Check to see if that being exists in the current room
        ArrayList<LivingBeing> beings = currentRoom.getBeings();
        LivingBeing beingToFight = new Creature("null",0,null,null);
        boolean isInRoom=false;
        for (LivingBeing b : beings){
            if (b.getName().equals(name)){
                isInRoom=true;
                beingToFight=b;
                break;
            }
        }

        if(!isInRoom){
            System.out.println("That creature isn't in this room. Try looking around");
        } else{
            //Checks to see if the player has an item to fight the living being
            if (this.p.hasItem(beingToFight.getIsWeakTo())){
                beingToFight.die();
                Item dropped = ((Creature) beingToFight).getDeathItem();
                currentRoom.addItem(dropped);
                System.out.println(((Creature) beingToFight).getDeathMessage());
                System.out.println(beingToFight.getName() +" dropped a "+dropped.getName());
                currentRoom.removeLivingBeing(beingToFight);
            } else {
                //If the player doesn't have an item to fight the creature:
                this.p.die();
                BackPack playerItems = this.p.getBackPack();
                
                for (Item i : playerItems){
                    currentRoom.addItem(i);
                }
                this.p.removeAllItems();
                
                
                System.out.println("You have been killed by the "+beingToFight.getName()+". Try finding something to help you kill it");
                System.out.println("Your items have been dropped in "+currentRoom.getName());
                currentRoom = startingRoom;
                System.out.println("You are now in "+currentRoom.getName());
                look();
            }
        }

    }

    //Displays the player's inventory
    public void checkInventory(){
        BackPack currentBP = this.p.getBackPack();
        currentBP.checkInventory();
    }
    
    //Changes rooms based on a direction
    public void changeCurrentRoom(String direction){
        RoomExit roomInfo = currentRoom.exitRoom(direction);
        //If there is no room exit found with that direction:
        if (roomInfo==null){
            System.out.println("There is no exit that way. Try a different direction");
            return;
        }
        else{
            //Removes the required items from the requiredItemList of a room exit
            Room newRoom = roomInfo.getDestinationRoom();
            ItemList requiredItems = roomInfo.getRequiredItems();
            for (int i=p.getBackPack().size()-1;i>=0;i--){
                for (int j=requiredItems.size()-1;j>=0;j--){
                    //Does so by ID in case there are duplicately named items
                    if (p.getBackPack().get(i).getId().equals(requiredItems.get(j).getId())){
                        requiredItems.remove(j);
                    }
                }
            }
            if(requiredItems.size()>0){
                System.out.println("You are missing: ");
                for (Item i : requiredItems){
                    System.out.println(i.getName());
                }
                return;
            }
            //Unlocks the room and displays the message once
            if(!roomInfo.unlocked()){
                System.out.println("The door to "+roomInfo.getDestinationRoom().getName()+" has been unlocked.");
                roomInfo.unlock();
            }
            currentRoom=newRoom;
            System.out.println("You are now in "+currentRoom.getName());
            this.look();
            currentTime=newRoom.getTimePeriod();    
        }
        //Checks to see if the resulting room is the end
        if(currentRoom==endingRoom){
            AdventureGame.endGame();
        }
    }
    public Room getCurrentRoom(){
        return this.currentRoom;
    }
    //Displays a list of possible exits for the player
    public void getExits(){
        System.out.println("The exits for the "+this.currentRoom+": ");
        for (RoomExit e : this.currentRoom.getExits()){
            System.out.println(e.getDirection()+": "+e.getDestinationRoom().getName());
        }
    }
}