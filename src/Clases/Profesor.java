
package Clases;

public class Profesor extends Persona{
    
    private String profesor;
    private String especialidad;
    private String tipoContrato;

    public Profesor(String profesor, String especialidad, String tipoContrato, String nombres, String apellidos, String email, String telefono) {
        super(nombres, apellidos, email, telefono);
        this.profesor = profesor;
        this.especialidad = especialidad;
        this.tipoContrato = tipoContrato;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }
    
    @Override
    public String toString() {
        return "Profesor{" + "profesor=" + profesor + ", especialidad=" + especialidad + ", tipoContrato=" + tipoContrato + '}';
    }
}
