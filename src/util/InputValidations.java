package util;

import java.io.File;

import genericDeser.fileOperations.FileProcessor;

public class InputValidations {
	
	public static boolean validatingInputArguments(String[] args) {
		boolean returnvalue = false;
		try {
			if (args.length == 1) {
				if (args[0] != null && !args[0].isEmpty()) {
					FileProcessor.setPreference_Input_File((args[0]));
					if (!new File(args[0]).canRead()) {
						LoggerHandler.writeMessage("Input file name invalid or missing !!", LoggerHandler.DebugLevel.ERROR);
						System.exit(0);
					}
				}
				return true;
			} else {
				LoggerHandler.writeMessage("Input Arguments are missing !!", LoggerHandler.DebugLevel.ERROR);
				LoggerHandler.writeMessage("Arguments should be in the below mentioned format !!", LoggerHandler.DebugLevel.ERROR);
				LoggerHandler.writeMessage("java <Executable> <InputFile> !!",
						LoggerHandler.DebugLevel.ERROR);
				System.exit(0);
			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
			System.exit(0);
		} finally {

		}
		return returnvalue;
	}

}
