package ru.asgubin.rsr.clients.rest.rsrfmea;

import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ru.asgubin.rsr.clients.rest.rsrfmea.model.EquipmentGroup;

import java.io.IOException;

public class DaoEquipmentGroup {
    private static final String TABLE = "/eqGroup";

    private DaoEquipmentGroup() {
    }

    private static class SingletonHelper {
        private static final DaoEquipmentGroup INSTANCE = new DaoEquipmentGroup();
    }

    public static DaoEquipmentGroup getInstance() {
        return DaoEquipmentGroup.SingletonHelper.INSTANCE;
    }

    public EquipmentGroup getById(int id) throws IOException {

        WebTarget webTarget = RsrFmeaTargetFactory.getInstance().getWebTarget();

        Response response = webTarget
                .path(TABLE)
                .path(String.valueOf(id))
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        if (response.getStatus() != 200) {
            throw new IOException(response.readEntity(String.class));
        }

        return response.readEntity(EquipmentGroup.class);
    }

    public EquipmentGroup getByEventId(String eventId) throws IOException {

        WebTarget webTarget = RsrFmeaTargetFactory.getInstance().getWebTarget();

        Response response = webTarget
                .path(TABLE + "/event")
                .path(eventId)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        if (response.getStatus() != 200) {
            throw new IOException(response.readEntity(String.class));
        }

        return response.readEntity(EquipmentGroup.class);
    }
}
