package qualcar.com.qualcar;

import java.util.ArrayList;

/**
 * Created by Nitish on 7/29/2015.
 */
//TODO: Add graphs information
public class ProfileModel {
    int id;
    String name;
    String picture_location;
    ArrayList<permission> permissions;
    int state;
    ArrayList<contextual_object> contextual_information;
    Configuration configurations;

    public ProfileModel(String profile_name){
        name = profile_name;
        state = 1;//State one is the initial valid state
        permissions = new ArrayList<permission>();
        contextual_information = new ArrayList<contextual_object>();
    }

    public ProfileModel(int id, String new_name, String photo, ArrayList<permission> new_permissions,ArrayList<contextual_object> cntx,Configuration new_config){
        state=1;
        name = new_name;
        picture_location=photo;
        permissions = new_permissions;
        contextual_information = cntx;
        configurations = new_config;
    }

    // setters
    public void set_id(int id) {
        this.id = id;
    }

    // getters
    public long get_id() {
        return this.id;
    }

    public String get_name(){
        return name;
    }

    public int get_state(){
        return state;
    }

    public String get_picture_location(){
        return picture_location;
    }

    public void set_picture(String picture_address){
        picture_location = picture_address;
    }

    public void add_permission(permission new_permission){
        permissions.add(new_permission);
    }

    public void set_configuration(Configuration new_configuration){
        configurations  = new_configuration;
    }

    public ArrayList<contextual_object> get_rules(){
        return contextual_information;
    }

    public ArrayList<permission> get_permissions(){
        return permissions;
    }

    public void add_contextual_rule(contextual_object new_rule){
        contextual_information.add(new_rule);
    }



    //delete
    public void remove_permission(permission permission_to_be_removed){
        permissions.remove(permission_to_be_removed);
    }

}
