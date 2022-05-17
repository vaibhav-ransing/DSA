public class EnumTest{


     enum COLOR {
        RED(1),
        BLUE(2),
        Green(3);

        final int number;
        COLOR(int number){
            this.number = number;
        }

        public static void colorLike(COLOR c){
        switch(c){
            case RED:
                System.out.println("red is angry");
                break;
            case BLUE:
                System.out.println("Blue is fres");
                break;
            case Green:
                System.out.println("Green is positive");
                break;
            default:
                System.out.println("No color");
                break;
        }
    }
    }
    


    public static void main(String[] args) {
        COLOR c = COLOR.RED;
        System.out.println(c.number);

        for(COLOR c1: COLOR.values()){
            System.out.println(c1);
            COLOR.colorLike(c1);
        }

        
    }
}