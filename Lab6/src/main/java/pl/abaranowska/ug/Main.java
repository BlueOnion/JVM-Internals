package pl.abaranowska.ug;

import static spark.Spark.*;

public class Main {
	
	public static void main(String[] args) {
		
        get("/hello/:time", (request, response) -> {
            MyHandler.takeTheTime(Integer.parseInt(request.params(":time")));
            return "Requested: " + request.params(":time");
		});
	}
}