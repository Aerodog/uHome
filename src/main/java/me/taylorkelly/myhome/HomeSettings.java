package me.taylorkelly.myhome;

import java.io.File;


public class HomeSettings {
    
    private static final String settingsFile = "MyHome.settings";
   
    public static boolean compassPointer;
    public static int coolDown;
    public static boolean coolDownNotify;
    public static int warmUp;
    public static boolean warmUpNotify;
    public static boolean respawnToHome;
    public static boolean adminsObeyWarmsCools;
    public static boolean allowSetHome;
    public static int coolDownSetHome;
    public static boolean eConomyEnabled;
    public static int setHomeCost;
    public static int homeCost;

    public static void initialize(File dataFolder) {
        if(!dataFolder.exists()) {
            dataFolder.mkdirs();
        }

        File configFile  = new File(dataFolder, settingsFile);
        PropertiesFile file = new PropertiesFile(configFile);
        compassPointer = file.getBoolean("compassPointer", true, "Whether or not users' compasses point to home");
        coolDown = file.getInt("coolDown", 0, "The number of seconds between when users can go to a home");
        warmUp = file.getInt("warmUp", 0, "The number of seconds after a user uses a home command before it takes them");
        coolDownNotify = file.getBoolean("coolDownNotify", false, "Whether or not players will be notified after they've cooled down");
        warmUpNotify = file.getBoolean("warmUpNotify", true, "Whether or not players will be notified after they've warmed up");
        respawnToHome = file.getBoolean("respawnToHome", true, "Whether or not players will respawn to their homes (false means to global spawn)");
        adminsObeyWarmsCools = file.getBoolean("adminsObeyWarmsCools", true, "Whether or not admins obey the WarmUp + CoolDown times (false means they don't)");
        allowSetHome = file.getBoolean("allowSetHome", false, "Whether MyHome should also watch for /sethome - This may cause conflicts with Essentials");
        coolDownSetHome = file.getInt("coolDownSetHome", 0, "The number of seconds between each use of /home set");
        eConomyEnabled = file.getBoolean("eConomyEnabled", false, "Whether or not to hook into an eConomy plugin");
        setHomeCost = file.getInt("setHomeCost", 0, "How much to charge the player for using /home set");
        homeCost = file.getInt("homeCost", 0, "How much to charge a player for using /home");
        file.save();
    }
}
