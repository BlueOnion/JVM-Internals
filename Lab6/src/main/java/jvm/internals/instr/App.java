package jvm.internals.instr;

import static spark.Spark.*;

public class App {
	
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Udało się!");
    }
}