package com.messias.payment.application.ports.out;

import com.messias.payment.application.core.domain.User;

public interface UpdateUserOutputPort {

    void update(User user);
}
