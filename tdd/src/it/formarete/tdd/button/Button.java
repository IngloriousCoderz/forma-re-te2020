package it.formarete.tdd.button;

public class Button {
	private final static String FULL_CELL = "* ";
	private final static String EMPTY_CELL = "  ";
	private final static String NEW_LINE = "\n";

	private int rows;
	private int columns;

	public Button(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
	}

	public String render(String text) {
		String button = "";
		button += buildFullRow(columns);
		button += buildEmptyRows(rows, columns);
		button += buildTextRow(columns, text);
		button += buildEmptyRows(rows, columns);
		button += buildFullRow(columns);
		return button;
	}

	private String buildFullRow(int columns) {
		String row = "";
		for (int j = 0; j < columns; j++) {
			row += FULL_CELL;
		}
		row += NEW_LINE;
		return row;
	}

	private String buildEmptyRows(int rows, int columns) {
		int fullRows = 2;
		int halfRows = (rows - fullRows) / 2;
		int fullCells = 2;
		int emptyCells = columns - fullCells;
		String result = "";
		for (int i = 0; i < halfRows; i++) {
			result += buildEmptyRow(emptyCells);
		}
		return result;
	}

	private String buildEmptyRow(int columns) {
		String result = FULL_CELL;
		result += buildEmptyCells(columns);
		result += FULL_CELL + NEW_LINE;
		return result;
	}

	private String buildTextRow(int columns, String text) {
		int fullCells = 2;
		int emptyCells = columns - fullCells;
		int spaces = emptyCells * EMPTY_CELL.length() - text.length();
		int halfSpaces = spaces / 2;
		int extraSpace = text.length() % 2 != 0 ? 1 : 0;

		String row = FULL_CELL;
		row += buildSpaces(halfSpaces);
		row += text;
		row += buildSpaces(halfSpaces + extraSpace);
		row += FULL_CELL + NEW_LINE;
		return row;
	}

	private String buildEmptyCells(int columns) {
		String cells = "";
		for (int j = 0; j < columns; j++) {
			cells += EMPTY_CELL;
		}
		return cells;
	}

	private String buildSpaces(int length) {
		String spaces = "";
		for (int j = 0; j < length; j++) {
			spaces += " ";
		}
		return spaces;
	}

	public static void main(String[] args) {
		System.out.print(new Button(10, 10).render("ciauz"));
	}
}