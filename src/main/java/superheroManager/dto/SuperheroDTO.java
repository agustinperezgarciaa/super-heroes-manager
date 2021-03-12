package superheroManager.dto;

/**
 * @author Agustin Perez Garcia
 *
 */
public class SuperheroDTO {

    private String name;

    public SuperheroDTO(){
    }

    public SuperheroDTO(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}