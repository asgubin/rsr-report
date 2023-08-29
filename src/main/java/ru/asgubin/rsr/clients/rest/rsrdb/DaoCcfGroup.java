package ru.asgubin.rsr.clients.rest.rsrdb;

import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ru.asgubin.rsr.clients.rest.rsrdb.model.CcfGroup;

import java.io.IOException;
import java.util.List;

public class DaoCcfGroup {
    private static final String TABLE = "/ccfGroup";

    private DaoCcfGroup() {
    }

    private static class SingletonHelper {
        private static final DaoCcfGroup INSTANCE = new DaoCcfGroup();
    }

    public static DaoCcfGroup getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public List<CcfGroup> getAll(String rsrDbName) throws IOException {

        WebTarget webTarget = RsrDbWebTargetFactory.getInstance().getWebTarget(rsrDbName);

        Response response = webTarget
                .path(TABLE)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        if (response.getStatus() != 200) {
            throw new IOException(response.readEntity(String.class));
        }

        return response.readEntity(new GenericType<List<CcfGroup>>(){});
    }
}
