package linkedlist;

import model.Fax;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class MyLinkedListTest {

    private Fax fax1;
    private Fax fax2;
    private Fax fax3;
    private Fax fax4;

    @Before
    public void setUp() throws Exception {
        receiveFaxes();
    }

    @Test
    public void get_WhenElementInList_thenReturnsElement() {
        MyLinkedList<Fax> list = getMyLinkedList();

        Fax resultFax = list.get(fax2);
        assertEquals(fax2, resultFax);
    }

    @Test
    public void get_whenElementNotInList_thenReturnsNull() {
        MyLinkedList<Fax> list = new MyLinkedList<>();
        list.add(fax1);
        list.add(fax2);

        Fax resultFax = list.get(fax3);
        assertNull(resultFax);
    }

    @Test
    public void reverseList() {
        MyLinkedList<Fax> list = getMyLinkedList();
        MyLinkedList<Fax> expectedList = getReversedMyLinkedList();

        list.printList();
        list.reverseList();
        list.printList();

        assertEquals(expectedList, list);
    }

    private void receiveFaxes() {
        fax1 = Fax.builder().from("Jan Levinson").subject("Downsizing").date(LocalDate.of(2006,12,1)).build();
        fax2 = Fax.builder().from("Staples").subject("We are hiring").date(LocalDate.of(2006,12,2)).build();
        fax3 = Fax.builder().from("Dwight from Future").subject("Coffee is poisoned").date(LocalDate.of(2006,12,1)).build();
        fax4 = Fax.builder().from("Dunder Mifflin New York").subject("Diversity training").date(LocalDate.of(2006,12,1)).build();
    }

    private MyLinkedList<Fax> getMyLinkedList() {
        MyLinkedList<Fax> list = new MyLinkedList<>();
        list.add(fax1);
        list.add(fax2);
        list.add(fax3);
        list.add(fax4);

        return list;
    }

    private MyLinkedList<Fax> getReversedMyLinkedList() {
        MyLinkedList<Fax> list = new MyLinkedList<>();
        list.add(fax4);
        list.add(fax3);
        list.add(fax2);
        list.add(fax1);

        return list;
    }
}