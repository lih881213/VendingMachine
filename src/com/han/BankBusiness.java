package com.han;

public class BankBusiness {

	private String account;
	private String name;
	private String create;
	private int balance;

	public BankBusiness(String account, String name, String createDay, int balance) {
		
		this.account = account;
		this.name = name;
		this.create = create;
		this.balance = balance;
		
	}

	public String getAccount() {
		
		return account;
		
	}

	public void setAccount(String account) {
		
		this.account = account;
		
	}

	public String getName() {
		
		return name;
		
	}

	public void setName(String name) {
		
		this.name = name;
		
	}

	public String getCreateDay() {
		
		return create;
		
	}

	public void setCreateDay(String create) {
		
		this.create = create;
		
	}

	public int getBalance() {
		
		return balance;
		
	}

	public void setBalance(int balance) {
		
		this.balance = balance;
		
	}
	
	public void deposit(int money) {
		
		balance += money;
		
	}

	public void withdrawal(int money) {
		
		balance -= money;
		
	}

	public void showMyBalance() {
		
		System.out.printf("[ 계좌번호 : %s, 예금주 : %s ] 잔액 : %d원\n", account, name, balance);
		
	}
}