package pt.hw1.dialerpad;

import java.util.HashMap;

public class SpeedDialSingleton {
    private static SpeedDialSingleton speedDialInstance;
    private HashMap<Integer, Integer> speedDialMap;

    public static SpeedDialSingleton getInstance() {
        if(speedDialInstance == null)
            speedDialInstance = new SpeedDialSingleton();

        return speedDialInstance;
    }

    private SpeedDialSingleton() {
        speedDialMap = new HashMap<Integer,Integer>();
    }
    // retrieve array from anywhere
    public HashMap<Integer, Integer> getHashMap() {
        return this.speedDialMap;
    }
    //Add element to array
    public void addToHashMap(int key, int value) {
        speedDialMap.put(key,value);
    }
}
