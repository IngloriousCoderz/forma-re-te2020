package it.formarete.tdd.button;

public class DynamicButton {
	private final static String DEFAULT_CORNER_CELL = "* ";
	private final static String DEFAULT_HORIZONTAL_CELL = "* ";
	private final static String DEFAULT_VERTICAL_CELL = "* ";
	private final static String DEFAULT_EMPTY_CELL = "  ";
	private final static String NEW_LINE = "\n";

	private int rows;
	private int columns;

	private String cornerCell;
	private String horizontalCell;
	private String verticalCell;
	private String emptyCell;

	public DynamicButton(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		this.cornerCell = DEFAULT_CORNER_CELL;
		this.horizontalCell = DEFAULT_HORIZONTAL_CELL;
		this.verticalCell = DEFAULT_VERTICAL_CELL;
		this.emptyCell = DEFAULT_EMPTY_CELL;
	}

	public DynamicButton(int rows, int columns, String cornerCell, String horizontalCell, String verticalCell,
			String emptyCell) {
		this.rows = rows;
		this.columns = columns;
		this.cornerCell = cornerCell;
		this.horizontalCell = horizontalCell;
		this.verticalCell = verticalCell;
		this.emptyCell = emptyCell;
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
		int cornerCells = 2;
		String row = cornerCell;
		for (int j = 0; j < columns - cornerCells; j++) {
			row += horizontalCell;
		}
		row += cornerCell + NEW_LINE;
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
		String result = verticalCell;
		result += buildEmptyCells(columns);
		result += verticalCell + NEW_LINE;
		return result;
	}

	private String buildTextRow(int columns, String text) {
		int fullCells = 2;
		int emptyCells = columns - fullCells;
		int spaces = emptyCells * emptyCell.length() - text.length();
		int halfSpaces = spaces / 2;
		int extraSpace = text.length() % 2 != 0 ? 1 : 0;

		String row = verticalCell;
		row += buildSpaces(halfSpaces);
		row += text;
		row += buildSpaces(halfSpaces + extraSpace);
		row += verticalCell + NEW_LINE;
		return row;
	}

	private String buildEmptyCells(int columns) {
		String cells = "";
		for (int j = 0; j < columns; j++) {
			cells += emptyCell;
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
		System.out.print(new DynamicButton(10, 10).render("ciauz"));
	}
}