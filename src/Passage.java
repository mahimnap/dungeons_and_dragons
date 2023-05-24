/**
* Mahimna Pyakuryal
* 1014826
* mpyakury
* mpyakury@uoguelph.ca
*/ 

package username;

import dnd.models.Monster;
import dnd.models.Treasure;
import dnd.die.D20;

import java.util.ArrayList;
import java.util.HashMap;
import dnd.models.ChamberShape;
import dnd.models.ChamberContents; 

/*
A passage begins at a door and ends at a door.  It may have many other doors along 
the way

You will need to keep track of which door is the "beginning" of the passage 
so that you know how to 
*/

public class Passage extends Space{
	//these instance variables are suggestions only
	//you can change them if you wish.
	
	private ArrayList<PassageSection> thePassage; //arraylist that holds all the passagesections in a passage
	private HashMap<Door,PassageSection> doorMap;
	private HashMap <Integer, String> table = new HashMap <> ();
	public ArrayList<String> hold = new ArrayList<>(); 
	public ArrayList<Door> myDoors; //currently public to test functionality of program
	private ChamberShape myShape;
	private ChamberContents myContents; 
	private Boolean check; 
	public int chamberCounter = 0;

	/******************************
	 Required Methods for that we will test during grading
	*******************************/
	/* note:  Some of these methods would normally be protected or private, but because we 
	don't want to dictate how you set up your packages we need them to be public 
	for the purposes of running an automated test suite (junit) on your code.  */

public Passage (){ 
	/**
	* contructor sets the table highlighted in the assignmnet 2 description 
	* it then creates a doorMap that will a Hashmap with the door as the key and passageSection as the value
	* creates an arraylist of doors
	* loop will get a random value from the defined table and insert that as the passagesection description 
	* if the passagesection description indicated the end of the passage check will be true else it will 
	* remain false
	*/ 
	setTable(); 

	doorMap = new HashMap <Door, PassageSection>(); 
	myDoors = new ArrayList<Door> (); 
	thePassage = new ArrayList<PassageSection>(); 

	check = false; 
	int i = 0; 
	while (check != true){ //add values from random table to each passagesection till end, fill array myDoors with null or door
		hold.add (sectionTable()); //door to chamber - now working on door implementation to connect chamber 
		PassageSection section = new PassageSection(hold.get(i)); 
		addPassageSection (section); 
		myDoors.add (getDoor(i));
		
		if ((hold.get(i) == table.get(5)) || (hold.get(i) == table.get(16)) || (hold.get(i) == table.get(19))){
			check = true; 
		}
		i++; 
	}

}


private ArrayList getDoors(){ //currently set myDoors to public because this won't let me reference it outside class without errors
	/**
	*returns myDoors for access to doors throughout program
	*/

	return myDoors; //currently returned with null values
}

public void print (){
	for (int i = 0; i < hold.size(); i++){
		System.out.println ("Section Value: " + hold.get(i));
	}
	System.out.println ("Number of Doors: " + myDoors.size());
}

public Door getDoor(int i){
	/** 
	* will check the appropriate attributes for every description passed throygh that 
	* contains a door
	* if the door indicates the end of a passage and start of chamber, and the chamber has at least 
	* one exit, then check will be set to true highlighting the end of the passage
	*/

	Door temp = new Door ();
	Chamber buffer = new Chamber(); 

	if (hold.get(i) == table.get(5)){ //if door to chamber
		//door to chamber
		temp.setArchway(false); 
		if (temp.isOpen() == true){ //if unlocked
			temp.setOpen (true);
			if (temp.isTrapped() == true){ // if door is trapped then trap the door
				temp.setTrapped(true); 
			}
			else { //if door is not trapped and unlocked, create a chamber
				temp.setTrapped(false);
				buffer = temp.setChamber(true); //chamber created here and set to buffer
				if (buffer.getDoorNum() > 0){
					check = true;
				}
				chamberCounter++;
			}
		}
		else if (temp.isOpen() == false){
			temp.setOpen (false);
		}
	
		return temp;
		//location spaces for doors not set yet
	}
	else if (hold.get(i) == table.get(7)){
		//archway right main continues
		temp.setArchway(true);
		buffer = temp.setChamber (true);
		if (buffer.getDoorNum() > 0){
			check = true;
		}
		chamberCounter++;
		return temp;
	}
	else if (hold.get(i) == table.get(9)){
		//archway left main continues
		temp.setArchway(true);
		buffer = temp.setChamber(true); 
		if (buffer.getDoorNum() > 0){
			check = true;
		}
		chamberCounter++;
		return temp; 
	}
	else if (hold.get(i) == table.get(16)){ 
		//archway to chamber
		temp.setArchway(true);
		buffer = temp.setChamber (true);
		if (buffer.getDoorNum() > 0){
			check = true;
		}
		chamberCounter++;
		return temp;
	}
	else{
		return null; 
	}
}

private Monster getMonster(int i){
	/**
	* returns a monster from a given passagesection and stores it into a 
	* Monster class object 
	*returns this object
	*/ 
	Monster tempMonster = thePassage.get(i).getMonster(); 
	return tempMonster; 
}


private void addPassageSection(PassageSection toAdd){
	
	thePassage.add (toAdd); 
}


@Override
public void setDoor(Door newDoor){ //if door, then call this and set location
	//should add a door connection to the current Passage Section
	//e.g. thePasssage.get(i) - where i contains a door

}

@Override
public String getDescription(){ //holds description found on table 

return null;
}
/***********
You can write your own methods too, you aren't limited to the required one
*************/

public String sectionTable(){
	/**
	* this will randomly roll a value from 1 to 20 and adjust the value to fit 
	* in the index of the table set after this method
	* this will provide implementation for passageSection 
	* implementation
	*/

	D20 newRoll = new D20(); 
	int roll = newRoll.roll(); 

	if (roll >= 1 && roll <=2){
		roll = 2; 
	}
	else if (roll >= 3 && roll <=5){
		roll = 5; 
	}
	else if (roll >= 6 && roll <=7){
		roll = 7;
	}
	else if (roll >= 8 && roll <=9){
		roll = 9; 
	}
	else if (roll >= 10 && roll <=11){
		roll = 11;
	}
	else if (roll >= 12 && roll <=13)
		roll = 13; 
	else if (roll >= 14 && roll <=16){
		roll = 16; 
	}
	else if (roll == 17){
		roll = 17; 
	}
	else if (roll >= 18 && roll <=19){
		roll = 19; 
	}
	else if (roll == 20){
		roll = 20; 
	}

	//return table.get(roll); 
	return table.get(roll);

}

private void setTable (){ 
	/** 
	* set table for the values highlighted in the the assignmnet 2 description 
	* this table utilizes a hashMap to store the index and values 
	* these string values represent the description for passageSection
	*/

	table.put (2, "Straight 10 Feet"); 
	/*if true add 10 to length or width of level */ 
	table.put (5, "Door to Chamber"); 
	/*if true, generate door, chamber, and chamber contents*/ 
	table.put (7, "Archway to the Right, Main Continues 10 Feet"); 
	/*if true, generate space for archway and add size for main*/ 
	table.put (9, "Archway to the Left, Main Continutes 10 Feet"); 
	/*dido */ 
	table.put (11, "Left and Straight 10 Feet");
	table.put (13, "Right and Straight 10 Feet"); 
	table.put (16, "End; Archway to Chamber"); 
	/*generate chamber*/ 
	table.put (17, "Stairs, Continues 10 Feet"); 
	table.put (19, "Dead End"); 
	table.put (20, "Wandering Monster, Continues 10 Feet"); 


}

} //eof class