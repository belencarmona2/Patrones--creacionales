package factory;

public class LogicaLibro {
    public static Libro crearLibro(String tipo,String titulo,String autor){
        try{
            switch (tipo.toLowerCase()){
                case "digital": return new LibroDigital(titulo,autor);
                case "fisico": return new LibroFisico(titulo,autor);
                default: throw new IllegalArgumentException("Tipo Desconocido");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("\nEl tipo de libro : '"+tipo+ "' no existe es un :"+e.getMessage()+"\n");
            return null;
        }
    }
}
