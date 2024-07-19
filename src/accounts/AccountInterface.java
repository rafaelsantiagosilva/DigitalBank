package accounts;

import exceptions.InvalidValueException;

public interface AccountInterface {
     void withdraw(double value) throws InvalidValueException;

     void deposit(double value);

     void transfer(double value, Account destinationAccount) throws InvalidValueException;
}
