package pe.edu.cibertec.vehiculos_frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import pe.edu.cibertec.vehiculos_frontend.viewmodel.ConsultaModel;

@Controller
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/inicio")
    public String inicio(Model model) {
        ConsultaModel consultaModel = new ConsultaModel("00", "", "", "",
                "", "", "");
        model.addAttribute("consultaModel", consultaModel);
        return "inicio";
    }

    @PostMapping("/consultar")
    public String consultar(@RequestParam("matricula") String matricula, Model model) {

        // condiciones de validación de campo matricula
        if (matricula == null || matricula.trim().length() == 0 || matricula.trim().length() > 7) {
            ConsultaModel consultaModel = new ConsultaModel("01", "Error: Ingrese una matricula válida.",
                    "", "", "", "", "");
            model.addAttribute("consultaModel", consultaModel);
            return "inicio";
        }

        return "inicio";
    }


}
