package application;
	
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import application.tools.Util;
import controls.Clock;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
import javafx.stage.Stage;
import weatherapi.data.WeatherApiD;
import weatherapi.model.Current;
import weatherapi.model.Forecast;
import weatherapi.model.ForecastResponse;
import weatherapi.model.Location;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;

public class Main extends Application {
	private Scene scene;
	private StackPane mainContainer;
	private GridPane resultGrid;
	private GridPane forecastGrid;
	private GridPane searchGrid;
    private TextField txtSearch;
    private Button btnSearch;
    private Button btnHistory;
    private Button btnTemp;
    private Button btnWind;
	private Clock lblClock;
	private Label lblDate;
	private Label lblSearch;
    private Label lblCountry;    
    private Label lblTempUnity;
    private Label lblTempValue;
    private Label lblTempFeelsLike;
    private Label lblWindDescription;
    private Label lblPressure;
    private Label lblPrecip;
    private Label lblHumidity;
    private Label lblUv;
    private Image image;
    private ImageView imageView;
    private String hotColor = "#ffa0d9";
    private String mediumColor = "#4ee07f";
    private String coldColor = "#8cbbff";
    private Current currentWeather;
    private Forecast forecastWeather;
    private Location locationWeather;    
    private String buttonStyle = "-fx-background-color: transparent; -fx-border-color: #e2e2e2; -fx-border-radius: 4;";
	private ArrayList<String> history = new ArrayList<String>();
	private int column = 0;	

