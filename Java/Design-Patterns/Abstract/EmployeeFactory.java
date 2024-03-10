public class EmployeeFactory {
    
    public static Employee getEmployee(EmployeeAbstractFactory employeeAbstractFactory){
        return employeeAbstractFactory.createEmployee();
    }
}
