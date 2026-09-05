package notificaciones;

public class EnviadorSMS implements CanalNotificacion {
    @Override
    public void enviar(String destinatario, String mensaje)
    {
        System.out.println("[SMS " + destinatario + "]" + mensaje);
    }   
}
