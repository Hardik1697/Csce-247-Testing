import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

public class TestDataUpdater {

	DataUpdater du;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		du = new DataUpdater();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUpdateUserValid() {
		Users users = Users.getInstance();
		ArrayList<SingleUser> userList = new ArrayList<SingleUser>();
		ArrayList<SingleUser> userList1 = users.getUsersUpdated();
		userList1 = DataUpdater.updateUser("ta2", "Funlin", "first", userList1);
		userList.add(new SingleUser("Hardik", "Anand", "XXX-XXX-XXXX", "22", "Student", "ha2", "pass", "user"));
		userList.add(new SingleUser("Hardik", "Anand", "XXX-XXX-XXXX", "22", "Student", "hanand", "pass", "admin"));
		userList.add(new SingleUser("Funlin", "Arya", "XXX-XXX-XXXX", "22", "Student", "ta2", "new", "user"));
		userList.add(new SingleUser("Ishu", "Singh", "98e", "u9ed", "Student", "ishu", "user", "user"));
		String[] arr1 = new String[userList.size()];
		String[] arr2 = new String[userList1.size()];
		int i = -1;
		int j = -1;
		for (SingleUser user : userList) {
			i++;
			arr1[i] = user.getFirstName() + user.getLastName() + user.getPhoneNumber() + user.getAge() + user.getStatus() + user.getEmail() + user.getPassword() + user.getType();
		}
		for (SingleUser user : userList1) {
			j++;
			arr2[j] = user.getFirstName() + user.getLastName() + user.getPhoneNumber() + user.getAge() + user.getStatus() + user.getEmail() + user.getPassword() + user.getType();
		}
		boolean bool1 = true, bool2 = true;
		for (int k = 0; k < userList.size(); k++) {
			if (!arr1[k].equalsIgnoreCase(arr2[k])) {
				bool2 = false;
				break;
			}
		}
		assertTrue(bool1 == bool2);
	}

	@Test
	public void testUpdateUserInvalid() {
		Users users = Users.getInstance();
		ArrayList<SingleUser> userList = new ArrayList<SingleUser>();
		ArrayList<SingleUser> userList1 = users.getUsersUpdated();
		userList1 = DataUpdater.updateUser("ta2", "Funlin", "first", userList1);
		userList.add(new SingleUser("Hardik", "Anand", "XXX-XXX-XXXX", "22", "Student", "ha2", "pass", "user"));
		userList.add(new SingleUser("Hardik", "Anand", "XXX-XXX-XXXX", "22", "Student", "hanand", "pass", "admin"));
		userList.add(new SingleUser("Talin", "Arya", "XXX-XXX-XXXX", "22", "Student", "ta2", "new", "user"));
		userList.add(new SingleUser("Ishu", "Singh", "98e", "u9ed", "Student", "ishu", "user", "user"));
		String[] arr1 = new String[userList.size()];
		String[] arr2 = new String[userList1.size()];
		int i = -1;
		int j = -1;
		for (SingleUser user : userList) {
			i++;
			arr1[i] = user.getFirstName() + user.getLastName() + user.getPhoneNumber() + user.getAge() + user.getStatus() + user.getEmail() + user.getPassword() + user.getType();
		}
		for (SingleUser user : userList1) {
			j++;
			arr2[j] = user.getFirstName() + user.getLastName() + user.getPhoneNumber() + user.getAge() + user.getStatus() + user.getEmail() + user.getPassword() + user.getType();
		}
		boolean bool1 = true, bool2 = true;
		for (int k = 0; k < userList.size(); k++) {
			if (!arr1[k].equalsIgnoreCase(arr2[k])) {
				bool2 = false;
				break;
			}
		}
		assertFalse(bool1 == bool2);
	}

}
