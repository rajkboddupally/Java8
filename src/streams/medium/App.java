package streams.medium;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.Entry.comparingByKey;

public class App {
    static List<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) {

        EmployeeFactory employeeFactory = new EmployeeFactory();
        employeeList = employeeFactory.getAllEmployee();

        // List all distinct project in non-ascending order.
        //listAllDistinctProjectInNonAscendingOrder(employeeList);

        // Print full name of any employee whose firstName starts with ‘A’.
        // printFullNameOfAnyEmployeeWhoseFirstNameStartsWithA(employeeList);

        // List of all employee who joined in year 2023 (year to be extracted from employee id i.e., 1st 4 characters)
        //listAllEmployeeWhoJoinedInYear2023(employeeList);


        // Sort employees based on firstName, for same firstName sort by salary.
        //sortEmployeesBasedOnFirstNameForSameFirstNameSortBySalary(employeeList);

        // Print names of all employee with 3rd highest salary. (generalise it for nth highest salary).
        //printNamesOfAllEmployeeWith3rdHighestSalary(employeeList,  3);

        // Print min salary.
        // printMinSalary(employeeList);

        // Print list of all employee with min salary.
        //printListOfAllEmployeeWithMinSalary(employeeList);

        // Print list of all employee with min salary.
        //printListOfAllEmployeeWithMinSalary2(employeeList);


        // List of people working on more than 2 projects.
        //printListOfPeopleWorkingOnMoreThanTwoProjects(employeeList);

        // Count of total laptops assigned to the employees.
        //countTotalOfLaptopsAssignedToTheEmployees(employeeList);


        // Count of all projects with Robert Downey Jr as PM.
        var projectManagerRobertDowneyJr = "Robert Downey Jr";
       // countAllProjectsWithRobertDowneyJrASPM(employeeList, projectManagerRobertDowneyJr);

        // List of all people working with Robert Downey Jr.
        //listAllPeopleWorkingWithRobertDowneyJr(employeeList, projectManagerRobertDowneyJr);

        // Create a map based on this data, they key should be the year of joining, and value should
        // be list of all the employees who joined the particular year. (Hint : Collectors.toMap)
        //createMapOfData(employeeList);

        String test = "hello first welcome to java first this is is my first program";
        Map<String, Long> map = Stream.of(test.split(" ")).collect(Collectors.groupingBy(String::toString, Collectors.counting()));

        //Map<String, Integer> map = Stream.of(test.split(" ")).collect(Collectors.toMap(String::toString, String::length));
        map.forEach((key, value) -> System.out.println(key + " " + value));

       Optional<Long> maxKey =  map.values().stream().max(Comparator.naturalOrder());
       System.out.println(maxKey.get());
    }

    private static void createMapOfData(List<Employee> employeeList) {
        Map<String, List<Employee>> employeeMap = employeeList.stream().collect(Collectors.groupingBy(employee -> employee.getId().substring(0,4)));
        employeeMap.forEach((k, v) -> System.out.println(k + " "+ v));
    }

    private static void listAllPeopleWorkingWithRobertDowneyJr(List<Employee> employeeList, String manager) {
        //first list of projects he is PM, then iterate each employee and see if that project match.
        Set<Employee> allEmployees = employeeList.stream()
                .filter(employee -> employee.getProjects().stream().anyMatch(project -> project.getProjectManager().equalsIgnoreCase(manager)))
                .collect(Collectors.toUnmodifiableSet());
        allEmployees.forEach(System.out::println);


    }

    private static void countAllProjectsWithRobertDowneyJrASPM(List<Employee> employeeList, String manager) {
        var count = employeeList.stream().flatMap(employee -> employee.getProjects().stream())
                .distinct()
                .filter(project -> project.getProjectManager().equalsIgnoreCase(manager))
                .count();
        System.out.println(count);
    }

    private static void countTotalOfLaptopsAssignedToTheEmployees(List<Employee> employeeList) {
        var count= employeeList.stream().map(Employee::getTotalLaptopsAssigned)
                .count();
        System.out.println(count);
    }

    private static void printListOfPeopleWorkingOnMoreThanTwoProjects(List<Employee> employeeList) {
        employeeList.stream().filter(employee -> employee.getProjects().size() > 2)
                .forEach(System.out::println);
    }

    private static void printListOfAllEmployeeWithMinSalary2(List<Employee> employeeList) {
        Map<Integer, List<Employee>> map = employeeList.stream().collect(Collectors.groupingBy(Employee::getSalary));
        map.entrySet().stream().sorted(comparingByKey())
                .limit(1)
                .flatMap(entry -> entry.getValue().stream())
                .forEachOrdered(System.out::println);
    }

    private static void printListOfAllEmployeeWithMinSalary(List<Employee> employeeList) {
        employeeList.stream().min(Comparator.comparing(Employee::getSalary))
                .ifPresent(employee ->
                        employeeList.stream().filter(employee1 -> employee.getSalary() == employee1.getSalary()).forEach(System.out::println));

    }

    private static void printMinSalary(List<Employee> employeeList) {
        employeeList.stream().min(Comparator.comparing(Employee::getSalary))
                .ifPresent(employee -> System.out.println(employee.getSalary()));
    }

    //
    private static void printNamesOfAllEmployeeWith3rdHighestSalary(List<Employee> employeeList, int i) {
        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary, Comparator.reverseOrder()))
                .limit(i)
                .skip(i - 1)
                .forEach(System.out::println);
    }

    private static void sortEmployeesBasedOnFirstNameForSameFirstNameSortBySalary(List<Employee> employeeList) {
        employeeList.stream().sorted(Comparator.comparing(Employee::getFirstName)
                        .thenComparing(Employee::getSalary))
                .forEach(System.out::println);
    }

    private static void listAllEmployeeWhoJoinedInYear2023(List<Employee> employeeList) {
        employeeList.stream().filter(employee -> employee.getId().startsWith("2023"))
                .forEach(System.out::println);
    }

    private static void printFullNameOfAnyEmployeeWhoseFirstNameStartsWithA(List<Employee> employeeList) {
        employeeList.stream().filter(employee -> employee.getFirstName()
                        .startsWith("A"))
                .findAny()
                .ifPresent(employee -> System.out.println(employee.getFirstName() + " " + employee.getLastName()));
    }

    private static void listAllDistinctProjectInNonAscendingOrder(List<Employee> employeeList) {
        employeeList.stream()
                .flatMap(employee -> employee.getProjects().stream())
                .sorted(Comparator.comparing(Project::getName, Comparator.reverseOrder()))
                .forEach(project -> System.out.println(project.getName()));
    }

}
