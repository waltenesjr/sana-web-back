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
    public String enviarEmail(@PathVariable String nome, @PathVariable String texto) {
        StringBuilder msg = new StringBuilder();
        msg.append("Nome: ");
        msg.append(nome);
        msg.append("\n");
        msg.append("Mensagem: ");
        msg.append(texto);
        EmailUtil.enviarEmail(msg.toString());
        return "Mensagem enviada com sucesso!";
    }

    @RequestMapping(value = "wbox/{nome}/{empresa}/{telefone}/{email}/{msg}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public String enviarEmailWbox(@PathVariable String nome,
                                  @PathVariable String empresa,
                                  @PathVariable String telefone,
                                  @PathVariable String email,
                                  @PathVariable String msg) {
        StringBuilder content = new StringBuilder();
        content.append("Nome: ");
        content.append(nome);
        content.append("\n\n");
        content.append("Empresa: ");
        content.append(empresa);
        content.append("\n\n");
        content.append("Telefone: ");
        content.append(telefone);
        content.append("\n\n");
        content.append("Email: ");
        content.append(email);
        content.append("\n\n");
        content.append("Mensagem: ");
        content.append(msg);
        EmailUtil.smtpWBox(content.toString());
        return "Mensagem enviada com sucesso!";
    }
}