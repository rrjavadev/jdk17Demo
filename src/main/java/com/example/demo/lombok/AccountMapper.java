package com.example.demo.lombok;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(target = "id", ignore = true)
    AccountTransferObject paymentToAchTransferObject(Account payment);
}
