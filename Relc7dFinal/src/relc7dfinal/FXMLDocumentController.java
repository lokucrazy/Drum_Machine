/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relc7dfinal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Ryan
 */
public class FXMLDocumentController implements Initializable, UIElements {
    
    @FXML
    Pane root = new Pane();
    
    private AboutPageController controller;
    private Stage stage;
    private Scene drumScene;
    private Scene aboutScene;
    
    @FXML
    private Label hint;
    
    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button b3;
    @FXML
    private Button b4;
    @FXML
    private Button b5;
    @FXML
    private Button b6;
    @FXML
    private Button b7;
    @FXML
    private Button b8;
    @FXML
    private Button s1;
    @FXML
    private Button s2;
    @FXML
    private Button s3;
    @FXML
    private Button s4;
    @FXML
    private Button s5;
    @FXML
    private Button s6;
    @FXML
    private Button s7;
    @FXML
    private Button s8;
    @FXML
    private Button h1;
    @FXML
    private Button h2;
    @FXML
    private Button h3;
    @FXML
    private Button h4;
    @FXML
    private Button h5;
    @FXML
    private Button h6;
    @FXML
    private Button h7;
    @FXML
    private Button h8;
    
    private ArrayList<Integer[]> serialContainer;
    private Button bButton[];
    private Button sButton[];
    private Button hButton[];
    private Button b;
    
    @FXML
    Rectangle rect=new Rectangle();
    private double rectLayout=24.0;
    private Color activeColor=Color.CADETBLUE;
    private Color unActiveColor=Color.BLACK;
    private String active="Active";
    private String unactive="Unactive";
    
    private Integer bassState[];
    private Integer snareState[];
    private Integer hiState[];
    private int i;
    
    Integer bpm=250;
    Timeline time;
    KeyFrame keyFrame;
    
    Media bass;
    Media snare;
    Media hiHat;
    MediaView bView;
    MediaView sView;
    MediaView hView;
    
    @FXML
    private void bassHit() {
        MediaPlayer mediaPlayer=new MediaPlayer(bass);
        bView.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
        
    }
    
    @FXML
    private void snareHit() {
        MediaPlayer mediaPlayer=new MediaPlayer(snare);
        sView.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
        
    }
    
    @FXML
    private void hiHit() {
        MediaPlayer mediaPlayer=new MediaPlayer(hiHat);
        hView.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
        
    }
    
    @FXML
    @Override
    public void handleMouseEnter(MouseEvent event){
        if (event.getEventType()==MouseEvent.MOUSE_ENTERED){
            b=(Button)event.getSource();
            switch(b.getText()){
                case "play":
                    hint.setText("plays the sequence");
                    break;
                case "stop":
                    hint.setText("stops the sequence");
                    break;
                case "clear":
                    hint.setText("clears the sequence");
                    break;
                case "bass drum":
                    hint.setText("plays the bass drum sound");
                    break;
                case "snare drum":
                    hint.setText("plays the snare drum sound");
                    break;
                case "hi-hat":
                    hint.setText("plays the hi-hat sound");
                    break;
                case "Unactive":
                    hint.setText("doesn't hold a sound");
                    break;
                case "Active":
                    hint.setText("holds a sound");
                    break;
                
            }
        }
    }
    
    @FXML
    @Override
    public void handleMouseExit(MouseEvent event){
        if (event.getEventType()==MouseEvent.MOUSE_EXITED){
            hint.setText("hover over the buttons to see what they do!");
        }
    }
    
    @Override
    public void setText(MouseEvent event){
        //not necessary for this drum machine, but could be for other scenes
    }
    
