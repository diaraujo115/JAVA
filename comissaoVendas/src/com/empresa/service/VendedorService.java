package com.empresa.service;

import com.empresa.model.Vendedor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VendedorService {
    private Connection connection;

    public VendedorService() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/comissaovendas", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cadastrarVendedor(Vendedor vendedor) {
        String sql = "INSERT INTO Vendedor (nome, cpf, salario, comissao) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, vendedor.getNome());
            stmt.setString(2, vendedor.getCpf());
            stmt.setDouble(3, vendedor.getSalario());
            stmt.setDouble(4, vendedor.getComissao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editarSalario(int id, double novoSalario) {
        String sql = "UPDATE Vendedor SET salario = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, novoSalario);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editarComissao(int id, double novaComissao) {
        String sql = "UPDATE Vendedor SET comissao = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, novaComissao);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void excluirVendedor(int id) {
    String sql = "DELETE FROM Vendedor WHERE id = ?";
    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, id);
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    public List<Vendedor> listarVendedores() {
        List<Vendedor> vendedores = new ArrayList<>();
        String sql = "SELECT * FROM Vendedor";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Vendedor vendedor = new Vendedor();
                vendedor.setId(rs.getInt("id"));
                vendedor.setNome(rs.getString("nome"));
                vendedor.setCpf(rs.getString("cpf"));
                vendedor.setSalario(rs.getDouble("salario"));
                vendedor.setComissao(rs.getDouble("comissao"));
                vendedores.add(vendedor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vendedores;
    }
}
