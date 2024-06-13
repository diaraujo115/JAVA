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

    public VendaService(VendedorService vendedorService) {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ComissaoVendas", "root", "password");
            this.vendedorService = vendedorService;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cadastrarVenda(Venda venda) {
        String sql = "INSERT INTO Venda (nomeVeiculo, valor, vendedorId) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, venda.getNomeVeiculo());
            stmt.setDouble(2, venda.getValor());
            stmt.setInt(3, venda.getVendedor().getId());
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

    public void editarValorVeiculo(int id, double novoValor) {
        String sql = "UPDATE Venda SET valor = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, novoValor);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
