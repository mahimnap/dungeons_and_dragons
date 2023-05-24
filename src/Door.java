/**
* Mahimna Pyakuryal
* 1014826
* mpyakury
* mpyakury@uoguelph.ca
*/ 

package username;
import dnd.models.Exit;
import dnd.models.Trap;
import java.util.ArrayList;
import java.lang.Math; 
import dnd.die.D20; 
import dnd.models.ChamberContents;
import dnd.models.ChamberShape;

public class Door{
	private Boolean checkArch = false;
	private Boolean checkOpen = false;
	private Boolean checkTrapped = false; 
	private Boolean checkLocked = false; 
	public String direction = new String (); 
	private ChamberShape myShape; 
	private ChamberContents myContents;
	private Passage myPassage; 
	public int finalCounter = 0;

	private Trap setTrap = new Trap(); //put this in if statement when door is called??????????? optional this  -> this.setTrap = new Trap();

	public Door(){
		/** 
		* Constructor sets a randomly allocated door through the use of the boolean parameter and boolean return type methods
		* isArchawy, isOpen, isTrapped, setArchway, setTrapped
		*/

		if (isArchway() == true){ //if archway, cant be locked/trapped, always open
			setArchway (true); 
		}
		else if (isOpen() == true) { //open and not archway 
			setOpen(true); 
			if (isTrapped() == true){ //oepn and trapped 
				setTrapped(true); 
			}

		}
		else{
			checkLocked = true;
		}

	}

	public void setTrapped(boolean flag, int ... roll){ 
		/**
		* vararg not used here
		* setTrapped takes a boolean expression as a parameter and returns void
		* if setTrapped is true, then roll a 20 sides dice, store that value in result 
		* set the global checkTrapped to true 
		* set all appropriate factors to true or false
		* this includes setOpen, because if it is trapped it must be unlocked 
		* this also includes setting archway to false because an archway cannot be trapped
		*/
		if (flag == true){
			D20 rollTrap = new D20(); 
			int result = rollTrap.roll();
			setTrap.setDescription(result);
			checkTrapped = true; 
			setOpen (true); 
			setArchway(false); 
		}
		else if(flag == false) {
			checkTrapped = false; 
		}

	}
	public void setOpen(boolean flag){
		/**
		* if setOpen has true passed through then set the checkOpen to true so it can be applied elsewhere in the class 
		* set Checklocked to false so it can be applied elsewhere in the class
		* if setOpen has false passed through, set checkopen to false and checklocked to true for use elsewhere in class
		*/

		if (flag == true){ 
			checkOpen = true; 
			checkLocked = false; 
		}
		else if (flag == false){
			checkOpen = false; 
			checkLocked = true; 
		}

	}



	public void setArchway(boolean flag){
		/** 
		* if true expression is passed through set the attributes of an archway
		* this includes always open, not trapped, and an archway
		*/

		if (flag == true){ 
			setOpen(true); 
			setTrapped (false);
			checkArch = true;  
		}
		else if (flag ==false){
			checkArch = false; 
		}
	}

	public Chamber setChamber (boolean flag){ 
		/**
		* sets the instance object of class chamberShape to new ChamberShape
		* sets object of class ChamberContents to new ChamberContents
		* Creates a new Chamber object called genChamber
		* prints contents of genChamber, which includes doors, monsters, treasure, size, dand oor location,
		* 
		*/
		myShape = new ChamberShape(); 
		myContents = new ChamberContents(); 
		Chamber genChamber = new Chamber(myShape, myContents); 
		genChamber.print();
		return genChamber; 
	}

	public void setPassage (boolean flag){
		/**
		* sets a passage when exiting from a newly created chamber, doesn't create a new passage if the chamber 
		* does not have any exits, instead it reverts back to the old passage and continues traversing it
		*
		*/
			myPassage = new Passage(); 
			Door checker = new Door ();  
			for (int i = 0; i < myPassage.myDoors.size(); i++){
				checker = myPassage.myDoors.get(i);
				try {
				//pass.print();
				System.out.println ("Table val: " + myPassage.hold.get(i));
				System.out.println(checker.getDescription());
				}
				catch (NullPointerException e){
					System.out.println("No Door");
				}
			}
			finalCounter = finalCounter + myPassage.chamberCounter; 
			System.out.println ("Chambers Created: " + finalCounter); 
	}

	public boolean isTrapped(){
		/** 
		* randomly generates a number between 1 and 20 
		* if the number generated is one then trap is set 
		* else trap is not set
		*/

		int trap = (int) (Math.random() * 20) + 1;
		if (trap == 1){
			return true; 
		}
		else { 
			return false;
		}
	}
	public boolean isOpen(){
		/**
		* randomly generates a number between 1 and 6
		* if the value is not one set open else set closed/locked (false)
		*/
		int open = (int) (Math.random() * 6) + 1; 
		if (open != 1){
			return true; 
		}
		else {
			return false;
		}
	}

	public boolean isArchway(){
		/**
		* randomly generate a number between 1 and 10
		* if the value is one set an arch else return false
		*
		*/
		int arch = (int) (Math.random() * 10) + 1;
		if (arch == 1){ 
			return true; 
		}
		else {
			return false;
		}
	}
	public String getTrapDescription(){ //add fail option so this cant be called when trap isnt supposed to be set
		/** 
		* get a trapdescription use the trap dnd package 
		* return the description stored in a string
		*/ 
		String returnTrap = new String (); 
		returnTrap = setTrap.getDescription(); 

		return returnTrap; 
	}

	public String getDescription(){
		/**
		* set the door description based off the previous defined attributes 
		* and set boolean instance variables 
		*/
		String doorDesc = new String(); 

		if (checkArch == true){ 
			doorDesc = "Archway, Open, Not Trapped, Chamber Created Above";
		}
		else if ((checkOpen == true) && (checkTrapped == false)){
			doorDesc = "Door, Open, Not Trapped, Chamber Created Above";
		}
		else if ((checkOpen == true) && (checkTrapped == true)){
			doorDesc = "Door, Open, Trapped: " + getTrapDescription(); 
		}
		else if (checkLocked == true){ 
			doorDesc = "Door, Locked";
		}
		else {
			doorDesc = "error in getDescription method in Door Class";
		}
		return doorDesc;
	}
/***********
You can write your own methods too, you aren't limited to the required ones
*************/
}