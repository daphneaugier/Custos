package com.example.custos.backend;

import java.io.UnsupportedEncodingException;

class CloudConfigManager {
    private String aerialAgentUrl = "https://api.tests.aerial-tech.net/api/core/v1";
    private String studentOrgId = "0f9ac77e";
    private String deviceSerial = "STUDENT_SERIAL_1";
    // The token is set with a short expiry time, simply for demo purposes
    private String studentJwt = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9." +
            "eyJhdWQiOiJjb3JlIiwiaWF0IjoxNTg3ODQ5MjkwLCJpc3MiOiJqaXJvI" +
            "iwianRpIjoiMGY5YWM3N2UtMTc4MDVhMTkiLCJzdWIiOiIwZjlhYzc3ZS" +
            "IsInNjb3BlcyI6WyJvcmc6MGY5YWM3N2U6YWRtaW4iXSwidSI6InN0dWR" +
            "lbnRfdG9rZW4iLCJleHAiOjE1OTA5Njk1OTl9.UOyofuiA01Kpk-ZpOQq" +
            "AiFuRjZ8A-oRuqeJsdPV-g9Y";

    String getMotionEventsEndpointForTimes(String fromDate, String toDate) throws UnsupportedEncodingException {
        String motionEventsEndpoint = "/org/" + studentOrgId +
                "/thing/" + deviceSerial + "/motion/events?toDate=" + toDate +
                "&fromDate=" + fromDate;
        return java.net.URLEncoder.encode(motionEventsEndpoint, "utf-8");
    }

    String getJwt() {
        return studentJwt;
    }

    String getAerialAgentUrl() {
        return aerialAgentUrl;
    }
}
