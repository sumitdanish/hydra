package com.practice.ds.design.decorator;

public class NaturalQuack implements QuackBehaviour {

  @Override
  public void quack() {
    System.out.println(" I am natural quack");
  }
}
