import java.awt.event.*;
import javax.swing.*;
public class Test {
  static public void main(String [] args) {
    MyTest t = new MyTest();

    try{
      Timer timer = new Timer(555, t); //timer is ticking
      timer.setRepeats(true); //by using this, we are asking to off timer once
      timer.start();
      Thread.sleep(5555);
	timer.stop();
      Thread.sleep(5555);
	timer.restart();
	Thread.sleep(5555);
      System.out.println("Timeout"); //timer ends and this message is displayed
    } catch (InterruptedException expn) {
    }
  }
}


class MyTest implements ActionListener {
	int i=0;

  public void actionPerformed(ActionEvent e) {
	System.out.println("Happening now..." + (++i));
  }
}


