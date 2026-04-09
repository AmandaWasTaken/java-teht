import java.util.Random;

public class BankAccount {


	static int totalAccounts = 0;
	int accountNumber;
	double balance;
	String accountName;

	Random r = new Random();
	public BankAccount(double balance){
		this.balance = balance;
		this.accountNumber = r.nextInt(100);
		totalAccounts++;
	}

	public void deposit(double amount){
		this.balance += amount;
	}

	public void withdraw(double amount){
		if(this.balance - amount < 0){
			System.out.println("Not enough balance to withdraw!");
		} else {
			this.balance -= amount;
			System.out.printf("Withdrew %.1f from account %d%nNew balance %.1f%n", amount, getAccountNumber(), this.balance);
		}
	}

	public int getAccountNumber(){
		return this.accountNumber;
	}

	public static int getTotalAccounts(){
		return totalAccounts;
	}

	public double getBalance(){
		return this.balance;
	}

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(1000);
        BankAccount account2 = new BankAccount(2000);

		System.out.println("Account " + account1.getAccountNumber() + " balance: " + account1.getBalance());
        System.out.println("Account " + account2.getAccountNumber() + " balance: " + account2.getBalance());
		System.out.println();

        account1.deposit(500);
        account2.withdraw(800);

        System.out.println("Account " + account1.getAccountNumber() + " balance: " + account1.getBalance());
        System.out.println("Account " + account2.getAccountNumber() + " balance: " + account2.getBalance());

		System.out.println();
        System.out.println("Total number of accounts: " + BankAccount.getTotalAccounts());
    }
}
