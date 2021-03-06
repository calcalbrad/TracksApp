package com.lostanimals.tracks.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.lostanimals.tracks.entries.PreferenceEntry;

public class PreferencesUtility {
    private final static String KEY_NAME = "key_name";
    private final static String KEY_USERNAME = "key_username";
    private final static String KEY_EMAIL = "key_email";
    private final static String KEY_NOTIFICATIONS = "key_notifications";
    private final static String KEY_DARK_MODE = "Key_dark_mode";

    // Filter Values
    private static String mSorter = "";
    private static String mSpeciesDog = "";
    private static String mSpeciesCat = "";
    private static String mSpeciesBird = "";
    private static String mSpeciesRabbit = "";
    private static String mSpeciesHorse = "";
    private static String mSpeciesCow = "";
    private static String mSpeciesSheep = "";
    private static String mSpeciesGoat = "";
    private static String mSpeciesGuineaPig = "";
    private static String mSpeciesTurtle = "";
    private static String mSpeciesOther = "";
    private static String mColourBlack = "";
    private static String mColourWhite = "";
    private static String mColourGrey = "";
    private static String mColourBrown = "";
    private static String mColourRed = "";
    private static String mColourGold = "";
    private static String mColourOther = "";
    private static String mMicroYes = "";
    private static String mMicroNo = "";


    private static SharedPreferences mSharedPreferences;

    public PreferencesUtility(SharedPreferences sharedPreferences) {
        mSharedPreferences = sharedPreferences;
    }

    public static void setSharedPreferences(Context context) {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static boolean removeUserEntry() {
        return setUserInfo(new PreferenceEntry("", "", ""));
    }

    public static boolean setUserInfo(PreferenceEntry preferenceEntry) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(KEY_NAME, preferenceEntry.getName());
        editor.putString(KEY_USERNAME, preferenceEntry.getUsername());
        editor.putString(KEY_EMAIL, preferenceEntry.getEmail());
        return editor.commit();
    }

    public static void setDarkMode(boolean darkMode) {
        PreferenceEntry.mDarkMode = darkMode;
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(KEY_DARK_MODE, darkMode);
        editor.apply();
    }

    public static void setNotifications(boolean notifications) {
        NotificationUtility.setNotificationsEnabled(notifications);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(KEY_NOTIFICATIONS, getUserInfo().isNotificationsEnabled());
        editor.apply();
    }

    public static PreferenceEntry getUserInfo() {
        String name = mSharedPreferences.getString(KEY_NAME, "");
        String username = mSharedPreferences.getString(KEY_USERNAME, "");
        String email = mSharedPreferences.getString(KEY_EMAIL, "");
        return new PreferenceEntry(name, username, email);
    }

    /**
     * Creates an SQL command for returning filters
     *
     * @return the SQL command as a String
     */
    public static String getFiltersCommand() {
        String command = "";

        // Add microchipped filters to command
        if (!mMicroYes.equals("")) {
            command += "AND microchipped = ";
            command += mMicroYes;
        }

        if (!mMicroYes.equals("")) {
            command += "AND microchipped = ";
            command += mMicroNo;
        }

        return command;
    }

    public static void setmSorter(String mSorter) {
        PreferencesUtility.mSorter = mSorter;
    }

    public static void setmSpeciesDog(String mSpeciesDog) {
        PreferencesUtility.mSpeciesDog = mSpeciesDog;
    }

    public static void setmSpeciesCat(String mSpeciesCat) {
        PreferencesUtility.mSpeciesCat = mSpeciesCat;
    }

    public static void setmSpeciesBird(String mSpeciesBird) {
        PreferencesUtility.mSpeciesBird = mSpeciesBird;
    }

    public static void setmSpeciesRabbit(String mSpeciesRabbit) {
        PreferencesUtility.mSpeciesRabbit = mSpeciesRabbit;
    }

    public static void setmSpeciesHorse(String mSpeciesHorse) {
        PreferencesUtility.mSpeciesHorse = mSpeciesHorse;
    }

    public static void setmSpeciesCow(String mSpeciesCow) {
        PreferencesUtility.mSpeciesCow = mSpeciesCow;
    }

    public static void setmSpeciesSheep(String mSpeciesSheep) {
        PreferencesUtility.mSpeciesSheep = mSpeciesSheep;
    }

    public static void setmSpeciesGoat(String mSpeciesGoat) {
        PreferencesUtility.mSpeciesGoat = mSpeciesGoat;
    }

    public static void setmSpeciesGuineaPig(String mSpeciesGuineaPig) {
        PreferencesUtility.mSpeciesGuineaPig = mSpeciesGuineaPig;
    }

    public static void setmSpeciesTurtle(String mSpeciesTurtle) {
        PreferencesUtility.mSpeciesTurtle = mSpeciesTurtle;
    }

    public static void setmSpeciesOther(String mSpeciesOther) {
        PreferencesUtility.mSpeciesOther = mSpeciesOther;
    }

    public static void setmColourBlack(String mColourBlack) {
        PreferencesUtility.mColourBlack = mColourBlack;
    }

    public static void setmColourWhite(String mColourWhite) {
        PreferencesUtility.mColourWhite = mColourWhite;
    }

    public static void setmColourGrey(String mColourGrey) {
        PreferencesUtility.mColourGrey = mColourGrey;
    }

    public static void setmColourBrown(String mColourBrown) {
        PreferencesUtility.mColourBrown = mColourBrown;
    }

    public static void setmColourRed(String mColourRed) {
        PreferencesUtility.mColourRed = mColourRed;
    }

    public static void setmColourGold(String mColourGold) {
        PreferencesUtility.mColourGold = mColourGold;
    }

    public static void setmColourOther(String mColourOther) {
        PreferencesUtility.mColourOther = mColourOther;
    }

    public static void setmMicroYes(String mMicroYes) {
        PreferencesUtility.mMicroYes = mMicroYes;
    }

    public static void setmMicroNo(String mMicroNo) {
        PreferencesUtility.mMicroNo = mMicroNo;
    }
}
