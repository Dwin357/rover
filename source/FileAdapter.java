import java.io.*;
import java.util.ArrayList;

class FileAdapter {

	private static ArrayList<String> missions;


	public static void main(String[] args) {

		missions = new ArrayList<String>();
		String loadFilepath = args[0];
		String saveTarget = "steinmetzRoverOutput.txt";

		if (args.length > 1) {
			saveTarget = args[1];
		}

		load(loadFilepath);

		MissionController huston = new MissionController(missions);
		huston.performMissions();
		missions = huston.getOutcomes();

		save(saveTarget);

	}

	private static void load(String filePath) {
		try {
			File myFile = new File(filePath);
			FileReader fileReader = new FileReader(myFile);
			BufferedReader reader = new BufferedReader(fileReader);
			String line = null;
			while ( (line = reader.readLine()) != null) {
				missions.add(line);
			}
			reader.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static void save(String target) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(target));
			for( String outcome : missions) {
				writer.write(outcome + "\n");
			}
			writer.close();

		} catch (IOException ex) {
			System.out.println("Error");
			ex.printStackTrace();
		}

	}
}

