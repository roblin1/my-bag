import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.layout.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import java.io.File;

public class PlayNow extends Application implements EventHandler<ActionEvent> {
    Button btOpen, btPlay, btPause, btStop, vidPlay, vidStop;
    TextField tfPG, tfSG, tfSF, tfPF, tfC, tfPG1, tfSG1, tfSF1, tfPF1, tfC1;
    BorderPane pane;
    ListView<Roster> listView, listView1;
    MediaPlayer videoPlayer, musicPlayer;
    Label p1Selection, p2Selection;
    private final Image PHILLY = new Image("file:embiid.gif");
    private final Image BUCKS = new Image("file:giannis.jpg");
    private final Image BULLS = new Image("file:lavine.jpg");
    private final Image CAVS = new Image("file:love.jpg");
    private final Image CELTICS = new Image("file:kemba.jpg");
    private final Image CLIPPERS = new Image("file:kawhi.jpg");
    private final Image GRIZZLIES = new Image("file:morant.jpg");
    private final Image HAWKS = new Image("file:trae.jpg");
    private final Image HEAT = new Image("file:butler.png");
    private final Image HORNETS = new Image("file:rozier.gif");
    private final Image JAZZ = new Image("file:dmitch.jpg");
    private final Image KINGS = new Image("file:fox.jpg");
    private final Image KNICKS = new Image("file:randle.png");
    private final Image LAKERS = new Image("file:bron.png");
    private final Image MAGIC = new Image("file:vucevic.jpg");
    private final Image MAVS = new Image("file:porzingis.jpg");
    private final Image NETS = new Image("file:kyrie.jpg");
    private final Image NUGGETS = new Image("file:jokic.gif");
    private final Image PACERS = new Image("file:oladipo.jpg");
    private final Image PELICANS = new Image("file:zion.png");
    private final Image PISTONS = new Image("file:blake.jpg");
    private final Image RAPS = new Image("file:lowry.jpg");
    private final Image ROCKETS = new Image("file:harden.gif");
    private final Image SPURS = new Image("file:derozan.jpg");
    private final Image SUNS = new Image("file:booker.png");
    private final Image OKC = new Image("file:paul.jpg");
    private final Image TIMBS = new Image("file:kat.jpg");
    private final Image BLAZERS = new Image("file:dame.jpg");
    private final Image WARRIORS = new Image("file:curry.jpg");
    private final Image WIZARDS = new Image("file:beal.jpg");
    private final Image COUNTRYFOLK = new Image("file:manny.jpg");
    private Image[] listOfImages = {PHILLY, BUCKS, BULLS, CAVS, CELTICS, CLIPPERS, GRIZZLIES, HAWKS, HEAT, HORNETS, JAZZ, KINGS, KNICKS, LAKERS, MAGIC, MAVS, NETS, NUGGETS, PACERS, PELICANS, PISTONS, RAPS, ROCKETS, SPURS, SUNS, OKC, TIMBS, BLAZERS, WARRIORS, WIZARDS, COUNTRYFOLK};

