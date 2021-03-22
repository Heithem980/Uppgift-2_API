package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@RequestMapping(path ="/")
	public String index() {
		
		return "<h1>Rock, paper or scissors? (2 players)</h1>";
		
	}
	
	PlayerData data, data2;
	
	@RequestMapping(method = RequestMethod.POST, path ="/player1")
	public String player1(String choice) { 
		
		data  = new PlayerData(choice);
		System.out.print(data);
		return "<h3>You have choosen: "+choice+"</h3>";
	}
	
	@RequestMapping(method = RequestMethod.POST, path ="/player2")
	public String player2(String choice) { 
		
		data2  = new PlayerData(choice);
		
		return "<h3>You have choosen: "+choice+"</h3>";
	}
	
	@RequestMapping(method = RequestMethod.GET, path ="/getResults", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getResults() { 
		
		String result = RoundScore.results(data, data2);
		boolean tie = RoundScore.tie(data, data2); 
		
		
		
		String pattern = "{ \"Player1\":\"%s\", \"Player2\":\"%s\", \"Winner\": \"%s\", \"Tie\": \"%s\"}";
		
		return String.format(pattern, data.getChoice(), data2.getChoice(), result, tie);
	}

}
