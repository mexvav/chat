package com.github.mexvav.chat.services.user;

import com.github.mexvav.chat.exceptions.UserNotFoundException;
import com.github.mexvav.chat.models.UserModel;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public interface UserService {

    @NotNull
    UserModel create(@NotNull UserModel model);

    @NotNull
    Optional<UserModel> get(@NotNull String name);

    @NotNull
    UserModel update(@NotNull UserModel model) throws UserNotFoundException;

    void delete(@NotNull UserModel model) throws UserNotFoundException;
}
