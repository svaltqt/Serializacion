package Serializacion;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Inicio {
    public static void main(String[] args) throws IOException {
        List<Empleado>empleados = new ArrayList<>();
        empleados.add(new Empleado("Juan",50000));
        empleados.add(new Empleado("Maria",60000));

        try{
            FileOutputStream fileOut = new FileOutputStream("empleados.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(empleados);
            out.close();
            System.out.println("Emplados Serializados en empleados.ser");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            FileInputStream fileIn = new FileInputStream("empleados.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            List<Empleado>empleadosDeserializados = (List<Empleado>) in.readObject();
            in.close();
            fileIn.close();

            System.out.println("Empleados deserializados");
            for (Empleado empleado:empleadosDeserializados) {
                System.out.println(empleado);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
