public class PythonDevFactory extends EmployeeAbstractFactory {

    public Employee createEmployee() {
        return new PythonDeveloper();
    }
}

