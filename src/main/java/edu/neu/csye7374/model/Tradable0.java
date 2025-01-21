package edu.neu.csye7374.model;

public interface Tradable0 extends Tradable{

    @Override
    default void setBid(String bid){}

    @Override
    default String getMetric() {
        return "0";
    }
}
