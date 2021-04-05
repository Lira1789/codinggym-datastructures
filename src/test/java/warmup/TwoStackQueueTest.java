package warmup;

import model.Fax;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;


public class TwoStackQueueTest {

    private Fax fax1;
    private Fax fax2;
    private Fax fax3;

    @Before
    public void setUp() throws Exception {
        receiveFaxes();
    }

    @Test
    public void twoStackQueue() {
        TwoStackQueue<Fax> twoStackQueue = new TwoStackQueue<>();

        twoStackQueue.queue(fax1);
        twoStackQueue.queue(fax2);
        twoStackQueue.queue(fax3);

        Fax resultFax = twoStackQueue.dequeue();
        assertEquals(fax1, resultFax);
    }

    private void receiveFaxes() {
        fax1 = Fax.builder().from("Jan Levinson").subject("Downsizing").date(LocalDate.of(2006,12,1)).build();
        fax2 = Fax.builder().from("Staples").subject("We are hiring").date(LocalDate.of(2006,12,2)).build();
        fax3 = Fax.builder().from("Dwigth from Future").subject("Coffee is poisoned").date(LocalDate.of(2006,12,1)).build();
    }
}