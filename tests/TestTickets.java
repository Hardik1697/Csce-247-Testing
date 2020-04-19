import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestTickets {

	Tickets tickets;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		tickets = new Tickets();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInstance() {
		Tickets tickets1 = new Tickets();
		tickets1 = tickets.getInstance();
		assertEquals(tickets1.getClass(), tickets.getClass());
	}
	
	@Test
	public void TestGetTicket() {
		ArrayList<SingleTicket> sT1 = tickets.getTicket();
		assertEquals(sT1, tickets.getTicket());
	}
	
}
