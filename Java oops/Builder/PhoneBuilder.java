package Builder;

public class PhoneBuilder {
    private String os;
    private int ram;
    private int price;

    public PhoneBuilder setOS(String os){
        this.os = os;
        return this;
    }
    public PhoneBuilder setRam(int ram){
        this.ram = ram;
        return this;
    }
    public PhoneBuilder setPrice(int price){
        this.price = price;
        return this;
    }

    public Phone getPhone(){
        return new Phone(os, ram, price);
    }
    public int getPrice(){
        return this.price;
    }

}
