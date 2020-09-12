package digifiatsim;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;

public class PSP1 extends TimerTask implements PSP {
  MainWindow m;
  int TxCount = 0;
  long TxValue = 0;

  public PSP1(MainWindow m1) {
    this.m = m1;
  }
  public void run() {
    try {
      m.PSP1Label1.setText(""+TxCount);
      m.PSP1Label2.setText(""+TxValue);
      //Thread.sleep(1000);
    } catch(Exception e) {}
  }

  // Receive and validate User transaction
  // Pass on to MintControl and return true if successful
  public Boolean submitTransaction(AccountTransaction t) {
    TxCount++;
    TxValue += t.getValue();
    // User who is sending the money
    IUser u1 = (IUser)t.getFromEntity();
    // Enough balance?
    if (u1.getBalance() > t.getValue()) { // Yes
      return m.submitTransaction(t);
    }
    
    return Boolean.FALSE;
  }
}
