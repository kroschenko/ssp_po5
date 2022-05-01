package com.example;

import java.sql.Date;

public final class Order {
    private Integer id;
    private String customer;
    private String worker;
    private Date date;
    private Double price;
    private String cpu;
    private String gpu;

    public Order(final Integer id, final String customer, final String worker, final Date date, final Double price,
            final String cpu, final String gpu) {
        this.id = id;
        this.customer = customer;
        this.worker = worker;
        this.date = date;
        this.price = price;
        this.cpu = cpu;
        this.gpu = gpu;
    }

    public final Integer getId() {
        return this.id;
    }

    public final void setId(final Integer id) {
        this.id = id;
    }

    public final String getCustomer() {
        return this.customer;
    }

    public final void setCustomer(final String customer) {
        this.customer = customer;
    }

    public final String getWorker() {
        return this.worker;
    }

    public final void setWorker(final String worker) {
        this.worker = worker;
    }

    public final Date getDate() {
        return this.date;
    }

    public final void setDate(final Date date) {
        this.date = date;
    }

    public final Double getPrice() {
        return this.price;
    }

    public final void setPrice(final Double price) {
        this.price = price;
    }

    public final String getCpu() {
        return this.cpu;
    }

    public final void setCpu(final String cpu) {
        this.cpu = cpu;
    }

    public final String getGpu() {
        return this.gpu;
    }

    public final void setGpu(final String gpu) {
        this.gpu = gpu;
    }
}
