/**
* Mahimna Pyakuryal
* 1014826
* mpyakury
* mpyakury@uoguelph.ca
*/ 

package username;

import dnd.models.ChamberContents;
import dnd.models.ChamberShape;
import dnd.models.DnDElement;
import dnd.models.Monster;
import dnd.models.Trap; 
import dnd.models.Treasure;
import java.util.ArrayList;
import dnd.models.Exit; 
import dnd.exceptions.NotProtectedException; 

public class Chamber extends Space{

	private ChamberContents myContents;
	private ChamberShape mySize;
	private ArrayList<Exit> myExits; 
	private Monster myMonster;
	private Trap myTrap;
	private Treasure myTreasure; 
	private String contents;
	private int doorNum; 

	


	/******************************
	 Required Methods for that we will test during grading
	*******************************/
	/* note:  Some of these methods would normally be protected or private, but because we 
	don't want to dictate how you set up your packages we need them to be public 
	for the purposes of running an automated test suite (junit) on your code. 
	*/

public Chamber(ChamberShape theShape, ChamberContents theContents)
{
	/**
	* this constructor sets the contents of the chamber based on 
	* random rolls obtained through the ChamberShape and ChamberContents 
	* dnd packages
	* it will also set the var getNumExits for use later in the class
	* All monsters and treasure are added through method calls to other 
	* methods in the class
	*/

	contents = new String (); 
	mySize = theShape; 
	myContents = theContents; 
	myContents.setDescription();
	contents = myContents.getDescription(); 

	while (contents == "stairs"){ 
		myContents.setDescription();
		contents = myContents.getDescription(); 
	}

	if (contents == "empty"){
		//do nothing
	} 
	else if (contents == "monster only"){
		myMonster = new Monster ();
		addMonster (myMonster);
	}
	else if (contents == "monster and treasure"){
		myMonster = new Monster ();
		addMonster (myMonster);

		myTreasure = new Treasure(); 
		addTreasure (myTreasure); 
	}
	else if (contents == "trap"){
		//do nothing
	}
	else if (contents == "treasure"){
		myTreasure = new Treasure(); 
		addTreasure (myTreasure); 
	}


	setShape (mySize); 
	doorNum = mySize.getNumExits();


}

public void setShape(ChamberShape theShape){
	/**
	* sets the shape of the Chamber using the dnd package ChamberShape
	* This includes the number of exits, shape, and area of the Chamber
	*/
	theShape.setShape();
	theShape.setNumExits();
	myExits = theShape.getExits(); //holds location of each exit

}

public int getDoorNum (){
	/**
	* this method returns the value doorNum 
	* this is utilized in other classes to determine 
	* whether to go back and continue in the previous 
	* passage due to chamber not having any exits 
	* or taking a chamber exit to continue 
	* in the level
	*/ 
	return doorNum; 
}

public ArrayList<Door> getDoors(){
	/**
	* sets an array of all the doors within a chamber 
	* it will keep iterating through the list until 
	* the number of exits that was obtained using 
	* chambershape earlier is reached
	*/
	ArrayList<Door> chamDoors = new ArrayList<>(); 
	Door temp;

	for (int i = 0; i < doorNum; i++){
		temp = new Door();
		chamDoors.add(i, temp); 
	}

return chamDoors;
}

private void addMonster(Monster theMonster){
	/**
	* this sets the monster through the dnd package Monster 
	* this is randomly generated
	*/ 
	theMonster.setType(); 
}

public void print (){
	/** 
	* this method prints all the values determined through the creation of the chamber 
	* in this class. This method also through a null exception when checking for protection
	* this will also iterate through doors until the number of exits in the chamber is reached 
	* and it will print those doors. Side Note: getDoorNum could've been used as the upper limit 
	* too
	*/ 
	System.out.println();
	System.out.println ("Chamber Shape: " + mySize.getShape());
	System.out.println ("Chamber Area: " + mySize.getArea());
	System.out.println ("Number of Exits: " + mySize.getNumExits());
	ArrayList <Door> chamberExits = new ArrayList<> (); 
	chamberExits = getDoors();

	for (int i = 0; i < mySize.getNumExits(); i++){ //use this to store location/direction of each door
		System.out.println(); 
		System.out.println("Door #: " + (i + 1));
		System.out.println("Door Description: " + chamberExits.get(i).getDescription());
		System.out.println ("----------------");
		System.out.println(myExits.get(i).getLocation()); 
		System.out.println(myExits.get(i).getDirection()); 
	}
	System.out.println ();
	System.out.println("Chamber Contents: " + myContents.getDescription()); 

	if ((contents == "monster only") || (contents == "monster and treasure")){
		System.out.println ("Monster: " + myMonster.getDescription());
	}

	if ((contents == "treasure") || (contents == "monster and treasure")){ 
		System.out.println ("Treasure: " + myTreasure.getDescription());
		System.out.println ("Treasure Container: " + myTreasure.getContainer()); 
		try{ 
			System.out.println ("Treasure Protection: " + myTreasure.getProtection());
		}
		catch (NotProtectedException e){
			System.out.print ("Treasure Protection: ");
			System.out.println (e.getMessage());
		}
	}
	System.out.println();
}


public void addTreasure(Treasure theTreasure){
	/** 
	* this method sets the treasure using the treasure 
	* dnd package 
	*/

	theTreasure.setDescription(); 
	theTreasure.setContainer(); 
}

@Override
public String getDescription(){

return null;
}

@Override
public void setDoor(Door newDoor){
	//should add a door connection to this room
}


/***********
You can write your own methods too, you aren't limited to the required ones
*************/

}