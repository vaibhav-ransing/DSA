package OOPS;

public class ComplexNum {
    int real;
    int imaginary;
    String test;
    static int count;
    public ComplexNum(){
        count++;
    }
    public ComplexNum(String test){
        this();
        this.test = test;
    }
    static void printTest(){
        System.out.println(count);
    }
    void plus(ComplexNum c){
        int newReal = c.real+this.real;
        int newImg = c.imaginary + this.imaginary;
        this.real = newReal;
        this.imaginary = newImg;
    }
    void multiply(ComplexNum c){
        System.out.println(test);
    }
    public String toString(){
        return "This is complex nunm";
    }
}
