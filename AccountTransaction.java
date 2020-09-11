package digifiatsim;


public class AccountTransaction implements Transaction {
  IUser u1, u2;
  Long amount;

  public AccountTransaction(IUser u1, IUser u2, Long amount) {
    this.u1 = u1;
    this.u2 = u2;
    this.amount = amount;
  }

  public String toString() {
    return "["+u1+","+u2+"], Amt:"+amount;
  }
  public IUser getFromEntity() {
    return u1;
  }
  public IUser getToEntity() {
    return u2;
  }
  public long getValue() {
    return amount;
  }
}
