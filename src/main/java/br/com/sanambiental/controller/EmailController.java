package br.com.sanambiental.controller;

import br.com.sanambiental.util.EmailUtil;
import org.apache.commons.mail.EmailException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "email")
public class EmailController {

    @RequestMapping(value = "enviar/{nome}/{texto}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public String enviarEmail(@PathVariable String nome, @PathVariable String texto) throws EmailException {
        StringBuilder msg = new StringBuilder();
        msg.append("Nome: ");
        msg.append(nome);
        msg.append("\n");
        msg.append("Mensagem: ");
        msg.append(texto);
        EmailUtil.enviarEmail(msg.toString());
        return "Mensagem enviada com sucesso!";
    }
}
