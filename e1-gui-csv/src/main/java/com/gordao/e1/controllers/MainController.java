package com.gordao.e1.controllers;

import com.gordao.e1.model.*;
import com.gordao.e1.ui.*;
import com.gordao.e1.util.CsvUtil;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.*;
import java.util.stream.Collectors;

public class MainController {

  @FXML private ComboBox<String> entityPicker;
  @FXML private VBox formBox;
  @FXML private Button btnSave;
  @FXML private Label lblFile;

  private final Map<String, EntitySpec> registry = new LinkedHashMap<>();
  private final Map<String, Node> inputs = new HashMap<>();

  @FXML
  public void initialize() {
    buildRegistry(); // registra todas as 12 classes do seu UML

    entityPicker.getItems().addAll(registry.keySet());
    entityPicker.getSelectionModel().selectedItemProperty().addListener((obs, old, val) -> {
      if (val != null) renderForm(registry.get(val));
    });

    // seleciona a primeira por padrão
    if (!registry.isEmpty()) {
      entityPicker.getSelectionModel().selectFirst();
    }
  }

  private void renderForm(EntitySpec spec) {
    formBox.getChildren().clear();
    inputs.clear();
    lblFile.setText("data/" + spec.id + ".csv");

    for (FieldSpec f : spec.fields) {
      HBox row = new HBox(10);
      row.setPadding(new Insets(4, 0, 4, 0));
      Label lab = new Label(f.name + ":");
      lab.setMinWidth(160);

      Node input;
      switch (f.type) {
        case STRING:
          input = new TextField();
          ((TextField) input).setPromptText("texto");
          break;
        case INT:
          input = new TextField();
          ((TextField) input).setPromptText("inteiro");
          break;
        case DOUBLE:
          input = new TextField();
          ((TextField) input).setPromptText("decimal");
          break;
        case BOOLEAN:
          input = new CheckBox();
          break;
        default:
          input = new TextField();
      }
      row.getChildren().addAll(lab, input);
      formBox.getChildren().add(row);
      inputs.put(f.name, input);
    }
  }

  @FXML
  public void onSave() {
    String key = entityPicker.getValue();
    EntitySpec spec = registry.get(key);
    if (spec == null) return;

    try {
      Map<String,Object> values = new LinkedHashMap<>();
      for (FieldSpec f : spec.fields) {
        Node n = inputs.get(f.name);
        Object parsed = parseValue(f, n);
        values.put(f.name, parsed);
      }

      // instancia o objeto via factory
      Object instance = spec.factory.apply(values);
      if (instance == null) {
        alert("Erro", "Falha ao instanciar " + spec.id, Alert.AlertType.ERROR);
        return;
      }

      // persiste CSV
      List<String> header = spec.fields.stream().map(fs -> fs.name).collect(Collectors.toList());
      List<String> row = spec.fields.stream()
        .map(fs -> {
          Object v = values.get(fs.name);
          return v == null ? "" : String.valueOf(v);
        }).collect(Collectors.toList());

      CsvUtil.append(spec.id + ".csv", header, row);
      alert("Sucesso", spec.id + " salvo em " + ("data/" + spec.id + ".csv"), Alert.AlertType.INFORMATION);

      // limpa inputs
      for (Node n : inputs.values()) {
        if (n instanceof TextField) ((TextField) n).clear();
        if (n instanceof CheckBox) ((CheckBox) n).setSelected(false);
      }

    } catch (Exception ex) {
      alert("Erro", ex.getMessage(), Alert.AlertType.ERROR);
    }
  }

  private Object parseValue(FieldSpec f, Node n) {
    switch (f.type) {
      case STRING:
        return ((TextField) n).getText();
      case INT:
        String sI = ((TextField) n).getText();
        return sI == null || sI.isEmpty() ? 0 : Integer.parseInt(sI.trim());
      case DOUBLE:
        String sD = ((TextField) n).getText();
        return sD == null || sD.isEmpty() ? 0.0 : Double.parseDouble(sD.trim());
      case BOOLEAN:
        return ((CheckBox) n).isSelected();
      default:
        return null;
    }
  }

  private void alert(String title, String msg, Alert.AlertType type) {
    Alert a = new Alert(type);
    a.setTitle(title);
    a.setHeaderText(null);
    a.setContentText(msg);
    a.showAndWait();
  }

