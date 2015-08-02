package qualcar.com.qualcar;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Greg-K`nox on 7/30/2015.
 */
public class ProfileCreator {
    public static ProfileModel nitish;
    public static ProfileModel hanna, ryan, enrique, greg;
    public static ProfileModel create_profiles(int userID) {
        //person 1 Nitish
        nitish = new ProfileModel("Nitish");
        nitish.set_id(1);
        nitish.set_picture(R.drawable.profile_pic_nitish);
        //creating array list of permissions
        nitish.add_permission(new permission(1, true, "Start Car"));
        nitish.add_permission(new permission(2, false, "Change Radio Station"));
        nitish.add_permission(new permission(3, true, "Open Door"));
        //creating array list of contextual information
        nitish.add_contextual_rule(new contextual_object(1,
                new ArrayList<String>(Arrays.asList("Temp=73F")),
                new ArrayList<String>(Arrays.asList("Open Car Door", "Start Car"))
        ));
        nitish.set_configuration(new Configuration(34, 27, "user_account", "English"));
         //person 2 Hanna
        hanna = new ProfileModel("Hanna");
        hanna.set_id(2);
        hanna.set_picture(R.drawable.profile_pic_hanna);
        //creating array list of permissions
        hanna.add_permission(new permission(1, true, "Start Car"));
        hanna.add_permission(new permission(2, true, "Change Radio Station"));
        hanna.add_permission(new permission(3, true, "Open Door"));
        //creating array list of contextual information
        hanna.add_contextual_rule(new contextual_object(1,
                new ArrayList<String>(Arrays.asList("Time=14:22 PM")),
                new ArrayList<String>(Arrays.asList("Set A/C", "Open Doors"))
        ));
        hanna.set_configuration(new Configuration(15, 1, "user_account", "French"));

        //person 3 Ryan
        ryan = new ProfileModel("Ryan");
        ryan.set_id(3);
        ryan.set_picture(R.drawable.profile_pic_ryan);
        //creating array list of permissions
        ryan.add_permission(new permission(1, true, "Start Car"));
        ryan.add_permission(new permission(2, true, "Change Radio Station"));
        ryan.add_permission(new permission(3, true, "Open Door"));
        //creating array list of contextual information
        ryan.add_contextual_rule(new contextual_object(1,
                new ArrayList<String>(Arrays.asList("Dist=7 ft")),
                new ArrayList<String>(Arrays.asList("Honk Horn", "Stop Car"))
        ));
        ryan.add_contextual_rule(new contextual_object(1,
                new ArrayList<String>(Arrays.asList("Time=7:22 PM")),
                new ArrayList<String>(Arrays.asList("Turn On A/C","Open Doors"))
        ));
        ryan.set_configuration(new Configuration(3, 99, "user_account", "Spanish"));

        enrique = new ProfileModel("Enrique");
        enrique.set_id(4);
        enrique.set_picture(R.drawable.profile_pic_enrique);
        //creating array list of permissions
        enrique.add_permission(new permission(1, true, "Change Radio Station"));
        enrique.add_permission(new permission(2, false, "Turn Off Car"));
        enrique.add_permission(new permission(3, true, "Open Doors"));
        //creating array list of contextual information
        enrique.add_contextual_rule(new contextual_object(1,
                new ArrayList<String>(Arrays.asList("Temp=70F", "Dist=1 ft.")),
                new ArrayList<String>(Arrays.asList("Honk Horn", "Start Car"))
        ));
        enrique.add_contextual_rule(new contextual_object(1,
                new ArrayList<String>(Arrays.asList("Temp=42F", "Dist=2 ft.")),
                new ArrayList<String>(Arrays.asList("Honk Horn", "Start Car"))
        ));
        enrique.set_configuration(new Configuration(87, 27, "user_account", "English"));
        //person 5 Greg
        greg = new ProfileModel("Greg");
        greg.set_id(5);
        greg.set_picture(R.drawable.profile_pic_greg);
        //creating array list of permissions
        greg.add_permission(new permission(1, true, "Roll Down Windows"));
        greg.add_permission(new permission(2, false, "Start Car"));
        greg.add_permission(new permission(3, true, "Unlock Car"));
        //creating array list of contextual information
        greg.add_contextual_rule(new contextual_object(1,
                new ArrayList<String>(Arrays.asList("Dist=5")),
                new ArrayList<String>(Arrays.asList("Honk Horn"))
        ));
        greg.set_configuration(new Configuration(37, 35, "user_account", "English"));

        if(userID == 0)
            return nitish;
        if(userID == 1)
            return hanna;
        if(userID == 2)
            return ryan;
        if(userID == 3)
            return enrique;
        if(userID == 4)
            return greg;
        else
            return null;
        }
}