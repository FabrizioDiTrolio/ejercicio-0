import java.util.ArrayList;
public class profesor extends persona{
    private String especialidad;
    private int anosexp;
    private ArrayList<Materias> materiasAsignadas;

    public profesor(String nombre,String apellido,int edad,String documento,String especialidad,int anosexp){
        super(nombre, apellido, edad, documento);
        this.especialidad=especialidad;
        this.anosexp=anosexp;
        this.materiasAsignadas=new ArrayList<>();
    }
     public String getEspecialidad(){
        return especialidad;
    }
    public void setEspecialidad(String especialidad){
        if(especialidad == null || especialidad.trim().isEmpty()){
            throw new IllegalArgumentException("El profesor no puede no tener especialidad");
        }
        this.especialidad=especialidad.trim();
    } 
    public int getAnosexp(){
        return anosexp;
    }
    public void setAnosexp(int anosexp){
        if(anosexp<=0){
            throw new IllegalArgumentException("El profesor no puede no tener años de experiencia");
        }
        this.anosexp=anosexp;
    }
    public void agregarMateria(Materias m){
        if(m == null){
            throw new IllegalArgumentException("La materia no puede ser nula");
        }
        materiasAsignadas.add(m);
    }

    public void mostrarProfesor(){
        Materias m;
        int i;
        mostrarPersona();
        System.out.println("especialidad:"+especialidad);
        System.out.println("años de experiencia:"+anosexp);
        for(i=0;i<materiasAsignadas.size();i++){
            m=materiasAsignadas.get(i);
            m.mostrarAsignadas();
        }
    }
}
