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
  String getID();
  String getName();
  String getPublicKey();
  Boolean increaseBalance(Long l);
  Boolean decreaseBalance(Long l);
  //Boolean transferFrom(Long amount);
  //Boolean transferTo(Long amount);
  Long getBalance();

}
