package qualcar.com.qualcar;

import java.util.ArrayList;

/**
 * Created by Nitish on 7/29/2015.
 */
public class contextual_object {
    int id;
    ArrayList<String> conditional;
    ArrayList<String> action;

    contextual_object(int obj_id, ArrayList<String> obj_condition,  ArrayList<String> obj_action){
        id = obj_id;
        conditional = obj_condition;
        action = obj_action;
    }

    // setters
    public void set_id(int id) { this.id = id; }
    public void set_condition( ArrayList<String> new_condition){ this.conditional=new_condition;}
    public void set_action( ArrayList<String> new_action){ this.action = new_action;}

    // getters
    public long get_id() { return this.id; }
    public ArrayList<String> get_condition(){ return this.conditional;}
    public ArrayList<String> get_action(){ return this.action;}

    public boolean equals(contextual_object other_obj) {
        if (other_obj == null) return false;
        if (other_obj == this) return true;
        contextual_object o = (contextual_object) other_obj;
        return o.id == this.id;
    }


}
