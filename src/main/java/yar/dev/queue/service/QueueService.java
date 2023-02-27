package yar.dev.queue.service;

import yar.dev.queue.exception.IncorrectValueException;


/**
 * Сервис для реализации алгоритма получения следующего талона
 */
public interface QueueService {

    /**
     * Алгоритм инкремента очереди
     * @param currentCode значение очереди, которое нужно инкриминировать
     * @return Новое сгенерированное значение очереди
     */
    String generateCode(String currentCode) throws IncorrectValueException;
}
