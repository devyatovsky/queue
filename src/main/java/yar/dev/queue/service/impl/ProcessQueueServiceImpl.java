package yar.dev.queue.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yar.dev.queue.dto.QueueDto;
import yar.dev.queue.entity.QueueEntity;
import yar.dev.queue.exception.IncorrectValueException;
import yar.dev.queue.service.ProcessQueueService;
import yar.dev.queue.service.QueueDataService;
import yar.dev.queue.service.QueueService;

@Service
@RequiredArgsConstructor
public class ProcessQueueServiceImpl implements ProcessQueueService {

    private final QueueDataService queueDataService;
    private final QueueService queueService;

    @Override
    public QueueDto getNextQueueValue() throws IncorrectValueException {
        String lastCode = queueDataService.getLastCode();
        String generatedCode = queueService.generateCode(lastCode);
        QueueEntity savedEntity = queueDataService.save(generatedCode);
        return new QueueDto(savedEntity.getId(), savedEntity.getValue());
    }

}
