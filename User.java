package digifiatsim;

/*
abstract class TxUser {
  abstract String getID();
  abstract String getName();
  abstract String getPublicKey();

  Boolean transferFrom(Long amount);
  Boolean transferTo(Long amount);
  abstract Long getBalance();
}
*/


 interface User {
  public String getID();
  public String getName();
  public String getPublicKey();
  public Boolean incBalance(Long l);
  public Boolean decBalance(Long l);
  public Long getBalance();
}
