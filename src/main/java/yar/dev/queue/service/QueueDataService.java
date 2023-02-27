package yar.dev.queue.service;


import yar.dev.queue.entity.QueueEntity;

/**
 * Дата-сервис для обработки значений из БД.
 */
public interface QueueDataService {

    /**
     * Получение последнего значения очереди из БД
     * @return последнее значение очереди из БД
     */
    String getLastCode();

    /**
     * Сохранение нового значения очереди
     * @param generatedCode Новое значение очереди
     */
    QueueEntity save(String generatedCode);
}
