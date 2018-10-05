package com.item;

public class Object {
	public double w = 0.0;
	public  Object(boolean isWeapon, double power, double weight, String name){
		super();
		this.w = weight;
	}
	public double getWeight(){
		return w;
	}
}
