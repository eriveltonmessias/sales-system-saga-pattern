package com.messias.payment.application.ports.in;

import com.messias.payment.application.core.domain.User;

public interface FindUserByIdInputPort {

    User find(Integer id);
}
