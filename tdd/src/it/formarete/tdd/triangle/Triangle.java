package it.formarete.tdd.triangle;

/**
 * i = 0: 4 spaces, 1 #
 * i = 1: 3 spaces, 3 #
 * i = 2: 2 spaces, 5 #
 * i = 3: 1 spaces, 7 #
 * i = 4: 0 spaces, 9 #
 */
public class Triangle {
	private int rows;

	public Triangle(int rows) {
		this.rows = rows;
	}

	public String render() {
		String triangle = "";

		for (int i = 0; i < rows; i++) {
			triangle += buildRow(i);
		}

		return triangle;
	}

	private String buildRow(int i) {
		return buildSpaces(i) + buildHashes(i) + "\n";
	}

	private String buildSpaces(int i) {
		String spaces = "";

		int lastIndex = rows - 1;
		int spacesNumber = lastIndex - i;
		for (int j = 0; j < spacesNumber; j++) {
			spaces += " ";
		}

		return spaces;
	}

	private String buildHashes(int i) {
		String hashes = "";

		int hashesNumber = i * 2 + 1;
		for (int j = 0; j < hashesNumber; j++) {
			hashes += "#";
		}

		return hashes;
	}
}
