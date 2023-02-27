package yar.dev.queue.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yar.dev.queue.entity.QueueEntity;
import yar.dev.queue.repository.QueueRepository;
import yar.dev.queue.service.QueueDataService;

@Service
@RequiredArgsConstructor
public class QueueDataServiceImpl implements QueueDataService {

    private final QueueRepository queueRepository;

    @Override
    public String getLastCode() {
        return queueRepository.findFirstByOrderByAddedDateDesc().getValue();
    }

    @Override
    public QueueEntity save(String generatedCode) {
        QueueEntity queueEntity = new QueueEntity();
        queueEntity.setValue(generatedCode);
        return queueRepository.save(queueEntity);
    }
}
