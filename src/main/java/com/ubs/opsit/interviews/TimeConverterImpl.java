package com.ubs.opsit.interviews;

public class TimeConverterImpl implements TimeConverter {

	private StringBuffer sb = new StringBuffer();
	private static final int QUARTER1 = 3;
	private static final int QUARTER2 = 6;
	private static final int QUARTER3 = 9;
	private static final int NUM_OF_HOUR_LAMPS = 4;
	private static final int NUM_OF_MINUTE_LAMPS_ROW1 = 11;
	private static final int NUM_OF_MINUTE_LAMPS_ROW2 = 4;

	@Override
	public String convertTime(String aTime) {
		String[] timeArray = aTime.split(":");
		printSeconds(Integer.valueOf(timeArray[2]) % 2);
		insertNewLine();
		printHours(Integer.valueOf(timeArray[0]) / 5);
		insertNewLine();
		printHours(Integer.valueOf(timeArray[0]) % 5);
		insertNewLine();
		printMinutesRow1(Integer.valueOf(timeArray[1]) / 5);
		insertNewLine();
		printMinutesRow2(Integer.valueOf(timeArray[1]) % 5);
		return sb.toString();
	}

	private void printSeconds(int remainder) {
		if (remainder == 0) {
			sb.append("Y");
		} else {
			sb.append("O");
		}
	}

	private void printHours(int redLampsCount) {
		for (int i = 1; i <= redLampsCount; i++) {
			sb.append("R");
		}
		for (int i = 1; i <= (NUM_OF_HOUR_LAMPS - redLampsCount); i++) {
			sb.append("O");
		}
	}

	private void printMinutesRow1(int quotient) {
		if (quotient >= 0 && quotient < QUARTER1) {
			appendYandO(1, quotient);
		}

		if (quotient >= QUARTER1 && quotient < QUARTER2) {
			appendYYR(1);
			appendYandO(4, quotient);
		}

		if (quotient >= QUARTER2 && quotient < QUARTER3) {
			appendYYR(2);
			appendYandO(7, quotient);
		}

		if (quotient >= QUARTER3) {
			appendYYR(3);
			appendYandO(10, quotient);
		}
	}

	private void printMinutesRow2(int remainder) {
		for (int i = 1; i <= remainder; i++) {
			sb.append("Y");
		}
		for (int i = 1; i <= NUM_OF_MINUTE_LAMPS_ROW2 - remainder; i++) {
			sb.append("O");
		}
	}

	private void appendYYR(int times) {
		for (int i = 1; i <= times; i++) {
			sb.append("YYR");
		}
	}

	private void appendYandO(int startIndex, int quotient) {
		for (int i = startIndex; i <= quotient; i++) {
			sb.append("Y");
		}
		for (int i = 1; i <= NUM_OF_MINUTE_LAMPS_ROW1 - quotient; i++) {
			sb.append("O");
		}
	}

	private void insertNewLine() {
		sb.append("\r\n");
	}
}