    @Override
    public void start(Stage primaryStage) {
        try {
        	setupBackgroundImage();
        	setupSearchBox();
        	setupResultBox();
        	setupScene();
            
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	private void setupScene() {
        mainContainer = new StackPane();
        mainContainer.setStyle("-fx-background-color: " + coldColor + ";");
        scene = new Scene(mainContainer, 350, 600);
        
        GridPane container = new GridPane();

        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setHgrow(Priority.ALWAYS);
        container.getColumnConstraints().addAll(columnConstraints);
        
        container.add(searchGrid, 0, 0);
        container.add(resultGrid, 0, 1);
        
        mainContainer.getChildren().addAll(imageView, container);
                                
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	}

	private void setupBackgroundImage() {
        image = new Image("http://cdn.weatherapi.com/weather/64x64/night/116.png");
        imageView = new ImageView(image);
        imageView.setFitWidth(180);
        imageView.setFitHeight(200);
    	
        double width = imageView.getImage().getWidth() * 0.8;
        double height = imageView.getImage().getHeight() * 0.9;
        Rectangle2D viewport = new Rectangle2D(0, 0, width, height);

        imageView.setViewport(viewport);
        StackPane.setAlignment(imageView, Pos.CENTER_RIGHT);
	}

	private void setupSearchBox() {
    	searchGrid = new GridPane();
    	txtSearch = new TextField();
    	lblSearch = new Label("Search by name or coordinates (lat,lon)");
    	btnSearch = new Button("Search");
    	btnHistory = new Button("History");

        Image image = new Image("http://cdn.weatherapi.com/weather/64x64/day/116.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        btnSearch.setGraphic(imageView);
        btnSearch.setStyle(buttonStyle);
        btnHistory.setStyle(buttonStyle);
        
        searchGrid.setHgap(10);
        searchGrid.setPadding(new Insets(10));
        searchGrid.add(lblSearch,  0, 0);
        searchGrid.add(txtSearch, 0,  1);
        searchGrid.add(btnSearch, 1,  1);
        searchGrid.add(btnHistory, 2,  1);
        GridPane.setHgrow(lblSearch, Priority.ALWAYS);
        GridPane.setColumnSpan(lblSearch, GridPane.REMAINING);

        btnSearch.setOnMouseClicked(e -> search());
        btnHistory.setOnMouseClicked(e -> searchHistory());
	}
	
    private void setupResultBox() {
    	resultGrid = new GridPane();
    	forecastGrid = new GridPane();
    	lblCountry = new Label();
    	lblDate = new Label();
    	lblClock = new Clock();
    	lblTempValue = new Label("21.7");
    	lblTempFeelsLike = new Label();
    	lblTempUnity = new Label("°C");
    	lblWindDescription = new Label();
    	lblPressure = new Label();
    	lblPrecip = new Label();
    	lblHumidity = new Label();
    	lblUv = new Label();
    	btnTemp = new Button("Temp °F / °C");
    	btnWind = new Button("Wind Speed kmph / mph");
    	
    	btnTemp.setOnMouseClicked(e -> switchTemp());
    	btnWind.setOnMouseClicked(e -> switchWind());

    	btnTemp.setStyle(buttonStyle);
    	btnWind.setStyle(buttonStyle);
    	
    	lblTempValue.setStyle("-fx-font-size: 60px;");
    	lblTempUnity.setStyle("-fx-font-size: 20px; -fx-padding: 15px 0 0 0;");
    	GridPane.setValignment(lblTempUnity, VPos.TOP);

        lblClock.onTick(() -> {
            lblDate.setText(DateTimeFormatter.ofPattern("EEEE, MMMM dd").format(LocalDate.now()));
        });

        resultGrid.add(lblCountry, 0, 0);
        resultGrid.add(lblDate, 0, 1);
        resultGrid.add(lblClock, 0, 2);
        resultGrid.add(btnTemp, 0, 3);
        resultGrid.add(btnWind, 0, 4);

		GridPane.setHalignment(lblCountry, HPos.CENTER);
		GridPane.setHalignment(lblDate, HPos.CENTER);
		GridPane.setHalignment(lblClock, HPos.CENTER);
		GridPane.setHalignment(btnTemp, HPos.CENTER);
		GridPane.setHalignment(btnWind, HPos.CENTER);
        
        GridPane tempGrid = new GridPane();
        tempGrid.add(lblTempValue, 0, 0);
        tempGrid.add(lblTempUnity, 1, 0);

        resultGrid.add(tempGrid, 0, 5);        

        resultGrid.add(lblWindDescription, 0, 6);
        resultGrid.add(lblPressure, 0, 7);
        resultGrid.add(lblPrecip, 0, 8);
        resultGrid.add(lblHumidity, 0, 9);
        resultGrid.add(lblTempFeelsLike, 0, 10);
        resultGrid.add(lblUv, 0, 11);

        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setHgrow(Priority.ALWAYS);
        resultGrid.getColumnConstraints().add(columnConstraints);
        
        resultGrid.add(forecastGrid, 0, 12);
        
        resultGrid.setVisible(false);
	}

    private boolean celsius = true;
    private boolean kilometer = true;

	private void switchTemp() {
		celsius = !celsius;
    	showCurrentInformation();
    	showForecastInformation();
	}
	
	private void switchWind() {
		kilometer = !kilometer;
    	showCurrentInformation();
    	showForecastInformation();
	}

	private void search() {
		if(txtSearch.getText().length() > 0) {
			history.add(txtSearch.getText());
			ForecastResponse result = WeatherApiD.getForecastWeather(txtSearch.getText().replace(" ", "%20"));
	        if(result != null) {
	        	currentWeather = result.getCurrent();
	        	locationWeather = result.getLocation();
	        	forecastWeather = result.getForecast();
	        	showCurrentInformation();
	        	showForecastInformation();
	        	resultGrid.setVisible(true);
	        }
		}
    }
	
	private void searchHistory() {
	    String content = "";

	    if(history.size() > 0) {
		    for (String item : history) {
		    	content += item + "\n";
		    }
	    }
	    else {
	    	content = "No history found.";
	    }

		Util.displayMessage("History",content, AlertType.INFORMATION);
	}
	
	private void showForecastInformation() {
	    forecastGrid.getChildren().clear();
	    forecastGrid.getColumnConstraints().clear();

	    double columnWidth = 100.0 / forecastWeather.getForecastDay().size();

	    forecastWeather.getForecastDay().forEach(i -> {

	        String tempDescrip = i.getDay().getMinTempC() + "°C / " + i.getDay().getMaxtempC() + " °C";
	        
			if(!celsius) {
		        tempDescrip = i.getDay().getMinTempF() + "°F / " + i.getDay().getMaxTempF() + " °F";
			}			

	        Label lblDay = new Label(i.getDate());
	        Label lblTemp = new Label(tempDescrip);
	        Image img = new Image(i.getDay().getCondition().getIcon());
	        ImageView imgView = new ImageView(img);
	        
	        ColumnConstraints col = new ColumnConstraints();
	        col.setPercentWidth(columnWidth);
	        forecastGrid.getColumnConstraints().add(col);

	        forecastGrid.add(lblDay, column, 0);
	        forecastGrid.add(imgView, column, 1);
	        forecastGrid.add(lblTemp, column, 2);

	        GridPane.setHalignment(lblDay, HPos.CENTER);
	        GridPane.setHalignment(imgView, HPos.CENTER);
	        GridPane.setHalignment(lblTemp, HPos.CENTER);

	        column++;
	    });
	    column = 0;
	}
	
	private void showCurrentInformation() {
		lblCountry.setText(locationWeather.getCountry() + " - " + locationWeather.getName());
		lblPrecip.setText("precip: " + currentWeather.getPrecipMm() + " mm");
		lblPressure.setText("pressure: " + currentWeather.getPressureMb() + " mb");
		lblHumidity.setText("humidity: " + currentWeather.getHumidity() + "%");
		lblUv.setText("uv: " + currentWeather.getUv());
		image = new Image(currentWeather.getCondition().getIcon());
		imageView.setImage(image);

		if(celsius) {
			lblTempValue.setText(String.valueOf(currentWeather.getTempC()));
			lblTempFeelsLike.setText("feelslike: " + currentWeather.getFeelslikeC() + " °C");
	    	lblTempUnity.setText("°C");
		}
		else {
			lblTempValue.setText(String.valueOf(currentWeather.getTempF()));
			lblTempFeelsLike.setText("feelslike: " + currentWeather.getFeelslikeF() + " °F");
	    	lblTempUnity.setText("°F");
		}
		
		if(kilometer) {
			lblWindDescription.setText("wind: " + currentWeather.getWindDegree() + "° - " + currentWeather.getWindKph() + " kmph");
		}
		else {
			lblWindDescription.setText("wind: " + currentWeather.getWindDegree() + "° - " + currentWeather.getWindMph() + " mph");			
		}
		
		if (currentWeather.getFeelslikeC() > 30) {
		    mainContainer.setStyle("-fx-background-color: " + hotColor + ";");
		} else if (currentWeather.getFeelslikeC() > 18) {
		    mainContainer.setStyle("-fx-background-color: " + mediumColor + ";");
		} else {
		    mainContainer.setStyle("-fx-background-color: " + coldColor + ";");
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
