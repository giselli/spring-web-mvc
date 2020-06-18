package ninja.hara.springwebmvc.model;

import javax.validation.constraints.NotBlank;

public class Jedi {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotBlank
    private String lastName;

    @NotBlank
    private String name;

    public Jedi() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Jedi(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
}
