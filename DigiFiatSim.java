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
  java.util.Timer timer;


  MainWindow() {
    setTitle("Main Window");
    setLayout(new GridLayout(4,1));
    add(addButtons()); // Add panel containing buttons
    add(addMintButtons());
    add(addPSP1Buttons());
    add(addPSP2Buttons());
    setSize(700,350);
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
    TimerTask t1, t2, t3;

    timer = new java.util.Timer("TaskThread");
    t1 = new ControlTask(this);
    t2 = new PSP1(this);
    t3 = new PSP2(this);
    timer.schedule(t1,1000,2000);
    timer.schedule(t2, 1000, 1000);
    timer.schedule(t3, 1000, 500);
    statusLabel.setText("Status: Running");
  }
}



public class DigiFiatSim {
  static public void main(String[] args) {
    MainWindow tw = new MainWindow();
  }
}
