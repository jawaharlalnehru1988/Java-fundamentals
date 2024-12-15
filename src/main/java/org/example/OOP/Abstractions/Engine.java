package org.example.OOP.Abstractions;

public interface Engine {
    void start();
}

class DieselEngine implements Engine{
    public void start(){
        System.out.println("Diesel engine started");
    }
}

class PetrolEngine implements Engine{
    @Override
    public void start() {
        System.out.println("Petrol engine started");
    }
}

class Car{
    private Engine engine;

    public Car(Engine engine){
        this.engine = engine;
    }

    public  void startCar(){
        engine.start();
    }
}