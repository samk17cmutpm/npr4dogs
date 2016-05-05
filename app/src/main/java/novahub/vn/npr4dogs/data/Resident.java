package novahub.vn.npr4dogs.data;

/**
 * Created by samnguyen on 5/5/16.
 */
public class Resident {
    private String id;

    private String name;

    public Resident(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
