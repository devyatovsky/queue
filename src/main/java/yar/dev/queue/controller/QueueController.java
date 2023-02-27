package yar.dev.queue.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yar.dev.queue.dto.QueueDto;
import yar.dev.queue.exception.IncorrectValueException;
import yar.dev.queue.service.ProcessQueueService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/queue")
public class QueueController {

    private final ProcessQueueService processQueueService;

    @GetMapping("/last")
    public QueueDto getQueue() throws IncorrectValueException {
        return processQueueService.getNextQueueValue();
    }

}
