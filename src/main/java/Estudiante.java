import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
public class Estudiante implements Serializable {

    // private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue (strategy = GenerationType. IDENTITY)
    private int idestudiante;
    private String carnet;
    private String nombres;
    private String apellidos;

    public Estudiante(String carnet, String nombres, String apellidos) {
        this.carnet = carnet;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }
    public Estudiante(){

    }

    public int getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(int idestudiante) {
        this.idestudiante = idestudiante;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "Estudiante {" +
                "idestudiante=" + idestudiante +
                ", carnet='" + carnet + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }
}
