package notificaciones;

public class NotificadorSlack implements CanalNotificacion {
    @Override
    public void enviar(String destinatario, String mensaje)
    {
        System.out.println("[Slack " + destinatario + "]" + mensaje);
    }
   
}
