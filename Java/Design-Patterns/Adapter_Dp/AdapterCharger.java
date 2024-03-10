public class AdapterCharger implements AppleCharger {

    private AndroidCharger androidCharger;
    
    public AdapterCharger(AndroidCharger androidCharger){
        this.androidCharger = androidCharger;
    }

    @Override
    public void chargePhone() {
        System.out.println("Your phone chargin with adapter");
        androidCharger.chargeAndroidPhone();
    }

}
