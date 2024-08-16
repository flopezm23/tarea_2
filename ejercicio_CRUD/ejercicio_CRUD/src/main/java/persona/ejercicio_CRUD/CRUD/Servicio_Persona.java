package persona.ejercicio_CRUD.CRUD;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import persona.ejercicio_CRUD.Persona.Pessoa;

@Service
public class Servicio_Persona {
    private static final String direccion = "persons.txt";

    public List<Pessoa> getAllPersons() {
        List<Pessoa> persons = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(direccion))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Pessoa person = new Pessoa();
                person.setId(Long.valueOf(data[0]));
                person.setFirstName(data[1]);
                person.setLastName(data[2]);
                person.setAge(Integer.parseInt(data[3]));
                person.setEmail(data[4]);
                persons.add(person);
            }
        } catch (IOException e) {            
            System.out.println("hubo un error");
        }
        return persons;
    }
//CREATE
    public void Registrar(Pessoa person) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(direccion, true))) {
            bw.write(person.getId() + "," + person.getFirstName() + "," + person.getLastName() + "," + person.getAge() + "," + person.getEmail());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("hubo un error");
        }
    }

    //UPDATE
    public void Atualizar(Pessoa person) {
        List<Pessoa> persons = getAllPersons();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(direccion))) {
            for (Pessoa p : persons) {
                if (p.getId().equals(person.getId())) {
                    bw.write(person.getId() + "," + person.getFirstName() + "," + person.getLastName() + "," + person.getAge() + "," + person.getEmail());
                } else {
                    bw.write(p.getId() + "," + p.getFirstName() + "," + p.getLastName() + "," + p.getAge() + "," + p.getEmail());
                }
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("hubo un error");
        }
    }
    //Delete eliminar
    public void Deletar(Long id) {
        List<Pessoa> persons = getAllPersons();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(direccion))) {
            for (Pessoa p : persons) {
                if (!p.getId().equals(id)) {
                    bw.write(p.getId() + "," + p.getFirstName() + "," + p.getLastName() + "," + p.getAge() + "," + p.getEmail());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("hubo un error");
        }
    }



}
