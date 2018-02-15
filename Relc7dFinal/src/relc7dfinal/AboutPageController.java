/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relc7dfinal;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Ryan
 */
public class AboutPageController implements UIElements{
    protected Scene drumScene;
    private Stage stage;
    
    @FXML
    private TextArea document;
    @FXML
    private Button theCode;
    @FXML
    private Button theMachine;
    @FXML
    private Button playingStopping;
    @FXML
    private Button thePerson;
    
    @FXML
    private Label hint;
    
    private String theCodeString="This Code was entire developed with the basis of creating a fluid and usuable drum machine for any user.\n"
            + "The most complex part of the code is the sequencer, which uses a timeline and 3 arrays of Integers to play the machine at a rhythym predefined by the user.\n"
            + "There was actually an earlier part where I used Threads to function as the instrument hits, but luckily Mr. Musser told me that MediaPlayer is not thread safe so"
            + " I used another solution, the one that's in the code right now.\n"
            + "While the buttons had to have their fx ids manually inputted, there are functions that automatically detect which button is being clicked/hovered and perform"
            + " specific actions.  That was also interesting to code.\n"
            + " Now both FXML controllers implement an Interface called \"UIElements\".  This interface is pretty bare save for a couple functions.  "
            + "I've created this interface so in the case that I want to add more scenes of different instruments/pages, I can use that interface and "
            + "keep the UI elements that I want, as well as add UI functions as I please.";
    private String theMachineString="The machine is a simple 8 step drum machine, of similar (though very less complex) designs of modern drum machines like the Roland TR-8,"
            + " or Korg Volca Beats.\n"
            + "It runs in 8 steps in 4/4 time, with a bpm of 120.  I may later at my own time and discretion add user support to change time signature and bpm.\n"
            + "It uses 3 drum samples: a bass drum sound, a snare drum sound, and a hi-hat sound.  All sounds were chopped to be their own individual"
            + " mp3 files.";
    private String playingStoppingString="you can play and stop the sequence using the two button \"play\" and \"stop\".  But did you know you can also"
            + " pause the sequence by pressing the \"p\" key?  betcha didn't know.\n"
            + "To play the drum sounds, you can press the \"bass\",\"snare\", and \"hi-hat\" buttons.  To offer better usability, you can also"
            + " use the \"A\", \"S\", and \"D\" keys to play the sounds in a more rhythmic fashion.";
    private String thePersonString="Ryan Lokugamage is the coolest dude ever in the whole universe. FACT\n"
            + "He has climbed the Himalayan Mountains, saved over 100,000 wild buffalo, and played golf with almost"
            + " every president in the world (he wins, even though he still doesn't know how to play golf)."
            + "  This man, destined for greatness can deadlift over 5 TONS and is fuel by American Pride and protein shakes.  He is attaining his B.S."
            + " in Computer Science and is in his sophomore year.";
    
    @FXML
    @Override
    public void setText(MouseEvent event){
        if (event.getEventType()==MouseEvent.MOUSE_CLICKED){
            Button b=(Button)event.getSource();
            switch(b.getText()){
                case "The Code":
                    document.setText(theCodeString);
                    break;
                case "The Machine":
                    document.setText(theMachineString);
                    break;
                case "Playing and Stopping":
                    document.setText(playingStoppingString);
                    break;
                case "The Person":
                    document.setText(thePersonString);
            }
        }
    }
    
    public void getStage(Stage stage){
        this.stage=stage;
    }
    
    @FXML
    @Override
    public void goToPage(MouseEvent event){
        document.setText("");
        hint.setText("hover over buttons to see what they do!");
        stage.setScene(drumScene);
    }

    @FXML
    @Override
    public void handleMouseEnter(MouseEvent event) {
        if (event.getEventType()==MouseEvent.MOUSE_ENTERED){
            Button b=(Button)event.getSource();
            switch(b.getText()){
                case "The Code":
                    hint.setText("describes the making of the code.");
                    break;
                case "The Machine":
                    hint.setText("describes the drum machine.");
                    break;
                case "Playing and Stopping":
                    hint.setText("describes playing and stopping the sequencer.");
                    break;
                case "The Person":
                    hint.setText("describes the creator behind project.");
                    break;
                case "Go Back to Drum Machine":
                    hint.setText("return to drum machine scene.");
            }
        }
    }

    @FXML
    @Override
    public void handleMouseExit(MouseEvent event) {
        if (event.getEventType()==MouseEvent.MOUSE_EXITED){
            hint.setText("hover over buttons to see what they do!");
        }
    }
}
