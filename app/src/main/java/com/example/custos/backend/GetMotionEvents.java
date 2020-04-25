package com.example.custos.backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class GetMotionEvents {
    private CloudConfigManager ccm = new CloudConfigManager();

    public Map<Date, String> getMotionEventsForTimes(String fromDate, String toDate) {
        // Due to isolation reasons we were unable to procure the device and flash the firmware.
        // Data is impossible to generate without the firmware present
        // This method is written to exercise the stack planned, but no actual values are returned
        Map<Date, String> eventsMap;
        // Inserting dummy data for demo purposes
        eventsMap = generateSampleEventData();
        try {
            URL url = composeUrlWithBase(ccm.getMotionEventsEndpointForTimes(fromDate, toDate));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Authorization", "Bearer " + ccm.getJwt());
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return eventsMap;
    }

    private URL composeUrlWithBase(String endpoint) throws MalformedURLException {
        return new URL(ccm.getAerialAgentUrl() + endpoint);
    }

    private Map<Date, String> generateSampleEventData() {
        Map<Date, String> sampleEventData = new HashMap<>();
        sampleEventData.put(new Date("1587849264"), "Kitchen");
        sampleEventData.put(new Date("1587842064"), "Kitchen");
        sampleEventData.put(new Date("1587827648"), "Bedroom");
        return sampleEventData;
    }

}