    @FXML
    private void changeState(MouseEvent event){
        Object source=event.getSource();
        if (!(source instanceof Button)){
            System.out.println("not a sequence button");
            return;
        }else {
            b=(Button)source;
            for (int i=0; i<=7;i++){
                if(b.equals(bButton[i])){
                    switch(bassState[i]){
                        case 0:
                            bassState[i]=1;
                            b.setText(active);
                            b.setTranslateX(8.0);
                            b.setTextFill(activeColor);
                            break;
                        case 1:
                            bassState[i]=0;
                            b.setText(unactive);
                            b.setTranslateX(-1.0);
                            b.setTextFill(unActiveColor);
                            break;
                    }
                }else if(b.equals(sButton[i])){
                    switch(snareState[i]){
                        case 0:
                            snareState[i]=1;
                            b.setText(active);
                            b.setTranslateX(8.0);
                            b.setTextFill(activeColor);
                            break;
                        case 1:
                            snareState[i]=0;
                            b.setText(unactive);
                            b.setTranslateX(-1.0);
                            b.setTextFill(unActiveColor);
                            break;
                    }
                } else if(b.equals(hButton[i])){
                    switch(hiState[i]){
                        case 0:
                            hiState[i]=1;
                            b.setText(active);
                            b.setTranslateX(8.0);
                            b.setTextFill(activeColor);
                            break;
                        case 1:
                            hiState[i]=0;
                            b.setText(unactive);
                            b.setTranslateX(-1.0);
                            b.setTextFill(unActiveColor);
                            break;
                    }
                }
            }
        }
    }
    
    private void changeState(){
        for(int i=0; i<=7; i++){
            switch(bassState[i]){
                case 1:
                    bButton[i].setText(active);
                    bButton[i].setTranslateX(8.0);
                    bButton[i].setTextFill(activeColor);
                    break;
                case 0:
                    bassState[i]=0;
                    bButton[i].setText(unactive);
                    bButton[i].setTranslateX(-1.0);
                    bButton[i].setTextFill(unActiveColor);
                    break;
            }
            switch(snareState[i]){
                case 1:
                    sButton[i].setText(active);
                    sButton[i].setTranslateX(8.0);
                    sButton[i].setTextFill(activeColor);
                    break;
                case 0:
                    sButton[i].setText(unactive);
                    sButton[i].setTranslateX(-1.0);
                    sButton[i].setTextFill(unActiveColor);
                    break;
            }
            switch(hiState[i]){
                case 1:
                    hButton[i].setText(active);
                    hButton[i].setTranslateX(8.0);
                    hButton[i].setTextFill(activeColor);
                    break;
                case 0:
                    hButton[i].setText(unactive);
                    hButton[i].setTranslateX(-1.0);
                    hButton[i].setTextFill(unActiveColor);
                    break;
            }
        }
    }
    
    @FXML
    private void clear(){
        rect.setTranslateX(b1.getLayoutX()-rectLayout);
        for (int i=0;i<=7;i++){
            bButton[i].setText(unactive);
            sButton[i].setText(unactive);
            hButton[i].setText(unactive);
            bButton[i].setTextFill(unActiveColor);
            sButton[i].setTextFill(unActiveColor);
            hButton[i].setTextFill(unActiveColor);
            
            if (bassState[i]==1){
                bButton[i].setTranslateX(-1.0);
            }
            if (snareState[i]==1){
                sButton[i].setTranslateX(-1.0);
            }
            if (hiState[i]==1){
                hButton[i].setTranslateX(-1.0);
            }
            
            bassState[i]=0;
            snareState[i]=0;
            hiState[i]=0;
        }
    }
    
    @FXML
    private void playSequence(){
        time.play();
    }
    
    @FXML 
    private void stopSequence(){
        time.stop();
        i=0;
        rect.setTranslateX(b1.getLayoutX()-rectLayout);
    }
    
    @FXML 
    private void pauseSequence(){
        time.pause();
    }
    
    private void update(){
        if (i>7){
            i=0;
        }
        
        rect.setTranslateX(bButton[i].getLayoutX()-rectLayout);
        
        switch(bassState[i]){
            case 1:
                bassHit();
                break;
            case 0:
                break;
        }
        
        switch(snareState[i]){
            case 1:
                snareHit();
                break;
            case 0:
                break;
        }
        
        switch(hiState[i]){
            case 1:
                hiHit();
                break;
            case 0:
                break;
        }
        i++;
    }
    
