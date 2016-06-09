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
        //don't want to hard-code distribution ,use a NavigableMap with the ceilingEntry method
        int[] options = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        double maxWeight = 83000/997940d;
        double[] weights = new double[]{ maxWeight, maxWeight, maxWeight, maxWeight, maxWeight, maxWeight,
                                         maxWeight, maxWeight, maxWeight, maxWeight, maxWeight, maxWeight,
                                         1000/997940d, 500/997940d, 250/997940d, 100/997940d, 50/997940d,
                                         25/997940d, 10/997940d,5/997940d };

        NavigableMap<Double, Integer> map = new TreeMap<Double, Integer>();
        double totalWeight = 0d;
        //assign a weight to a selection option.
        for (int i = 0; i < weights.length; i++) {
            totalWeight += weights[i];
            map.put(totalWeight, options[i]);
        }

        //select from the weighted elements
        Random rand = new Random();

        int iterations = 997940;

        List<String> generatedNums = new ArrayList<String>();
        List<Integer> lineContainer = new ArrayList<Integer>();
        for(int i = 0; i < iterations; i++) {
            double rnd = rand.nextDouble() * totalWeight;
            Integer elem = (Integer)map.ceilingEntry(rnd).getValue();
            if (elem == 20) {
                lineContainer.add(i);
            }
            generatedNums.add(elem.toString());
        }

        generateOutput(generatedNums);
        lineContainer.forEach(l -> {
            System.out.println(l);
        });

    }

}
