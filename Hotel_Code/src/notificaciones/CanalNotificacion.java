package notificaciones;

public interface CanalNotificacion {
    void enviar(String destinatario, String mensaje);
}
