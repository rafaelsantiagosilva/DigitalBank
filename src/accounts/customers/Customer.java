package accounts.customers;

import java.time.LocalDate;

public class Customer {
     private String name, email, cpf, phone;
     private LocalDate birthDate;

     public Customer(String name, String email, String cpf, String phone, LocalDate birthDate) {
          this.name = name;
          this.email = email;
          this.cpf = cpf;
          this.phone = phone;
          this.birthDate = birthDate;
     }

     @Override
     public String toString() {
          return "Customer={" +
                    "name='" + this.name + "\'" +
                    ", email='" + this.email + "\'" +
                    ", cpf='" + this.cpf + "\'" +
                    ", phone='" + this.phone + "\'" +
                    "birthDate='" + this.birthDate + "\'" +
                    "}";
     }

     public String getName() {
          return name;
     }

     public String getEmail() {
          return email;
     }

     public String getCpf() {
          return cpf;
     }

     public String getPhone() {
          return phone;
     }

     public LocalDate getBirthDate() {
          return birthDate;
     }

     public void setName(String name) {
          this.name = name;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public void setCpf(String cpf) {
          this.cpf = cpf;
     }

     public void setPhone(String phone) {
          this.phone = phone;
     }

     public void setBirthDate(LocalDate birthDate) {
          this.birthDate = birthDate;
     }
}
