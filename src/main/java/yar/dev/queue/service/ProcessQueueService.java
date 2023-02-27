package yar.dev.queue.service;

import yar.dev.queue.dto.QueueDto;
import yar.dev.queue.exception.IncorrectValueException;

/**
 * Сервис для работы получения следующей очереди.
 */
public interface ProcessQueueService {

    /**
     * Получение следующего значения очереди на табло
     * @return следующее значение очереди
     */
    QueueDto getNextQueueValue() throws IncorrectValueException;
}
