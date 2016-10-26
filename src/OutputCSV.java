import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class OutputCSV {

	static ArrayList<String> array = new ArrayList<String>();
	static String seperator = ",";
	static String outputFile = "output.csv";
	
	/**
	 * 
	 * Creates the OutputCSV object for printing usage.
	 * @author Brandon Brown <brandon.brown22@stclairconnect.ca>
	 * @version 1.0
	 * @param	array		An ArrayList which will contain the values for the .csv line
	 * @param	seperator	The separating value between the array values
	 * @param	outputFile	The filename/directory where the csv file is stored.
	 * 						String should have .csv extension
	 * 
	 */
	OutputCSV(ArrayList<String> array, String seperator, String outputFile) {
		OutputCSV.array = array;
		OutputCSV.seperator = seperator;
		OutputCSV.outputFile = outputFile;
	}
	
	/**
	 * 
	 * Prints the object's ArrayList to a .csv file.
	 * @author Brandon Brown <brandon.brown22@stclairconnect.ca>
	 * @version 1.0
	 * 
	 */
	public void writeArrayToFile() {
		try(FileWriter fw = new FileWriter(outputFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw)) {
				for (int i = 0; i < array.size(); i++) {
					out.print(array.get(i));
					if (i < array.size() - 1) {
						out.print(seperator);
					}
				}
				out.println();
			} catch (IOException e) {
				
			}
	}

	public static ArrayList<String> getArray() {
		return array;
	}

	public static void setArray(ArrayList<String> array) {
		OutputCSV.array = array;
	}

	public static String getSeperator() {
		return seperator;
	}

	public static void setSeperator(String seperator) {
		OutputCSV.seperator = seperator;
	}

	public static String getOutputFile() {
		return outputFile;
	}

	public static void setOutputFile(String outputFile) {
		OutputCSV.outputFile = outputFile;
	}
}
