package accounts;

import java.time.LocalDate;

public class SavingsAccount extends Account {
     public SavingsAccount(double balance, String customerName, String customerEmail, String customerCpf,
               String customerPhone,
               LocalDate customerBirthDate) {

          super(balance, customerName, customerEmail, customerCpf, customerPhone, customerBirthDate);
     }

     @Override
     public void printExtract() {
          System.out.println("---------------------------------------------------");
          System.out.println("*** Extrato: Conta Poupança");
          this.printStandardInfos();
          this.printCustomerInfos();
          System.out.println("---------------------------------------------------");
     }
}