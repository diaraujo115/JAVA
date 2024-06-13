package com.empresa.model;

public class Venda {
    private int id;
    private String nomeVeiculo;
    private double valor;
    private Vendedor vendedor;

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeVeiculo() {
        return nomeVeiculo;
    }

    public void setNomeVeiculo(String nomeVeiculo) {
        this.nomeVeiculo = nomeVeiculo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", nomeVeiculo='" + nomeVeiculo + '\'' +
                ", valor=" + valor +
                ", vendedor=" + vendedor +
                '}';
    }
}
