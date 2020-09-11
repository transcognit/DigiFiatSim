package digifiatsim;


public class AccountTransaction implements Transaction {
  public IUser getFromEntity() {
    return new IUser();
  }
  public IUser getToEntity() {
    return new IUser();
  }
  public long getValue() {
    return 0L;
  }
}