    @Override
    public void start(Stage stage) {
        pane = new BorderPane();

        // displays NBA2K20 cover
        //Image image = new Image("file:cover.png");
        Image image = new Image("file:///C://Users/blade/IntellijProjects/HerHouse/nina.gif");
        ImageView imageView = new ImageView();
        imageView.setFitHeight(365);
        imageView.setFitWidth(260);
        imageView.setImage(image);
        pane.setCenter(imageView);

        // Player 1 NBA image
        ImageView imageView1 = new ImageView();
        imageView1.setFitHeight(305);
        imageView1.setFitWidth(285);
        imageView1.setTranslateX(10);
        imageView1.setTranslateY(10);
        pane.setLeft(imageView1);

        // Player 2 NBA image
        ImageView imageView2 = new ImageView();
        imageView2.setFitHeight(305);
        imageView2.setFitWidth(285);
        imageView2.setTranslateX(-25);
        imageView2.setTranslateY(10);
        pane.setRight(imageView2);

        // Dwyane Wade tribute video
        Media videoFile = new Media("file:///C://Users/blade/IntellijProjects/MyHouse/Budweiser.mp4");
        videoPlayer = new MediaPlayer(videoFile);
        VideoControl mediaControl = new VideoControl(videoPlayer);

        // Displays selected Team name on top
        HBox topSide = new HBox();
        Label blank1 = new Label("       ");
        p1Selection = new Label("  "); // Player 1 team selection
        p1Selection.setFont(Font.font("Impact", 16));
        p1Selection.setTextFill(Color.WHITE);

        Label blank2 = new Label("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
        p2Selection = new Label("  ");
        p2Selection.setFont(Font.font("Impact", 16));
        p2Selection.setTextFill(Color.WHITE);

        topSide.getChildren().addAll(blank1, p1Selection, blank2, p2Selection);
        pane.setTop(topSide);

        // Player One List View
        VBox leftTeams = new VBox();
        leftTeams.setPrefWidth(400);
        leftTeams.setStyle("-fx-border-color: black; ");
        Label posStops = new Label("   Player One");
        posStops.setFont(Font.font("Impact", 15));

        Roster t1 = new Roster("Philadelphia 76ers", "Ben Simmons", "Josh Richardson", "Tobias Harris", "Al Horford", "Joel Embiid");
        Roster t2 = new Roster("Milwaukee Bucks", "Eric Bledsoe", "Wesley Matthews", "Khris Middleton", "Giannis Antetokounmpo", "Brook Lopez");
        Roster t3 = new Roster("Chicago Bulls", "Kris Dunn", "Zach Lavine", "Otto Porter Jr.", "Lauri Marrkanen", "Wendell Carter Jr.");
        Roster t4 = new Roster("Cleveland Cavaliers", "Collin Sexton", "Darius Garland", "Cedi Osman", "Kevin Love", "Larry Nance Jr.");
        Roster t5 = new Roster("Boston Celtics", "Kemba Walker", "Jaylen Brown", "Gordon Hayward", "Jayson Tatum", "Enes Kanter");
        Roster t6 = new Roster("Los Angeles Clippers", "Patrick Beverly", "Landry Shamet", "Kawhi Leonard", "Paul George", "Ivica Zubac");
        Roster t7 = new Roster("Memphis Grizzlies", "Ja Morant", "Avery Bradley", "Andre Iguodala", "Jarren Jackson Jr.", "Jonas Valanciunas");
        Roster t8 = new Roster("Atlanta Hawks", "Trae Young", "Kevin Huerter", "De'Andre Hunter", "John Collins", "Alex Len");
        Roster t9 = new Roster("Miami Heat", "Goran Dragic", "Jimmy Butler", "Justice Winslow", "James Johnson", "Bam Adebayo");
        Roster t10 = new Roster("Charlotte Hornets", "Terry Rozier", "Nicolas Batum", "Miles Bridges", "Marvin Williams", "Bismack Biyombo");
        Roster t11 = new Roster("Utah Jazz", "Mike Conley", "Donovan Mitchell", "Joe Ingles", "Bojan Bogdanovic", "Rudy Gobert");
        Roster t12 = new Roster("Sacramento Kings", "De'Aaron Fox", "Buddy Hield", "Harrison Barnes", "Trevor Ariza", "Marvin Bagley III");
        Roster t13 = new Roster("New York Knicks", "Dennis Smith Jr.", "RJ Barrett", "Kevin Knox", "Julius Randle", "Mitchell Robinson");
        Roster t14 = new Roster("Los Angeles Lakers", "Rajon Rondo", "Danny Green", "Lebron James", "Anthony Davis", "Demarcus Cousin");
        Roster t15 = new Roster("Orlando Magic", "DJ Augustin", "Evan Fournier", "Jonathan Issac", "Aaron Gordon", "Nikola Vucevic");
        Roster t16 = new Roster("Dallas Mavericks", "Jalen Brunson", "Tim Hardaway Jr.", "Luka Doncic", "Kristaps Porzingis", "Dwight Powell");
        Roster t17 = new Roster("Brooklyn Nets", "Kyrie Irving", "Caris Levert", "Joe Harris", "Taurean Prince", "Deandre Jordan");
        Roster t18 = new Roster("Denver Nuggets", "Jamal Murray", "Gary Harris", "Will Barton", "Paul Millsap", "Nikola Jokic");
        Roster t19 = new Roster("Indiana Pacers", "Malcolm Brogdon", "Victor Oladipo", "T.J. Warren", "Domantas Sabonis", "Myles Turner");
        Roster t20 = new Roster("New Orleans Pelicans", "Lonzo Ball", "Jrue Holiday", "Brandon Ingram", "Zion Williamson", "Derrick Favors");
        Roster t21 = new Roster("Detroit Pistons", "Reggie Jackson", "Luke Kennard", "Bruce Brown", "Blake Griffin", "Andre Drummond");
        Roster t22 = new Roster("Toronto Raptors", "Kyle Lowry", "Norman Powell", "OG Anunoby", "Pascal Siakam", "Marc Gasol");
        Roster t23 = new Roster("Houston Rockets", "Russell Westbrook", "James Harden", "Eric Gordon", "P.J. Tucker", "Clint Capela");
        Roster t24 = new Roster("San Antonio Spurs", "Dejuounte Murray", "Derrick White", "Demar Derozan", "Lamarcus Aldridge", "Jakob Poeltl");
        Roster t25 = new Roster("Phoenix Suns", "Ricky Rubio", "Devin Booker", "Mikal Bridges", "Dario Saric", "Deandre Ayton");
        Roster t26 = new Roster("Oklahoma City Thunder", "Chris Paul", "Shai Gilgeous-Alexander", "Danilo Gallinari", "Patrick Patterson", "Steven Adams");
        Roster t27 = new Roster("Minnesota Timbewolves", "Jeff Teague", "Andrew Wiggins", "Robert Covington", "Jordan Bell", "Karl-Anthony Towns");
        Roster t28 = new Roster("Portland Trailblazers", "Damian Lillard", "CJ McCollum", "Kent Bazemore", "Zach Collins", "Hassan Whiteside");
        Roster t29 = new Roster("Golden State Warriors", "Stephen Curry", "D'Angelo Russell", "Alfonzo McKinnie", "Draymond Green", "Willie Cauley-Stein");
        Roster t30 = new Roster("Washington Wizards", "Isaiah Thomas", "Bradley Beal", "C.J. Miles", "Rui Hachimura", "Thomas Bryant");
        Roster bonus = new Roster("Country Folk", "Teren Destajo", "Emmanuel Benard", "Robert Lin", "Luis Abrogar", "Andrew Tam");

        ObservableList<Roster> oldTown = FXCollections.observableArrayList(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22, t23, t24, t25, t26, t27, t28, t29, t30, bonus);
        listView = new ListView<Roster>(oldTown);
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listView.setMaxHeight(250.0);
        listView.setOnMouseClicked(e -> { // clicking on team displays starting 5
            tfPG.setText(listView.getSelectionModel().getSelectedItem().getPG());
            tfSG.setText(listView.getSelectionModel().getSelectedItem().getSG());
            tfSF.setText(listView.getSelectionModel().getSelectedItem().getSF());
            tfPF.setText(listView.getSelectionModel().getSelectedItem().getPF());
            tfC.setText(listView.getSelectionModel().getSelectedItem().getC());
            p1Selection.setText(listView.getSelectionModel().getSelectedItem().getTeamName().toUpperCase());

            // displays player image according to the team selected
            if(listView.getSelectionModel().getSelectedItem().equals(t1)) imageView1.setImage(listOfImages[0]);
            else if(listView.getSelectionModel().getSelectedItem().equals(t2)) imageView1.setImage(listOfImages[1]);
            else if(listView.getSelectionModel().getSelectedItem().equals(t3)) imageView1.setImage(listOfImages[2]);
            else if(listView.getSelectionModel().getSelectedItem().equals(t4)) imageView1.setImage(listOfImages[3]);
            else if(listView.getSelectionModel().getSelectedItem().equals(t5)) imageView1.setImage(listOfImages[4]);
            else if(listView.getSelectionModel().getSelectedItem().equals(t6)) imageView1.setImage(listOfImages[5]);
            else if(listView.getSelectionModel().getSelectedItem().equals(t7)) imageView1.setImage(listOfImages[6]);
            else if(listView.getSelectionModel().getSelectedItem().equals(t8)) imageView1.setImage(listOfImages[7]);
            else if(listView.getSelectionModel().getSelectedItem().equals(t9)) imageView1.setImage(listOfImages[8]);
            else if(listView.getSelectionModel().getSelectedItem().equals(t10)) imageView1.setImage(listOfImages[9]);
            else if(listView.getSelectionModel().getSelectedItem().equals(t11)) imageView1.setImage(listOfImages[10]);
            else if(listView.getSelectionModel().getSelectedItem().equals(t12)) imageView1.setImage(listOfImages[11]);
            else if(listView.getSelectionModel().getSelectedItem().equals(t13)) imageView1.setImage(listOfImages[12]);
            else if(listView.getSelectionModel().getSelectedItem().equals(t14)) imageView1.setImage(listOfImages[13]);
            else if(listView.getSelectionModel().getSelectedItem().equals(t15)) imageView1.setImage(listOfImages[14]);
            else if(listView.getSelectionModel().getSelectedItem().equals(t16)) imageView1.setImage(listOfImages[15]);
            else if(listView.getSelectionModel().getSelectedItem().equals(t17)) imageView1.setImage(listOfImages[16]);
            else if(listView.getSelectionModel().getSelectedItem().equals(t18)) imageView1.setImage(listOfImages[17]);
            else if(listView.getSelectionModel().getSelectedItem().equals(t19)) imageView1.setImage(listOfImages[18]);
            else if(listView.getSelectionModel().getSelectedItem().equals(t20)) imageView1.setImage(listOfImages[19]);
            else if(listView.getSelectionModel().getSelectedItem().equals(t21)) imageView1.setImage(listOfImages[20]);
            else if(listView.getSelectionModel().getSelectedItem().equals(t22)) imageView1.setImage(listOfImages[21]);
            else if(listView.getSelectionModel().getSelectedItem().equals(t23)) imageView1.setImage(listOfImages[22]);
            else if(listView.getSelectionModel().getSelectedItem().equals(t24)) imageView1.setImage(listOfImages[23]);
            else if(listView.getSelectionModel().getSelectedItem().equals(t25)) imageView1.setImage(listOfImages[24]);
            else if(listView.getSelectionModel().getSelectedItem().equals(t26)) imageView1.setImage(listOfImages[25]);
            else if(listView.getSelectionModel().getSelectedItem().equals(t27)) imageView1.setImage(listOfImages[26]);
            else if(listView.getSelectionModel().getSelectedItem().equals(t28)) imageView1.setImage(listOfImages[27]);
            else if(listView.getSelectionModel().getSelectedItem().equals(t29)) imageView1.setImage(listOfImages[28]);
            else if(listView.getSelectionModel().getSelectedItem().equals(t30)) imageView1.setImage(listOfImages[29]);
            else if(listView.getSelectionModel().getSelectedItem().equals(bonus)) imageView1.setImage(listOfImages[30]); });
        leftTeams.getChildren().addAll(posStops, listView);

        // creates space between listview and Player One textfields
        VBox blankBox = new VBox();
        Label blank3 = new Label ("  \t");
        blankBox.getChildren().addAll(blank3);

        // Player One textfields
        VBox p1Roster = new VBox(4.5);
        p1Roster.setPrefWidth(250);
        Label away = new Label("AWAY");
        away.setFont(Font.font("Impact", 15));
        tfPG = new TextField();
        tfPG.setStyle("-fx-border-color: black; ");
        tfSG = new TextField();
        tfSG.setStyle("-fx-border-color: black; ");
        tfSF = new TextField();
        tfSF.setStyle("-fx-border-color: black; ");
        tfPF = new TextField();
        tfPF.setStyle("-fx-border-color: black; ");
        tfC = new TextField();
        tfC.setStyle("-fx-border-color: black; ");

        // video buttons
        btOpen = new Button("     OPEN MUSIC   ");
        btOpen.setStyle("-fx-border-color: black; ");
        btOpen.setFont(Font.font("Impact", 10));

        vidPlay = new Button("     PLAY VIDEO   ");
        vidPlay.setStyle("-fx-border-color: black; ");
        vidPlay.setFont(Font.font("Impact", 10));

        vidStop = new Button("     STOP   ");
        vidStop.setStyle("-fx-border-color: black; ");
        vidStop.setFont(Font.font("Impact", 10));

        p1Roster.getChildren().addAll(away, tfPG, tfSG, tfSF, tfPF, tfC, btOpen, vidPlay, vidStop);

        // Player One position labels
        VBox p1Position = new VBox(20);
        Label blank5 = new Label(" ");
        p1Position.getChildren().addAll(blank5);

        // creates space between Player One & Player Two textfields
        VBox blankBox2 = new VBox();
        Label blank6 = new Label ("\t\t\t\t\t\t\t");
        blankBox2.getChildren().addAll(blank6);

        // Player Two position labels
        VBox p2Position = new VBox(20);
        Label blank7 = new Label(" ");
        p2Position.getChildren().addAll(blank7);

        // Player Two textfields
        VBox p2Roster = new VBox(4.5);
        p2Roster.setPrefWidth(250);
        Label home = new Label("\t\t\t\t\t\t\t\t\tHOME");
        home.setFont(Font.font("Impact", 15));
        tfPG1 = new TextField();
        tfPG1.setStyle("-fx-border-color: black; ");
        tfSG1 = new TextField();
        tfSG1.setStyle("-fx-border-color: black; ");
        tfSF1 = new TextField();
        tfSF1.setStyle("-fx-border-color: black; ");
        tfPF1 = new TextField();
        tfPF1.setStyle("-fx-border-color: black; ");
        tfC1 = new TextField();
        tfC1.setStyle("-fx-border-color: black; ");

        // Music player buttons
        btPlay = new Button("     PLAY   ");
        btPlay.setStyle("-fx-border-color: black; ");
        btPlay.setFont(Font.font("Impact", 10));

        btPause = new Button("     PAUSE   ");
        btPause.setStyle("-fx-border-color: black; ");
        btPause.setFont(Font.font("Impact", 10));

        btStop = new Button("     STOP   ");
        btStop.setStyle("-fx-border-color: black; ");
        btStop.setFont(Font.font("Impact", 10));

        p2Roster.getChildren().addAll(home, tfPG1, tfSG1, tfSF1, tfPF1, tfC1, btPlay, btPause, btStop);

        // Creates border for bottom box
        HBox combine = new HBox();
        combine.getChildren().addAll(p1Roster, p1Position, blankBox2, p2Position, p2Roster);

        // creates space between Player Two textfields and ListView1
        VBox blankBox3 = new VBox();
        Label blank9 = new Label ("\t");
        blankBox3.getChildren().addAll(blank9);

        // Player Two ListView
        VBox rightTeams = new VBox();
        rightTeams.setPrefWidth(400);
        rightTeams.setStyle("-fx-border-color: black");
        Label posStops1 = new Label("   Player Two");
        posStops1.setFont(Font.font("Impact", 15));

        ObservableList<Roster> myTown = FXCollections.observableArrayList(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22, t23, t24, t25, t26, t27, t28, t29, t30, bonus);
        listView1 = new ListView<Roster>(myTown);
        listView1.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listView1.setMaxHeight(250.0);
        listView1.setOnMouseClicked(e -> { // clicking on team with display starting 5
            tfPG1.setText(listView1.getSelectionModel().getSelectedItem().getPG());
            tfSG1.setText(listView1.getSelectionModel().getSelectedItem().getSG());
            tfSF1.setText(listView1.getSelectionModel().getSelectedItem().getSF());
            tfPF1.setText(listView1.getSelectionModel().getSelectedItem().getPF());
            tfC1.setText(listView1.getSelectionModel().getSelectedItem().getC());
            p2Selection.setText(listView1.getSelectionModel().getSelectedItem().getTeamName().toUpperCase());

            // team selected will display starting 5
            if(listView1.getSelectionModel().getSelectedItem().equals(t1)) imageView2.setImage(listOfImages[0]);
            else if(listView1.getSelectionModel().getSelectedItem().equals(t2)) imageView2.setImage(listOfImages[1]);
            else if(listView1.getSelectionModel().getSelectedItem().equals(t3)) imageView2.setImage(listOfImages[2]);
            else if(listView1.getSelectionModel().getSelectedItem().equals(t4)) imageView2.setImage(listOfImages[3]);
            else if(listView1.getSelectionModel().getSelectedItem().equals(t5)) imageView2.setImage(listOfImages[4]);
            else if(listView1.getSelectionModel().getSelectedItem().equals(t6)) imageView2.setImage(listOfImages[5]);
            else if(listView1.getSelectionModel().getSelectedItem().equals(t7)) imageView2.setImage(listOfImages[6]);
            else if(listView1.getSelectionModel().getSelectedItem().equals(t8)) imageView2.setImage(listOfImages[7]);
            else if(listView1.getSelectionModel().getSelectedItem().equals(t9)) imageView2.setImage(listOfImages[8]);
            else if(listView1.getSelectionModel().getSelectedItem().equals(t10)) imageView2.setImage(listOfImages[9]);
            else if(listView1.getSelectionModel().getSelectedItem().equals(t11)) imageView2.setImage(listOfImages[10]);
            else if(listView1.getSelectionModel().getSelectedItem().equals(t12)) imageView2.setImage(listOfImages[11]);
            else if(listView1.getSelectionModel().getSelectedItem().equals(t13)) imageView2.setImage(listOfImages[12]);
            else if(listView1.getSelectionModel().getSelectedItem().equals(t14)) imageView2.setImage(listOfImages[13]);
            else if(listView1.getSelectionModel().getSelectedItem().equals(t15)) imageView2.setImage(listOfImages[14]);
            else if(listView1.getSelectionModel().getSelectedItem().equals(t16)) imageView2.setImage(listOfImages[15]);
            else if(listView1.getSelectionModel().getSelectedItem().equals(t17)) imageView2.setImage(listOfImages[16]);
            else if(listView1.getSelectionModel().getSelectedItem().equals(t18)) imageView2.setImage(listOfImages[17]);
            else if(listView1.getSelectionModel().getSelectedItem().equals(t19)) imageView2.setImage(listOfImages[18]);
            else if(listView1.getSelectionModel().getSelectedItem().equals(t20)) imageView2.setImage(listOfImages[19]);
            else if(listView1.getSelectionModel().getSelectedItem().equals(t21)) imageView2.setImage(listOfImages[20]);
            else if(listView1.getSelectionModel().getSelectedItem().equals(t22)) imageView2.setImage(listOfImages[21]);
            else if(listView1.getSelectionModel().getSelectedItem().equals(t23)) imageView2.setImage(listOfImages[22]);
            else if(listView1.getSelectionModel().getSelectedItem().equals(t24)) imageView2.setImage(listOfImages[23]);
            else if(listView1.getSelectionModel().getSelectedItem().equals(t25)) imageView2.setImage(listOfImages[24]);
            else if(listView1.getSelectionModel().getSelectedItem().equals(t26)) imageView2.setImage(listOfImages[25]);
            else if(listView1.getSelectionModel().getSelectedItem().equals(t27)) imageView2.setImage(listOfImages[26]);
            else if(listView1.getSelectionModel().getSelectedItem().equals(t28)) imageView2.setImage(listOfImages[27]);
            else if(listView1.getSelectionModel().getSelectedItem().equals(t29)) imageView2.setImage(listOfImages[28]);
            else if(listView1.getSelectionModel().getSelectedItem().equals(t30)) imageView2.setImage(listOfImages[29]);
            else if(listView1.getSelectionModel().getSelectedItem().equals(bonus)) imageView2.setImage(listOfImages[30]); });
        rightTeams.getChildren().addAll(posStops1, listView1);

        // Combines all the bottom boxes into one HBOX
        HBox bottomSide = new HBox();
        //bottomSide.setStyle("-fx-border-color: black; -fx-background-color: #D3D3D3");
        bottomSide.getChildren().addAll(leftTeams, blankBox, combine, blankBox3, rightTeams);
        pane.setBottom(bottomSide);

        btOpen.setOnAction((ActionEvent event) -> {
            FileChooser fc = new FileChooser();
            fc.setInitialDirectory(new File("C:\\Users\\blade\\IntellijProjects\\MyHouse"));
            fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("MP3 Files", "*.mp3"));
            File selectedFile = fc.showOpenDialog(null); // opens file explorer
            if(selectedFile != null) {
                Media musicFile = new Media(new File(selectedFile.getName()).toURI().toString());
                musicPlayer = new MediaPlayer(musicFile);
                musicPlayer.play();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("INVALID SELECTION!");
                alert.showAndWait();
            } });

        btPlay.setOnAction((ActionEvent event) -> {
            musicPlayer.play(); });

        btPause.setOnAction((ActionEvent event) -> {
            musicPlayer.pause(); });

        btStop.setOnAction((ActionEvent event) -> {
            musicPlayer.stop(); });

        vidPlay.setOnAction((ActionEvent event) -> {
            pane.setCenter(mediaControl);
            videoPlayer.play(); });

        vidStop.setOnAction((ActionEvent event) -> {
            pane.setCenter(imageView);
            videoPlayer.stop(); });

        // *** HOW TO GET EVERYTHING TO SHOW UP ON THE SCREEN ***
        //BackgroundImage bi = new BackgroundImage(new Image("file:great.jpg"), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(1.0, .80, true, true, false, false));
        BackgroundImage bi = new BackgroundImage(new Image("file:///C://Users/blade/IntellijProjects/HerHouse/nina_agdal.png"), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        pane.setBackground(new Background(bi));
        Scene scene = new Scene(pane, 1000, 500);
        stage.getIcons().add(new Image("file:nbalogo.jpg"));
        stage.setTitle("TEAM SELECT");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void handle(ActionEvent event) {}

    public static void main(String[] args) {
        launch(args);
    }
}