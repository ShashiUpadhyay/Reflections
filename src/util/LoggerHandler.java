package util;

public class LoggerHandler {
	public static enum DebugLevel {
		CONSTRUCTOR, ERROR, NODE_POPULATED, COUNT_WORDS, NODE_MODIFIED, NODE_CLONED, NODE_VISITED, NO_OUTPUT, EXCEPTION, OUTPUT, ALL
	};

	private static DebugLevel debugLevel;

	public static void setDebugValue(DebugLevel levelIn) {
		if (levelIn == null) {
			debugLevel = levelIn;
		} else {
			return;
		}
		return;
	}

	public static void writeMessage(String message, DebugLevel levelIn) {
		if (message != null && levelIn != null) {
			if(levelIn == debugLevel){
				if(levelIn == DebugLevel.ERROR || levelIn == DebugLevel.EXCEPTION || levelIn == DebugLevel.OUTPUT){
					System.err.println("ERROR Message->" + message);
				}else{
					System.out.println("LoggerHandler Message->" + message);
				}
			}
		} else {
			return;
		}
		return;
	}

	/*
	 * @return none
	 */
	public String toString() {
		return "Debug Level : " + debugLevel;
	}
}
