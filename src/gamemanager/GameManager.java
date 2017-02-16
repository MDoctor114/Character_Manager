// GameManager.java
// Mark Doctor
// 11/9/2016
// Documentation: Game Manager.docx
package gamemanager;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;

public class GameManager extends Application
{
    TextArea taOutput = new TextArea(); // Contains messages to user
    public static void main(String[] args) 
  {
    launch(args);
  }
    @Override
    public void start(Stage primaryStage)
    {
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        GridPane centerPane = getPlayerCreatorPane();
        HBox outputPane = getOutputPane(); 
        root.add(new HBox(),0,1);        
        root.add(centerPane,1,1);
        root.add(outputPane,1,2);
        

        //Set and display the scene
        Scene scene = new Scene(root,550, 700);
        primaryStage.setTitle("Character Creation");
        primaryStage.setScene(scene);
        // primaryStage.setResizable(false);
        primaryStage.setMinWidth(centerPane.getMinWidth() + 50);
        primaryStage.setMinHeight(centerPane.getMinHeight() + outputPane.getMaxHeight() + 50);
        primaryStage.show();
        
    } // end application
    
    private GridPane getPlayerCreatorPane()
    {
        GridPane pcPane = new GridPane();
        pcPane.setAlignment(Pos.CENTER);
        pcPane.setHgap(10);
        pcPane.setVgap(5);
        pcPane.setMinWidth(400);
        pcPane.setMaxWidth(400);
        pcPane.setMinHeight(400);
        pcPane.setMaxHeight(400);
        pcPane.setStyle("-fx-border-color: grey;");
        
        //nodes for Character Creation
        Label lName = new Label("Name:");
        TextField tfName = new TextField();
        Label lRace = new Label("race:");
        ComboBox cbRace = new ComboBox();
        cbRace.getItems().addAll(GlobalPlayerData.RACES); // add RACES to combo box
        Label lClass = new Label("Class:");
        ComboBox cbClass = new ComboBox();
        cbClass.getItems().addAll(GlobalPlayerData.CLASSES);
        Label lAlignment = new Label("Alignment:");
        ComboBox cbAlignment = new ComboBox();
        cbAlignment.getItems().addAll(GlobalPlayerData.ALIGNMENTS);
        //label lLevel = new Label("Level");
        //TextField tfLevel = new TextField();
        // Stats
        Label lStrength = new Label("Strength:");
        TextField tfStrength = getTextField();
        tfStrength.setEditable(false);
        Label lDexterity = new Label("Dexterity:");
        TextField tfDexterity = getTextField();
        tfDexterity.setEditable(false);
        Label lConstitution = new Label("Constitution:");
        TextField tfConstitution = getTextField();
        tfConstitution.setEditable(false);
        Label lIntelligence = new Label("Intelligence:");
        TextField tfIntelligence = getTextField();
        tfIntelligence.setEditable(false);
        Label lWisdom = new Label("Wisdom:");
        TextField tfWisdom = getTextField();
        tfWisdom.setEditable(false);
        Label lCharisma = new Label("Charisma:");
        TextField tfCharisma = getTextField();
        tfCharisma.setEditable(false);        
        // add nodes to gridpane
        pcPane.add(lName,   0,0);
        pcPane.add(tfName,  1,0);
        pcPane.add(lRace,   0,1);
        pcPane.add(cbRace,  1,1);
        pcPane.add(lClass,  0,2);
        pcPane.add(cbClass, 1,2);
        pcPane.add(lAlignment,  0,3);
        pcPane.add(cbAlignment, 1,3);  
        //pcPane.add(lLevel, 0,4);
        //pcPane.add(tfLevel, 1,4);
        //stat nodes
        pcPane.add(lStrength,   2,0);
        pcPane.add(tfStrength,  3,0);        
        pcPane.add(lDexterity,  2,1);
        pcPane.add(tfDexterity, 3,1);        
        pcPane.add(lConstitution,  2,2);
        pcPane.add(tfConstitution, 3,2);        
        pcPane.add(lIntelligence,  2,3);
        pcPane.add(tfIntelligence, 3,3);        
        pcPane.add(lWisdom,  2,4);
        pcPane.add(tfWisdom, 3,4);        
        pcPane.add(lCharisma,  2,5);
        pcPane.add(tfCharisma, 3,5);        
        
        Button bGenerate = new Button("Generate"); // Generate button
        bGenerate.setOnAction(e -> 
        {
        	taOutput.clear();
        	tfName.setText(tfName.getText().trim());
        	boolean outputIsValid = true;
        	
        	if (tfName.getText().isEmpty()) 
            {
            	taOutput.appendText("You must enter a name.\n");
            	outputIsValid = false;
            }       	
            try {
            	cbRace.getValue().toString().isEmpty();
            } catch (NullPointerException npe)
            {
                taOutput.appendText("You must select your race.\n");
                outputIsValid = false;
            }
            try {
            	cbClass.getValue().toString().isEmpty();	
            } catch (NullPointerException npe)
            {
            	taOutput.appendText("You must select a class.\n");
            	outputIsValid = false;
            }
            try {
            	cbAlignment.getValue().toString().isEmpty();
            } catch (NullPointerException npe)
            {
            	taOutput.appendText("You must select an alignment\n");
            	outputIsValid = false;
            }    
            if (outputIsValid) {
                tfStrength.setText(Integer.toString(Player.getStatRoll() + 
                        GlobalPlayerData.getBonus((Race) cbRace.getSelectionModel().getSelectedItem(), "Strength")));
                tfDexterity.setText(Integer.toString(Player.getStatRoll() + 
                        GlobalPlayerData.getBonus((Race) cbRace.getSelectionModel().getSelectedItem(), "Dexterity")));
                tfConstitution.setText(Integer.toString(Player.getStatRoll() + 
                        GlobalPlayerData.getBonus((Race) cbRace.getSelectionModel().getSelectedItem(), "Constitution")));
                tfIntelligence.setText(Integer.toString(Player.getStatRoll() + 
                        GlobalPlayerData.getBonus((Race) cbRace.getSelectionModel().getSelectedItem(), "Intelligence")));
                tfWisdom.setText(Integer.toString(Player.getStatRoll() + 
                        GlobalPlayerData.getBonus((Race) cbRace.getSelectionModel().getSelectedItem(), "Wisdom")));
                tfCharisma.setText(Integer.toString(Player.getStatRoll() + 
                        GlobalPlayerData.getBonus((Race) cbRace.getSelectionModel().getSelectedItem(), "Charisma")));
            }
        });
        pcPane.add(bGenerate, 1,5);
        pcPane.setHalignment(bGenerate, HPos.RIGHT);
        return pcPane;
    }// end Character Creation Pane
      
    private TextField getTextField()
    {
        TextField tField = new TextField();
        //tField.setEditable(false);
        tField.setMaxWidth(40);
        tField.setStyle("-fx-background-color: gainsboro");
        return tField;
    }
    
    private HBox getOutputPane()
    {
        HBox outputPane = new HBox();
        outputPane.setMaxHeight(100);
        taOutput.setWrapText(true);
        taOutput.setEditable(false);
        taOutput.setStyle("-fx-background-color: gainsboro");
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(taOutput);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setMaxWidth(400);
        scrollPane.setMaxHeight(100);

        outputPane.getChildren().add(scrollPane);
        return outputPane;
    }
} // end class
