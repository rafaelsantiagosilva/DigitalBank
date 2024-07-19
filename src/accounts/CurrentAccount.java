package accounts;

import java.time.LocalDate;

public class CurrentAccount extends Account {
     public CurrentAccount(double balance, String customerName, String customerEmail, String customerCpf,
               String customerPhone,
               LocalDate customerBirthDate) {

          super(balance, customerName, customerEmail, customerCpf, customerPhone, customerBirthDate);
     }

     @Override
     public void printExtract() {
          System.out.println("---------------------------------------------------");
          System.out.println("*** Extrato: Conta Corrente");
          this.printStandardInfos();
          this.printCustomerInfos();
          System.out.println("---------------------------------------------------");
     }
}
