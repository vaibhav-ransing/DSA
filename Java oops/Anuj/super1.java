package Anuj;
public class super1 {
    
    static class polygon{
        int sides;
        polygon(int sides){
            this.sides = sides;
        }
        void diplay(){
            System.out.println("Polygon "+ sides);
        }
    }
    static class triangle extends polygon{
        String name;
        triangle(int sides, String name){
            super(sides);
            this.name = name;
        }
        void diplay(){
            System.out.println(sides +" "+name);
        }
    }



    public static void main(String[] args) {
        triangle t = new triangle(3, "traingel");
        t.diplay();
    }
}
