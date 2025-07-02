
package Clases;

public class Curso {
    
    private String Codigo;
    private String nombre;
    private String descripcion; 
    private String profesor;
    private String capacidadMaxima;
    private String listaEstudiantes;

    public Curso(String Codigo, String nombre, String descripcion, String profesor, String capacidadMaxima, String listaEstudiantes) {
        this.Codigo = Codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.profesor = profesor;
        this.capacidadMaxima = capacidadMaxima;
        this.listaEstudiantes = listaEstudiantes;
    }
    

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(String capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public String getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(String listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }
    

    public String mostrarInformacion() {
        return "Curso :" + "Codigo=" + Codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", profesor=" + profesor + ", capacidadMaxima=" + capacidadMaxima + ", listaEstudiantes=" + listaEstudiantes + ')';
    }
}
