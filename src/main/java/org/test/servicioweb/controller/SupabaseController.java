package org.test.servicioweb.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.test.servicioweb.model.SupabaseModel;
import org.test.servicioweb.service.SupabaseService;

import java.util.List;

public class SupabaseController {

    @FXML private Label lblEstado;
    @FXML private Button btnConsultar;

    @FXML private TableView<SupabaseModel> tblDatos;
    @FXML private TableColumn<SupabaseModel, Integer> colId;
    @FXML private TableColumn<SupabaseModel, String> colNombre;
    @FXML private TableColumn<SupabaseModel, String> colApellido;
    @FXML private TableColumn<SupabaseModel, String> colEmail;
    @FXML private TableColumn<SupabaseModel, String> colTelefono;
    @FXML private TableColumn<SupabaseModel, String> colFechaNacimiento;
    @FXML private TableColumn<SupabaseModel, String> colPais;
    @FXML private TableColumn<SupabaseModel, String> colCiudad;
    @FXML private TableColumn<SupabaseModel, String> colDireccion;
    @FXML private TableColumn<SupabaseModel, Double> colIngresoAnual;
    @FXML private TableColumn<SupabaseModel, Integer> colPuntajeCredito;
    @FXML private TableColumn<SupabaseModel, Boolean> colTieneDeuda;
    @FXML private TableColumn<SupabaseModel, Double> colMontoDeuda;
    @FXML private TableColumn<SupabaseModel, String> colEstado;

    private final SupabaseService servicio = new SupabaseService();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colFechaNacimiento.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
        colPais.setCellValueFactory(new PropertyValueFactory<>("pais"));
        colCiudad.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        colIngresoAnual.setCellValueFactory(new PropertyValueFactory<>("ingresoAnual"));
        colPuntajeCredito.setCellValueFactory(new PropertyValueFactory<>("puntajeCredito"));
        colTieneDeuda.setCellValueFactory(new PropertyValueFactory<>("tieneDeuda"));
        colMontoDeuda.setCellValueFactory(new PropertyValueFactory<>("montoDeuda"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
    }

    @FXML
    public void consultarDatos() {
        try {
            List<SupabaseModel> lista = servicio.obtenerDatos();
            tblDatos.setItems(FXCollections.observableArrayList(lista));
            lblEstado.setText("Registros cargados: " + lista.size());
        } catch (Exception e) {
            lblEstado.setText("Error al consultar datos: " + e.getMessage());
        }
    }
}