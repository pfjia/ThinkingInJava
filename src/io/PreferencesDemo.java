package io;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * Created by pfjia on 2017/4/27 0027.
 */
public class PreferencesDemo {
    public static void main(String[] args) throws BackingStoreException {
        Preferences prefs = Preferences.userNodeForPackage(PreferencesDemo.class);
        prefs.put("Location", "Oz");
        prefs.put("Footwear", "Ruby Slippers");
        prefs.putInt("Companions", 4);
        prefs.putBoolean("Are there witches?", true);
        int usageCount = prefs.getInt("UsageCount", 0);
        usageCount++;
        prefs.putInt("UsageCount", usageCount);

        for (String key : prefs.keys()) {
            System.out.println(key + ": " + prefs.get(key, null));
        }

        // You must always provide a default value:
        System.out.println("How many companions does Dorothy have? " + prefs.getInt("Companions", 0));
    }
}
