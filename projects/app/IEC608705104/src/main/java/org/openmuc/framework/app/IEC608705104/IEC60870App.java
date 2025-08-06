package org.openmuc.framework.app.IEC608705104;

import org.openmuc.framework.data.IntValue;
import org.openmuc.framework.data.Value;
import org.openmuc.framework.data.ValueType;
import org.openmuc.framework.dataaccess.*;
import org.openmuc.framework.data.Record;
import org.osgi.service.component.annotations.*;

@Component(immediate = true)
public class IEC60870App {

    @Reference
    private DataAccessService dataAccessService;

    private Channel readChannel;
    private Channel writeChannel;

    private final RecordListener listener = new RecordListener() {
        @Override
        public void newRecord(Record record) {
            System.out.println("Received from IEC client: " + record.getValue());

            Value value = record.getValue();
            if (value != null && value.getValueType() == ValueType.INTEGER) {
                int original = value.asInt();
                int newVal = original + 1; // Increment the received value

                try {
                    writeChannel.write(new IntValue(newVal));
                    System.out.println("Wrote (incremented): " + newVal);
                } catch (Exception e) {
                    System.err.println("Write failed: " + e.getMessage());
                }
            } else {
                System.out.println("Received non-integer value; skipping write.");
            }
        }
    };

    @Activate
    public void activate() {
        try {
            readChannel = dataAccessService.getChannel("iec_in");
            writeChannel = dataAccessService.getChannel("iec_out");

            readChannel.addListener(listener);
            System.out.println("Listening on channel: iec_in");

        } catch (Exception e) {
            System.err.println("Activation failed: " + e.getMessage());
        }
    }

    @Deactivate
    public void deactivate() {
        try {
            if (readChannel != null) {
                readChannel.removeListener(listener);
                System.out.println("Listener removed from: iec_in");
            }
        } catch (Exception e) {
            System.err.println("Deactivation failed: " + e.getMessage());
        }
    }
}
