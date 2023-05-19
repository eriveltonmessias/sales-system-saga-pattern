package com.messias.payment.application.core.usecase;

import com.messias.payment.application.core.domain.User;
import com.messias.payment.application.ports.in.FindUserByIdInputPort;
import com.messias.payment.application.ports.out.FindUserByIdOutputPort;

public class FindUserByIdUseCase implements FindUserByIdInputPort {

    private FindUserByIdOutputPort findUserByIdOutputPort;

    public FindUserByIdUseCase(FindUserByIdOutputPort findUserByIdOutputPort) {
        this.findUserByIdOutputPort = findUserByIdOutputPort;
    }

    @Override
    public User find(final Integer id){
        return this.findUserByIdOutputPort.find(id)
                .orElseThrow(()-> new RuntimeException("Usuario não encontrado"));
    }
}
