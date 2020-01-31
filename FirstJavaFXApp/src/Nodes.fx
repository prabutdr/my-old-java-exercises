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
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.transform.Transform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Group;

Stage {
    title: "Nodes";
    scene: Scene {
        fill: Color.LIGHTBLUE;
        width: 220;
        height: 170;
        content: Group {
            translateX: 55;
            translateY: 10;
            content: [
                Circle {
                    centerX: 50;
                    centerY: 50;
                    radius: 50;
                    fill: Color.WHITE;
                    stroke: Color.YELLOW;
                }, //Circle
                Circle {
                    centerX: 10;
                    centerY: 100;
                    radius: 10;
                    stroke: Color.BLACK;
                }

                Text {
                    content: "Duke";
                    transforms: [
                        Transform.rotate(33, 10, 100)
                    ]
                } //Text
                ImageView {
                    image: Image {
                        url: "{__DIR__}dukewave.png"
                    }

                }
            ]
        } //Group
    } //Scene
} //Stage
