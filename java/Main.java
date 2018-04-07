import parser.ByteCode;
import parser.Parser;
import parser.Script;

import java.io.File;

public class Main {
	public static void main(String[] args) {
		Script s = new Script();
		Parser p = new Parser(new File(args[0]), s);
		s.run();
	}
}
