package com.virtusa;

public class GetPlanFactory {

    public Plan getPlan(String type) {
        if(type==null) {
            return null;
        }
        if(type.equalsIgnoreCase("singleplan")) {
            return new SinglePlan();
        } else if(type.equalsIgnoreCase("familyplan")) {
            return new FamilyPlan();
        } else {
            return null;
        }
    }
}
