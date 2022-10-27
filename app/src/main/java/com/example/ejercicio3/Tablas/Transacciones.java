package com.example.ejercicio3.Tablas;

public class Transacciones {
    public static final String NameDatabase = "PMO1";

    public static final String TbPersonas = "personas";


    public static final String nombre = "nombre";
    public static final String apellido = "apellido";
    public static final String edad = "edad";
    public static final String correo = "correo";
    public static final String direccion = "direccion";

    public static final String CTPersonas = "CREATE TABLE personas (nombre TEXT, apellido TEXT, edad INTEGER, correo TEXT, direccion TEXT)";

    public static final String DropTPersonas = "DROP TABLE IF EXISTS personas";



}
