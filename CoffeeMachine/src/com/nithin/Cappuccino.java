package com.nithin;

//inheriting the coffee class to override the constructor which accepts the respective ingredients to brew the Cappuccino.
public class Cappuccino extends Coffee{

	public Cappuccino() {
		//passing the preset ingredients.
		super(200, 100, 12, 6, "cappuccino");
	}
}
