import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Task_7 {
	public static void main(String[] args) {
		String outputPath = "OUTPUT.TXT";
		String inputPath = "INPUT.TXT";
		MaxFinder test = new MaxFinder(inputPath);
		try (BufferedWriter output = Files.newBufferedWriter(Paths.get(outputPath))) {
			output.write(test.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class MaxFinder {
	private BigInteger num1;
	private BigInteger num2;
	private BigInteger num3;

	public MaxFinder(String path) {
		try (final BufferedReader input = Files.newBufferedReader(Paths.get(path))) {
			String data = input.lines().collect(Collectors.joining());
			String[] parsedData = data.split(" ");
			num1 = new BigInteger(parsedData[0]);
			num2 = new BigInteger(parsedData[1]);
			num3 = new BigInteger(parsedData[2]);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String max() {
		BigInteger max = num1.max(num2);
		max = max.max(num3);
		return max.toString();
	}

	@Override
	public String toString() {
		return max();
	}
}