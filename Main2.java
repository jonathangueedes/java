package br.edu.cefsa.ftt.ec.chart.app;


import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class Main extends Application {
	
	InputStream reader = System.in;
	public static String conteudo ="";
	@Override
	public void start(Stage primaryStage) {
		
		try {
			
			BorderPane rootBorderPane = new BorderPane();
			//Reference: https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/BorderPane.html
			
			Scene scene = new Scene(rootBorderPane, 800, 600);
			
			primaryStage.setTitle("JavaFX - Chart Controll");
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			//Components declaration:
			//Reference: https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/package-summary.html
			
			Button buttonFileOpen = new Button("Open");
			
			Button buttonSettings = new Button("Settings");

			Slider slider = new Slider();
			//Reference for Slider: https://docs.oracle.com/javafx/2/ui_controls/slider.htm
			//                      https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Slider.html
			
			slider.setMin(1);
			slider.setMax(100);
			slider.setValue(40);
			slider.setShowTickLabels(true);
			slider.setShowTickMarks(true);
			slider.setMajorTickUnit(50);
			slider.setMinorTickCount(5);
			slider.setBlockIncrement(10);
			
		    Label status = new Label("Status: ");
		    
		    //TODO: Criar componente do gráfico...
			
			//Actions to the interactive components:
			
			buttonFileOpen.setOnAction(new EventHandler<ActionEvent>() {
			    @Override 
			    public void handle(ActionEvent e) {
			    	//TODO: Read a file and get data to the graphic, using dialog
			        StringBuilder builder = new StringBuilder();
			    	FileChooser fileChooser = new FileChooser();
					File file = fileChooser.showOpenDialog(primaryStage);
					try {
						reader = new FileInputStream(file);
						for(int data = 0; data!=-1;data=reader.read()){
							builder.append((char)data);
						}
						conteudo = builder.toString();
						System.out.println(conteudo);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					finally{
						try {
							reader.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
					
			    	System.out.println("Open...");
			    	
			    	
			    	// criar metodo para ler o arquivo e jogar em um array. usar o array para popular o grafico
			    	
			    }
			});

			buttonSettings.setOnAction(new EventHandler<ActionEvent>() {
			    @Override 
			    public void handle(ActionEvent e) {
			    	//TODO: Change graphic parameters using dialog
			        System.out.println("Settings...");
			    }
			});			
			
			slider.valueProperty().addListener((observable, oldvalue, newvalue) -> {
			            float val = newvalue.floatValue();
			            System.out.println("Slider value: " + val);
			            status.setText("Status: Slider=" + val);
			});
		
			//Form layout...		
			
		    ToolBar toolbar = new ToolBar();
		     
		    toolbar.getItems().add(buttonFileOpen);
		    toolbar.getItems().add(buttonSettings);
		    toolbar.getItems().add(slider);
		     
		    HBox statusbar = new HBox();
		    //Reference: https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/HBox.html

		    statusbar.getChildren().add(status);

		    rootBorderPane.setTop(toolbar);
		    
		    //TODO: Criar o gráfico e carrega-lo no centro...
		    rootBorderPane.setCenter(LoadChart());
		    
		    rootBorderPane.setBottom(statusbar);
		      
			//Mágica...
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	

	public static LineChart LoadChart() {
		final CategoryAxis   xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Number of Month");
		// creating the chart
		final LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);

		lineChart.setTitle("Stock Monitoring, 2010");
		// defining a series
		XYChart.Series series = new XYChart.Series();
		series.setName("My portfolio");
		// populating the series with data
		String[] valores = conteudo.split("\\r\\n");
		
		series.getData().add(new XYChart.Data(1, 23));
		series.getData().add(new XYChart.Data(2, 14));
		series.getData().add(new XYChart.Data(3, 15));
		series.getData().add(new XYChart.Data(4, 24));
		series.getData().add(new XYChart.Data(5, 34));
		series.getData().add(new XYChart.Data(6, 36));
		series.getData().add(new XYChart.Data(7, 22));
		series.getData().add(new XYChart.Data(8, 45));
		series.getData().add(new XYChart.Data(9, 43));
		series.getData().add(new XYChart.Data(10, 17));
		series.getData().add(new XYChart.Data(11, 29));
		series.getData().add(new XYChart.Data(12, 25));

		Scene scene = new Scene(lineChart, 800, 600);
		lineChart.getData().add(series);
		return lineChart;
	}
	
}
