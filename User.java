package digifiatsim;

interface User implements Serializable {
  String getID();
  String getName();
  String getPublicKey();
  /*
  Boolean transferFrom(Long amount);
  Boolean transferTo(Long amount); */
  Long getBalance();
}
