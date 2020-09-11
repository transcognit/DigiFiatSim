package digifiatsim;


interface PSP {
  public Boolean requestTransaction(AccountTransaction t);
  public Boolean submitTransaction(AccountTransaction t);
}
