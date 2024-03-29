import java.util.*;
import java.util.stream.Collectors;

public class FlatMap {

    public static List<Employee> makeEmpList() {
        List<Employee> list = new ArrayList<>();

        list.add(new Employee("vaibhav", List.of("Pune", "Banglore", "Delhi")));
        list.add(new Employee("Pratik", List.of("Pune", "Delhi")));
        list.add(new Employee("Sky", List.of("Pune", "Noida", "Mumbai")));

        return list;
    }

    public static void flatMap() {
        List<Employee> empList = makeEmpList();

        // suppose we want all the different cities in all the employeess
        // We pass the stream of each city to flatMap and then perform operations on
        // flatMapOutput
        // On flatMapOutput we can again use map to do other operations
        Set<String> cities = empList.stream().flatMap(emp -> emp.getCities().stream()).collect(Collectors.toSet());

        List<String> citiesRenames = empList.stream().flatMap(emp -> emp.getCities().stream()).map(city -> {
            return (city + "-India");
        }).toList();
        System.out.println(citiesRenames);
        
        
        // Give me count of employees who worked in Delhi City 
        int DelhiCityCount = empList.stream().flatMap(emp -> emp.getCities().stream())
                .filter(city -> {
                    if (city.equals("Delhi")) {
                        return true;
                    }
                    return false;
                }).toList().size();

        System.out.println(DelhiCityCount);
    }

    public static void mapMethod() {
        List<Employee> empList = makeEmpList();

        List<String> names = empList.stream().map((Employee e) -> {
            return e.name + "Nae";
        }).collect(Collectors.toList());

        List<List<String>> cities = empList.stream().map(emp -> emp.getCities()).collect(Collectors.toList());
        Set<List<String>> citiesSet = empList.stream().map(emp -> emp.getCities()).collect(Collectors.toSet());
        System.out.println(cities);
        System.out.println(citiesSet);

        System.out.println(names);

    }

    public static void main(String[] args) {
        // mapMethod();
        flatMap();
    }
}

class Employee {
    String name;
    List<String> cities;

    Employee(String name, List<String> cities) {
        this.name = name;
        this.cities = cities;
    }

    @Override
    public String toString() {
        return name + " " + cities;
    }

    List<String> getCities() {
        return this.cities;
    }
}