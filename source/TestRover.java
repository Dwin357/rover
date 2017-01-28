import junit.framework.*;
import java.util.Random;
import static org.junit.Assert.*;

public class TestRover extends TestCase {
	protected int x, y;
	protected String facing;
	protected Rover subject;

	protected void setUp() {
		Random randy = new Random();
		String[] facings = {"N", "S", "E", "W"};

		x = randy.nextInt(100);
		y = randy.nextInt(100);
		facing = facings[randy.nextInt(4)];

		subject = new Rover(x, y, facing);
	}

	public void testGetX() {
		assertEquals(x, subject.getX());
	}

	public void testGetY() {
		assertEquals(y, subject.getY());
	}

	public void testGetFacing() {
		assertEquals(facing, subject.getFacing());
	}

	public void testGetPosition() {
		String[] benchmark = {""+x, ""+y, facing};
		assertArrayEquals(benchmark, subject.getPosition());
	}

	public void testLTurnSouth() {
		subject = new Rover(x, y, "S");
		Rover benchmark = dupRover(subject);

		subject.left();

		// N/S doesn't change
		assertEquals(benchmark.getY(), subject.getY());

		// E/W doesn't change
		assertEquals(benchmark.getX(), subject.getX());

		// facing east
		assertEquals("E", subject.getFacing());
	}

	public void testLTurnNorth() {
		subject = new Rover(x, y, "N");
		Rover benchmark = dupRover(subject);

		subject.left();

		// N/S doesn't change
		assertEquals(benchmark.getY(), subject.getY());

		// E/W doesn't change
		assertEquals(benchmark.getX(), subject.getX());

		// facing west
		assertEquals("W", subject.getFacing());
	}

	public void testLTurnEast() {
		subject = new Rover(x, y, "E");
		Rover benchmark = dupRover(subject);

		subject.left();

		// N/S doesn't change
		assertEquals(benchmark.getY(), subject.getY());

		// E/W doesn't change
		assertEquals(benchmark.getX(), subject.getX());

		// facing north
		assertEquals("N", subject.getFacing());
	}

	public void testLTurnWest() {
		subject = new Rover(x, y, "W");
		Rover benchmark = dupRover(subject);

		subject.left();

		// N/S doesn't change
		assertEquals(benchmark.getY(), subject.getY());

		// E/W doesn't change
		assertEquals(benchmark.getX(), subject.getX());

		// facing south
		assertEquals("S", subject.getFacing());
	}

	public void testRTurnWest() {
		subject = new Rover(x, y, "W");
		Rover benchmark = dupRover(subject);

		subject.right();

		// N/S doesn't change
		assertEquals(benchmark.getY(), subject.getY());

		// E/W doesn't change
		assertEquals(benchmark.getX(), subject.getX());

		// facing north
		assertEquals("N", subject.getFacing());
	}

	public void testRTurnEast() {
		subject = new Rover(x, y, "E");
		Rover benchmark = dupRover(subject);

		subject.right();

		// N/S doesn't change
		assertEquals(benchmark.getY(), subject.getY());

		// E/W doesn't change
		assertEquals(benchmark.getX(), subject.getX());

		// facing south
		assertEquals("S", subject.getFacing());
	}

	public void testRTurnNorth() {
		subject = new Rover(x, y, "N");
		Rover benchmark = dupRover(subject);

		subject.right();

		// N/S doesn't change
		assertEquals(benchmark.getY(), subject.getY());

		// E/W doesn't change
		assertEquals(benchmark.getX(), subject.getX());

		// facing east
		assertEquals("E", subject.getFacing());
	}

	public void testRTurnSouth() {
		subject = new Rover(x, y, "S");
		Rover benchmark = dupRover(subject);

		subject.right();

		// N/S doesn't change
		assertEquals(benchmark.getY(), subject.getY());

		// E/W doesn't change
		assertEquals(benchmark.getX(), subject.getX());

		// facing west
		assertEquals("W", subject.getFacing());
	}

	public void testFullRotationRight() {
		subject = new Rover(x, y, "N");
		Rover benchmark = dupRover(subject);

		subject.right().right().right().right();

		// N/S doesn't change
		assertEquals(benchmark.getY(), subject.getY());

		// E/W doesn't change
		assertEquals(benchmark.getX(), subject.getX());

		// facing doesn't change
		assertEquals(benchmark.getFacing(), subject.getFacing());
	}

	public void testFullRotationLeft() {
		subject = new Rover(x, y, "N");
		Rover benchmark = dupRover(subject);

		subject.left().left().left().left().left().left().left().left();

		// N/S doesn't change
		assertEquals(benchmark.getY(), subject.getY());

		// E/W doesn't change
		assertEquals(benchmark.getX(), subject.getX());

		// facing doesn't change
		assertEquals(benchmark.getFacing(), subject.getFacing());
	}

	public void testMoveEast() {
		subject = new Rover(x, y, "E");
		Rover benchmark = dupRover(subject);

		subject.move();

		// N/S doesn't change
		assertEquals(benchmark.getY(), subject.getY());

		// E/W ++
		assertEquals( (benchmark.getX()+1), subject.getX() );

		// facing doesn't change
		assertEquals(benchmark.getFacing(), subject.getFacing());
	}

	public void testMoveWest() {
		subject = new Rover(x, y, "W");
		Rover benchmark = dupRover(subject);

		subject.move();

		// N/S doesn't change
		assertEquals(benchmark.getY(), subject.getY());

		// E/W --
		assertEquals((benchmark.getX()-1), subject.getX() );

		// facing doesn't change
		assertEquals(benchmark.getFacing(), subject.getFacing());
	}

	public void testMoveNorth() {
		subject = new Rover(x, y, "N");
		Rover benchmark = dupRover(subject);

		subject.move();

		// N/S ++
		assertEquals((benchmark.getY()+1), subject.getY());

		// E/W doesn't change
		assertEquals(benchmark.getX(), subject.getX());

		// facing doesn't change
		assertEquals(benchmark.getFacing(), subject.getFacing());
	}

	public void testMoveSouth() {
		subject = new Rover(x, y, "S");
		Rover benchmark = dupRover(subject);

		subject.move();

		// N/S --
		assertEquals((benchmark.getY()-1), subject.getY());

		// E/W doesn't change
		assertEquals(benchmark.getX(), subject.getX());

		// facing doesn't change
		assertEquals(benchmark.getFacing(), subject.getFacing());
	}

	private Rover dupRover(Rover original) {
		return new Rover(original.getX(), original.getY(), original.getFacing());
	}
}
