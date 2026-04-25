public class personal extends persona {
    private String depto;
    private String puesto;
    private String ingreso;

    public personal(String nombre,String apellido,int edad,String documento,String depto,String puesto,String ingreso){
        super(nombre, apellido, edad, documento);
        this.depto=depto;
        this.puesto=puesto;
        this.ingreso=ingreso;
    }
     public String getDepto(){
        return depto;
    }
    public void setDepto(String depto){
        if(depto == null || depto.trim().isEmpty()){
            throw new IllegalArgumentException("por favor ingrese su direccion de depto/casa");
        }
        this.depto=depto.trim();
    } 
     public String getPuesto(){
        return puesto;
    }
    public void setPuesto(String puesto){
        if(puesto == null || puesto.trim().isEmpty()){
            throw new IllegalArgumentException("por favor ingrese su puesto");
        }
        this.puesto=puesto.trim();
    } 
     public String getIngreso(){
        return ingreso;
    }
    public void setIngreso(String ingreso){
        if(ingreso == null || ingreso.trim().isEmpty()){
            throw new IllegalArgumentException("por favor ingrese la fecha de ingreso");
        }
        this.ingreso=ingreso.trim();
    } 

    public void mostrarEmpleados(){
        mostrarPersona();
        System.out.println("direccion: "+depto+", puesto: "+puesto+" ,fecha de ingreso:"+ingreso);
    }
}
