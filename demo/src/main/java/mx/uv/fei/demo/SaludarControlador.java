package mx.uv.fei.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController 
public class SaludarControlador {
    String nombre;

    @GetMapping("/saludos")
    public String saludar() {
        return "¡Hola, mundo, " + nombre + "!";
    }

    @GetMapping("/despedidas")
    public String despedirse() {
        return "¡Adiós, mundo!";
    }   

    @PostMapping ("/nombramientos")
    public void nombre(){
        nombre = "Fernando";
    }

    @PutMapping ("/nombramientos")
    public void met1(){
        nombre="actualizar";
    }

    @DeleteMapping ("/nombramientos")
    public void met2(){
        nombre=null;
    }

    @GetMapping("/saludador/{nombre}")
    public Saludador met3(@PathVariable String nombre){
        return new Saludador(nombre);
    }

    @RequestMapping("saludador2/{nombreX}")
    public Saludador met4(@PathVariable("nombreX") String nombre){
        System.out.println("Nombre recibido: " + nombre);
        saludador = new Saludador(nombre);
        return saludador;
    }

    @RequestMapping("/")
    public String indice(){
        return """
            <h1>Menú principal</h1>
            <ul>
                <li><a href='/saludos'>/saludos/</a></li>
                <li><a href='/despedidas'>/despedidas/</a></li>
                <li>/nombramientos (Post - Put - Delete)</li>
                <li><a href='/saludador/default'>/saludador/{nombre}</a></li>
                <li><a href='/saludador2/default2'>/saludador2/{nombreX}</a></li>
                <li> crearSaludador (Post) </li>
                <li><a href='/obtenerSaludador'>/obtenerSaludador</a></li>
            </ul>
               """;
    }

    Saludador saludador;

    @PostMapping("/crearSaludador")
    public void crearSaludador(@RequestBody Saludador nombre){
        saludador = nombre;
    }

    @GetMapping("/obtenerSaludador")
    public Saludador obtenerSaludador(){
        return saludador;
    }

    @GetMapping("/getQuery")
    public String GetQuertString(@RequestParam String nombre, @RequestParam String paterno){
        return nombre + "" + paterno;
    }
}