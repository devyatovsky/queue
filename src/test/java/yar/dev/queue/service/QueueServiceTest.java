package yar.dev.queue.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yar.dev.queue.exception.IncorrectValueException;


@SpringBootTest
class QueueServiceTest {

    @Autowired
    private QueueService queueService;

    @Test
    void generateCode_test() throws IncorrectValueException {
        Assertions.assertEquals("a0a1",
                queueService.generateCode("a0a0"),
                "Инкремент a0a0 должен дать результат a0a1");
        Assertions.assertEquals("a0b0",
                queueService.generateCode("a0a9"),
                "Инкремент a0a0 должен дать результат a0b0");
        Assertions.assertEquals("a1a0",
                queueService.generateCode("a0z9"),
                "Инкремент a0z9 должен дать результат a1a0");
        Assertions.assertEquals("a0a0a0",
                queueService.generateCode("z9z9"),
                "Инкремент z9z9 должен дать результат a0a0a0");
    }

    @Test
    void generateCode_fail() {
        Assertions.assertThrows(IncorrectValueException.class,
                () -> queueService.generateCode("a0"),
                "Метод должен упасть. Начальное значение должно начинаться с пары значений");
        Assertions.assertThrows(IncorrectValueException.class,
                () -> queueService.generateCode("as"),
                "Метод должен упасть. Начальное значение должно начинаться с пары значений и вида a0a0");
        Assertions.assertThrows(IncorrectValueException.class,
                () -> queueService.generateCode("99"),
                "Метод должен упасть. Начальное значение должно начинаться с пары значений и вида a0a0");
        Assertions.assertThrows(IncorrectValueException.class,
                () -> queueService.generateCode("aoao"),
                "Метод должен упасть. Начальное значение должно начинаться с пары значений и вида a0a0");
        Assertions.assertThrows(IncorrectValueException.class,
                () -> queueService.generateCode("A0a0"),
                "Метод должен упасть. Допускаются буквы английского алфавита в нижнем регистре");
        Assertions.assertThrows(IncorrectValueException.class,
                () -> queueService.generateCode("a0A0"),
                "Метод должен упасть. Допускаются буквы английского алфавита в нижнем регистре");
        Assertions.assertThrows(IncorrectValueException.class,
                () -> queueService.generateCode("A0A0"),
                "Метод должен упасть. Допускаются буквы английского алфавита в нижнем регистре");
        Assertions.assertThrows(IncorrectValueException.class,
                () -> queueService.generateCode("я0в0"),
                "Метод должен упасть. Допускаются буквы английского алфавита в нижнем регистре");
        Assertions.assertThrows(IncorrectValueException.class,
                () -> queueService.generateCode("a_a0"),
                "Метод должен упасть. Допускаются буквы английского алфавита в нижнем регистре прочих символов");
        Assertions.assertThrows(IncorrectValueException.class,
                () -> queueService.generateCode("a-1a0"),
                "Метод должен упасть. Допускаются буквы английского алфавита в нижнем регистре прочих символов");
        Assertions.assertThrows(IncorrectValueException.class,
                () -> queueService.generateCode("a-a0"),
                "Метод должен упасть. Допускаются буквы английского алфавита в нижнем регистре прочих символов");
    }
}