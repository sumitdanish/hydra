package com.practice.ds.design.decorator;

public class ArtificialQuack implements QuackBehaviour{

  @Override
  public void quack() {
    System.out.println("I am artificial quack");
  }
}
