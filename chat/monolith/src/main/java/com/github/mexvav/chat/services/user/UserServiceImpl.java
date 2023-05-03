package com.github.mexvav.chat.services.user;

import com.github.mexvav.chat.exceptions.UserNotFoundException;
import com.github.mexvav.chat.models.UserModel;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserStorage storage;

    @Override
    public @NotNull UserModel create(@NotNull UserModel model) {
        return storage.create(model);
    }

    @Override
    public @NotNull Optional<UserModel> get(@NotNull String name) {
        return storage.get(name);
    }

    @Override
    public @NotNull UserModel update(@NotNull UserModel model) throws UserNotFoundException {
        return storage.update(model);
    }

    @Override
    public void delete(@NotNull UserModel model) throws UserNotFoundException {
        storage.delete(model);
    }
}
