package com.example.sweater.repos;

import com.example.sweater.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


/**
 * Здесь мы указываем класс объекта и класс идентификатора объекта, Message и Long.
 * Когда создается экземпляр этого репозитория, базовая логика автоматически устанавливается
 * для работы с нашим классом Message
 * Таким образом, с очень небольшим количеством кода мы уже можем начать использовать метод save().
 * */

public interface MessageRepo extends CrudRepository<Message, Long> {
    // название метода преобразуется в SQL запрос
    // https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html#jpa.query-methods.query-creation
    List<Message> findByTag(String tag);
}
