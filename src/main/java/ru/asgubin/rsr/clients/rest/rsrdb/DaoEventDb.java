package ru.asgubin.rsr.clients.rest.rsrdb;

import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ru.asgubin.rsr.clients.rest.rsrdb.model.Event;

import java.io.IOException;
import java.util.List;

public class DaoEventDb {
    private static final String TABLE = "/events";

    private DaoEventDb() {
    }

    private static class SingletonHelper {
        private static final DaoEventDb INSTANCE = new DaoEventDb();
    }

    public static DaoEventDb getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public List<Event> getCcfEventsByCcfGroupId(String rsrDbName, int ccfGroupId)
            throws IOException {

        WebTarget webTarget = RsrDbWebTargetFactory.getInstance().getWebTarget(rsrDbName);

        Response response = webTarget
                .path(TABLE + "/ccfGroup")
                .path(String.valueOf(ccfGroupId))
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        if (response.getStatus() != 200) {
            throw new IOException(response.readEntity(String.class));
        }

        return response.readEntity(new GenericType<List<Event>>(){});
    }

    public List<Event> getEventsByType(String rsrDbName, int type)
            throws IOException {

        WebTarget webTarget = RsrDbWebTargetFactory.getInstance().getWebTarget(rsrDbName);

        Response response = webTarget
                .path(TABLE + "/type")
                .path(String.valueOf(type))
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        if (response.getStatus() != 200) {
            throw new IOException(response.readEntity(String.class));
        }

        return response.readEntity(new GenericType<>() {});
    }

    public Event getEvent(String rsrDbName, int num) throws IOException {

        WebTarget webTarget = RsrDbWebTargetFactory.getInstance().getWebTarget(rsrDbName);

        Response response = webTarget
                .path(TABLE)
                .path(String.valueOf(num))
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        if (response.getStatus() != 200) {
            throw new IOException(response.readEntity(String.class));
        }

        return response.readEntity(Event.class);
    }

    public List<Event> getEventsByEventId(String rsrDbName, String id)
            throws IOException {

        WebTarget webTarget = RsrDbWebTargetFactory.getInstance().getWebTarget(rsrDbName);

        Response response = webTarget
                .path(TABLE + "/id")
                .path(id)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        if (response.getStatus() != 200) {
            throw new IOException(response.readEntity(String.class));
        }

        return response.readEntity(new GenericType<>() {});
    }
}
