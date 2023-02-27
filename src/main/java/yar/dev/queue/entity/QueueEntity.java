package yar.dev.queue.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Table(name = "queue")
@Entity
public class QueueEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "queue_id", columnDefinition = "VARCHAR(36)")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    private String value;

    @CreationTimestamp
    private Timestamp addedDate;

}
