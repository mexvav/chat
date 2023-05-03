package com.github.mexvav.chat.services.user;

import com.github.mexvav.chat.exceptions.UserNotFoundException;
import com.github.mexvav.chat.models.UserModel;
import com.google.common.collect.Maps;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryUserStorage implements UserStorage{

    private final Map<String, UserModel> users = Maps.newHashMap();

    @Override
    public @NotNull UserModel create(@NotNull UserModel model) {
        users.put(model.getName(), model);
        return model;
    }

    @Override
    public @NotNull Optional<UserModel> get(@NotNull String name) {
        return Optional.ofNullable(users.get(name));
    }

    @Override
    public @NotNull UserModel update(@NotNull UserModel model) throws UserNotFoundException {
        get(model.getName()).orElseThrow(UserNotFoundException::new);
        users.put(model.getName(), model);
        return model;
    }

    @Override
    public void delete(@NotNull UserModel model) throws UserNotFoundException {
        get(model.getName()).orElseThrow(UserNotFoundException::new);
        users.remove(model.getName());
    }
}
