import java.util.ArrayList;
public class carrera {
    private String nombre;
    private String codigo;
    private ArrayList<Estudiante> estudiantes;
    private Estudiante e;
    int i;
    public carrera(String nombre,String codigo){
        setNombre(nombre);
        setCodigo(codigo);
        this.estudiantes=new ArrayList<>();
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        if(nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre de la carrera no puede estar vacío");
        }
        this.nombre=nombre.trim();
    }
    public String getCodigo(){
        return codigo;
    }
    public void setCodigo(String codigo){
        if(codigo == null || codigo.trim().isEmpty()){
            throw new IllegalArgumentException("El código de la carrera no puede estar vacío");
        }
        this.codigo=codigo.trim();
    }
    public void agregarEstudiante(Estudiante e) {
        if(e == null){
            throw new IllegalArgumentException("El estudiante no puede ser nulo");
        }
        estudiantes.add(e);
    }
    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }
    public void mostrarCarrera(){
        System.out.println("carrera: "+nombre+"("+codigo+")");
        System.out.println("estudiantes");
        for(i=0;i<estudiantes.size();i++){
            e=estudiantes.get(i);
            e.mostrarEstudiante();
        }
    }
}