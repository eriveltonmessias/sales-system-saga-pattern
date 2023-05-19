package com.messias.payment.adapters.out;

import com.messias.payment.adapters.out.repository.UserRepository;
import com.messias.payment.adapters.out.repository.mapper.UserEntityMapper;
import com.messias.payment.application.core.domain.User;
import com.messias.payment.application.ports.out.UpdateUserOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserAdapter implements UpdateUserOutputPort {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserEntityMapper userEntityMapper;

    @Override
    public void update(User user) {
        userRepository.save(userEntityMapper.toUserEntity(user));
    }
}
