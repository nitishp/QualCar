package qualcar.com.qualcar;

/**
 * Created by Nitish on 7/29/2015.
 */
public class permission {
    int id;
    boolean state;
    String permission_string;

    public permission(int id, boolean state, String permission_string){
        this.id = id;
        this.state = state;
        this.permission_string = permission_string;
    }
    // setters
    public void set_id(int id) {this.id = id;}

    public void set_state(boolean state) {this.state = state;}

    public void set_string(String permission_string) {this.permission_string = permission_string;}
    // getters
    public boolean get_state() {return this.state;}

    public long get_id() {return this.id;}

    public String get_string(){return this.permission_string;}

    public boolean equals(permission other_obj) {
        if (other_obj == null) return false;
        if (other_obj == this) return true;
        permission o = (permission) other_obj;
        return o.id == this.id;
    }
}
