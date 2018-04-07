package parser;

import java.util.ArrayList;

public class Script extends ArrayList<ByteCode> {
	public void run() {
		this.forEach(ByteCode::run);
	}
}
