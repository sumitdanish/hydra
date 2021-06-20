package com.practice.ds.design.decorator;

public class Main {

  public static void main(String[] args) {
    FlyingBehaviour flyingBehaviour = new NaturalFlying();
    QuackBehaviour quackBehaviour = new NaturalQuack();
    Duck duck = new RealDuck(flyingBehaviour,quackBehaviour);
    duck.performFly();
    duck.performQuack();

    FlyingBehaviour flyingBehaviour1 = new ArtificialFlying();
    QuackBehaviour quackBehaviour1 = new ArtificialQuack();
    Duck duck1 = new WoodDuck(flyingBehaviour1,quackBehaviour1);
    duck1.performFly();
    duck1.performQuack();
  }

}
