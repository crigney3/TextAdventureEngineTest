package com.base;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.item.Sword;
import com.room.Room;
import com.text.CommandText;
import com.text.RoomText;

public class Main {
	final static Set<String> Verbs = new HashSet<String>(Arrays.asList( new String[] {"look","examine","take","steal", "grab", "go", "kill", "attack", "break", "destroy", "open", "close", "eat", "tumble", "one-five-two-nine"}));
	public static String start = "#";
	static String A = "A";
	static String B = "B";
	static String C = "C";
	static String D = "D";
	public static String input5;
	
	public static String location = Room.id;
	public static int end = 0;
	Room spawn = new Room(true, true, true, true, false, start, "Spawn", false, 0);	
	Room swordRoom = new Room(false, false, true, false, false, "#A", "Sword", true, 0);	
	Room doorRoom = new Room(false, true, false, true, false, "#B", "Door", true, 0);
	Room pit = new Room(true, false, false, false, false, "#C", "Pit", true, 0);
	
	public static String input1;
	
 
	public static void main(String[] args) {
		
		
		System.out.println("Welcome to the adventure!");
		
		locText();
		while(end < 1){
			adventure();
		}
		

	}
	public static void adventure(){
		getRoomId();
		input5 = getInput();
		if(Verbs.contains(input5)){
			if(input5.equalsIgnoreCase("go")){
				System.out.println(CommandText.go);
				input5 = getInput();
				if(input5.equalsIgnoreCase("north")){
					System.out.println("it works!");
					Room.setIdNorth();
					
					System.out.println("north is" + getPlace().getNorth());
					System.out.println(location);
					locText();
					System.out.println(Room.setIdNorth());
				}
				else if(input5.equalsIgnoreCase("east")){
					Room.setIdEast();
					locText();
				}
				else if(input5.equalsIgnoreCase("south")){
					System.out.println(location);
					Room.setIdSouth();
					System.out.println(location);
					locText();
				}
				else if(input5.equalsIgnoreCase("west")){
					Room.setIdWest();
					locText();
				}
				else {
					System.out.println(CommandText.invDirec);
				}
			}
			
			else if(input5.equalsIgnoreCase("look")){
				locText();
			}
			
			
			
			else{
				System.out.println("hm");
				System.out.println(input5);
			}
		}
		else{
			System.out.println("nope.");
			System.out.println(input5);
		}
		
	}
	public static String getInput(){
		Scanner scanner = new Scanner(System.in);
		String input5 = scanner.next();	
		return input5;
	}
	public static String getWholeInput(){
		Scanner scanner = new Scanner(System.in);
		String input4 = scanner.nextLine();	
		return input4;
	}
	public static void locText(){
		if(location.equals("#")){
			System.out.println(RoomText.spawn);
		}
		if(location.equals("#A") || location.equals("#ABCD") || location.equals("#ADCB") || location.equals("#BCDA") || location.equals("#BADC") || location.equals("#CDBA") || location.equals("CABD") || location.equals("DABC") || location.equals("DCBA")){
			System.out.println(RoomText.swordRoom);
		}
		if(location.equals("#B")){
			System.out.println(RoomText.doorRoom);
		}
		if(location.equals("#C")){
			System.out.println(RoomText.pit);
		}
		else{
			
		}
		
	}
	public static String goNorth(){
		setRoomExits();
		
			if(getRoomExits() == 1 || getRoomExits() == 2 || getRoomExits() == 3 || getRoomExits() == 4 || getRoomExits() == 8 || getRoomExits() == 9 || getRoomExits() == 10 || getRoomExits() == 13){
				
				location = getRoomId(); 
				
				
				location = getRoomId() + A;
				
				 return location;
				
			}
		
		
		else {
			System.out.println("You can't go that way");
			return location;
		}
		
	}
	public static String goWest(){
		setRoomExits();
		
			if(getRoomExits() == 3 || getRoomExits() == 4 || getRoomExits() == 6 || getRoomExits() == 7 || getRoomExits() == 9 || getRoomExits() == 11 || getRoomExits() == 10 || getRoomExits() == 12){
				location = getPlace().getId(); 
				location = getPlace().getId() + "D";
				 
				 return location;
				
			}
		
		
		else {
			System.out.println("You can't go that way");
			return location;
		}
		
	}
	public static String goEast(){
		setRoomExits();
		
			if(getRoomExits() == 15 || getRoomExits() == 2 || getRoomExits() == 3 || getRoomExits() == 4 || getRoomExits() == 8 || getRoomExits() == 5 || getRoomExits() == 6 || getRoomExits() == 7){
				location = getPlace().getId(); 
				location = getPlace().getId() + "B";
				 
				 return location;
				
			}
		
		
		else {
			System.out.println("You can't go that way");
			return location;
		}
		
	}
	public static String goSouth(){
		setRoomExits();
		
			if(getRoomExits() == 4 || getRoomExits() == 7 || getRoomExits() == 8 || getRoomExits() == 11 || getRoomExits() == 13 || getRoomExits() == 14 || getRoomExits() == 15 || getRoomExits() == 10){
				location = getPlace().getId(); 
				location = getPlace().getId() + "C";
				 
				 return location;
				
			}
		
		
		else {
			System.out.println("You can't go that way");
			return location;
		}
		
	}
	public static Room getPlace(){
		if(location.equals(start)){
			
			return spawn;
		}
		if(location.equals("#A")){
			return swordRoom;
		}
		else {
			return spawn;
		}
	}
	public static void setRoomExits(){
		if(getPlace() == spawn){
			Room.north = true;
			Room.east = true;
			Room.south = true;
			Room.west = true;
		}
		if(getPlace() == swordRoom){
			Room.north = true;
			Room.east = false;
			Room.south = false;
			Room.west = false;
		}
	}
	public static void setRoomNames(){
		if(getPlace() == spawn){
			Room.name = "Empty Room";
		}
		if(getPlace() == swordRoom){
			Room.name = "Pedestal Room";
		}
		if(getPlace() == doorRoom){
			Room.name = "Hall of Paintings";
		}
		if(getPlace() == pit){
			Room.name = "Mysterious Pit";
		}
	}
	public static String getRoomName(){
		return Room.name;
	}
	public static String getRoomId(){
		if(getPlace() == spawn){
			return spawn.id;
		}
		if(getPlace() == swordRoom){
			return swordRoom.id;
		}
		else{
			return start;
		}
	}
	public static int getRoomExits(){
		//1000
		if(getPlace().getNorth() == true){
			return 1;
		}
		//1100
		if(getPlace().getNorth() == true && getPlace().getEast() == true){
			return 2;
		}
		//1110
		if(getPlace().getNorth() == true && getPlace().getEast() == true && getPlace().getWest() == true){
			return 3;
		}
		//1111
		if(getPlace().getNorth() == true && getPlace().getEast() == true && getPlace().getWest() == true && getPlace().getSouth() == true){
			return 4;
		}
		//0100
		if(getPlace().getEast() == true){
			return 5;
		}
		//0110
		if(getPlace().getEast() == true && getPlace().getWest() == true){
			return 6;
		}
		//0111
		if(getPlace().getEast() == true && getPlace().getWest() == true && getPlace().getSouth() == true){
			return 7;
		}
		//1101
		if(getPlace().getEast() == true && getPlace().getNorth() == true && getPlace().getSouth() == true){
			return 8;
		}
		//1010
		if(getPlace().getWest() == true && getPlace().getNorth() == true ){
			return 9;
		}
		//1011
		if(getPlace().getWest() == true && getPlace().getNorth() == true && getPlace().getSouth() == true){
			return 10;
		}
		//0011
		if(getPlace().getWest() == true && getPlace().getSouth() == true){
			return 11;
		}
		//0010
		if(getPlace().getWest() == true ){
			return 12;
		}
		//1001
		if(getPlace().getSouth() == true && getPlace().getNorth() == true){
			return 13;
		}
		//0001
		if(getPlace().getSouth() == true){
			return 14;
		}
		//0101
		if(getPlace().getSouth() == true && getPlace().getEast() == true){
			return 15;
		}
		//0000
		else {
			return 0;
		}
		
	}
	

}