  private void buildRegistry() {
    // WIFI
    registry.put("Wifi", new EntitySpec(
      "Wifi",
      Arrays.asList(
        new FieldSpec("nomeRede", FieldType.STRING),
        new FieldSpec("senha", FieldType.STRING),
        new FieldSpec("conectado", FieldType.BOOLEAN)
      ),
      m -> new Wifi(
        (String)m.get("nomeRede"),
        (String)m.get("senha"),
        (Boolean)m.get("conectado"))
    ));

    // GAROTA
    registry.put("Garota", new EntitySpec(
      "Garota",
      Arrays.asList(
        new FieldSpec("nome", FieldType.STRING),
        new FieldSpec("idade", FieldType.INT),
        new FieldSpec("sotaque", FieldType.STRING)
      ),
      m -> new Garota(
        (String)m.get("nome"),
        (Integer)m.get("idade"),
        (String)m.get("sotaque"))
    ));

    // VIAGEM
    registry.put("Viagem", new EntitySpec(
      "Viagem",
      Arrays.asList(
        new FieldSpec("destino", FieldType.STRING),
        new FieldSpec("milhas", FieldType.INT),
        new FieldSpec("internacional", FieldType.BOOLEAN)
      ),
      m -> new Viagem(
        (String)m.get("destino"),
        (Integer)m.get("milhas"),
        (Boolean)m.get("internacional"))
    ));

    // GELEIA UVA
    registry.put("GeleiaUva", new EntitySpec(
      "GeleiaUva",
      Arrays.asList(
        new FieldSpec("tonalidade", FieldType.STRING),
        new FieldSpec("viscosidade", FieldType.DOUBLE),
        new FieldSpec("quantidade", FieldType.DOUBLE)
      ),
      m -> new GeleiaUva(
        (String)m.get("tonalidade"),
        (Double)m.get("viscosidade"),
        (Double)m.get("quantidade"))
    ));

    // MANTEIGA AMENDOIM
    registry.put("ManteigaAmendoim", new EntitySpec(
      "ManteigaAmendoim",
      Arrays.asList(
        new FieldSpec("textura", FieldType.STRING),
        new FieldSpec("oleosidade", FieldType.DOUBLE),
        new FieldSpec("quantidade", FieldType.DOUBLE)
      ),
      m -> new ManteigaAmendoim(
        (String)m.get("textura"),
        (Double)m.get("oleosidade"),
        (Double)m.get("quantidade"))
    ));

    // RETRATO MONA LISA
    registry.put("RetratoMonaLisa", new EntitySpec(
      "RetratoMonaLisa",
      Arrays.asList(
        new FieldSpec("larguraCm", FieldType.INT),
        new FieldSpec("alturaCm", FieldType.INT),
        new FieldSpec("fundo", FieldType.STRING)
      ),
      m -> new RetratoMonaLisa(
        (Integer)m.get("larguraCm"),
        (Integer)m.get("alturaCm"),
        (String)m.get("fundo"))
    ));

    // ASTRONAUTA
    registry.put("Astronauta", new EntitySpec(
      "Astronauta",
      Arrays.asList(
        new FieldSpec("nome", FieldType.STRING),
        new FieldSpec("traje", FieldType.STRING),
        new FieldSpec("emMissao", FieldType.BOOLEAN)
      ),
      m -> new Astronauta(
        (String)m.get("nome"),
        (String)m.get("traje"),
        (Boolean)m.get("emMissao"))
    ));

    // COMPUTADOR
    registry.put("Computador", new EntitySpec(
      "Computador",
      Arrays.asList(
        new FieldSpec("modelo", FieldType.STRING),
        new FieldSpec("memoriaRAM", FieldType.INT),
        new FieldSpec("ligado", FieldType.BOOLEAN)
      ),
      m -> new Computador(
        (String)m.get("modelo"),
        (Integer)m.get("memoriaRAM"),
        (Boolean)m.get("ligado"))
    ));

    // ROBO
    registry.put("Robo", new EntitySpec(
      "Robo",
      Arrays.asList(
        new FieldSpec("identificador", FieldType.STRING),
        new FieldSpec("funcao", FieldType.STRING),
        new FieldSpec("nivelBateria", FieldType.INT)
      ),
      m -> new Robo(
        (String)m.get("identificador"),
        (String)m.get("funcao"),
        (Integer)m.get("nivelBateria"))
    ));

    // LARANJA IRRITANTE
    registry.put("LaranjalIrritante", new EntitySpec(
      "LaranjalIrritante",
      Arrays.asList(
        new FieldSpec("nome", FieldType.STRING),
        new FieldSpec("volumeVoz", FieldType.INT),
        new FieldSpec("nivelIrritacao", FieldType.INT)
      ),
      m -> new LaranjalIrritante(
        (String)m.get("nome"),
        (Integer)m.get("volumeVoz"),
        (Integer)m.get("nivelIrritacao"))
    ));

    // MACA
    registry.put("Maca", new EntitySpec(
      "Maca",
      Arrays.asList(
        new FieldSpec("nome", FieldType.STRING),
        new FieldSpec("paciencia", FieldType.INT),
        new FieldSpec("estado", FieldType.STRING)
      ),
      m -> new Maca(
        (String)m.get("nome"),
        (Integer)m.get("paciencia"),
        (String)m.get("estado"))
    ));

    // FACA
    registry.put("Faca", new EntitySpec(
      "Faca",
      Arrays.asList(
        new FieldSpec("afiacao", FieldType.INT),
        new FieldSpec("material", FieldType.STRING),
        new FieldSpec("posicao", FieldType.STRING)
      ),
      m -> new Faca(
        (Integer)m.get("afiacao"),
        (String)m.get("material"),
        (String)m.get("posicao"))
    ));
  }
}
