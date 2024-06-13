package com.empresa.service;

import com.empresa.model.Venda;
import com.empresa.model.Vendedor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VendaService {
    private Connection connection;
    private VendedorService vendedorService;
    private static final double COMISSAO_PERCENTUAL = 0.05;

    public VendaService(VendedorService vendedorService) {
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/comissaovendas", "root", "");
            this.vendedorService = vendedorService;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   public void cadastrarVenda(Venda venda) {
        String sql = "INSERT INTO Venda (nomeVeiculo, valor, vendedorId, comissao) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            double comissao = venda.getValor() * COMISSAO_PERCENTUAL;
            venda.setComissao(comissao);
            
            stmt.setString(1, venda.getNomeVeiculo());
            stmt.setDouble(2, venda.getValor());
            stmt.setInt(3, venda.getVendedor().getId());
            stmt.setDouble(4, comissao);
            stmt.executeUpdate();
            
            // Atualizar a comissão do vendedor
            atualizarComissaoVendedor(venda.getVendedor().getId(), comissao);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void atualizarComissaoVendedor(int vendedorId, double comissao) {
        String sql = "UPDATE Vendedor SET comissao = comissao + ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, comissao);
            stmt.setInt(2, vendedorId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void excluirVenda(int id) {
    String sql = "DELETE FROM Venda WHERE id = ?";
    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, id);
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    public List<Venda> listarVendas() {
        List<Venda> vendas = new ArrayList<>();
        String sql = "SELECT * FROM Venda";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Venda venda = new Venda();
                venda.setId(rs.getInt("id"));
                venda.setNomeVeiculo(rs.getString("nomeVeiculo"));
                venda.setValor(rs.getDouble("valor"));
                int vendedorId = rs.getInt("vendedorId");
                venda.setVendedor(vendedorService.listarVendedores().stream()
                        .filter(v -> v.getId() == vendedorId)
                        .findFirst()
                        .orElse(null));
                vendas.add(venda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vendas;
    }

    public List<Venda> listarVendasPorVendedor(int vendedorId) {
        List<Venda> vendasVendedor = new ArrayList<>();
        String sql = "SELECT * FROM Venda WHERE vendedorId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, vendedorId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Venda venda = new Venda();
                    venda.setId(rs.getInt("id"));
                    venda.setNomeVeiculo(rs.getString("nomeVeiculo"));
                    venda.setValor(rs.getDouble("valor"));
                    venda.setVendedor(vendedorService.listarVendedores().stream()
                            .filter(v -> v.getId() == vendedorId)
                            .findFirst()
                            .orElse(null));
                    vendasVendedor.add(venda);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vendasVendedor;
    }
}
