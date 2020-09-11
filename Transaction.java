package digifiatsim;


public interface Transaction {
  public User getFromEntity();
  public User getToEntity();
  public long getValue();
}
