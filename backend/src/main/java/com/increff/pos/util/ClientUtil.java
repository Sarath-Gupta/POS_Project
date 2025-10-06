package com.increff.pos.util;

import com.increff.pos.commons.ApiException;
import com.increff.pos.model.data.ClientData;
import com.increff.pos.model.form.ClientForm;
import com.increff.pos.entity.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClientUtil {

    //TODO: to use a generalised method for this conversion
    public static Client convert(ClientForm form) {
        Client pojo = new Client();
        pojo.setClientName(form.getClientName());
        return pojo;
    }

    public static ClientData convert(Client pojo) {
        ClientData data = new ClientData();
        data.setId(pojo.getId());
        data.setClientName(pojo.getClientName());
        return data;

    }

    public static List<ClientData> convert(List<Client> listClients) {
        List<ClientData> listData = new ArrayList<>();
        for(Client client : listClients) {
            ClientData data = new ClientData();
            data.setId(client.getId());
            data.setClientName(client.getClientName());
            listData.add(data);
        }
        return listData;
    }

//    public List<ClientForm> parse(MultipartFile file) throws IOException {
//        List<ClientForm> list = new ArrayList<>();
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
//            String line;
//            boolean firstLine = true;
//            while((line = br.readLine()) != null) {
//                if(firstLine) {
//                    firstLine = false;
//
//                }
//            }
//        }
//    }
}
