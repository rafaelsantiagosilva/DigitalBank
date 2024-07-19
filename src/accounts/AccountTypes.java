package accounts;

public enum AccountTypes {
     CURRENT_ACCOUNT(1),
     SAVINGS_ACCOUNT(2);

     private int type;

     private AccountTypes(int type) {
          this.type = type;
     }

     public int getType() {
          return type;
     }
}
