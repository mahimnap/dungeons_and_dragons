/**
* Mahimna Pyakuryal
* 1014826
* mpyakury
* mpyakury@uoguelph.ca
*/ 

package username;

public class level {
    public static void main (String[] args) {
    	/** 
    	* sets the first door of the first passage 
    	* this door is an archway with no space prior and 
    	* followed by a passage space
    	* this will loop and create passages and chambers until
    	* 5 unique chambers have been created
    	*/ 
        Door starter = new Door();
        while (starter.finalCounter != 5) {
        starter.setPassage(true);
		}
    }
}

