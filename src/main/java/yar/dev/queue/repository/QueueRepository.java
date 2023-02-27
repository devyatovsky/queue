package yar.dev.queue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yar.dev.queue.entity.QueueEntity;

import java.util.UUID;

/**
 * Репозиторий для работы с queue таблицей
 */
public interface QueueRepository extends JpaRepository<QueueEntity, UUID> {

    QueueEntity findFirstByOrderByAddedDateDesc();
}
