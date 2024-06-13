package com.empresa;

import com.empresa.model.Vendedor;
import com.empresa.model.Venda;
import com.empresa.service.VendedorService;
import com.empresa.service.VendaService;

public class Main {
    public static void main(String[] args) {
        VendedorService vendedorService = new VendedorService();
        VendaService vendaService = new VendaService();

        // Cadastro de Vendedores
        Vendedor vendedor1 = new Vendedor();
        vendedor1.setId(1);
        vendedor1.setNome("João");
        vendedor1.setSalario(2000.00);
        vendedor1.setComissao(0.1);
        vendedorService.cadastrarVendedor(vendedor1);

        // Cadastro de Vendas
        Venda venda1 = new Venda();
        venda1.setId(1);
        venda1.setVendedor(vendedor1);
        venda1.setValor(30000.00);
        vendaService.cadastrarVenda(venda1);

        // Listagem de Vendedores
        System.out.println("Vendedores cadastrados: " + vendedorService.listarVendedores());

        // Listagem de Vendas
        System.out.println("Vendas cadastradas: " + vendaService.listarVendas());

        // Edição de Salário
        vendedorService.editarSalario(1, 2500.00);

        // Edição de Comissão
        vendedorService.editarComissao(1, 0.15);

        // Listagem de Vendas por Vendedor
        System.out.println("Vendas do vendedor João: " + vendaService.listarVendasPorVendedor(1));

        // Edição de Valor de Veículo
        vendaService.editarValorVeiculo(1, 28000.00);
    }
}
