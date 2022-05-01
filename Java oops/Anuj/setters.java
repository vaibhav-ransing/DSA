package Anuj;
public class setters{

    static class developer extends Person{
        public developer(){
            System.out.println("developer created");
        }
        public developer(String name, int age){
            super(name, age);
        }
        void printCount(){
            System.out.println(count);
        }
    }

    static class Person{
        String name;
        int age;
        // private int count;
        protected int count;
        // public int count;

        Person(){
            count++;
            System.out.println("count"+this.count);
            System.out.println("person created");
        }
        Person(String name, int age){
            this();
            this.age = age;
            this.name = name;
        }
        void walk(){
            System.out.println(count);
            System.out.println("Person walks");
        }
    }
    


    public static void main(String[] args) {
        developer d1 = new developer();
        d1.walk();
    }
}