    @FXML
    private void handleSave(){
        serialContainer.add(bassState);
        serialContainer.add(snareState);
        serialContainer.add(hiState);
        System.out.println(serialContainer);
        FileChooser fileChooser=new FileChooser();
        File file=fileChooser.showSaveDialog(stage);
        if (file!=null){
            try {
                FileOutputStream fileOutput=new FileOutputStream(file.getPath());
                ObjectOutputStream objOutput=new ObjectOutputStream(fileOutput);
                objOutput.writeObject(serialContainer);
                objOutput.close();
                fileOutput.close();
            } catch(Exception e){
                String message = "Exception occurred while saving to " + file.getPath(); 
            }
        }
    }
    
    @FXML
    private void handleOpen(){
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            try{
                FileInputStream fileInput = new FileInputStream(file.getPath());
                ObjectInputStream objInput = new ObjectInputStream(fileInput);
                serialContainer=(ArrayList<Integer[]>) objInput.readObject();
                this.bassState=serialContainer.get(0);
                this.snareState=serialContainer.get(1);
                this.hiState=serialContainer.get(2);
                objInput.close();
                fileInput.close();
               
            }catch(Exception e){
                System.out.println("couldn't get stuff from"+file.getPath());
            }
        }
        changeState();
        
    }
    
    @FXML
    @Override
    public void goToPage(MouseEvent event){
        String fileName="";
        Button b=(Button) event.getSource();
        if(b.getText().equals("About")){
            fileName="AboutPage.fxml";
        }
        if (aboutScene==null){
            try {
                FXMLLoader aboutLoad = new FXMLLoader(getClass().getResource(fileName));
                Parent page = (Parent) aboutLoad.load();
                controller = (AboutPageController) aboutLoad.getController();
                controller.drumScene=drumScene;
                aboutScene=new Scene(page);
            }catch(IOException e){
                System.out.println("could not go to page AboutPage.fxml");
            }
        }
        stage.setScene(aboutScene);
        controller.getStage(stage);
    }
    
    public void ready(Stage stage){
        this.stage=stage;
        drumScene=stage.getScene();
        
        bass=new Media(new File("bassDrum.mp3").toURI().toString());
        snare=new Media(new File("snareDrum.mp3").toURI().toString());
        hiHat=new Media(new File("hiHat.mp3").toURI().toString());
        bView=new MediaView();
        sView=new MediaView();
        hView=new MediaView();
        root.getChildren().addAll(bView,hView,sView);
        
        hint.setText("hover over the buttons to see what they do!");
        active="Active";
        unactive="Unactive";
        
        serialContainer=new ArrayList<>();
        bassState=new Integer[]{0,0,0,0,0,0,0,0};
        snareState=new Integer[]{0,0,0,0,0,0,0,0};
        hiState=new Integer[]{0,0,0,0,0,0,0,0};
        bButton=new Button[]{b1,b2,b3,b4,b5,b6,b7,b8};
        sButton=new Button[]{s1,s2,s3,s4,s5,s6,s7,s8};
        hButton=new Button[]{h1,h2,h3,h4,h5,h6,h7,h8};
        
        keyFrame = new KeyFrame(Duration.millis(bpm), (ActionEvent event) -> {
            update();
        });
        
        time = new Timeline(keyFrame);
        time.setCycleCount(Animation.INDEFINITE);
        //this is to stop the delay factor that happens when sequencer is played for the first time
        bassHit();
        snareHit();
        hiHit();
        
        stage.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {
            if ("A".equals(event.getCode().toString())){
                bassHit();
            }else if("S".equals(event.getCode().toString())){
                snareHit();
            }else if("D".equals(event.getCode().toString())){
                hiHit();
            }else if("P".equals(event.getCode().toString())){
                pauseSequence();
            }
        });
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }   
    
}
