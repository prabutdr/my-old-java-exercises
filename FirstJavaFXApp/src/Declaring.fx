/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * @author Prabu
 */

// place your code here
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

Stage {
    title: "Declaring is easy!"
    scene: Scene {
        width: 300;
        height: 250;
        content: [
            Rectangle {
                x: 25;
                y: 80;
                width: 250;
                height: 80;
                arcWidth: 20;
                arcHeight: 20;
                fill: Color.web("#6699ff");
                stroke: Color.web("#003399");
                strokeWidth: 5;
            } //Rectangle
            Circle {
                centerX: 150;
                centerY: 120;
                radius: 80;
                fill: Color.MAROON;
                stroke: Color.INDIANRED;
                strokeWidth: 10;
            } //Circle
        ] //Content
    } //Scene
} //Stage
