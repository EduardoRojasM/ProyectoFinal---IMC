package Utilidades;

public class Utilidades {

    public static final String TABLA_USUARIO="usuario";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_APELLIDO="apellido";
    public static final String CAMPO_EDAD="edad";
    public static final String CAMPO_ALTURA="altura";
    public static final String CAMPO_PESO="peso";
    public static final String CAMPO_ANIO="anio";
    public static final String CAMPO_MES="mes";
    public static final String CAMPO_DIA="dia";

    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE "+TABLA_USUARIO+"  ("+CAMPO_ID+" INTEGER, " +
            ""+CAMPO_NOMBRE+"  TEXT, "+CAMPO_APELLIDO+"  TEXT," +
            ""+CAMPO_EDAD+"  INTEGER, "+CAMPO_ALTURA+"  INTEGER, "+CAMPO_PESO+"  INTEGER, "+CAMPO_ANIO+"  INTEGER," +
            " "+CAMPO_MES+"  INTEGER, "+CAMPO_DIA+" INTEGER)";
}