package yar.dev.queue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class QueueDto {
    private UUID id;
    private String value;
}
