package com.enes.expensetracker.service.mapper;


import com.enes.expensetracker.model.Transaction;
import com.enes.expensetracker.model.dto.request.transaction.TransactionRequest;
import com.enes.expensetracker.model.dto.response.transaction.TransactionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionMapper {

    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    @Mapping(source="userid",target="user.id")
    Transaction toTransaction(TransactionRequest transactionRequest);

    @Mapping(source="user.id",target="userid")
    TransactionResponse fromTransaction(Transaction transaction);

}
