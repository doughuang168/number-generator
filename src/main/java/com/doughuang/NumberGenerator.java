package com.doughuang;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumberGenerator {

    public static void generateOutput(List<String> lines) throws IOException {
        Files.write(Paths.get("./test.output"), lines);
    }

    public static void main( String[] args ) throws IOException
    {
	/* program iteration=997940 times selects one of n=20 elements with weights weights[i].
	 * Selections are summed up in counter[i]. 
	 */
        List<String> generatedNums = new ArrayList<String>();
        List<Integer> lineContainer = new ArrayList<Integer>();

        double maxWeight = 83000/997940d;
        double[] weights = new double[]{ maxWeight, maxWeight, maxWeight, maxWeight, maxWeight, maxWeight,
                                         maxWeight, maxWeight, maxWeight, maxWeight, maxWeight, maxWeight,
                                         1000/997940d, 500/997940d, 250/997940d, 100/997940d, 50/997940d,
                                         25/997940d, 10/997940d,5/997940d };

        int iterations = 997940;
        int n=20;
        int [] counter = new int[n];
        double max_weight=maxWeight;
        int index=0;
        boolean notaccepted;
        for (int i=0; i<iterations; i++){
            notaccepted=true;
            while (notaccepted){
                index= (int)(n*Math.random());
                if(Math.random()<weights[index]/max_weight) {notaccepted=false;}
            }
            Integer line = (Integer) (i+1);
            Integer elem = (Integer) (index+1);
            if ((index+1) == 20) {
                lineContainer.add(line);
            }
            generatedNums.add(elem.toString());
            //counter[index]++;
        }
//        for (int i=0; i<n; i++){
//            System.out.println("counter["+i+"]="+counter[i]);
//        }

        generateOutput(generatedNums);
        lineContainer.forEach(l -> {
            System.out.println(l);
        });

    }

}
