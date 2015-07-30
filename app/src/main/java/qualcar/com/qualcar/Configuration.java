package qualcar.com.qualcar;

/**
 * Created by Nitish on 7/29/2015.
 */
public class Configuration {
    int version;
    int id;
    String type_of_account;
    String language;

    Configuration(int version, int id, String type_of_account, String language){
        this.version=version;
        this.id=id;
        this.type_of_account=type_of_account;
        this.language=language;
    }

    // setters
    public void set_id(int id) {
        this.id = id;
    }
    public void set_type_of_account(String account_type){
        this.type_of_account = account_type;
    }

    public void set_language(String language){
        this.language = language;
    }

    // getters
    public long getId() {
        return this.id;
    }

    public String get_type_of_account(){
        return this.type_of_account;
    }

    public String get_language(){
        return this.language;
    }

}
