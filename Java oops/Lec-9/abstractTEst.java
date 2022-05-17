public class abstractTEst {
    
    static interface animal{
        void hello();
    }

    static class cat  implements animal{
        @Override
        public void hello(){
            System.out.println("helo ");
        }
    }
    static class animalFactory{

        public animal getInstance(String name){
            return new cat();
        }
    }

    public static void main(String[] args) {
        // animalFactory af = new animalFactory();
        // animal a = af.getInstance("cat");
        // a.hello();

        animal af = new cat();
        af.hello();
    }
}
