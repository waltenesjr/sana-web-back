package br.com.sanambiental.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailUtil {
    public static void enviarEmail(String msg) {
        SimpleEmail mail = new SimpleEmail();
        try {
            mail.setFrom("info@sanambiental.com.br", "sanambiental.com.br");
            mail.setSubject("Mensagem do site (sanambiental.com.br)");
            mail.setMsg(msg);
            mail.setSSLOnConnect(true);
            mail.setAuthentication("info@sanambiental.com.br", "@sana2018");
            mail.setHostName("mail.sanambiental.com.br");
            mail.setSmtpPort(25);
            mail.addTo("contato@sanambiental.com.br", "sanambiental.com.br");
            mail.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
