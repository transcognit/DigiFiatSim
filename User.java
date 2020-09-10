import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;

class User extends TimerTask {
  MainWindow m;

  public User(MainWindow m1) {
    this.m = m1;
  }
  public void run() {
    try {
      m.UserLabel1.setText(""+(int)(Math.random() * 5000 + 1));
      m.UserLabel2.setText(""+(int)(Math.random() * 50000 + 1));
      //Thread.sleep(500);
    } catch(Exception e) {}
  }
}
