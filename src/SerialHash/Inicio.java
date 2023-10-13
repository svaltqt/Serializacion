package SerialHash;

import Serializacion.Empleado;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inicio {

    public static void main(String[] args) {
        Map<String, Producto> inventario = new HashMap<>();

        inventario.put("Producto1", new Producto("Producto1", 10.10, 100));
        inventario.put("Producto2",new Producto("Producto2",20.10,10));
        inventario.put("Producto3",new Producto("Producto3",30.10,10));


        try{
            FileOutputStream fileOut = new FileOutputStream("inventario.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(inventario);
            out.close();
            System.out.println("inventarios Serializados en inventario.ser");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            FileInputStream fileIn = new FileInputStream("inventario.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Map<String, Producto>inventarioDeserializados = (Map<String, Producto>) in.readObject();
            in.close();
            fileIn.close();

            System.out.println("Inventario deserializados");
            for (Producto producto:inventarioDeserializados.values()) {
                System.out.println(producto);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


}
