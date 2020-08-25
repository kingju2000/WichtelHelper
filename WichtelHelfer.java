package com.company;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class WichtelHelfer {
  public static ArrayList<String> peopleExist = new ArrayList<String>();

  public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {


    int ammountPeople = args.length;

    for (int i = 0; i < ammountPeople; i++) {
      peopleExist.add(args[i]);
    }

    for (int closedPeople = 0; closedPeople < ammountPeople; closedPeople++) {
      String donatorName = args[closedPeople];
      writeTextDocument(donatorName, getRandomPerson(donatorName));
    }

  }

  static String getRandomPerson(String donor) {
    double randomNumber = Math.random();
    double y = (1.0 / (double) peopleExist.size());
    String theChoosenOne = "Doesnt work...";

    for (int i = 0; i < peopleExist.size(); i++) {
      if (randomNumber > (y * i) && randomNumber < (y * (i + 1))) {
        String donee = peopleExist.get(i);
        if (!donee.equals(donor)) {
          peopleExist.remove(i);
          theChoosenOne = donee;
        } else {
          theChoosenOne = getRandomPerson(donor);
        }
      }
    }
    return theChoosenOne;
  }

  static void writeTextDocument(String donatorName, String doneeName) throws FileNotFoundException, UnsupportedEncodingException {
    PrintWriter writer = new PrintWriter(donatorName, "UTF-8");
    writer.println(doneeName);
    writer.close();
    System.out.println(nodatorName);
  }
}
