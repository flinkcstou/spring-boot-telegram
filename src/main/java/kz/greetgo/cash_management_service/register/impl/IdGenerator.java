package kz.greetgo.cash_management_service.register.impl;

import java.util.concurrent.ThreadLocalRandom;
import org.springframework.stereotype.Component;

@Component
public class IdGenerator {

  private static final String ENG = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final String DEG = "0123456789";

  private static final char[] charArray = (DEG + ENG + ENG.toLowerCase()).toCharArray();

  public String newId() {
    final char res[] = new char[17];
    for (int i = 0; i < res.length; i++) {
      res[i] = charArray[ThreadLocalRandom.current().nextInt(charArray.length)];
    }

    return new String(res);
  }

}
