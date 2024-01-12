package ru.edu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Game {
    private Integer id;

    private ArrayList<Map<String, Integer>> listCombinations;

    public Game (String gameString) {
        String gameId = gameString.substring(0,gameString.indexOf(':'));
        id = Integer.parseInt(gameId.replaceAll("\\D+",""));

        String сombinationsStr = gameString.substring(gameString.indexOf(':')+1);
        String[] combinations = сombinationsStr.split(";");

        setListCombinations(combinations);
    }

    public Boolean checkGame(Integer redCount, Integer blueCount, Integer greenCount) {
        Integer count;
        for (Map<String,Integer> combination:listCombinations) {

            if (  combination.containsKey("red") && combination.get("red") > redCount ) {
                return false;
            }
            if ( combination.containsKey("blue") && combination.get("blue") > blueCount ) {
                return false;
            }
            if ( combination.containsKey("green") && combination.get("green") > greenCount ) {
                return false;
            }
        }
        return true;
    }

    public Integer getId() {
        return id;
    }

    private void setListCombinations( String[] combinations ) {
        listCombinations = new ArrayList<>();
        for ( int i = 0; i<combinations.length ; i++) {
            String[] cubics = combinations[i].split(",");
            Map<String, Integer> combination = getCombination(cubics);
            listCombinations.add(combination);
        }
    }

    private Map<String, Integer> getCombination(String[] cubics) {
        Map<String, Integer> combination = new HashMap<>();
        for (int j = 0 ; j<cubics.length ; j++) {
            String[] cubicsCount = cubics[j].trim().split(" ");
            combination.put(cubicsCount[1], Integer.parseInt(cubicsCount[0]));
        }
        return combination;
    }
}
