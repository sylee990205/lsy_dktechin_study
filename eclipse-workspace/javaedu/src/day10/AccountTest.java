package day10;
class Account {
	private String account;
	private double balance;
	private double interestRate;
	public Account() {
	}
	public Account(String account, double balance, double interestRate) {
		setAccount(account);
		setBalance(balance);
		setInterestRate(interestRate);
	}	
	@Override  
	public String toString() {
		return "계좌정보 : " + account + " " + balance + " " + interestRate;
	}
	public double calculateInterest() {
		// 잔액기준 이자 계산		
		return balance * interestRate*0.01;
	}
	public void deposit(double money) throws Exception {
		if (money > 0)
			balance += money;
		else
			throw new Exception("입금 금액이 0보다 적습니다.");
	}
	public void withdraw(double money) throws Exception {
		if (money < 0 || balance < money)
			throw new Exception("금액이 0보다 적거나 현재 잔액보다 많습니다.");
		else
			balance -= money;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
}
public class AccountTest {
	public static void main(String[] args) {
		Account ac = new Account("441-0290-1203", 500000, 7.3);
		System.out.println("계좌정보 : " + ac.getAccount() + "  " + ac.getBalance() + "  " + ac.getInterestRate());
		System.out.println(ac);
		try {
			ac.deposit(-10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
		try {
			ac.withdraw(600000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("이자 : " + ac.calculateInterest());
	}
}
