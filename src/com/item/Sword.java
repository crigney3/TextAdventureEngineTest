package com.item;

public class Sword extends Object{
	
	public Sword(boolean isWeapon, double power, double weight, String name) {
		super(isWeapon, power, weight, name);
		isWeapon = true;
		power = 5.0;
		weight = 10.0;
		
		name = "Rusty Sword";
	}
	
}
