
package Clases;


import java.util.ArrayList;
import java.util.List;
import Interfaces.GestionAcademicaImp;


public class GestionAcademica implements GestionAcademicaImp {
      
    private List<Estudiantes> estudiantes = new ArrayList<>();
    private List<Profesor> profesores = new ArrayList<>();
    private List<Curso> cursos = new ArrayList<>();
    private List<Matricula> matriculas = new ArrayList<>();
    
    @Override 
    public boolean registrarEstudiante(Estudiantes estudiante) {
        return estudiantes.add(estudiante);
    }

   @Override
    public Estudiantes buscarEstudiantePorCarnet(String carnet) {
        for (Estudiantes e : estudiantes) {
            if (e.getCarnet().equalsIgnoreCase(carnet)) return e;
        }
        return null;
    }
  @Override
    public List<Estudiantes> obtenerTodosLosEstudiantes() {
        return estudiantes;
    }

    
    @Override
    public boolean registrarProfesor(Profesor profesor) {
        return profesores.add(profesor);
    }

    @Override
    public Profesor buscarProfesorPorId(String idProfesor) {
        for (Profesor p : profesores) {
            if (p.getProfesor().equalsIgnoreCase(idProfesor)) return p;
        }
        return null;
    }

    @Override
    public List<Profesor> obtenerTodosLosProfesores() {
        return profesores;
    }

    
   @Override
    public boolean crearCurso(Curso curso) {
        return cursos.add(curso);
    }

   @Override
    public Curso buscarCursoPorCodigo(String codigo) {
        for (Curso c : cursos) {
            if (c.getCodigo().equalsIgnoreCase(codigo)) return c;
        }
        return null;
    }

   @Override
    public List<Curso> obtenerTodosLosCursos() {
        return cursos;
    }

   
   @Override
    public boolean matricularEstudiante(String carnetEstudiante, String codigoCurso) {
        Estudiantes estudiante = buscarEstudiantePorCarnet(carnetEstudiante);
        Curso curso = buscarCursoPorCodigo(codigoCurso);

        if (estudiante != null && curso != null) {
            Matricula matricula = new Matricula(carnetEstudiante, codigoCurso, java.time.LocalDate.now().toString());
            matriculas.add(matricula);
            return true;
        }
        return false;
    }

    @Override
    public boolean desmatricularEstudiante(String carnetEstudiante, String codigoCurso) {
        return matriculas.removeIf(m ->
            m.getEstudinte().equalsIgnoreCase(carnetEstudiante) &&
            m.getCurso().equalsIgnoreCase(codigoCurso)
        );
    }

   @Override
    public List<Matricula> obtenerMatriculasPorEstudiante(String carnetEstudiante) {
        List<Matricula> resultado = new ArrayList<>();
        for (Matricula m : matriculas) {
            if (m.getEstudinte().equalsIgnoreCase(carnetEstudiante)) {
                resultado.add(m);
            }
        }
        return resultado;
    }
}
