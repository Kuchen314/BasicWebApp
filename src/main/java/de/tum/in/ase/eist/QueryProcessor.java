package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "MyTeam";
        } else if(query.contains("largest")){
            if(query.contains("number")){
                ArrayList<Integer> numbers = new ArrayList<>();
                for(String numStrng : query.split("[^0-9]+")){
                    if(!numStrng.isEmpty()) {
                        numbers.add(Integer.parseInt(numStrng));
                    }
                }
                int largest = numbers.get(0);
                for(int i = 0; i < numbers.size(); i++){
                    if(largest < numbers.get(i)){
                        largest = numbers.get(i);
                    }
                }
                return largest + "";
            }
        }
        else if(query.contains("plus")){
            ArrayList<Integer> numbers = new ArrayList<>();
            for(String numStrng : query.split("[^0-9]+")){
                if(!numStrng.isEmpty()) {
                    numbers.add(Integer.parseInt(numStrng));
                }
            }
            int one = numbers.get(0);
            int two = numbers.get(1);
            int result = one + two;
            return result + "";
        }
        return "";
    }




}
