package com.github.mexvav.chat.services.user;

import com.github.mexvav.chat.exceptions.UserNotFoundException;
import com.github.mexvav.chat.models.UserModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    @Test
    public void test() throws UserNotFoundException {
        String name = "name";
        UserModel model = new UserModel(name);

        UserStorage storage = new InMemoryUserStorage();
        UserService service = new UserServiceImpl(storage);

        Assertions.assertFalse(service.get(name).isPresent());
        Assertions.assertEquals(model, service.create(model));
        Assertions.assertTrue(service.get(name).isPresent());

        service.delete(model);

        Assertions.assertFalse(service.get(name).isPresent());
    }

}