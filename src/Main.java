import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int i,j,k;
        String nombre;
        String apellido;
        int edad;
        String documento;
        int cantcarreras;
        String codigoCarrera;
        int cantmaterias;
        String codigoMateria;
        int creditos;
        String especialidad;
        float calificacion;
        int cantalumnos;
        carrera c;
        Materias m;
        Materias encontrada;
        Materias mat;
        int experiencia;
        int cantprofesores;
        int cantasignadas;
        int cantpersonal;
        profesor prof;
        personal pers;
        String direccion;
        String puesto;
        String fecha;
        ArrayList<Materias> todas=new ArrayList<>();
        ArrayList<profesor> profe=new ArrayList<>();
        ArrayList<personal> empleados=new ArrayList<>();
        universidad univ;
        String alumnoBuscado;
        Estudiante encontrado;
        Estudiante[] alumnos;
        try{
            do{
        System.out.println("ingrese el nombre de la universidad");
        nombre=sc.nextLine();
            }while(nombre.isEmpty());
            do{
        System.out.println("ingrese la direccion");
        direccion=sc.nextLine();
            }while(direccion.isEmpty());
        univ=new universidad(nombre, direccion);
        do{
            System.out.println("ingrese la cantidad de carreras");
            cantcarreras=sc.nextInt();
            sc.nextLine();
        }while(cantcarreras<=0);
        for(i=0; i<cantcarreras; i++){
            do{
            System.out.println("ingrese el nombre de la carrera");
            nombre=sc.nextLine();
            }while(nombre.isEmpty());
            do{
            System.out.println("ingrese el codigo de la carrera");
            codigoCarrera=sc.nextLine();
            }while(codigoCarrera.isEmpty());
            c=new carrera(nombre, codigoCarrera);
            univ.agregarCarrera(c);
            do{
                System.out.println("ingrese la cantidad de alumnos");
                cantalumnos=sc.nextInt();
                sc.nextLine();
            }while(cantalumnos<=0);
            alumnos=new Estudiante[cantalumnos];
            for(j=0;j<cantalumnos;j++){
                System.out.println("alumno " + (j+1) + ":");
                do{
                    System.out.println("nombre:");
                    nombre= sc.nextLine(); //trim elimina espacios en blanco al inicio y al final
                }while(nombre.isEmpty());
                do{
                    System.out.println("apellido:");
                    apellido= sc.nextLine(); //trim elimina espacios en blanco al inicio y al final
                }while(apellido.isEmpty());
                do{
                    System.out.println("ingrese la edad");
                    edad= sc.nextInt();
                    sc.nextLine();
                }while(edad<16);
                do{
                    System.out.println("documento:");
                    documento= sc.nextLine(); //trim elimina espacios en blanco al inicio y al final
                }while(documento.isEmpty());
                alumnos[j]=new Estudiante(nombre,apellido,edad,documento,c);
                do{
                    System.out.println("ingrese la cantidad de materias (>0)");
                    cantmaterias=sc.nextInt();
                    sc.nextLine();
                }while(cantmaterias<=0);
                for(k=0;k<cantmaterias;k++){
                    do{
                    System.out.println("nombre de la materia: ");
                    nombre = sc.nextLine();
                    }while(nombre.isEmpty());
                    do{
                    System.out.println("codigo");
                    codigoMateria=sc.nextLine();
                    }while(codigoMateria.isEmpty());
                    do{
                    System.out.println("créditos: ");
                    creditos = sc.nextInt();
                    sc.nextLine();
                    }while (creditos<=0);
                    do{
                    System.out.println("calificación obtenida (0-10): ");
                    calificacion = sc.nextFloat();
                    sc.nextLine();
                    }while(calificacion<=0);
                    m = new Materias(nombre,codigoMateria ,creditos, calificacion);
                    alumnos[j].agregarMateria(m);
                    todas.add(m);
                }
            }
        }
        do{
                System.out.println("ingrese la cantidad de profesores a agregar");
                cantprofesores=sc.nextInt();
                sc.nextLine();
            }while(cantprofesores<=0);
            for(i=0;i<cantprofesores;i++){
                System.out.println("profesor"+ (i+1) + ":");
                do{
                System.out.println("nombre:");
                nombre=sc.nextLine();
                }while(nombre.isEmpty());
                do{
                    System.out.println("apellido:");
                    apellido=sc.nextLine();
                }while(apellido.isEmpty());
                do{
                    System.out.println("edad:");
                    edad=sc.nextInt();
                    sc.nextLine();
                }while(edad<16);
                do{
                    System.out.println("documento");
                    documento=sc.nextLine();
                }while(documento.isEmpty());
                 do{
                    System.out.println("especialidad");
                    especialidad=sc.nextLine();
                }while(especialidad.isEmpty());
                do{
                    System.out.println("puesto:");
                    experiencia=sc.nextInt();
                    sc.nextLine();
                }while(experiencia<0);
                prof=new profesor(nombre, apellido, edad, documento, especialidad, experiencia);
                profe.add(prof);
                do{
                    System.out.println("ingrese la cantidad de materias a asignar");
                    cantasignadas=sc.nextInt();
                    sc.nextLine();
                }while(cantasignadas<=0);
                for(j=0;j<cantasignadas;j++){
                    do{
                        do{
                        System.out.println("ingrese el nombre de la materia "+ (j+1));
                        nombre=sc.nextLine().trim();
                        }while(nombre.isEmpty());
                        encontrada=null;
                        for(k=0;k<todas.size();k++){
                            mat=todas.get(k);
                            if(mat.getNombre().equalsIgnoreCase(nombre)){
                                encontrada=mat;
                                break;
                            }
                        }
                        if(encontrada!=null){
                            prof.agregarMateria(encontrada);
                            encontrada.agregarProfesor(prof);
                            System.out.println("se asigno la materia");
                        }else{
                            System.out.println("no se ha encontrado la materia");
                        }
                    }while(encontrada==null);
                }
            }
            do{
                System.out.println("ingrese la cantidad de personal a agregar");
                cantpersonal=sc.nextInt();
                sc.nextLine();
            }while(cantpersonal<=0);
            for(i=0;i<cantpersonal;i++){
                System.out.println("personal"+ (i+1) + ":");
                do{
                System.out.println("nombre:");
                nombre=sc.nextLine();
                }while(nombre.isEmpty());
                do{
                    System.out.println("apellido:");
                    apellido=sc.nextLine();
                }while(apellido.isEmpty());
                do{
                    System.out.println("edad:");
                    edad=sc.nextInt();
                    sc.nextLine();
                }while(edad<16);
                do{
                    System.out.println("documento");
                    documento=sc.nextLine();
                }while(documento.isEmpty());
                 do{
                    System.out.println("departamento/casa:");
                    direccion=sc.nextLine();
                }while(direccion.isEmpty());
                do{
                    System.out.println("puesto:");
                    puesto=sc.nextLine();
                }while(puesto.isEmpty());
                do{
                    System.out.println("ingrese la fecha de ingreso (dd/mm/yy)");
                    fecha=sc.nextLine();
                }while(fecha.isEmpty());
                pers=new personal(nombre, apellido, edad, documento, direccion,puesto,fecha);
                empleados.add(pers);
            }
        univ.mostrar();
        System.out.println("ingrese un nombre de un alumno a buscar");
        alumnoBuscado=sc.nextLine().trim();
        encontrado=buscarAlumno(univ, alumnoBuscado);
        if (encontrado!=null) {
            System.out.println("se encontro al alumno");
            encontrado.mostrarEstudiante();
        }else{
            System.out.println("no se encontro al alumno");
        }
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }finally{
        sc.close();
        }
    }
    public static Estudiante buscarAlumno(universidad univ, String nombreAlumno){
        int i,j;
        carrera c;
        Estudiante e;
        for(i=0;i<univ.getCarreras().size();i++){
            c=univ.getCarreras().get(i);
            for(j=0;j<c.getEstudiantes().size();j++){
                e=c.getEstudiantes().get(j);
                if (e.getNombre().equalsIgnoreCase(nombreAlumno)) {
                    return e;
                }else{
                    
                }
            }
        }
        return null;
    }
}
