package net.uni;

public class Customer {

	private Drink fanta;
	private Drink cola;
	private Drink cider;
	
	private int money;
	
	public Customer() {
		fanta = new Drink("환타", 0, 0);
		cola = new Drink("콜라", 0, 0);
		cider = new Drink("사이다", 0, 0);
	}
	
	public Drink getFanta() {
		return fanta;
	}
	public void setFanta(Drink fanta) {
		this.fanta = fanta;
	}
	public Drink getCola() {
		return cola;
	}
	public void setCola(Drink cola) {
		this.cola = cola;
	}
	public Drink getCider() {
		return cider;
	}
	public void setCider(Drink cider) {
		this.cider = cider;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	public int pay(int money) {
		// 고객이 가진 금액에서 지불할 만큼을 뺀다.
		this.money -= money;
		
		// 지불할 금액을 리턴한다.
		return money;
	}
	
	public void takeRemainMoney(int money) {
		this.money += money;
	}
	
	public void takeDrink(Drink drink) {
		
		String name = drink.getName();
		if ( name.equals("환타") ) {
			int fantaQuantity = fanta.getQuantity();
			fantaQuantity++;
			fanta.setQuantity(fantaQuantity);
		}
		else if ( name.equals("콜라") ) {
			int colaQuantity = cola.getQuantity();
			colaQuantity++;
			cola.setQuantity(colaQuantity);
		}
		else if ( name.equals("사이다") ) {
			int ciderQuantity = cider.getQuantity();
			ciderQuantity++;
			cider.setQuantity(ciderQuantity);
		}
		
	}
	
	@Override
	public String toString() {
		System.out.println("====== 구매자 ======");
		System.out.printf("%s %,d개\n", 
				fanta.getName(),
				fanta.getQuantity());
		
		System.out.printf("%s %,d개\n", 
				cola.getName(),
				cola.getQuantity());
		
		System.out.printf("%s %,d개\n", 
				cider.getName(),
				cider.getQuantity());
		
		System.out.printf("%,d원 있습니다.", money);
		return "";
	}
	
}






