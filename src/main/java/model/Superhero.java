package model;

import javax.persistence.*;

/**
 * @author Agustin Perez Garcia
 *
 */
@Entity
@Table
public class Superhero {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    public Superhero (){
    }

    public Superhero (String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}