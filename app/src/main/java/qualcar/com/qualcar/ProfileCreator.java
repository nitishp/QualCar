package qualcar.com.qualcar;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Greg-K`nox on 7/30/2015.
 */
public class ProfileCreator {
    public static ProfileModel create_profiles(int userID) {
        //person 1 Nitish
        ProfileModel nitish = new ProfileModel("Nitish");
        nitish.set_id(1);
        nitish.set_picture(R.drawable.profile_pic_nitish);
        //creating array list of permissions
        nitish.add_permission(new permission(1, true, "af9d8fad"));
        nitish.add_permission(new permission(2, true, "k324k234"));
        nitish.add_permission(new permission(3, true, "po132j44"));
        //creating array list of contextual information
        nitish.add_contextual_rule(new contextual_object(1,
                new ArrayList<String>(Arrays.asList("Temp=73")),
                new ArrayList<String>(Arrays.asList("open_car_door", "start_car"))
        ));
        nitish.set_configuration(new Configuration(34, 27, "user_account", "English"));
         //person 2 Hanna
        ProfileModel hanna = new ProfileModel("Hanna");
        hanna.set_id(2);
        hanna.set_picture(R.drawable.profile_pic_hanna);
        //creating array list of permissions
        hanna.add_permission(new permission(1, true, "a68f4ass"));
        hanna.add_permission(new permission(2, true, "afdaf654"));
        hanna.add_permission(new permission(3, true, "zvcx5v45"));
        //creating array list of contextual information
        hanna.add_contextual_rule(new contextual_object(1,
                new ArrayList<String>(Arrays.asList("Time=14:22")),
                new ArrayList<String>(Arrays.asList("set_ac", "open_doors"))
        ));
        hanna.set_configuration(new Configuration(15, 1, "user_account", "French"));

        //person 3 Ryan
        ProfileModel ryan = new ProfileModel("Ryan");
        ryan.set_id(3);
        ryan.set_picture(R.drawable.profile_pic_ryan);
        //creating array list of permissions
        ryan.add_permission(new permission(1, true, "684aff4a"));
        ryan.add_permission(new permission(2, true, "htrej5dd"));
        ryan.add_permission(new permission(3, true, "262g3kh4"));
        //creating array list of contextual information
        ryan.add_contextual_rule(new contextual_object(1,
                new ArrayList<String>(Arrays.asList("Dist=7")),
                new ArrayList<String>(Arrays.asList("honk_horn", "stop_car"))
        ));
        ryan.add_contextual_rule(new contextual_object(1,
                new ArrayList<String>(Arrays.asList("Time=7:22")),
                new ArrayList<String>(Arrays.asList("set_ac","open_doors"))
        ));
        ryan.set_configuration(new Configuration(3, 99, "user_account", "Spanish"));

        ProfileModel enrique = new ProfileModel("Enrique");
        enrique.set_id(4);
        enrique.set_picture(R.drawable.profile_pic_enrique);
        //creating array list of permissions
        enrique.add_permission(new permission(1, true, "hi525lk2"));
        enrique.add_permission(new permission(2, true, "lkj22345"));
        enrique.add_permission(new permission(3, true, "lk414314"));
        //creating array list of contextual information
        enrique.add_contextual_rule(new contextual_object(1,
                new ArrayList<String>(Arrays.asList("Temp=70", "Dist=1")),
                new ArrayList<String>(Arrays.asList("honk_horn", "start_car"))
        ));
        enrique.set_configuration(new Configuration(87, 27, "user_account", "English"));
        //person 5 Greg
        ProfileModel greg = new ProfileModel("Greg");
        greg.set_id(5);
        greg.set_picture(R.drawable.profile_pic_greg);
        //creating array list of permissions
        greg.add_permission(new permission(1, true, "lk23l31k"));
        greg.add_permission(new permission(2, true, "b3jb1k21"));
        greg.add_permission(new permission(3, true, "m324kr13"));
        //creating array list of contextual information
        greg.add_contextual_rule(new contextual_object(1,
                new ArrayList<String>(Arrays.asList("Dist=5")),
                new ArrayList<String>(Arrays.asList("honk_horn"))
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