
package Principal;

import Clases.Curso;
import Clases.Estudiantes;
import Clases.Matricula;
import Clases.Profesor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import Clases.GestionAcademica;
import Interfaces.GestionAcademicaImp;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Proyecto {
    
     static Scanner sc = new Scanner(System.in);
    static GestionAcademicaImp sistema = new GestionAcademica();

    public static void main(String[] args) {
        verificarOCrearArchivos();
        cargarEstudiantesDesdeArchivo("estudiantes.txt");
        cargarProfesoresDesdeArchivo("profesores.txt");
        cargarCursosDesdeArchivo("cursos.txt");

        int opcion;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Gestionar estudiantes");
            System.out.println("2. Gestionar profesores");
            System.out.println("3. Gestionar cursos");
            System.out.println("4. Gestion de matriculas");
            System.out.println("0. Salir y guardar");
            System.out.print("Ingrese opcion: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> menuEstudiantes();
                case 2 -> menuProfesores();
                case 3 -> menuCursos();
                case 4 -> menuMatricula();
                case 0 -> {
                    guardarEstudiantesEnArchivo();
                    guardarProfesoresEnArchivo();
                    guardarCursosEnArchivo();
                    System.out.println("¡Datos guardados! Hasta luego.");
                }
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void verificarOCrearArchivos() {
        crearArchivoSiNoExiste("estudiantes.txt");
        crearArchivoSiNoExiste("profesores.txt");
        crearArchivoSiNoExiste("cursos.txt");
    }

    private static void crearArchivoSiNoExiste(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        if (!archivo.exists()) {
            try {
                if (archivo.createNewFile()) {
                    System.out.println(" Archivo creado: " + nombreArchivo);
                }
            } catch (IOException e) {
                System.out.println("️ Error al crear el archivo: " + nombreArchivo);
            }
        }
    }
    private static void menuEstudiantes() {
        System.out.println("--- ESTUDIANTES ---");
        System.out.println("1. Registrar estudiante");
        System.out.println("2. Buscar estudiante");
        System.out.println("3. Mostrar todos");
        System.out.print("Opción: ");
        int op = Integer.parseInt(sc.nextLine());

        switch (op) {
            case 1 -> {
                System.out.print("Carnet: ");
                String carnet = sc.nextLine();
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Apellido: ");
                String apellido = sc.nextLine();
                System.out.print("Correo: ");
                String correo = sc.nextLine();
                System.out.print("Teléfono: ");
                String tel = sc.nextLine();
                System.out.print("Carrera: ");
                String carrera = sc.nextLine();
                System.out.print("Nivel: ");
                String nivel = sc.nextLine();

                Estudiantes e = new Estudiantes(nombre, apellido, correo, tel);
                e.setCarnet(carnet);
                e.setCarrera(carrera);
                e.setNivel(nivel);

                sistema.registrarEstudiante(e);
                System.out.println("Estudiante registrado con éxito.");
            }
            case 2 -> {
                System.out.print("Carnet: ");
                String carnet = sc.nextLine();
                Estudiantes e = sistema.buscarEstudiantePorCarnet(carnet);
                System.out.println(e != null ? e : "No encontrado.");
            }
            case 3 -> {
                List<Estudiantes> lista = sistema.obtenerTodosLosEstudiantes();
                lista.forEach(System.out::println);
            }
            default -> System.out.println("Opción inválida.");
        }
    }

    private static void cargarEstudiantesDesdeArchivo(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 7) {
                    Estudiantes e = new Estudiantes(datos[1], datos[2], datos[3], datos[4]);
                    e.setCarnet(datos[0]);
                    e.setCarrera(datos[5]);
                    e.setNivel(datos[6]);
                    sistema.registrarEstudiante(e);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer estudiantes: " + e.getMessage());
        }
    }

    private static void guardarEstudiantesEnArchivo() {
        try (FileWriter writer = new FileWriter("estudiantes.txt")) {
            for (Estudiantes e : sistema.obtenerTodosLosEstudiantes()) {
                writer.write(String.join(";",
                        e.getCarnet(),
                        e.getNombres(),
                        e.getApellidos(),
                        e.getEmail(),
                        e.getTelefono(),
                        e.getCarrera(),
                        e.getNivel()) + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error al guardar estudiantes: " + e.getMessage());
        }
    }

    private static void menuProfesores() {
        System.out.println("\n--- PROFESORES ---");
        System.out.println("1. Registrar profesor");
        System.out.println("2. Buscar profesor");
        System.out.println("3. Mostrar todos");
        System.out.print("Opción: ");
        int op = Integer.parseInt(sc.nextLine());

        switch (op) {
            case 1 -> {
                System.out.print("ID Profesor: ");
                String id = sc.nextLine();
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Apellido: ");
                String apellido = sc.nextLine();
                System.out.print("Correo: ");
                String correo = sc.nextLine();
                System.out.print("Teléfono: ");
                String tel = sc.nextLine();
                System.out.print("Especialidad: ");
                String esp = sc.nextLine();
                System.out.print("Tipo contrato: ");
                String contrato = sc.nextLine();

                Profesor p = new Profesor(id, esp, contrato, nombre, apellido, correo, tel);
                sistema.registrarProfesor(p);
                System.out.println("Profesor registrado con éxito.");
            }
            case 2 -> {
                System.out.print("ID: ");
                String id = sc.nextLine();
                Profesor p = sistema.buscarProfesorPorId(id);
                System.out.println(p != null ? p : "No encontrado.");
            }
            case 3 -> {
                List<Profesor> lista = sistema.obtenerTodosLosProfesores();
                lista.forEach(System.out::println);
            }
            default -> System.out.println("Opción inválida.");
        }
    }

    private static void cargarProfesoresDesdeArchivo(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 7) {
                    Profesor p = new Profesor(datos[0], datos[5], datos[6], datos[1], datos[2], datos[3], datos[4]);
                    sistema.registrarProfesor(p);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer profesores: " + e.getMessage());
        }
    }

    private static void guardarProfesoresEnArchivo() {
        try (FileWriter writer = new FileWriter("profesores.txt")) {
            for (Profesor p : sistema.obtenerTodosLosProfesores()) {
                writer.write("\n" + String.join(";",
                        p.getProfesor(),
                        p.getNombres(),
                        p.getApellidos(),
                        p.getEmail(),
                        p.getTelefono(),
                        p.getEspecialidad(),
                        p.getTipoContrato()));
            }
        } catch (IOException e) {
            System.out.println("Error al guardar profesores: " + e.getMessage());
        }
    }

    private static void menuCursos() {
        System.out.println("\n--- CURSOS ---");
        System.out.println("1. Crear curso");
        System.out.println("2. Buscar curso");
        System.out.println("3. Mostrar todos");
        System.out.print("Opción: ");
        int op = Integer.parseInt(sc.nextLine());

        switch (op) {
            case 1 -> {
                System.out.print("Código: ");
                String cod = sc.nextLine();
                System.out.print("Nombre: ");
                String nom = sc.nextLine();
                System.out.print("Descripción: ");
                String desc = sc.nextLine();
                System.out.print("Profesor: ");
                String prof = sc.nextLine();
                System.out.print("Capacidad: ");
                String cap = sc.nextLine();
                
                  Curso c = new Curso(cod, nom, desc, prof, cap, "");
                sistema.crearCurso(c);
                System.out.println("Curso creado correctamente.");
            }
            case 2 -> {
                System.out.print("Código: ");
                String cod = sc.nextLine();
                Curso c = sistema.buscarCursoPorCodigo(cod);
                System.out.println(c != null ? c : "No encontrado.");
            }
            case 3 -> {
                List<Curso> lista = sistema.obtenerTodosLosCursos();
                lista.forEach(System.out::println);
            }
            default -> System.out.println("Opción inválida.");
        }
    }

    private static void cargarCursosDesdeArchivo(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length >= 5) {
                    Curso c = new Curso(datos[0], datos[1], datos[2], datos[3], datos[4], "");
                    sistema.crearCurso(c);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer cursos: " + e.getMessage());
        }
    }

    private static void guardarCursosEnArchivo() {
        try (FileWriter writer = new FileWriter("cursos.txt")) {
            for (Curso c : sistema.obtenerTodosLosCursos()) {
                writer.write(String.join(";",
                        c.getCodigo(),
                        c.getNombre(),
                        c.getDescripcion(),
                        c.getProfesor(),
                        c.getCapacidadMaxima()) + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error al guardar cursos: " + e.getMessage());
        }
    }

    private static void menuMatricula() {
        System.out.println("\n--- MATRÍCULAS ---");
        System.out.println("1. Matricular estudiante");
        System.out.println("2. Desmatricular estudiante");
        System.out.println("3. Ver matrículas por estudiante");
        System.out.print("Opción: ");
        int op = Integer.parseInt(sc.nextLine());

        switch (op) {
            case 1 -> {
                System.out.print("Carnet estudiante: ");
                String carnet = sc.nextLine();
                System.out.print("Código curso: ");
                String codigo = sc.nextLine();
                boolean ok = sistema.matricularEstudiante(carnet, codigo);
                System.out.println(ok ? "Matriculado correctamente." : "No se pudo matricular.");
            }
            case 2 -> {
                System.out.print("Carnet estudiante: ");
                String carnet = sc.nextLine();
                System.out.print("Código curso: ");
                String codigo = sc.nextLine();
                boolean ok = sistema.desmatricularEstudiante(carnet, codigo);
                System.out.println(ok ? "Desmatriculado correctamente." : "No se pudo desmatricular.");
            }
            case 3 -> {
                System.out.print("Carnet estudiante: ");
                String carnet = sc.nextLine();
                List<Matricula> lista = sistema.obtenerMatriculasPorEstudiante(carnet);
                lista.forEach(System.out::println);
            }
            default -> System.out.println("Opción inválida.");
        }
    }
 } 