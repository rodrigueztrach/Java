
package Clases;

public class Matricula {
    
    private String estudinte; 
    private String curso;
    private String fechaMatricula;

    public Matricula(String estudinte, String curso, String fechaMatricula) {
        this.estudinte = estudinte;
        this.curso = curso;
        this.fechaMatricula = fechaMatricula;
    }

    public String getEstudinte() {
        return estudinte;
    }

    public void setEstudinte(String estudinte) {
        this.estudinte = estudinte;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(String fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    @Override
    public String toString() {
        return "Matricula{" + "estudinte=" + estudinte + ", curso=" + curso + ", fechaMatricula=" + fechaMatricula + '}';
    }
}
