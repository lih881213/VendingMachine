package net.uni;

public class VendingMachine {

	private Drink fanta;
	private Drink cola;
	private Drink cider;
	
	private int preparedMoney;
	
	private int remainMoney; // 고객에게 돌려줄 거스름돈
	private int paidMoney; // 고객이 자판기에 넣은 돈

	public VendingMachine() {
		fanta = new Drink("환타", 10, 1500);
		cola = new Drink("콜라", 10, 1000);
		cider = new Drink("사이다", 10, 900);
		
		preparedMoney = 500000;
	}
	
	/**
	 * 고객에게 돈을 받는다.
	 * 
	 * @param customer : 불특정 고객
	 * @param money : 고객이 낸 돈
	 */
	public boolean receiveMoney(Customer customer, int money) {
		
		paidMoney = customer.pay(money);
		
		if ( paidMoney < 900 ) {
			System.out.println("돈을 너무 적게 넣었습니다.");
			refundMoney(customer, money);
			return false;
		}
		else {
			showMenu();
			return true;
		}
		
	}
	
	/**
	 * 환불
	 * @param customer : 돈을 넣은 고객
	 * @param money : 환불할 금액
	 */
	public void refundMoney(Customer customer, int money) {
		System.out.printf("%,d원을 가져가세요.\n", money);
		customer.takeRemainMoney(money);
		paidMoney = 0;
	}
	
	/**
	 * 구매가능한 상품을 보여준다.
	 */
	public void showMenu() {
		System.out.printf("%,d원으로 구매할 수 있는 상품입니다.\n", paidMoney);
		
		// 환타, 콜라, 사이다를 모두 보여줌.
		if ( paidMoney >= 1500 ) {
			System.out.printf("1. %s (%,d개) %,d원\n", 
					fanta.getName(),
					fanta.getQuantity(),
					fanta.getPrice());
			System.out.printf("2. %s (%,d개) %,d원\n", 
					cola.getName(),
					cola.getQuantity(),
					cola.getPrice());
			System.out.printf("3. %s (%,d개) %,d원\n", 
					cider.getName(),
					cider.getQuantity(),
					cider.getPrice());
		}
		else if ( paidMoney >= 1000 ) {
			System.out.printf("2. %s (%,d개) %,d원\n", 
					cola.getName(),
					cola.getQuantity(),
					cola.getPrice());
			System.out.printf("3. %s (%,d개) %,d원\n", 
					cider.getName(),
					cider.getQuantity(),
					cider.getPrice());
		}
		else if ( paidMoney >= 900 ) {
			System.out.printf("3. %s (%,d개) %,d원\n", 
					cider.getName(),
					cider.getQuantity(),
					cider.getPrice());
		}
	}
	
	public void extractDrink(Customer customer, int selectedMenuId) {
		
		if ( selectedMenuId == 1 && paidMoney >= 1500 ) {
			Drink fanta = new Drink("환타", 1, 0);
			customer.takeDrink(fanta);
			remainMoney = paidMoney - 1500;
			preparedMoney += (paidMoney - remainMoney);
			
			int fantaQuantity = this.fanta.getQuantity();
			fantaQuantity--;
			this.fanta.setQuantity(fantaQuantity);
		}
		else if ( selectedMenuId == 2 && paidMoney >= 1000 ) {
			Drink cola = new Drink("콜라", 1, 0);
			customer.takeDrink(cola);
			remainMoney = paidMoney - 1000;
			preparedMoney += (paidMoney - remainMoney);
			
			int colaQuantity = this.cola.getQuantity();
			colaQuantity--;
			this.cola.setQuantity(colaQuantity);
		}
		else if ( selectedMenuId == 3 && paidMoney >= 900 ) {
			Drink cider = new Drink("사이다", 1, 0);
			customer.takeDrink(cider);
			remainMoney = paidMoney - 900;
			preparedMoney += (paidMoney - remainMoney);
			
			int ciderQuantity = this.cider.getQuantity();
			ciderQuantity--;
			this.cider.setQuantity(ciderQuantity);
		}
		else {
			remainMoney = paidMoney;
			System.out.println("잘못 눌렀습니다.");
		}
		
		refundMoney(customer, remainMoney);
	}
	
	@Override
	public String toString() {
		System.out.println("====== 판매자 ======");
		System.out.printf("%s %,d개\n", 
				fanta.getName(),
				fanta.getQuantity());
		
		System.out.printf("%s %,d개\n", 
				cola.getName(),
				cola.getQuantity());
		
		System.out.printf("%s %,d개\n", 
				cider.getName(),
				cider.getQuantity());
		
		System.out.printf("%,d원 있습니다.", preparedMoney);
		return "";
	}
	
	public boolean isSoldOut() {
		int ciderQuantity = cider.getQuantity();
		int colaQuantity = cola.getQuantity();
		int fantaQuantity = fanta.getQuantity();
		
		int totalQuantity = ciderQuantity + colaQuantity + fantaQuantity;
		
		return totalQuantity == 0;
	}
}




