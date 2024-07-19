package accounts;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import accounts.customers.Customer;
import exceptions.InvalidValueException;

public abstract class Account implements AccountInterface {
     private static final int STANDARD_AGENCY = 143;
     private static int sequential = 0;

     protected int agencyCode;
     protected int number;
     protected double balance;
     protected Customer customer;

     public Account(double balance, String customerName, String customerEmail, String customerCpf, String customerPhone,
               LocalDate customerBirthDate) {
          this.agencyCode = STANDARD_AGENCY;
          this.number = ++sequential;
          this.balance = balance;
          this.customer = new Customer(customerName, customerEmail, customerCpf, customerPhone, customerBirthDate);
     }

     protected void printStandardInfos() {
          System.out.printf("\tAgência: %d\n", this.getAgencyCode());
          System.out.printf("\tNúmero: %d\n", this.getNumber());
          System.out.printf("\tSaldo: R$%.2f\n", this.getBalance());
     }

     protected void printCustomerInfos() {
          DateTimeFormatter birthDateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
          String customerBirthDateFormatted = this.customer.getBirthDate().format(birthDateFormatter);

          System.out.println("\tCliente: ");
          System.out.println("\t\tNome: " + this.customer.getName());
          System.out.println("\t\tData de nascimento: " + customerBirthDateFormatted);
          System.out.println("\t\tCPF: " + this.customer.getCpf());
          System.out.println("\t\tEmail: " + this.customer.getEmail());
          System.out.println("\t\tTelefone: " + this.customer.getPhone());
     }

     public void printExtract() {

     }

     @Override
     public void withdraw(double value) throws InvalidValueException {
          if (value > this.balance)
               throw new InvalidValueException();

          setBalance(this.balance - value);
     }

     @Override
     public void deposit(double value) {
          setBalance(this.balance + value);
     }

     @Override
     public void transfer(double value, Account destinationAccount) throws InvalidValueException {
          try {
               this.withdraw(value);
               destinationAccount.deposit(value);
          } catch (InvalidValueException e) {
               System.err.println("Erro: Valor de saque maior que o saldo disponível!");
          }
     }

     @Override
     public String toString() {
          return "Account{" +
                    "agencyCode='" + this.agencyCode + "\'" +
                    ", number='" + this.number + "\'" +
                    ", balance='" + this.balance + "\'" +
                    "}";
     }

     public int getAgencyCode() {
          return agencyCode;
     }

     public int getNumber() {
          return number;
     }

     public double getBalance() {
          return balance;
     }

     public Customer getCustomer() {
          return customer;
     }

     public void setBalance(double balance) {
          this.balance = balance;
     }
}
