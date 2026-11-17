package org.test.servicioweb.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.test.servicioweb.model.Usuario;
import org.test.servicioweb.service.UsuarioService;

import java.util.List;

public class UsuarioController {
    @FXML
    private Label lblUsuario;

    @FXML
    private Button btnConsultar;

    @FXML
    private TableView<Usuario> tblUsuarios;
    @FXML
    private TableColumn<Usuario, Integer > colId;
    @FXML
    private TableColumn<Usuario , String> colNombre;
    @FXML
    private TableColumn<Usuario , String> colUsername;
    @FXML
    private TableColumn<Usuario , String> colEmail;
    @FXML
    private TableColumn<Usuario , String> colTelefono;
    @FXML
    private TableColumn<Usuario , String> colCiudad;
    @FXML
    private TableColumn<Usuario , String> colEmpresa;

    private final UsuarioService servicio = new UsuarioService();
    @FXML
    public void initialize(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colCiudad.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        colEmpresa.setCellValueFactory(new PropertyValueFactory<>("empresa"));
    }

    @FXML
    public void consultarDatos(){
        try {
            List<Usuario> usuarios = servicio.obtenerUsuarios();
            tblUsuarios.setItems(FXCollections.observableArrayList(usuarios));
            lblUsuario.setText("Usuarios cargados: " + usuarios.size());
        } catch (Exception e){
            lblUsuario.setText("Error al consultar datos" + e.getMessage());
        }
    }
}
