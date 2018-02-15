/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relc7dfinal;

import javafx.scene.input.MouseEvent;

/**
 *
 * @author Ryan
 */
public interface UIElements {
    void handleMouseEnter(MouseEvent event);
    void handleMouseExit(MouseEvent event);
    void setText(MouseEvent event);
    void goToPage(MouseEvent event);
}
