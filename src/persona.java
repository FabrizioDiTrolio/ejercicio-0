public class persona {
    private String nombre;
    private String apellido;
    private int edad;
    private String documento;

    public persona(String nombre,String apellido,int edad,String documento){
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
        this.documento=documento;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        if(nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre=nombre.trim();
    }
     public String getApellido(){
        return apellido;
    }
    public void setApellido(String apellido){
        if(apellido == null || apellido.trim().isEmpty()){
            throw new IllegalArgumentException("El apellido no puede estar vacío");
        }
        this.apellido=apellido.trim();
    }
     public int getEdad(){
        return edad;
    }
    public void setEdad(int edad){
        if(edad<16){
            throw new IllegalArgumentException("La edad no puede ser <16");
        }
        this.edad=edad;
    }
     public String getDocumento(){
        return documento;
    }
    public void setDocumento(String documento){
        if(documento == null || documento.trim().isEmpty()){
            throw new IllegalArgumentException("El documento no puede estar vacío");
        }
        this.documento=documento.trim();
    }

    public void mostrarPersona(){
        System.out.println(nombre +" "+apellido+","+edad+","+documento+":");
    }
}
