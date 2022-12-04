package com.nithin;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {


		Scanner scanner = new Scanner(System.in);

		//creating the coffee machine object and passing the preset ingredient values
		CoffeeMachine defaulCoffeeMachine = new CoffeeMachine(400, 540, 120, 9, 0);

		boolean exit = false;
		String inputValue = "";
		while (!exit) {
			System.out.println("Write action (buy, fill, take, remaining, exit)");
			inputValue = scanner.nextLine();
			scanner.close();
			if (inputValue.equals("buy")) {
				CoffeeMachine.buy(defaulCoffeeMachine);
			} else if (inputValue.equals("fill")) {
				CoffeeMachine.fill(defaulCoffeeMachine);
			} else if (inputValue.equals("take")) {
				CoffeeMachine.take(defaulCoffeeMachine);
			} else if (inputValue.equals("remaining")) {
				CoffeeMachine.showSupply(defaulCoffeeMachine);
			} else if (inputValue.equals("exit")) {
				exit = true;
			}
		}
	}
}

