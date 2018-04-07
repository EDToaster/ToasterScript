package parser;

import java.io.*;
import java.util.Arrays;

public class Parser {
	public Parser(File file, Script script) {
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while((line = reader.readLine()) != null)
				compile(script, line);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static final String REG = "\\s+";

	public Script compile(Script script, String line) {
		String[] toks = line.split(REG);
		ByteCode.ByteType type = ByteCode.ByteType.find(toks[0]);
		ByteCode code = new ByteCode(type, Arrays.copyOfRange(toks, 1, toks.length));
		script.add(code);
		return script;
	}
}
