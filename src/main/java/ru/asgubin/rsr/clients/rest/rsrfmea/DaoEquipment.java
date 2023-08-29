package ru.asgubin.rsr.clients.rest.rsrfmea;

import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ru.asgubin.rsr.clients.rest.rsrfmea.model.Equipment;

import java.io.IOException;

public class DaoEquipment {

    private static final String TABLE = "/equipment";

    private DaoEquipment() {
    }

    private static class SingletonHelper {
        private static final DaoEquipment INSTANCE = new DaoEquipment();
    }

    public static DaoEquipment getInstance() {
        return DaoEquipment.SingletonHelper.INSTANCE;
    }

    public Equipment getByEventId(String eventId) throws IOException {

        WebTarget webTarget = RsrFmeaTargetFactory.getInstance().getWebTarget();

        Response response = webTarget
                .path(TABLE + "/event")
                .path(eventId)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        if (response.getStatus() != 200) {
            throw new IOException(response.readEntity(String.class));
        }

        return response.readEntity(Equipment.class);
    }
}
