package com.practice.ds.design;

public abstract class Duck {

  private FlyingBehaviour flyingBehaviour;
  private QuackBehaviour quackBehaviour;

  public Duck(FlyingBehaviour flyingBehaviour, QuackBehaviour quackBehaviour) {
    this.flyingBehaviour = flyingBehaviour;
    this.quackBehaviour = quackBehaviour;
  }

  public void performFly() {
    flyingBehaviour.flyingBehaviour();
  }

  public void performQuack() {
    quackBehaviour.quack();
  }

}
