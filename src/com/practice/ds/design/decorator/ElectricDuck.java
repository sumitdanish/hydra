package com.practice.ds.design.decorator;

public class ElectricDuck extends Duck{

  public ElectricDuck(FlyingBehaviour flyingBehaviour, QuackBehaviour quackBehaviour) {
    super(flyingBehaviour, quackBehaviour);
  }
}
