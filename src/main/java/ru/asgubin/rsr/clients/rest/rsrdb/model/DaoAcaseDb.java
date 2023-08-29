package ru.asgubin.rsr.clients.rest.rsrdb;

import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ru.asgubin.rsr.clients.rest.rsrdb.model.Acase;

import java.io.IOException;

public class DaoAcaseDb {
    private static final String TABLE = "/acases";

    private DaoAcaseDb() {

    }

    private static class SingletonHelper {
        private static final DaoAcaseDb INSTANCE = new DaoAcaseDb();
    }

    public static DaoAcaseDb getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public Acase getEvent(String rsrDbName, int num) throws IOException {

        WebTarget webTarget = RsrDbWebTargetFactory.getInstance().getWebTarget(rsrDbName);

        Response response = webTarget
                .path(TABLE)
                .path(String.valueOf(num))
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        if (response.getStatus() != 200) {
            throw new IOException(response.readEntity(String.class));
        }

        return response.readEntity(Acase.class);
    }
}
