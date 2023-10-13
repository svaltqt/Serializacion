package Serializacion;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Empleado implements Serializable{
    private String nombre;
    private double salario;

    public Empleado(String nombre, double salario){
        this.nombre = nombre;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", salario=" + salario +
                '}';
    }
}
