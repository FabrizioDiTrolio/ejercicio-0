import java.util.ArrayList;
public class universidad{
    private String nombre;
    private String direccion;
    private ArrayList<carrera> carreras;
    private ArrayList<profesor> profesor;
    private ArrayList<personal> empleados; 
    private carrera c;
    private profesor p;
    private personal e;
    private int i;
    private IndiceEstudiante legajo;
    public universidad(String nombre,String direccion,int tamanio){
        setNombre(nombre);
        setDireccion(direccion);
        this.carreras=new ArrayList<>();
        this.profesor=new ArrayList<>();
        this.empleados=new ArrayList<>();
        this.legajo=new IndiceEstudiante(tamanio);
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        if(nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre de la universidad no puede estar vacío");
        }
        this.nombre=nombre.trim();
    }

    public String getDireccion(){
        return direccion;
    }

    public void setDireccion(String direccion){
        if(direccion == null || direccion.trim().isEmpty()){
            throw new IllegalArgumentException("La dirección no puede estar vacía");
        }
        this.direccion=direccion.trim();
    }

    public void agregarCarrera(carrera c){
        if(c == null){
            throw new IllegalArgumentException("La carrera no puede ser nula");
        }
        carreras.add(c);
    }
    
    public ArrayList<carrera> getCarreras() {
        return carreras;
    }

    public void agregarProfesor(profesor p){
        if(p == null){
            throw new IllegalArgumentException("Los datos del profesor no pueden estar vacíos");
        }
        profesor.add(p);
    }
    
    public ArrayList<profesor> getProfesor() {
        return profesor;
    }

    public void agregarEmpleado(personal e){
        if(e == null){
            throw new IllegalArgumentException("Los datos del empleado no pueden estar vacios");
        }
        empleados.add(e);
    }
    
    public ArrayList<personal> getEmpleado() {
        return empleados;
    }

    public void agregarLegajo(String clave, Estudiante e) {
        legajo.insertar(clave, e);
    }

    public Estudiante buscarLegajo(String clave) {
        return legajo.buscar(clave);
    }

    public void mostrarLegajos() {
        legajo.mostrar();
    }
    public void mostrar(){
        System.out.println("universidad: " + nombre + ", direccion: " + direccion );
        System.out.println("carreras:");
        for(i=0;i<carreras.size();i++){
            c=carreras.get(i);
            c.mostrarCarrera();
        }
        for(i=0;i<profesor.size();i++){
            p=profesor.get(i);
            p.mostrarProfesor();
        }
        for(i=0;i<empleados.size();i++){
            e=empleados.get(i);
            e.mostrarEmpleados();
        }
    }
}