package digifiatsim;


import org.apache.commons.lang3.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.Paths.*;
import java.util.Collections;


public class AccountManager {
  IUser users[];
  int k;
  long balance; // The balance in this account
  int MAXCOUNT=1000;
  static Boolean firstRun = Boolean.TRUE;

  public void go() {
    users = new IUser[MAXCOUNT];
    /* Connect to database here, but a file for simulator */
    if (firstRun) {
      createUsers(); /* Create pool of 1000 users */
      firstRun = Boolean.FALSE;
    }
  }

  private void createUsers() {
    Long l;
    String s;
    for (int i=0; i<MAXCOUNT; i++) {
      k = i + 1;
      s = RandomStringUtils.random(15, Boolean.TRUE, Boolean.FALSE);
      l = (Math.round(Math.random()*10000+100));
      users[i] = new IUser(""+(1000*k+k), s, l);
      if (i%100 == 0) {
        System.out.println(users[i]);
      }
    }
  }

public void saveState(String filename) {
  try {
    FileOutputStream fos = new FileOutputStream(filename);
    ObjectOutputStream out = new ObjectOutputStream(fos);
    for (int i=0; i < MAXCOUNT; i++) {
      out.writeObject(users[i]);
    }
    out.flush();
    fos.close();
  } catch (IOException ex) {
      System.out.println("Error: " + ex.toString());
  }

}




public static void main(String s[]) {
    AccountManager am = new AccountManager();
    am.go();
    am.saveState("accounts.ser");
  }
}
