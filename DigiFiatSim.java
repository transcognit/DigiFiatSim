package digifiatsim;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;

class MainWindow extends JFrame implements ActionListener {  //creation of an window using JFrame
  private int start = 1;
  private JButton jbtn; //creation of button inside the JFrame window private
  private JLabel statusLabel;
  public JLabel MintLabel1, MintLabel2, PSP1Label1, PSP1Label2, PSP2Label1, PSP2Label2;
  public JLabel UserManagerLabel1, UserManagerLabel2, UserCountLabel;
  java.util.Timer timer;
  TimerTask TimerMintControl, TimerPSP1, TimerPSP2, TimerUserControl;

  MainWindow() {
    setTitle("Main Window");
    setLayout(new GridLayout(5,1));
    add(addButtons()); // Add panel containing buttons
    add(addMintButtons());
    add(addPSP1Buttons());
    add(addPSP2Buttons());
    add(addUserManagerButtons());
    setSize(700,450);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }
  private JPanel addButtons() {
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout());
    jbtn = new JButton("Start...");
    panel.add(jbtn);
    statusLabel = new JLabel();
    panel.add(statusLabel);
    jbtn.addActionListener(this);
    return(panel);
  }

  private JPanel addMintButtons() {
    JPanel panel = new JPanel();
    GridLayout g = new GridLayout(1,4);
    g.setHgap(5); g.setVgap(5);
    panel.setLayout(g);
    Border eBorder = BorderFactory.createEtchedBorder();
    panel.setBorder(BorderFactory.createTitledBorder(eBorder, "Mint Control"));
    panel.add(new JLabel("Transactions"));
    MintLabel1 = new JLabel();
    MintLabel2 = new JLabel();
    panel.add(MintLabel1);
    panel.add(new JLabel("Value"));
    panel.add(MintLabel2);
    return(panel);
  }

  private JPanel addPSP1Buttons() {
    JPanel panel = new JPanel();
    GridLayout g = new GridLayout(1,4);
    g.setHgap(5); g.setVgap(5);
    panel.setLayout(g);
    Border eBorder = BorderFactory.createEtchedBorder();
    panel.setBorder( BorderFactory.createTitledBorder( eBorder, "Payments Processor 1" ) );
    panel.add(new JLabel("Transactions"));
    PSP1Label1 = new JLabel();
    panel.add(PSP1Label1);
    panel.add(new JLabel("Value"));
    PSP1Label2 = new JLabel();
    panel.add(PSP1Label2);
    return(panel);
  }

  private JPanel addPSP2Buttons() {
    JPanel panel = new JPanel();
    GridLayout g = new GridLayout(1,4);
    g.setHgap(5); g.setVgap(5);
    panel.setLayout(g);
    Border eBorder = BorderFactory.createEtchedBorder();
    panel.setBorder( BorderFactory.createTitledBorder( eBorder, "Payments Processor 2" ) );
    panel.add(new JLabel("Transactions"));
    PSP2Label1 = new JLabel();
    panel.add(PSP2Label1);
    panel.add(new JLabel("Value"));
    PSP2Label2 = new JLabel();
    panel.add(PSP2Label2);
    return(panel);
  }

  private JPanel addUserManagerButtons() {
    JPanel panel = new JPanel();
    GridLayout g = new GridLayout(4,2);
    g.setHgap(5); g.setVgap(5);
    panel.setLayout(g);
    Border eBorder = BorderFactory.createEtchedBorder();
    panel.setBorder( BorderFactory.createTitledBorder( eBorder, "UserManager" ) );
    panel.add(new JLabel("Users loaded:"));
    UserCountLabel = new JLabel();
    panel.add(UserCountLabel);
    panel.add(new JLabel("Transactions"));
    UserManagerLabel1 = new JLabel();
    panel.add(UserManagerLabel1);
    panel.add(new JLabel("Value"));
    UserManagerLabel2 = new JLabel();
    panel.add(UserManagerLabel2);
    return(panel);
  }

  public void actionPerformed(ActionEvent evnt) {
    JButton src = (JButton)evnt.getSource();
    if (src.getText().equals("Pause...")) {
      stopTasks();
      src.setText("Start...");
    } else if (src.getText().equals("Start...")) {
        startTasks();
        src.setText("Pause...");
    }
  }

  public void stopTasks() {
    timer.cancel();
    statusLabel.setText("Status: Stopped");
  }

  public void startTasks() {
    //timer = new java.util.Timer("TaskThread");
    TimerMintControl = new ControlTask(this);
    TimerPSP1 = new PSP1(this);
    TimerPSP2 = new PSP2(this);
    TimerUserControl = new UserManager(this);
    timer.schedule(TimerMintControl,1000,2000);
    timer.schedule(TimerPSP1, 1000, 1000);
    timer.schedule(TimerPSP2, 1000, 500);
    timer.schedule(TimerUserControl, 1000, 500);
    statusLabel.setText("Status: Running");
  }

  // Mint Control Functions
  public PSP getPSP() { // Return a random PSP to the caller
    if (Math.random() > 0.5) {
      return (PSP)TimerPSP1;
    }
    return (PSP)TimerPSP2;
  }
  public Boolean submitTransaction(AccountTransaction t) {
    // Check if Transaction is valid
    // Update balances
    // Return true;
    return false;
  }
}



public class DigiFiatSim {
  static public void main(String[] args) {
    MainWindow tw = new MainWindow();
  }
}
