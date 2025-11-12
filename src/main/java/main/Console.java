package main;

public class Console {
	public static void draw(String format, Object ... args) {
		System.out.println(String.format(format, args));
	}
	public static void write(String format, Object ... args) {
		System.out.printf(format, args);
	}
	public static void writeln(String format, Object ... args) {
		draw(format, args);
	}
}
