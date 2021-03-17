package com.spring.professional.exam.tutorial.module03.question18.service;

import com.spring.professional.exam.tutorial.module03.question18.exception.CustomException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Transactional
    public void methodWithUncheckedExceptionCausingRollback() {
        throw new IllegalArgumentException("test unchecked exception that will cause rollback");
    }

    @Transactional
    public void methodWithCheckedExceptionNotCausingRollback() throws CustomException {
        throw new CustomException("test checked exception that will not cause rollback");
    }

    @Transactional(noRollbackFor = IllegalArgumentException.class)
    public void methodWithUncheckedExceptionNotCausingRollback() {
        throw new IllegalArgumentException("test unchecked exception that will not cause rollback because of noRollbackFor field");
    }

    @Transactional(rollbackFor = CustomException.class)
    public void methodWithCheckedExceptionCausingRollback() throws CustomException {
        throw new CustomException("test checked exception that will cause rollback because of rollbackFor field");
    }
}
