package ru.stqa.pft.sandbox.Lecture6;

public class Student{
  public String name;
  public String lastname;
  public Integer mathematics;
  public Integer english;
  public Integer programming;

  Student(String name, String lastname, Integer mathematics, Integer english, Integer programming) {
    this.name = name;
    this.lastname = lastname;
    this.mathematics = mathematics;
    this.english = english;
    this.programming = programming;
  }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public String getLastname() { return lastname; }
  public void setLastname(String author) { this.lastname = lastname; }

  public Integer getMathematics() { return mathematics; }
  public void setMathematics(int mathematics) { this.mathematics = mathematics; }

  public Integer getEnglish() { return english; }
  public void setEnglish(int english) { this.english = english; }

  public Integer getProgramming() { return programming; }
  public void setProgramming(int programming) { this.programming = programming; }

  @Override
  public String toString() {
    return
            "|" + name +
                    "|" + lastname  +
                    "|" + mathematics +
                    "|" + english +
                    "|" + programming
            ;
  }

}
