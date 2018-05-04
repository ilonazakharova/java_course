package ru.stqa.pft.mantis.appmanager;

import org.apache.commons.net.telnet.TelnetClient;

import javax.mail.Session;
import javax.mail.Store;
import java.io.InputStream;
import java.io.PrintStream;

public class JamesHelper {
  private ApplicationManager app;

  private TelnetClient telnet;
  private InputStream in;
  private PrintStream out;

  private Session mailSession;
  private Store store;
  private String mailserver;

  public JamesHelper(ApplicationManager app) {
    this.app = app;
    telnet = new TelnetClient();
    mailSession = Session.getDefaultInstance(System.getProperties());
  }

  //public boolean doesUserExist(String name) {
    //initTelnetSession();
    //write("verify" + name);
    //String result = readUntil("exist");
    //closeTelnetSession();
    //return result.trim().equals()("User " + name + " exist");
  //}

  public void createUser(String name, String passwd) {

  }
}
