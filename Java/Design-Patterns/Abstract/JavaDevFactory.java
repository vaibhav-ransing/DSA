public class JavaDevFactory extends EmployeeAbstractFactory{
    
    public Employee createEmployee(){
        return new JavaDeveloper();
    }
}
