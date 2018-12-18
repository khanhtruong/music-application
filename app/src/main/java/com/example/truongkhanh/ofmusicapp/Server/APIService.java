package com.example.truongkhanh.ofmusicapp.Server;

public class APIService {
    private static String base_url = "https://app-1542704100.000webhostapp.com/API%20web%20Server/";

    public static Dataservice getService()
    {
        return APIRetrofitClient.getClient(base_url).create(Dataservice.class);
    }
}
