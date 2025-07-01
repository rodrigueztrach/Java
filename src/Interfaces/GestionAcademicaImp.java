
package Interfaces;

import Clases.Curso;
import Clases.Estudiantes;
import Clases.Matricula;
import Clases.Profesor;
import java.util.List;

public interface GestionAcademicaImp {
    boolean registrarEstudiante(Estudiantes estudiante); // Metodo para hacer algo
    Estudiantes buscarEstudiantePorCarnet(String carnet); // Hace una busqueda interesante 
    List<Estudiantes> obtenerTodosLosEstudiantes(); // obtiene la lista de los que se pide 
  
    
    boolean registrarProfesor(Profesor profesor);
    Profesor buscarProfesorPorId(String idProfesor);
    List<Profesor> obtenerTodosLosProfesores();
    
    
   
    boolean crearCurso(Curso curso);
    Curso buscarCursoPorCodigo(String codigo);
    List<Curso> obtenerTodosLosCursos();
   
   
    boolean matricularEstudiante(String carnetEstudiante, String codigoCurso);
    boolean desmatricularEstudiante(String carnetEstudiante, String codigoCurso);
    List<Matricula> obtenerMatriculasPorEstudiante(String carnetEstudiante);
}
