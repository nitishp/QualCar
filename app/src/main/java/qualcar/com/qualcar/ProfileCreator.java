package qualcar.com.qualcar;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Greg-K`nox on 7/30/2015.
 */
public class ProfileCreator {
    public ProfileModel create_profiles(int userID) {
        //person 1 Nitish
        ProfileModel user1 = new ProfileModel("Nitish");
        user1.set_id(1);
        user1.set_picture("profile_pic_nitish.jpg");
        //creating array list of permissions
        user1.add_permission(new permission(1,true,"af9d8fad"));
        user1.add_permission(new permission(2,true,"k324k234"));
        user1.add_permission(new permission(3,true,"po132j44"));
        //creating array list of contextual information
        user1.add_contextual_rule(new contextual_object(1,
                                                        new ArrayList<String>(Arrays.asList("Temp=73")),
                                                        new ArrayList<String>(Arrays.asList("open_car_door","start_car"))
                                                        ));
        user1.set_configuration( new Configuration(34,27,"user_account","English"));

        //person 2 Hanna
        ProfileModel user2 = new ProfileModel("Hanna");
        user2.set_id(2);
        user2.set_picture("profile_pic_hanna");
        //creating array list of permissions
        user2.add_permission(new permission(1,true,"a68f4ass"));
        user2.add_permission(new permission(2,true,"afdaf654"));
        user2.add_permission(new permission(3,true,"zvcx5v45"));
        //creating array list of contextual information
        user2.add_contextual_rule(new contextual_object(1,
                new ArrayList<String>(Arrays.asList("Time=14:22")),
                new ArrayList<String>(Arrays.asList("set_ac","open_doors"))
        ));
        user2.set_configuration( new Configuration(15,1,"user_account","French"));

        //person 3 Ryan
        ProfileModel user3 = new ProfileModel("Ryan");
        user3.set_id(3);
        user3.set_picture("profile_pic_ryan");
        //creating array list of permissions
        user3.add_permission(new permission(1,true,"684aff4a"));
        user3.add_permission(new permission(2,true,"htrej5dd"));
        user3.add_permission(new permission(3,true,"262g3kh4"));
        //creating array list of contextual information
        user3.add_contextual_rule(new contextual_object(1,
                new ArrayList<String>(Arrays.asList("Dist=7")),
                new ArrayList<String>(Arrays.asList("honk_horn","stop_car"))
        ));
        user3.set_configuration( new Configuration(3,99,"user_account","Spanish"));

        //person 4 Enrique
        ProfileModel user4 = new ProfileModel("Enrique");
        user4.set_id(4);
        user4.set_picture("profile_pic_enrique");
        //creating array list of permissions
        user4.add_permission(new permission(1,true,"hi525lk2"));
        user4.add_permission(new permission(2,true,"lkj22345"));
        user4.add_permission(new permission(3,true,"lk414314"));
        //creating array list of contextual information
        user4.add_contextual_rule(new contextual_object(1,
                new ArrayList<String>(Arrays.asList("Temp=70","Dist=1")),
                new ArrayList<String>(Arrays.asList("honk_horn","start_car"))
        ));
        user4.set_configuration( new Configuration(87,27,"user_account","English"));

        //person 5 Greg
        ProfileModel user5 = new ProfileModel("Greg");
        user5.set_id(5);
        user5.set_picture("profile_pic_greg");
        //creating array list of permissions
        user5.add_permission(new permission(1,true,"lk23l31k"));
        user5.add_permission(new permission(2,true,"b3jb1k21"));
        user5.add_permission(new permission(3, true, "m324kr13"));
        //creating array list of contextual information
        user5.add_contextual_rule(new contextual_object(1,
                new ArrayList<String>(Arrays.asList("Dist=5")),
                new ArrayList<String>(Arrays.asList("honk_horn"))
        ));
        user5.set_configuration( new Configuration(37,35,"user_account","English"));

        if(userID == 1)
            return user1;
        if(userID == 2)
            return user2;
        if(userID == 3)
            return user3;
        if(userID == 4)
            return user4;
        if(userID == 5)
            return user5;
        else
            return null;
    }

}