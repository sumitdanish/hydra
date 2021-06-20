package com.practice.ds.design.decorator;

public class RealDuck extends Duck{

  public RealDuck(FlyingBehaviour flyingBehaviour, QuackBehaviour quackBehaviour) {
    super(flyingBehaviour, quackBehaviour);
  }
}
