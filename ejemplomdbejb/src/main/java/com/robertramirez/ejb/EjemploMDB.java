package com.robertramirez.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "MyQueue")
})
public class EjemploMDB implements MessageListener{

	@Override
	public void onMessage(Message msg) {
		TextMessage txtMsg = (TextMessage)msg;
		
		try {
			System.out.println("Mensaje recibido=" + txtMsg.getText());
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	@PostConstruct
	public void inicializar() {
		System.out.println("Inicializando componente");
	}
	
}
