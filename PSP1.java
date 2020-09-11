package digifiatsim;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;

public class PSP1 extends TimerTask implements PSP {
  MainWindow m;

  public PSP1(MainWindow m1) {
    this.m = m1;
  }
  public void run() {
    try {
      m.PSP1Label1.setText(""+(int)(Math.random() * 5000 + 1));
      m.PSP1Label2.setText(""+(int)(Math.random() * 500000 + 1));
      //Thread.sleep(1000);
    } catch(Exception e) {}
  }
  public Boolean requestTransaction(AccountTransaction t) { return Boolean.FALSE;}
  public Boolean submitTransaction(AccountTransaction t) { return Boolean.FALSE;}
}
