
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

class newStage {
    public newStage(String nim, String nama, String jk, String alamat)
    {
        GridPane gridLabel = new GridPane();
        gridLabel.setHgap(10.0D);
        gridLabel.setVgap(10.0D);

        Label pCustom = new Label("Pesan Custom");
        Label Lnim = new Label(nim);
        Label Lnama = new Label(nama);
        Label Ljk = new Label(jk);
        Label tAlamat = new Label(alamat);
        pCustom.setFont(javafx.scene.text.Font.font("Tahoma", javafx.scene.text.FontWeight.NORMAL, 20.0D));
        tAlamat.setMinHeight(50.0D);
        tAlamat.setAlignment(Pos.TOP_LEFT);
        //tAlamat.setDisable(true);
        gridLabel.add(pCustom, 0, 0);
        gridLabel.add(Lnim, 0, 1);
        
        gridLabel.add(Lnama, 0, 2);
        gridLabel.add(Ljk, 0, 3);
        gridLabel.add(tAlamat, 0, 5);

        gridLabel.setAlignment(Pos.CENTER);
        gridLabel.setMinHeight(300.0D);

        Scene scene = new Scene(gridLabel, 300.0D, 300.0D);
        Stage secondStage = new Stage();
        secondStage.setTitle("Anda sukses mendaftar");
        secondStage.setScene(scene);
        secondStage.show();
    }
}