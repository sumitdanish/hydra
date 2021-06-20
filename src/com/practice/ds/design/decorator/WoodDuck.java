package com.practice.ds.design.decorator;

public class WoodDuck extends Duck {

  public WoodDuck(FlyingBehaviour flyingBehaviour, QuackBehaviour quackBehaviour) {
    super(flyingBehaviour, quackBehaviour);
  }
}
