package yar.dev.queue.service.impl;


import org.springframework.stereotype.Service;
import yar.dev.queue.exception.IncorrectValueException;
import yar.dev.queue.service.QueueService;

import java.util.regex.Pattern;

@Service
public class QueueServiceImpl implements QueueService {

    private static final String ERROR_MESSAGE = "Некорректный вид значения: %s. Принимается формат вида: a0b1c2";
    private static final Pattern PATTERN = Pattern.compile("^[a-z]\\d[a-z]\\d([a-z]\\d)*");

    private static final char[] chars = new char[]{
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };

    @Override
    public String generateCode(String currentCode) throws IncorrectValueException {

        if (!PATTERN.matcher(currentCode).matches()) {
            throw new IncorrectValueException(String.format(ERROR_MESSAGE, currentCode));
        }

        if (mustAddNewStep(currentCode)) {
            return "a0".repeat(currentCode.length() / 2) + "a0";
        }

        var charArray = currentCode.toCharArray();

        for (int i = charArray.length - 1; i > 0; i -= 2) {
            var numeric = Character.getNumericValue(charArray[i]);

            if (charArray[i - 1] == 'z' && numeric == 9) {
                charArray[i] = '0';
                charArray[i - 1] = 'a';
            } else if (numeric < 9) {
                charArray[i] = (char) ((numeric + 1) + '0');
                return String.valueOf(charArray);
            } else if (numeric == 9) {
                charArray[i - 1] = getNextChar(charArray[i - 1]);
                charArray[i] = '0';
                return String.valueOf(charArray);
            }
        }
        throw new IncorrectValueException("Непредвиденная ошибка. Значение: " + currentCode);
    }

    public boolean mustAddNewStep(String str) {
        for (int i = 0; i < str.length(); i += 2) {
            if (str.charAt(i) != 'z' || str.charAt(i + 1) != '9') {
                return false;
            }
        }

        return true;
    }

    private char getNextChar(char c) {
        for (int i = 0; i < chars.length; i++) {
            if (c == chars[i]) {
                return chars[i + 1];
            }
        }
        return 'z';
    }

}
