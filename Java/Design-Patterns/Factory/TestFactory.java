public class TestFactory {
    

    public static void main(String[] args) {
        
        // Employee emp = new JavaDeveloper();   // Tighly coupled
        Employee emp = EmployeeFactory.getEmployee("JAVA DEVELOPER");
        emp.salary();

        Employee emp2 = EmployeeFactory.getEmployee("PYTHON DEVELOPER");
        emp2.salary();
    }
}
