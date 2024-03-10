public class Main {
    


    public static void main(String[] args) {
        AppleCharger appleCharger = new ChargerX();
        Iphone13 phone = new Iphone13(appleCharger);
        phone.chargeIphone();

        AndroidCharger androidCharger = new AndroidChargerImpl();
        AppleCharger appleCharger2 = new AdapterCharger(androidCharger);
        Iphone13 applePhone2 = new Iphone13(appleCharger2);
        applePhone2.chargeIphone();
    }
}
