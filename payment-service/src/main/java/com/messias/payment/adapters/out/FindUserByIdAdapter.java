package com.messias.payment.adapters.out;

import com.messias.payment.adapters.out.repository.UserRepository;
import com.messias.payment.adapters.out.repository.mapper.UserEntityMapper;
import com.messias.payment.application.core.domain.User;
import com.messias.payment.application.ports.out.FindUserByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindUserByIdAdapter implements FindUserByIdOutputPort {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserEntityMapper userEntityMapper;
    @Override
    public Optional<User> find(Integer userId) {
        return this.userRepository.findById(userId)
                .map(userEntity -> userEntityMapper.toUser(userEntity));
    }
}
