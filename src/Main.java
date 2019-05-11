
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main {

    public static class Modul6 extends Application {

        RadioButton lk;
        RadioButton pr;
        TextField nimInput;
        TextField namaInput;
        TextField alamatInput;

        public Modul6() {
        }

        public void start(Stage primaryStage) {
            primaryStage.setTitle("Programming JavaFx !");

            GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(50.0D);
            grid.setVgap(50.0D);

            Text scenetitle = new Text("Masukkan Data Diri anda : ");
            Label nim = new Label("NIM: ");
            Label nama = new Label("Nama: ");
            Label jenis_kelamin = new Label("Jenis Kelamin: ");
            Label alamat = new Label("Alamat: ");

            lk = new RadioButton("Laki-laki");
            pr = new RadioButton("Perempuan");
            ToggleGroup kelaminGroup = new ToggleGroup();
            lk.setToggleGroup(kelaminGroup);
            pr.setToggleGroup(kelaminGroup);
            nimInput = new TextField("");
            namaInput = new TextField("");
            alamatInput = new TextField("");
            alamatInput.setMinHeight(.0D);
            alamatInput.setAlignment(Pos.TOP_LEFT);

            Button btnNew = new Button("New");
            Button btnEdit = new Button("Edit");
            Button btnDelete = new Button("Delete");
            btnNew.setOnAction((ActionEvent event) -> {
                String getJK;
                if (lk.isSelected()) {
                    getJK = lk.getText();
                } else if (pr.isSelected()) {
                    getJK = pr.getText();
                } else {
                    getJK = "Jenis Kelamin belum terinput";
                }

                new newStage(nimInput.getText(), namaInput.getText(), getJK, alamatInput.getText());

                nimInput.setDisable(true);
                namaInput.setDisable(true);
                alamatInput.setDisable(true);
                pr.setDisable(true);
                lk.setDisable(true);
            });
            btnEdit.setOnAction(event -> {
                nimInput.setDisable(false);
                namaInput.setDisable(false);
                alamatInput.setDisable(false);
                pr.setDisable(false);
                lk.setDisable(false);
            });
            btnDelete.setOnAction(event -> {
                nimInput.setText("");
                namaInput.setText("");
                alamatInput.setText("");
                pr.setSelected(false);
                lk.setSelected(false);
            });
            HBox hbBtn = new HBox(10.0D);
            hbBtn.setPadding(new Insets(20.0D));
            hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
            hbBtn.getChildren().add(btnNew);
            hbBtn.getChildren().add(btnEdit);
            hbBtn.getChildren().add(btnDelete);

            HBox hbJk = new HBox(10.0D);
            hbBtn.setPadding(new Insets(20.0D));
            hbJk.setAlignment(Pos.CENTER_LEFT);
            hbJk.getChildren().add(pr);
            hbJk.getChildren().add(lk);

            grid.add(scenetitle, 0, 0, 2, 1);
            grid.add(nim, 0, 1);
            grid.add(nama, 0, 2);
            grid.add(jenis_kelamin, 0, 3);
            grid.add(alamat, 0, 4);

            grid.add(nimInput, 1, 1);
            grid.add(namaInput, 1, 2);
            grid.add(hbJk, 1, 3);
            grid.add(alamatInput, 1, 4);
            grid.add(hbBtn, 1, 5);

            Scene scene = new Scene(grid, 300.0D, 275.0D);
            scene.setRoot(grid);

            scenetitle.setFont(javafx.scene.text.Font.font("Tahoma", FontWeight.NORMAL, 20.0D));

            primaryStage.setScene(scene);
            primaryStage.setMinHeight(500.0D);
            primaryStage.setMinWidth(500.0D);
            primaryStage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }
    }
}
