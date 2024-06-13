package com.empresa1;

import com.empresa.model.Vendedor;
import com.empresa.model.Venda;
import com.empresa.service.VendedorService;
import com.empresa.service.VendaService;

import javax.swing.*;
import java.util.List;

public class Main {
    private static VendedorService vendedorService = new VendedorService();
    private static VendaService vendaService = new VendaService(vendedorService);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            String opcao = exibirMenu();

            switch (opcao) {
                case "1":
                    inserirVendedor();
                    break;
                case "2":
                    listarVendedores();
                    break;
                case "3":
                    inserirVenda();
                    break;
                case "4":
                    listarVendas();
                    break;
                case "5":
                    excluirVendedor();
                    break;
                case "6":
                    excluirVenda();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
            }
        }
    }

    private static String exibirMenu() {
        String menu = "Menu:\n" +
                      "1. Inserir Vendedor\n" +
                      "2. Listar Vendedores\n" +
                      "3. Inserir Venda\n" +
                      "4. Listar Vendas\n" +
                      "5. Excluir Vendedor pelo ID\n" +
                      "6. Excluir Venda pelo ID\n" +
                      "0. Sair\n" +
                      "Escolha uma opção:";
        return JOptionPane.showInputDialog(menu);
    }

    private static void inserirVendedor() {
        String nome = JOptionPane.showInputDialog("Nome:");
        String cpf = JOptionPane.showInputDialog("CPF:");
        double salario = Double.parseDouble(JOptionPane.showInputDialog("Salário:"));
        double comissao = Double.parseDouble(JOptionPane.showInputDialog("Comissão:"));

        Vendedor vendedor = new Vendedor();
        vendedor.setNome(nome);
        vendedor.setCpf(cpf);
        vendedor.setSalario(salario);
        vendedor.setComissao(comissao);

        vendedorService.cadastrarVendedor(vendedor);
        JOptionPane.showMessageDialog(null, "Vendedor cadastrado com sucesso.");
    }

    private static void listarVendedores() {
        List<Vendedor> vendedores = vendedorService.listarVendedores();
        if (vendedores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum vendedor cadastrado.");
        } else {
            StringBuilder sb = new StringBuilder("Vendedores cadastrados:\n");
            for (Vendedor v : vendedores) {
                sb.append(v).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    private static void inserirVenda() {
        listarVendedores(); // Listar vendedores para escolha
        int vendedorId = Integer.parseInt(JOptionPane.showInputDialog("ID do Vendedor:"));

        Vendedor vendedor = vendedorService.listarVendedores().stream()
                .filter(v -> v.getId() == vendedorId)
                .findFirst()
                .orElse(null);

        if (vendedor == null) {
            JOptionPane.showMessageDialog(null, "Vendedor não encontrado.");
            return;
        }

        String nomeVeiculo = JOptionPane.showInputDialog("Nome do Veículo:");
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor:"));

        Venda venda = new Venda();
        venda.setNomeVeiculo(nomeVeiculo);
        venda.setValor(valor);
        venda.setVendedor(vendedor);

        vendaService.cadastrarVenda(venda);
        JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso.");
    }

    private static void listarVendas() {
        List<Venda> vendas = vendaService.listarVendas();
        if (vendas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma venda cadastrada.");
        } else {
            StringBuilder sb = new StringBuilder("Vendas cadastradas:\n");
            for (Venda v : vendas) {
                sb.append(v).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    private static void excluirVendedor() {
        listarVendedores(); // Listar vendedores para escolha
        int vendedorId = Integer.parseInt(JOptionPane.showInputDialog("ID do Vendedor a excluir:"));

        vendedorService.excluirVendedor(vendedorId);
        JOptionPane.showMessageDialog(null, "Vendedor excluído com sucesso.");
    }

    private static void excluirVenda() {
        listarVendas(); // Listar vendas para escolha
        int vendaId = Integer.parseInt(JOptionPane.showInputDialog("ID da Venda a excluir:"));

        vendaService.excluirVenda(vendaId);
        JOptionPane.showMessageDialog(null, "Venda excluída com sucesso.");
    }
}
