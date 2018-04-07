package parser;

import java.util.Arrays;
import java.util.function.Function;

public class ByteCode {
	public enum ByteType {
		PRINT("PRINT", args->{
			System.out.println(String.join(" ", args));
			return null;
		});

		String desc;
		Function<String[], Void> executable;

		ByteType(String desc, Function<String[], Void> executable) {
			this.desc = desc;
			this.executable = executable;
		}

		void run(String[] toks) {
			executable.apply(toks);
		}

		static ByteType find(String tok) {
			return Arrays.stream(values()).filter(a -> a.desc.equals(tok.trim())).findFirst().orElse(null);
		}
	}

	private String[] args;
	private ByteType type;

	public ByteCode(ByteType type, String... args) {
		this.type = type;
		this.args = args;
	}

	public void run(){
		type.run(args);
	}
}
