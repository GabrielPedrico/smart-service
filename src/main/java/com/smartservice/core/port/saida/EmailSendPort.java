package com.smartservice.core.port.saida;

import javax.mail.MessagingException;

public interface EmailSendPort {

    void sendEmail(String emailDestino) throws MessagingException;
}
