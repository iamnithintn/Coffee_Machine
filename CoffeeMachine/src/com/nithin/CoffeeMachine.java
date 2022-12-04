package com.nithin;
import java.util.Scanner;

public class CoffeeMachine {

	//JBC
	static Scanner scanner = new Scanner(System.in);
	private int water;
	private int milk;
	private int coffeeBeans;
	private int disposableCups;
	private int money;

	public CoffeeMachine(){

	}
	//constructor to initialize the ingredients before the operation of the machine.
	public CoffeeMachine(int water, int milk, int coffeeBeans, int disposableCups, int money) {
		this.water = water;
		this.milk = milk;
		this.coffeeBeans = coffeeBeans;
		this.disposableCups = disposableCups;
		this.money = money;
	}

	//setting the value of respective ingredients in the coffee machine.
	public int getWater() {
		return water;
	}

	public void setWater(int water) {
		this.water = water;
	}

	public int getMilk() {
		return milk;
	}

	public void setMilk(int milk) {
		this.milk = milk;
	}

	public int getCoffeeBeans() {
		return coffeeBeans;
	}

	public void setCoffeeBeans(int coffeeBeans) {
		this.coffeeBeans = coffeeBeans;
	}

	public int getDisposableCups() {
		return disposableCups;
	}

	public void setDisposableCups(int disposableCups) {
		this.disposableCups = disposableCups;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}


	//function to show the available ingredients in the coffee machine.
	public static void showSupply(CoffeeMachine coffeeMachine){
		System.out.println("The coffee machie has:");
		System.out.println(coffeeMachine.getWater() + " of water");
		System.out.println(coffeeMachine.getMilk() + " of Milk");
		System.out.println(coffeeMachine.getCoffeeBeans() + " of coffee beans");
		System.out.println(coffeeMachine.getDisposableCups() + " of disposable cups");
		System.out.println(coffeeMachine.getMoney() + " of Money");
	}

	//function to display the menu
	public static void buy(CoffeeMachine coffeeMachine){
		System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu");
		String inputValue = scanner.nextLine();

		switch(inputValue){
		case "1" : //function calling which brews and distributes the coffee.
			System.out.println(checkWhatIsNotEnough(coffeeMachine, new Espresso()));
			break;
		case "2" :
			System.out.println(checkWhatIsNotEnough(coffeeMachine, new Latte()));
			break;
		case "3" :
			System.out.println(checkWhatIsNotEnough(coffeeMachine, new Cappuccino()));
			break;
		case "back": 
			break;
		}
	}

	//function to check if there are enough ingredients for the drink to prepare and distribute the drink
	public static String checkWhatIsNotEnough(CoffeeMachine coffeeMachine, Coffee coffee){
		if(coffeeMachine.getWater() < coffee.getWater()){
			return "Sorry, not enough water!";
		}else if(coffeeMachine.getMilk() < coffee.getMilk()){
			return "Sorry, not enough milk!";
		}else if(coffeeMachine.getCoffeeBeans()<coffee.getCoffeeBeans()){
			return "Sorry, not enough coffee beans";
		}else if(coffeeMachine.getDisposableCups() < 1){
			return "Sorry, not enough disposable cups";
		}else {
			//deducting the ingredients in the process of preparing the drink
			coffeeMachine.setWater(coffeeMachine.getWater() - coffee.getWater());
			coffeeMachine.setMilk(coffeeMachine.getMilk() - coffee.getMilk());
			coffeeMachine.setCoffeeBeans(coffeeMachine.getCoffeeBeans() - coffee.getCoffeeBeans());
			coffeeMachine.setDisposableCups(coffeeMachine.getDisposableCups() - 1);
			coffeeMachine.setMoney(coffeeMachine.getMoney() + coffee.getMoney());

			System.out.println("I have enough resources, making you a coffee in 5 seconds!"); 
			try {
				// a small 5 second wait since for the coffee to be prepared using Thread:-)
				Thread.sleep(5000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			return "Here is your drink";
		}
	}
	//function to refill the machine with ingredients
	public static void fill(CoffeeMachine coffeeMachine){
		System.out.println("Write how many ml of water do you want to add: ");
		coffeeMachine.setWater(scanner.nextInt() + coffeeMachine.getWater());
		System.out.println("Write how many ml of milk do you want to add: ");
		coffeeMachine.setMilk(scanner.nextInt() +  coffeeMachine.getMilk());
		System.out.println("Write how many grams of coffee do you want to add: ");
		coffeeMachine.setCoffeeBeans(scanner.nextInt() + coffeeMachine.getCoffeeBeans());
		System.out.println("Write how many disposable cups of coffee do you want to add: ");
		coffeeMachine.setDisposableCups(scanner.nextInt() + coffeeMachine.getDisposableCups());

	}

	//function to collect the money
	public static void take(CoffeeMachine coffeeMachine){
		System.out.println("I gave you $" + coffeeMachine.getMoney());
		coffeeMachine.setMoney(0);
	}


}
