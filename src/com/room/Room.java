package com.room;

import com.base.Main;

public class Room {
	public static String id = Main.start;
	public static String name;
	public String LOC;
	public static boolean north;
	public static boolean east;
	public static boolean south;
	public static boolean west;
	
	public Room(boolean north, boolean east, boolean south, boolean west, boolean dark, String id, String name, boolean containsItem, int timesVisited){
	    super();
		String LOC = id;
		String na = name;
		boolean n = north;
		boolean e = east;
		boolean s = south;
		boolean w = west;
		boolean d = dark;
		
	}
	public static String getId(){
		return id;
	}
	public String getRoomName(){
		return name;
	}
	
	public boolean getNorth(){
		return north;
	}
	public boolean getEast(){
		return east;
	}
	public boolean getSouth(){
		return south;
	}
	public boolean getWest(){
		return west;
	}
	public static String setIdNorth(){
		Main.setRoomExits();
		if(id.equals("#")){
			Main.location = "#A";
			id = Main.location;
			return Main.location;
		}
		if(id.equals("#C")){
			Main.location = "#";
			id = Main.location;
			return Main.location;
		}
		else{
			return "#";
		}
	}
	public static String setIdEast(){
		Main.setRoomExits();
		if(id.equals("#")){
			Main.location = "#B";
			id = Main.location;
			return Main.location;
		}
		else{
			return "#";
		}
	}
	public static String setIdSouth(){
		Main.setRoomExits();
		if(id.equals("#")){
			Main.location = "#C";
			id = Main.location;
			return Main.location;
		}
		else if(id.equals("#A")){
			Main.location = "#";
			id = Main.location;
			return Main.location;
		}
		else{
			return "#";
		}
	}
	public static String setIdWest(){
		Main.setRoomExits();
		if(id.equals("#")){
			Main.location = "#D";
			id = Main.location;
			return Main.location;
		}
		else{
			return "#";
		}
	}
}
