/**
* Mahimna Pyakuryal
* 1014826
* mpyakury
* mpyakury@uoguelph.ca
*/ 

package username;

import dnd.models.Monster;
import java.util.HashMap;

/* Represents a 10 ft section of passageway */

public class PassageSection{

	private String globalDesc = new String();
	private int length; 
	private String direction = new String (); 
	public Boolean checkMonster = false;
	public Boolean checkDoor = false; 
	public Boolean checkArchway = false; 
	public Boolean checkChamber = false;
	public Boolean checkStairs = false; 
	public Boolean checkDead = false; 
	public Boolean checkEmpty = false; 
	public Monster myMonster; 
	/*
	//test 1
	String testString = new String (); 
	*/ 

	/******************************
	 Required Methods for that we will test during grading
	*******************************/
	/* note:  Some of these methods would normally be protected or private, but because we 
	don't want to dictate how you set up your packages we need them to be public 
	for the purposes of running an automated test suite (junit) on your code.  */



public PassageSection(){
	direction = "not set";
	length = 0; 
}

public PassageSection(String description) //expects a description from table to be passed
{
	/**
	* this method will set the appropriate attributes for a passageSection 
	* based on the string inputted. It will also set any monsters found 
	* in the passageSection 
	* these attributes will
	*/
	globalDesc = description; 

	if (globalDesc == "Straight 10 Feet"){
		direction = "straight";
		length = 10; 
		checkEmpty = true; 
	}
	else if (globalDesc == "Door to Chamber"){
		direction = "end"; 
		length = 10; 
		checkDoor = true; 
		checkChamber = true; 
	}
	else if (globalDesc == "Archway to the Right, Main Continues 10 Feet"){
		direction = "straight"; 
		length = 10; 
		checkArchway = true;
	}
	else if (globalDesc == "Archway to the Left, Main Continutes 10 Feet"){
		direction = "straight";
		length = 10;
		checkArchway = true; 

	}
	else if (globalDesc == "Left and Straight 10 Feet"){
		direction = "left";
		length = 10; 
		checkEmpty = true; 
	}
	else if (globalDesc == "Right and Straight 10 Feet"){
		direction = "right";
		length = 10; 
		checkEmpty = true; 

	}
	else if (globalDesc == "End; Archway to Chamber"){
		direction = "end";
		length = 0; 
		checkArchway = true; 
		checkChamber = true; 

	}
	else if (globalDesc == "Stairs, Continues 10 Feet"){
		direction = "straight";
		length = 10; 
		checkStairs = true; 

	}
	else if (globalDesc == "Dead End"){
		direction = "back";
		length = 0; 
		checkDead = true; 

	}
	else if (globalDesc == "Wandering Monster, Continues 10 Feet"){
		direction = "straight";
		length = 10; 
		checkMonster = true; 
		myMonster = new Monster(); 
		myMonster.setType(); 

	}
	else{
		direction = "not set"; 
		length = 0; 
	}


}

public Monster getMonster(){
	/**
	* utilized by passage to return any monsters 
	* in a passage section 
	*/ 
	if (checkMonster == true){ 


		return myMonster;

	}
	else{

		return null;
	}
}
public String getDescription(){
	/**
	* prints and sets the values of each passageSection 
	* as the Passage class iterates through
	*/ 

	if (globalDesc.length() != 0){

		System.out.println ("Direction: " + direction);
		System.out.println ("Length: " + length);
		return globalDesc;
	}
	else { 
	return null;
	}
}

} //end of class