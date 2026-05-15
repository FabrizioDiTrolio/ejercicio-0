public class IndiceEstudiante {
    private Estudiante[] tabla;
    private int tamanio;
    private double r=0.618034;
    
    public IndiceEstudiante(int tamanio){
        this.tamanio=tamanio;
        this.tabla=new Estudiante[tamanio];
    }

    private int convertirClave(String legajo){
        int d=0;
        int i;
        for(i=0;i<legajo.length();i++){
            d=d*27+(int)legajo.charAt(i);
            System.out.println("d: "+d);
        }
        if(d<0){
            d=-d;
        }
        return d;
    }

    private int dispersion(int x){
        double t;
        t=r*x-Math.floor(r*x);
        x=(int)(tamanio*t);
        return x;
    }

    public void insertar(String legajo,Estudiante e){
        int v=convertirClave(legajo);
        v=dispersion(v);
        int i=0;
        int pos;
        while (tabla[(v+i*i)%tamanio]!=null && i<tamanio) {
            i++;
        }
        if(i==tamanio){
            System.out.println("tabla llena, no se puede insertar a "+e.getNombre());
            return;
        }
        pos=(v+i*i)%tamanio;
        tabla[pos]=e;
        System.out.println("alumno "+e.getNombre()+"insertado en la posicion "+pos);
    }

    public Estudiante buscar(String legajo){
        int v=convertirClave(legajo);
        v=dispersion(v);
        int i=0;
        int pos;
        while (i<tamanio) {
            pos=(v+i*i)%tamanio;
            if(tabla[pos]==null){
                return null;
            }else{
                if(tabla[pos]!=null&&tabla[pos].getLegajo().equalsIgnoreCase(legajo)){
                    return tabla[pos];
                }
            }
            i++;
        }
        return null;
    }
    public void mostrar() {
        for (int i = 0; i <tamanio; i++) {
            if (tabla[i] != null) {
                System.out.println("Posición " + i + ": " + tabla[i].getNombre());
            } else {
                System.out.println("Posición " + i + ": vacía");
            }
        }
    }
}
