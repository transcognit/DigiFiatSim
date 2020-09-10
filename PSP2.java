import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;

class PSP2 extends TimerTask {
  MainWindow m;

  public PSP2(MainWindow m1) {
    this.m = m1;
  }
  public void run() {
    try {
      m.PSP2Label1.setText(""+(int)(Math.random() * 5000 + 1));
      m.PSP2Label2.setText(""+(int)(Math.random() * 50000 + 1));
      //Thread.sleep(500);
    } catch(Exception e) {}
  }
}
