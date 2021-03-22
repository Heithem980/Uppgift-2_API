package com.example.demo;

public class RoundScore {

	
	private static String winner;

	public static String results(PlayerData data, PlayerData data2) {
		// TODO Auto-generated method stub
		
		// Om spelarnas val skiljer sig
				if(data != data2) {
					
					
					// sten krossar sax
					if(data.getChoice().equals("rock") && data2.getChoice().equals("scissors")) {
						winner = "player1";
					}
					else if(data2.getChoice().equals("rock") && data.getChoice().equals("scissors")) {
						winner = "player2";
					}
					
					
					// sax klipper påse
					
					if(data.getChoice().equals("scissors") && data2.getChoice().equals("paper")) {
						winner = "player1";
					}
					else if(data2.getChoice().equals("scissors") && data.getChoice().equals("paper")) {
						winner = "player2";
					}
					
					// påse fångar sten
					
					if(data.getChoice().equals("paper") && data2.getChoice().equals("rock")) {
						winner = "player1";
					}
					else if(data2.getChoice().equals("paper") && data.getChoice().equals("rock")) {
						winner = "player2";
					}
					return winner;
				}
		return "--";
	}

	public static boolean tie(PlayerData data, PlayerData data2) {
		// TODO Auto-generated method stub
		
		
		return data.getChoice().equals(data2.getChoice());
	}

}
