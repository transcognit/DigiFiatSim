package digifiatsim;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;

public class ControlTask extends TimerTask {
  MainWindow m;

  public ControlTask(MainWindow m1) {
    this.m = m1;
  }
  public void run() {
    try {
      //Thread.sleep(1000);
      m.MintLabel1.setText("" + m.pars.Mint_TxCount);
      m.MintLabel2.setText("" + m.pars.Mint_TxCount);
    } catch(Exception e) {}
  }
}
