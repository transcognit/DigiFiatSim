package digifiatsim;

interface User {
  String getID();
  String getName();
  String getPublicKey();
  boolean transferFrom(long amount);
  boolean transferTo(long amount);
  long getBalance();
}
