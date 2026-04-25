import java.util.ArrayList;
public class Materias {
    private String nombre;
    private String codigo;
    private int creditos;
    private float calificacion;
    private ArrayList<profesor> profesor;

    public Materias(String nombre, String codigo, int creditos, float calificacion){
        this.nombre=nombre;
        this.codigo=codigo;
        this.creditos=creditos;
        this.calificacion=calificacion;
        this.profesor= new ArrayList<>();
    }

    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        if(nombre == null){
            throw new IllegalArgumentException("La materia debe tener nombre");
        }
        this.nombre=nombre.trim();
    }

    public String getCodigo(){
        return codigo;
    }

    public void setCodigo(String codigo){
        if(codigo == null){
            throw new IllegalArgumentException("La materia no puede no tener codigo");
        }
        this.codigo=codigo.trim();
    }

    public int getCreditos(){
        return creditos;
    }

    public void setCreditos(int creditos){
        if(creditos <= 0){
            throw new IllegalArgumentException("La materia no puede no tener credito");
        }
        this.creditos=creditos;
    }

    public float getCalificacion(){
        return calificacion;
    }

    public void setCalificacion(float calificacion){
        if(calificacion <= 0 || calificacion >10){
            throw new IllegalArgumentException("La calificacion no puede ser <=0 o >10");
        }
        this.calificacion=calificacion;
    }

    public void agregarProfesor(profesor p){
        if(p == null){
            throw new IllegalArgumentException("el profesor no puede no existir");
        }
        profesor.add(p);
    }

    public void mostrarAsignadas(){
        System.out.println("materia: "+ nombre + ", codigo: " + codigo);
    }

    public void mostrarNotas(){
        System.out.println("materia: "+ nombre + ", codigo: " + codigo + ", creditos: " + creditos + ", calificacion: " + calificacion);
    }
}
