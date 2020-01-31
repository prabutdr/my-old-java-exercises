/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER
 *
 * Copyright c 2010, Oracle and/or its affiliates. All rights reserved.
 * Oracle is a registered trademark of Oracle Corporation and/or its affiliates.
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:

 *   *  Redistributions of source code must retain the above copyright notice,
        trademark notice, this list of conditions, and the following disclaimer.

 *   *  Redistributions in binary form must reproduce the above copyright notice,
        trademark notice, this list of conditions, and the following disclaimer in
        the documentation and/or other materials provided with the distribution.

 *   *  Neither the name of Oracle nor the names of its contributors may be used
        to endorse or promote products derived from this software without specific
        prior written permission.

 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.animation.Timeline;
import javafx.geometry.*;

var opacityLevel: Number;

Timeline {
    repeatCount: Timeline.INDEFINITE
    autoReverse: false
    keyFrames: [
        at (0s) {opacityLevel => 0.2},
        at (2s) {opacityLevel => 1.0}
        at (4s) {opacityLevel => 0.2}
    ]
}.play();

var group1 = ToggleGroup {};
var group2 = ToggleGroup {};
def slider = Slider {
    min: 0
    max: 100
    value: 0
    showTickMarks: true
    showTickLabels: true
    majorTickUnit: 50
    minorTickCount: 5
    blockIncrement: 10
    labelFormatter: function (num) {"{%(,.0f num}%"}
}
Stage {
    title: "Controls (JavaFX sample)"
    scene: Scene {
        width: 510
        height: 400
        content: ScrollView {
            layoutInfo: LayoutInfo {height: 310 width: 350}
            node: VBox {translateX: 10 translateY: 10 spacing: 20
                padding: Insets{top: 30 bottom: 30}
                content: [
                    HBox {spacing: 5
                        vpos: VPos.BOTTOM
                        content: [
                            VBox {
                                spacing: 2
                                content: [
                                    RadioButton {toggleGroup: group2 text: "High"
                                        selected: true
                                    }
                                    RadioButton {toggleGroup: group2 text: "Medium"},
                                    RadioButton {toggleGroup: group2 text: "Low"}
                                ]
                            }
                            VBox {
                                content: [
                                    TextBox {columns: 15 promptText: "Type your name"},
                                    PasswordBox {promptText: "Type your password" echoChar: "#"}
                                ]
                            },
                            ChoiceBox {
                                items: ["English", "Русский", "简体中文"]
                                tooltip: Tooltip {text: "Your language"}
                            }
                        ]
                    }
                    HBox {spacing: 2
                        content: [
                            Label {text: "Make your choice:"}
                            ToggleButton {toggleGroup: group1 text: "Agree" selected: true}
                            ToggleButton {toggleGroup: group1 text: "Disagree"}
                            ToggleButton {toggleGroup: group1 text: "I don't know"
                                opacity: bind opacityLevel
                            }
                        ]
                    },

                    ListView {
                        items: ["Double Room", "Twin Room", "Family App", "Junior Suite", "Single Room"]
                        layoutInfo: LayoutInfo {width: 220 height: 40 }
                        vertical: false
                    }
                    HBox {spacing: 12
                        content: [
                            Label {text: "Approved:"}
                            CheckBox {text: "Normal"},
                            Separator {vertical: true layoutInfo: LayoutInfo{width: 1 height: 15}},
                            CheckBox {text: "Checked" selected: true}
                            CheckBox {allowTriState: true text: "Undefined" defined: false}
                        ]
                    }
                    HBox {spacing: 5
                        content: [
                            Label {text: "Progress:"}
                            slider,
                            HBox {
                                content: [
                                    ProgressBar {progress: bind slider.value / slider.max},
                                    ProgressIndicator {progress: bind slider.value / slider.max}
                                ]
                            }
                        ]
                    }
                    HBox {spacing: 5
                        content: [
                            VBox {
                                content: [
                                    HBox {
                                        spacing: 15
                                        nodeVPos: VPos.BOTTOM
                                        content: [
                                            Hyperlink {text: "http://example.com/"
                                                visited: true}
                                            ProgressBar {progress: -1},
                                            ProgressIndicator {progress: -1}
                                        ]
                                    }
                                ]
                            }
                        ]
                    }
                ]//content of VBox
            }//VBox
        }//ScrollView
    }//Scene
}//Stage

