package com.practice.ds.design.decorator;

public class NaturalFlying implements FlyingBehaviour{

  @Override
  public void flyingBehaviour() {
    System.out.println("I am natural flyer");
  }
}
