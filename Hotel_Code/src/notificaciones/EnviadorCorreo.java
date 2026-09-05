package notificaciones;

public class EnviadorCorreo implements CanalNotificacion {
    @Override
    public void enviar(String destinatario, String mensaje)
    {
        System.out.println("[Correo " + destinatario + "]" + mensaje);
    }
}
