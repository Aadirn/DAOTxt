/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Persona;
import modelo.Tipo;

/**
 *
 * @author Castealo
 */
public class FicheroTextoPersonaDAO implements PersonaDAO {

    private ArrayList<Persona> personas = new ArrayList<>();
    private Persona pers;

    /*public static void guardarDatos(){
        String path = "C:\\Users\\Castelao\\Desktop\\CProjects\\AgendaJava\\contactos2.txt";
        int contador=0;
        String contacto;
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path,true))){
            Iterator iter = contactList.iterator();
            while(iter.hasNext()){
                contacto=contactList.get(contador).toContacto();
                writer.write(contacto);
                writer.newLine();
                //contador++;
            }*/
 /* public static void nuevoContacto() {
        contactoLleno();
        int dia;
        int mes;
        int anho;
        String nombre;
        long telefono;
        char tipo;
        String fechaRaw;
        Fecha fecha;
        Contacto contactos;
        String fechas[] = new String[MAX_ENTRADA];
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Nombre?: ");
        nombre = keyboard.nextLine();
        keyboard.reset();
        System.out.println("Telefono?: ");
        telefono = Long.parseLong(keyboard.nextLine());
        keyboard.reset();
        //HACER PARSEO DE FECHA
        System.out.println("Fecha de Nacimiento? (dd/mm/aaaa): ");
        fechas = keyboard.nextLine().split("/");
        dia = Integer.parseInt(fechas[0]);
        mes = Integer.parseInt(fechas[1]);
        anho = Integer.parseInt(fechas[2]);
        fecha = new Fecha(dia, mes, anho);
        keyboard.reset();

        do {
            System.out.println("Tipo Contacto? (a)migo, (e)enemigo, (f)amiliar, (t)rabajo: ");
            tipo = keyboard.nextLine().charAt(0);
        } while (!esTipoValido(tipo));
        contactos= new Contacto(nombre, telefono, fecha, tipo);
        contactList.add(contactos);
        ocupacion++;
                

    }*/
 /*public static void cargarDatos() {
        int dia;
        int mes;
        int anho;
        String nombre;
        long telefono;
        char tipo;
        Fecha fecha;
        String path = "C:\\Users\\Castelao\\Desktop\\CProjects\\AgendaJava\\contactos.txt";
        String fichero;
        String valores[] = new String[MAX_ENTRADA];
        Contacto contactos;
        contactList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while ((fichero = reader.readLine()) != null) {
                valores = fichero.split("#");
                nombre = valores[0];
                telefono = Long.parseLong(valores[1]);
                dia = Integer.parseInt(valores[2]);
                mes = Integer.parseInt(valores[3]);
                anho = Integer.parseInt(valores[4]);
                //parsear fecha
                fecha = new Fecha(dia, mes, anho);
                tipo = valores[5].toLowerCase().charAt(0);
                contactos = new Contacto(nombre, telefono, fecha, tipo);

                contactList.add(ocupacion, contactos);//Porqu2e nullPointer?
                ocupacion++;
            }

        } catch (FileNotFoundException ex) {
            System.err.println("No se encontro el archivo" + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Ocurrió un error con el fichero" + ex.getMessage());
        }
    }*/
    @Override
    public List<Persona> getAllPersona() {
        cargarFichero();

        return personas;

    }

    @Override
    public Persona getPersonaByNIF(String NIF) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addPersona(Persona p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removePersona(Persona p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updatePersona(Persona p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void cargarFichero() {
        String nombre;
        int edad;
        Tipo tipo;
        String NIF;
        String data;
        String valores[] = new String[4];

        try (BufferedReader reader = new BufferedReader(new FileReader("personas.txt"))) {
            while ((data = reader.readLine()) != null) {
                valores = data.split("#");
                NIF = valores[0];
                nombre = valores[1];
                edad = Integer.valueOf(valores[2]);
                tipo = Enum.valueOf(Tipo.class, valores[3].toUpperCase());

                personas.add(new Persona(NIF, nombre, edad, tipo));
            }

        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void guardarFichero() {

        String persona;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("personas.txt", true))) {
            Iterator iter = personas.iterator();
            while (iter.hasNext()) {
                persona = ((Persona) iter.next()).toTxt();
                writer.write(persona);
                writer.newLine();

            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());;
        }
    }

}
