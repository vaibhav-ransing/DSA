public class EmployeeFactory {
    
    public static Employee getEmployee(String empType){
        if(empType.equalsIgnoreCase("JAVA DEVELOPER")){
            return new JavaDeveloper();
        }else if(empType.equalsIgnoreCase("PYTHON DEVELOPER")){
            return new PythonDeveloper();
        }else{
            return null;
        }
    }
}
