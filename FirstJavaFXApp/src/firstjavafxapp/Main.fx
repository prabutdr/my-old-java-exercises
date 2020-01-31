/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package firstjavafxapp;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.animation.transition.TranslateTransition;
import javafx.animation.Timeline;
import javafx.scene.input.MouseEvent;

/**
 * @author Prabu
 */
var icon: ImageView;
icon = ImageView {
    image: Image{url: "{__DIR__}resources/mailIcon.png"}
    translateX: 133
    translateY: 30
    onMouseEntered: function(e: MouseEvent): Void {
        transition.play();
    }
    onMouseExited: function(e: MouseEvent): Void {
        transition.pause();
    }
}

def backGround = ImageView {
    image: Image {url: "{__DIR__}resources/dock.jpg"}
}

var transition = TranslateTransition {
	duration: 650ms
	node: icon
	byY: -25
	repeatCount: 3//Timeline.INDEFINITE
        autoReverse: true
}

Stage {
    title: "First JavaFX Application"
    scene: Scene {
        width: 362
        height: 150
        content: [
            backGround,
            icon
        ] //content
    } //scene
} //Stage