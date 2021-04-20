package ie.ut.ac.ir.Bolbolestan.model;

public class Bolbol {
    private String id;
    private String name;
    private String habitat;

    public Bolbol(String id, String name, String habitat) {
        this.id = id;
        this.name = name;
        this.habitat = habitat;
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

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }
}
