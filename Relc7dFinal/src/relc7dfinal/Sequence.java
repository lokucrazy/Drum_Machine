/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relc7dfinal;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;

/**
 *
 * @author Ryan
 */
public class Sequence {
    Integer bassState[] = {0,0,0,0,0,0,0,0};
    Integer snareState[] = {0,0,0,0,0,0,0,0};
    Integer hiState[] = {0,0,0,0,0,0,0,0};
    
    Integer bpm=250;
    Timeline time;
    KeyFrame keyFrame;
    
    public Sequence(){
        keyFrame = new KeyFrame(Duration.millis(bpm), (ActionEvent event) -> {
            update();
        });
        
        time = new Timeline(keyFrame);
        time.setCycleCount(Animation.INDEFINITE);
    }
    
    public void play(){
        time.play();
    }
    public void pause(){
        time.pause();
    }
    public void stop(){
        time.stop();
    }
    
    private void update(){
        
    }
    
}
