package net.uni;

import java.util.Scanner;

public class Outside {

	private Customer customer;
	private VendingMachine vendingMachine;

	/**
	 * 자판기와 고객의 중개
	 */
	public void mediation() {
		vendingMachine = new VendingMachine();
		customer = new Customer();
		customer.setMoney(5000);
		
		Scanner input = new Scanner(System.in);
		
		int money = 0;
		boolean isSuccess = false;
		int selectedMenuId = 0;
		
		while ( true ) {
			System.out.println("음료 자판기입니다. 금액을 넣어주세요.");
			money = input.nextInt();
			
			isSuccess = false;
			
			// 돈을 넣는다.
			while ( true ) {
				isSuccess = vendingMachine.receiveMoney(customer, money);
				if ( !isSuccess ) {
					System.out.println("금액을 다시 넣어주세요.");
					money = input.nextInt();
				}
				else {
					break;
				}
			}
			
			selectedMenuId = input.nextInt();
			vendingMachine.extractDrink(customer, selectedMenuId);
			
			System.out.println(vendingMachine);
			System.out.println(customer);
			
			if ( customer.getMoney() <= 0 || vendingMachine.isSoldOut() ) {
				break;
			}
			
			
		}
	}
	
	public static void main(String[] args) {
		new Outside().mediation();
	}
	
}
