package com.ourcalendar.model.user.accepteddata;

import java.util.ArrayList;

public class AcceptedData {
    ArrayList<DayAccepted> theirСomments = new ArrayList<>();

    public void setData(String rawTheirComments){
        for (String comm: rawTheirComments.split("#@@#")) {
            String[] mes = comm.split("##!!##");
            DayAccepted dayAccepted = new DayAccepted();
            dayAccepted.setDay(Integer.parseInt(mes[0]));
            dayAccepted.setMonth(Integer.parseInt(mes[1]));
            dayAccepted.setYear(Integer.parseInt(mes[2]));
            dayAccepted.setMessage(mes[3]);
            theirСomments.add(dayAccepted);
        }
    }
    public ArrayList<DayAccepted> getData(){
        return theirСomments;
    }
}
