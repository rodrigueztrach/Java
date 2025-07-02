
package Clases;

public class Estudiantes extends Persona{

    private String carnet;
    private String carrera;
    private String nivel;

    public Estudiantes(String nombres, String apellidos, String email, String telefono) {
        super(nombres, apellidos, email, telefono);
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "Estudiante :" + "carnet=" + carnet + ", carrera=" + carrera + ", nivel=" + nivel + ')';
    }
}
