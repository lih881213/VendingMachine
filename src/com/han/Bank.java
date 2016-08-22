package com.han;

import java.util.Scanner;

public class Bank {
	
	private BankBusiness bankBusiness;
	Scanner input = new Scanner(System.in);
	
	String account;
	String name;
	String create;
	int money;
		
	public Bank() {
		
		System.out.println("안녕하세요. 반장은행입니다.");
		
		System.out.println("예금주명을 입력 하세요.");
		name = input.next();
		
		System.out.println("계좌번호를 입력하세요.");
		account = input.next();
		
		System.out.println("개설 일자를 입력하세요.");
		create = input.next();
		
		System.out.println("입금 하실 금액을 입력하세요.");
		money = input.nextInt();
		
		System.out.println("계좌가 생성되었습니다.");
		
		bankBusiness = new BankBusiness( account, name, create, money );
		
	}
	
	public void BankBusinessStart() {
		
		while(true) {
			
			System.out.println("업무를 선택 하세요.");
			System.out.println("1. 입금");
			System.out.println("2. 출금");
			System.out.println("3. 종료");
			
			int selectedMenu = input.nextInt();
			
			if ( selectedMenu == 1) {
				
				System.out.println("입금 금액을 입력하세요");
				money = input.nextInt();
				bankBusiness.deposit(money);
				bankBusiness.showMyBalance();
				
			}
			
			else if ( selectedMenu == 2) {
								
				while(true) {
					
					System.out.println("출금 금액을 입력하세요.");
					money = input.nextInt();
					
					if ( money > bankBusiness.getBalance()){
						System.out.println("잔액이 모자랍니다. 출금 할 수 없습니다.");
						
					}
					
					else{
						
						bankBusiness.withdrawal(money);
						System.out.println(money + "원이 출금 되었습니다.");
						bankBusiness.showMyBalance();
						break;
						
					}
				}
			}
			
			else if ( selectedMenu == 3) {
				
				System.out.println("안녕히 가세요.");
				break;
				
			}
			
			else {
				
				System.out.println("잘못 선택 하셨습니다.");
				
			}
		}
	}
	
	public static void main(String[] args) {
		
		new Bank().BankBusinessStart();
		
	}
}
