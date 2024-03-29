package mvc.connect;

public enum MessageType {
    FIELD, //при отправке приеме матрицы игрового поля
    SHOT, //при отправке приеме выстрела
    DEFEAT, //при отправке приеме поражения одного из игроков
    ACCEPTED, //при принятии сокета сервером
    DISCONNECT, //при отключении клиента
    MY_DISCONNECT;
}