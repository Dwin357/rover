import junit.framework.*;
import java.util.Random;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class TestMissionController extends TestCase {

	protected MissionController subject;
	protected ArrayList<String> scenarioOne;


	protected void setUp() {
		scenarioOne = new ArrayList<String>();
		scenarioOne.add("5 5");
		scenarioOne.add("1 2 N");
		scenarioOne.add("LMLMLMLMM");
		scenarioOne.add("3 3 E");
		scenarioOne.add("MMRMMRMRRM");

		subject = new MissionController(scenarioOne);
	}

	protected ArrayList<String> scenarioTwo() {
		ArrayList<String> scenarioTwo = new ArrayList<String>();
		scenarioTwo.add("2 2");
		scenarioTwo.add("1 2 N");
		scenarioTwo.add("M");
		scenarioTwo.add("0 0 N");
		scenarioTwo.add("LLRR");
		return scenarioTwo;
	}


	public void testMapSetting() {
		String expected = "5 5";
		assertEquals(expected, subject.getMap());
	}

	public void testMissionSetting() {
		String[] expectedFirst = { "1 2 N", "LMLMLMLMM", ""};
		String[] expectedSecond = { "3 3 E", "MMRMMRMRRM", ""};

		assertArrayEquals(expectedFirst, subject.getMissions().get(0));
		assertArrayEquals(expectedSecond, subject.getMissions().get(1));
	}

	public void testExecuteMissions() {
		String[] expectedFirst = { "1 2 N", "LMLMLMLMM", "1 3 N"};
		String[] expectedSecond = { "3 3 E", "MMRMMRMRRM", "5 1 E"};

		subject.performMissions();

		assertArrayEquals(expectedFirst, subject.getMissions().get(0));
		assertArrayEquals(expectedSecond, subject.getMissions().get(1));
	}

	public void testGetOutcomes() {
		ArrayList<String> before = new ArrayList<String>();
		before.add("");
		before.add("");
		ArrayList<String> after = new ArrayList<String>();
		after.add("1 3 N");
		after.add("5 1 E");

		assertEquals(before, subject.getOutcomes());
		subject.performMissions();
		assertEquals(after, subject.getOutcomes());
	}

	public void testDriveOffCliff() {
		subject = new MissionController(scenarioTwo());

		ArrayList<String> expected = new ArrayList<String>();
		expected.add("Rover crashed");
		expected.add("0 0 N");

		subject.performMissions();

		assertEquals(expected, subject.getOutcomes());
	}
}
