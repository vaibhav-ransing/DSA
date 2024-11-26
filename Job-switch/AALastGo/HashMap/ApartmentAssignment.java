package AALastGo.HashMap;

import java.util.*;

// Class to represent an Apartment
class Apartment {
    int aptId;
    int numBedrooms;

    public Apartment(int aptId, int numBedrooms) {
        this.aptId = aptId;
        this.numBedrooms = numBedrooms;
    }
}

// Class to represent a Person (Intern)
class Person {
    String name;
    boolean wantsHousemates;

    public Person(String name, boolean wantsHousemates) {
        this.name = name;
        this.wantsHousemates = wantsHousemates;
    }
}

public class ApartmentAssignment {

    public static Map<Integer, List<String>> assignApartments(List<Apartment> apartments, List<Person> people) {
        // Sort apartments by number of bedrooms (descending)
        apartments.sort((a1, a2) -> Integer.compare(a2.numBedrooms, a1.numBedrooms));

        // Create result map
        Map<Integer, List<String>> apartmentsToTenants = new HashMap<>();

        // Initialize lists for people who want/don't want housemates
        List<Person> wantShared = new ArrayList<>();
        List<Person> wantSingle = new ArrayList<>();

        // Separate people based on their preferences
        for (Person person : people) {
            if (person.wantsHousemates) {
                wantShared.add(person);
            } else {
                wantSingle.add(person);
            }
        }

        // First, try to accommodate people who want shared apartments
        for (Apartment apt : apartments) {
            if (apt.numBedrooms > 1 && !wantShared.isEmpty()) {
                List<String> tenants = new ArrayList<>();

                // Fill the apartment with people who want shared living
                while (tenants.size() < apt.numBedrooms && !wantShared.isEmpty()) {
                    tenants.add(wantShared.remove(0).name);
                }

                // If there's still space and no more people want shared, fill with people who
                // wanted single
                while (tenants.size() < apt.numBedrooms && !wantSingle.isEmpty()) {
                    tenants.add(wantSingle.remove(0).name);
                }

                if (!tenants.isEmpty()) {
                    apartmentsToTenants.put(apt.aptId, tenants);
                }
            }
        }

        // Then, try to accommodate people who want single apartments
        for (Apartment apt : apartments) {
            if (!apartmentsToTenants.containsKey(apt.aptId)) {
                List<String> tenants = new ArrayList<>();

                // First try to place people who wanted single apartments
                while (tenants.size() < apt.numBedrooms && !wantSingle.isEmpty()) {
                    tenants.add(wantSingle.remove(0).name);
                }

                // If there's still space, fill with remaining people who wanted shared
                while (tenants.size() < apt.numBedrooms && !wantShared.isEmpty()) {
                    tenants.add(wantShared.remove(0).name);
                }

                if (!tenants.isEmpty()) {
                    apartmentsToTenants.put(apt.aptId, tenants);
                }
            }
        }

        return apartmentsToTenants;
    }

    // Example usage
    public static void main(String[] args) {
        // Create sample data
        List<Apartment> apartments = Arrays.asList(
                new Apartment(1, 2),
                new Apartment(2, 1),
                new Apartment(3, 3),
                new Apartment(4, 1));

        List<Person> people = Arrays.asList(
                new Person("Alice", true),
                new Person("Bob", true),
                new Person("Charlie", false),
                new Person("David", true),
                new Person("Eve", false));

        Map<Integer, List<String>> result = assignApartments(apartments, people);

        // Print results
        for (Map.Entry<Integer, List<String>> entry : result.entrySet()) {
            System.out.println("Apartment " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
