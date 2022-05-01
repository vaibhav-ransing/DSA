package Anuj;
public class Interfaces {
    
}

class InterfaceTemp implements car, bike {

    @Override
    public void startCar(){
        System.out.println("Car started");
    }
    public void startBike(){
        System.out.println("Bike started");
    }
}


interface car{
    void startCar();
}
interface bike{
    void startBike();
}
