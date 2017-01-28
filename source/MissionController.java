import java.util.ArrayList;

class MissionController {
	private String map;
	private ArrayList<String[]> missions;

	public MissionController(ArrayList<String> missionPlan) {
		loadMap(missionPlan);
		loadMissions(missionPlan);
	}

	public String getMap() {
		return map;
	}

	public ArrayList<String[]> getMissions() {
		return missions;
	}

	public ArrayList<String> getOutcomes() {
		ArrayList<String> outcomes = new ArrayList<String>();
		for( String[] mission : missions) {
			outcomes.add(mission[2]);
		}
		return outcomes;
	}

	public MissionController performMissions() {
		for(String[] mission : missions) {
			mission[2] = performMission(mission);
		}
		return this;
	}

	private void loadMap(ArrayList<String> missionPlan) {
		map = missionPlan.get(0);
	}

	private void loadMissions(ArrayList<String> missionPlan) {
		missions = new ArrayList<String[]>();

		for(int i=1; i < missionPlan.size(); i=i+2) {
			String roverLanding   = missionPlan.get(i);
			String missionOrders  = missionPlan.get(i+1);
			String missionOutcome = "";

			String[] mission = {roverLanding, missionOrders, missionOutcome};
			missions.add(mission);
		}
	}


	private String performMission(String[] mission) {
		Rover rover = landRover(mission[0]);
		String[] actions = mission[1].split("");
		String outcome = null;

		for(String action : actions) {
			executeAction(rover, action);
			if (!roverPositionValid(rover)) {
				outcome = "Rover crashed";
			}
		}

		if (outcome == null) {
			outcome = String.join(" ", rover.getPosition());
		}
		return outcome;
	}

	private void executeOrders(Rover rover, String orders) {
		String[] actions = orders.split("");
		for(String action : actions) {
			executeAction(rover, action);
		}
	}

	private Rover landRover(String landing) {
		String[] landingDetails = landing.split(" ");
		int x = Integer.parseInt(landingDetails[0]);
		int y = Integer.parseInt(landingDetails[1]);
		String facing = landingDetails[2];
		return new Rover(x, y, facing);
	}

	private void executeAction(Rover rover, String action) {
		switch(action) {
			case "M" : rover.move(); break;
			case "L" : rover.left(); break;
			case "R" : rover.right(); break;
		}
	}

	private boolean roverPositionValid(Rover rover) {
		boolean valid = true;
		if(roverOffMap(rover)) {
			valid = false;
		}
		return valid;
	}

	private boolean roverOffMap(Rover rover) {
		String[] grid = map.split(" ");
		int x = Integer.parseInt(grid[0]);
		int y = Integer.parseInt(grid[1]);

		return (rover.getX() > x) || (rover.getY() > y);
	}
}
