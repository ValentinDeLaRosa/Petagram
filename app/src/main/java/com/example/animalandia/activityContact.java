package com.example.animalandia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Properties;
import android.hardware.input.InputManager;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class activityContact extends AppCompatActivity {
    String correo;
    String contrasena;

    EditText mensaje;
    Button enviar;
    Session session;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        //Parte del correo java
        mensaje = (EditText)findViewById(R.id.txtMensaje);
        enviar = (Button)findViewById(R.id.botonEnviar);

        correo = "delarosa0628@gmail.com";   //PONER AQUI SU USUARIO Y CONTRASEÑA
        contrasena = "Syngates";
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Properties properties = new Properties();
                properties.put("mail.smtp.host", "smtp.googlemail.com");
                properties.put("mail.smtp.socketFactory.port", "465");
                properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.port", "465");

                try {
                    session = Session.getDefaultInstance(properties, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(correo, contrasena);
                        }
                    });

                    if (session!=null){
                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress((correo)));
                        message.setSubject("Correo petagram javamil");
                        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("delarosa0628@gmail.com"));
                        message.setContent(mensaje.getText().toString(), "text/html; charset=utf-8");

                        Transport.send(message);

                    }

                }
                catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });
    }
}