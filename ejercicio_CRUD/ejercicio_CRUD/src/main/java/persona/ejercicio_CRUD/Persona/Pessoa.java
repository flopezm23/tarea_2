package persona.ejercicio_CRUD.Persona;

public class Pessoa {
    private Long id;
    private String Nombre;
    private String Apellido;
    private int edad;
    private String correo;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {
        return Nombre;
    }
    public void setFirstName(String Nombre) {
        this.Nombre = Nombre;
    }
    public String getLastName() {
        return Apellido;
    }
    public void setLastName(String lastName) {
        this.Apellido = lastName;
    }
    public int getAge() {
        return edad;
    }
    public void setAge(int edad) {
        this.edad = edad;
    }
    public String getEmail() {
        return correo;
    }
    public void setEmail(String correo) {
        this.correo = correo;
    }

    


    
}
