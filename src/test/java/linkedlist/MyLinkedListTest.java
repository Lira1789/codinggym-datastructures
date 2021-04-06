package linkedlist;

import model.Employee;
import model.Fax;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class MyLinkedListTest {

    private Employee employee1;
    private Employee employee2;
    private Employee employee3;
    private Employee employee4;
    private Employee employee5;
    private Employee employee6;


    @Before
    public void setUp() throws Exception {
        fullEmployees();
    }

    @Test
    public void get_WhenElementInList_thenReturnsElement() {
        MyLinkedList<Employee> list = getMyLinkedList();

        Employee result = list.get(employee2);
        assertEquals(employee2, result);
    }

    @Test
    public void get_whenElementNotInList_thenReturnsNull() {
        MyLinkedList<Employee> list = new MyLinkedList<>();
        list.add(employee1);
        list.add(employee2);

        Employee result = list.get(employee3);
        assertNull(result);
    }

    @Test
    public void reverseList() {
        MyLinkedList<Employee> list = getMyLinkedList();
        MyLinkedList<Employee> expectedList = getReversedMyLinkedList();

        list.printList();
        list.reverseList();
        list.printList();

        assertEquals(expectedList, list);
    }

    private void fullEmployees() {

        employee1 = Employee.builder().name("Dwigth").lastname("Schrut").position("Assistant to the regional manager").build();
        employee2 = Employee.builder().name("Phyllis").lastname("Lapin").position("Salesman").build();
        employee3 = Employee.builder().name("Michael").lastname("Scott").position("Regional manager").build();
        employee4 = Employee.builder().name("Ryan").lastname("Howard").position("The temp").build();
        employee5 = Employee.builder().name("Toby").lastname("Flanderson").position("HR").build();
        employee6 = Employee.builder().name("Angela").lastname("Martin").position("Accountant").build();
    }

    private MyLinkedList<Employee> getMyLinkedList() {
        MyLinkedList<Employee> list = new MyLinkedList<>();
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);
        list.add(employee5);
        list.add(employee6);

        return list;
    }

    private MyLinkedList<Employee> getReversedMyLinkedList() {
        MyLinkedList<Employee> list = new MyLinkedList<>();
        list.add(employee6);
        list.add(employee5);
        list.add(employee4);
        list.add(employee3);
        list.add(employee2);
        list.add(employee1);

        return list;
    }
}