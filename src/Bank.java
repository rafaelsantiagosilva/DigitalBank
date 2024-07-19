import accounts.Account;
import accounts.AccountTypes;
import accounts.SavingsAccount;
import accounts.CurrentAccount;
import exceptions.InvalidValueException;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class Bank {
    public static void main(String[] args) throws Exception {
        Bank bank = new Bank("Blaze: The best of the universe!");

        bank.addAccount(AccountTypes.CURRENT_ACCOUNT, 1500.00, "João Silva", "joao.silva@example.com",
                "123.456.789-00", "555-1234", LocalDate.of(1990, 5, 20));
        bank.addAccount(AccountTypes.SAVINGS_ACCOUNT, 2500.00, "Maria Oliveira", "maria.oliveira@example.com",
                "987.654.321-00", "555-5678", LocalDate.of(1985, 8, 15));

        bank.showBankInfo();

        Account currentAccount = bank.accounts.get(0);
        Account savingsAccount = bank.accounts.get(1);

        currentAccount.deposit(500.00);
        savingsAccount.withdraw(300.00);

        try {
            currentAccount.transfer(200.00, savingsAccount);
        } catch (InvalidValueException e) {
            System.out.println("Transferência falhou: saldo insuficiente.");
        }

        currentAccount.printExtract();
        savingsAccount.printExtract();

        bank.removeAccount(currentAccount.getNumber());

        bank.showBankInfo();
    }

    private String name;
    private List<Account> accounts;

    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<Account>();
    }

    public void addAccount(AccountTypes accountType, double balance,
            String customerName, String customerEmail, String customerCpf, String customerPhone,
            LocalDate customerBirthDate) {
        if (accountType == AccountTypes.CURRENT_ACCOUNT)
            this.accounts.add(new CurrentAccount(balance, customerName, customerEmail, customerCpf, customerPhone,
                    customerBirthDate));
        else if (accountType == AccountTypes.SAVINGS_ACCOUNT)
            this.accounts.add(new SavingsAccount(balance, customerName, customerEmail, customerCpf, customerPhone,
                    customerBirthDate));
    }

    public void removeAccount(int accountNumber) {
        if (this.accounts.isEmpty())
            return;

        Account accountToRemove = null;

        for (Account account : this.accounts) {
            if (account.getNumber() == accountNumber) {
                accountToRemove = account;
                break;
            }
        }

        this.accounts.remove(accountToRemove);
    }

    public void showBankInfo() {
        System.out.println("|Bank " + this.name + "|");
        for (Account account : accounts) {
            System.out.println(account);
            System.out.println(account.getCustomer());
        }
    }
}
