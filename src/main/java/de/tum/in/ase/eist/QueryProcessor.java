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
                String input = query.substring(10);
                ArrayList<Integer> numbers = new ArrayList<>();
                for(String numStrng : input.split("[^0-9]+")){
                    if(!numStrng.isEmpty()) {
                        int test = Integer.parseInt(numStrng);
                        if(test != 20) {
                            numbers.add(test);
                        }
                    }
                }
                int largest = numbers.get(0);
                for(int i = 0; i < numbers.size(); i++){
                    if(largest < numbers.get(i)){
                        largest = numbers.get(i);
                    }
                }
                return Integer.toString(largest);
            }
        }
        else if(query.contains("plus")){
            ArrayList<Integer> numbers = new ArrayList<>();
            String input = query.substring(10);
            for(String numStrng : input.split("[^0-9]+")){
                if(!numStrng.isEmpty()) {
                    int test = Integer.parseInt(numStrng);
                    if(test != 20) {
                        numbers.add(test);
                    }
                }
            }
            int one = numbers.get(0);
            int two = numbers.get(1);
            int result = one + two;
            return Integer.toString(result);
        }
        return "";
    }

    public static void main(String[] args) {
        QueryProcessor processor = new QueryProcessor();
        processor.process("largest numbers 10;3123;412 ");
                System.out.println(processor.process("329ea7c0: what is 15 plus 18"));
    }


}
