package com.increff.pos.util;

import com.increff.pos.commons.ApiException;
import com.increff.pos.pojo.Client;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ConvertUtil {

    @Autowired
    private ModelMapper modelMapper;


    public <S,D> D convert(S source, Class<D> destinationClass) {
        return modelMapper.map(source, destinationClass);
    }

    public <S,D> List<D> convert(List<S> list, Class<D> destinationClass) {
        return list.stream()
                .map(source -> convert(source, destinationClass))
                .collect(Collectors.toList());
    }

    public void ifExists(Client client) throws ApiException{
        if(!Objects.isNull(client)) {
            throw new ApiException("Client already exists");
        }
    }

    public void ifNotExists(Client client) throws ApiException {
        if(Objects.isNull(client)) {
            throw new ApiException("Client doesn't exist");
        }
    }
}
