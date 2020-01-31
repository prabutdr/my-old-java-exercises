/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * @author Prabu
 */

def images = for(i in [0..9]) {Image {url: "{__DIR__}{i}.png"}}
var count = 0;
var curImage = images[count] on replace oldValue {
    if(count < 10) {
        if(count == 9) {
            println("Max count ({count}) reached.");
        }
    }
    else {
        println("\tWarning: count has exceeded 9! ");
        println("\tThis would cause the screen to go black.");
        println("\tI'll roll back the change (which will fire the trigger again)....");
        count = 9;
        curImage = oldValue;
        println("Done. The counter should look OK now.");
    }
}


Stage {
    title: "LED Digit Example - Data Bind"
    scene: Scene {
        content: ImageView {
            image: bind curImage
            onMouseClicked: function(e: MouseEvent): Void {
                println("Click Number {++count}...");
                curImage = images[count];
            }
        }
    }
}