import java.util.ArrayList;
public class Estudiante extends persona{
    private carrera carrera;
    private float promedio;
    private ArrayList<Materias> materias;
    private Materias m;
    private int i;
    private String legajo;
    
    public Estudiante(String nombre,String apellido,int edad,String documentos,carrera carrera,String legajo){
        super(nombre, apellido, edad, documentos);
        this.carrera=carrera;
        this.promedio=0;
        this.materias=new ArrayList<>();
        carrera.agregarEstudiante(this);
        this.legajo=legajo;
    }
    
    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        if (legajo == null || legajo.trim().isEmpty()) {
            throw new IllegalArgumentException("El legajo no puede estar vacío");
        }
        this.legajo = legajo.trim();
    }

    public void calcularPromedio(){
        if(materias.isEmpty()){
            promedio=0;
            return;
        }
        float suma=0;
        for(i=0;i<materias.size();i++){
            m=materias.get(i);
            suma=suma+m.getCalificacion();
        }
        promedio=suma/materias.size();
    }

    public void setPromedio(float promedio){
        this.promedio=promedio;
    }

    public void agregarMateria(Materias m){
        if(m == null){
            throw new IllegalArgumentException("La materia no puede ser nula");
        }
        materias.add(m);
    }

    public void mostrarEstudiante(){
        calcularPromedio();
        mostrarPersona();
        System.out.println(promedio + " (" + carrera.getNombre() + ")");  
        System.out.println("materias inscriptas:");
        for(i=0;i<materias.size();i++){
            m=materias.get(i);
            m.mostrarNotas();
        }
    }
}
