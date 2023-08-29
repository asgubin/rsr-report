package ru.asgubin.rsr.clients.rest.rsrdb;

import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ru.asgubin.rsr.clients.rest.rsrdb.model.Param;

import java.io.IOException;
import java.util.List;

public class DaoParamDb {

    private static final String TABLE = "/params";

    private DaoParamDb() {
    }

    private static class SingletonHelper {
        private static final DaoParamDb INSTANCE = new DaoParamDb();
    }

    public static DaoParamDb getInstance() {
        return DaoParamDb.SingletonHelper.INSTANCE;
    }

    public List<Param> getCcfParamsByCcfGroupId(String rsrDbName, int ccfGroupNum)
            throws IOException {

        WebTarget webTarget = RsrDbWebTargetFactory.getInstance().getWebTarget(rsrDbName);

        Response response = webTarget
                .path(TABLE + "/ccfGroup")
                .path(String.valueOf(ccfGroupNum))
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        if (response.getStatus() != 200) {
            throw new IOException(response.readEntity(String.class));
        }

        return response.readEntity(new GenericType<List<Param>>(){});
    }

    public List<Param> getParamsByEventNum(String rsrDbName, int eventNum)
            throws IOException {

        WebTarget webTarget = RsrDbWebTargetFactory.getInstance().getWebTarget(rsrDbName);

        Response response = webTarget
                .path(TABLE + "/event")
                .path(String.valueOf(eventNum))
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        if (response.getStatus() != 200) {
            throw new IOException(response.readEntity(String.class));
        }

        return response.readEntity(new GenericType<List<Param>>(){});
    }
}
