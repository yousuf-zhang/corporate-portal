package cn.org.szdaxh.portal.common.enums;

import java.util.Optional;
import java.util.function.Predicate;

public interface BaseEnum<T> {
    T getCode();
    String getText();

    static <T extends Enum & BaseEnum> Optional<T> find(Class<T> type, Predicate<T> predicate) {
        if (type.isEnum()) {
            for (T enumDict : type.getEnumConstants()) {
                if (predicate.test(enumDict)) {
                    return Optional.of(enumDict);
                }
            }
        }
        return Optional.empty();
    }

    static <T extends Enum & BaseEnum<?>> Optional<T> findByCode(Class<T> type, Object value) {
        return find(type,
                e -> e.getCode() == value || e.getCode().equals(value) || String.valueOf(e.getCode()).equalsIgnoreCase(String.valueOf(value)));
    }

    static <T extends Enum & BaseEnum> Optional<T> findByText(Class<T> type, String text) {
        return find(type, e -> e.getText().equalsIgnoreCase(text));
    }
}
