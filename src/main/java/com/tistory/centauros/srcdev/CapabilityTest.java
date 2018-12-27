package com.tistory.centauros.srcdev;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Rene on 2018-12-26.
 * auth : Rene
 */
public class CapabilityTest {

    Log logger = LogFactory.getLog("stdLogger");

    /**
     * DataSet
     */
    public ConcurrentHashMap<String, Integer> randomData = new ConcurrentHashMap<>();

    /**
     * get String key size
     * @return - random string key size (2 ~ 4)
     */
    private int getKeySize() {
        return getKeySize(3, 2);
    }

    /**
     * get String key size
     * @param bound - bound
     * @param init - init
     * @return init <= randomKeySize < (init+bound)-1
     */
    private int getKeySize(int bound, int init) {
        Random random = new Random();
        return random.nextInt(bound) + init;
    }


    /**
     * get random numberic value under 100
     * @return random numberic value (0 ~ 99)
     */
    private int getRandomNumbericValue() {
        return getRandomNumbericValue(100);
    }

    /**
     * get random numberic value under bound - 1
     * @param bound - bound
     * @return random numberic value (0 ~ bound - 1)
     */
    private int getRandomNumbericValue(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }





    //1.
    private void generateRandomDataWithThread() {
        Runnable generate = new Runnable() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();
                while(randomData.size() < 7000000) {
                    String key = RandomStringUtils.randomAlphabetic(getKeySize());
                    int value = getRandomNumbericValue();
                    if (!randomData.containsKey(key)) {
                        randomData.put(key, value);
                        if (randomData.size() % 10000 == 0) logger.debug("key :: " + key +", value :: " + value);
                    }
                }
                System.out.println((System.currentTimeMillis() - startTime)/1000);
            }
        };


        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(generate);
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //1-1.
    private void generateRandomData() {
        long startTime = System.currentTimeMillis();
        while(randomData.size() < 7000000) {
            randomData.put(RandomStringUtils.randomAlphabetic(getKeySize()), getRandomNumbericValue());
            if (randomData.size() % 10000 == 0) logger.debug("MAP SIZE :: " + randomData.size());
        }
        System.out.println((System.currentTimeMillis() - startTime)/1000);
    }

    //2.
    private int findValue(String key) {
        int result = -1;

        if (randomData.containsKey(key)) {
            result = randomData.get(key);
        }

        return result;
    }

    //3.
    private List<Object> findKey(int input) {
        Object value = (Object)Integer.valueOf(input);
        List<Object> result = new ArrayList();
        for (Object object : randomData.keySet()) {
            if (randomData.get(object).equals(value)) {
                result.add(object);
            }
        }
        return result;
    }

    //4.
    private List<Integer> checkPrefixKeyAndValue(String input) {
        int limit = input.length() < 4 ? input.length() : 4;
        String prefix;
        int value;
        List<Integer> results = new ArrayList<>();

        for (int i = 1; i <= limit; i++) {
            prefix = input.substring(0, i);

            if (randomData.containsKey(prefix)) {
                value = randomData.get(prefix);
                System.out.println("key :: " + prefix + ", value :: " + value);
                results.add(value);
            } else {
                System.out.println("key :: " + prefix + " is not mapping value !!");
            }
        }
        return results;
    }



    public static void main(String[] args) {
        CapabilityTest capabilityTest = new CapabilityTest();

        //1.random data create
        capabilityTest.generateRandomDataWithThread();
        System.out.println("new random data size is :: " + capabilityTest.randomData.size());

        //2.find value
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a key to know the value :: ");
        String key = input.nextLine();
        System.out.println(key + " mapping value is :: " + capabilityTest.findValue(key));

        //3. find key
        input = new Scanner(System.in);
        System.out.println("Please enter a value to know the key :: ");
        int value = Integer.parseInt(input.nextLine());
        System.out.println(value + " mapping key is :: " + capabilityTest.findKey(value));

        //4. find mapping key style of prefix
        input = new Scanner(System.in);
        System.out.println("Please enter anyText ");
        String anyText = input.nextLine();
        List<Integer> results = capabilityTest.checkPrefixKeyAndValue(anyText);
        for (Integer result : results) {
            System.out.println(result + " count :: " + Collections.frequency(results, result));
        }

    }
}
